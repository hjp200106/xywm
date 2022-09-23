package com.hjp.xywm.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hjp.xywm.common.R;
import com.hjp.xywm.common.SendEmailUtils;
import com.hjp.xywm.common.ValidateCodeUtils;
import com.hjp.xywm.entity.User;
import com.hjp.xywm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
    //redis服务
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserService userService;

    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user){
        //获取手机号
        String email=user.getEmail();
        if(!StringUtils.isEmpty(email)) {
            //生成随机的4位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("code={}",code);
            //调用邮箱提供的验证码服务
           // SendEmailUtils.sendAuthCodeEmail(email, code);

            //需要将生成的验证码保存到Session
            //session.setAttribute(email,code);
            //需要将生成的验证码保存到Redis，5分钟有效
            redisTemplate.opsForValue().set(email,code,5, TimeUnit.MINUTES);

            return R.success("手机验证码短信发送成功");
        }
        return R.error("手机短信发送失败");
    }
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session){
        log.info("map:{}", map.toString());
        //获取手机号
        String email = map.get("email").toString();
        //获取验证码
        String code = map.get("code").toString();
        //从Session中获取保存的验证码
        //Object codeInSession = session.getAttribute(email);
        //从Redis中获取保存的验证码
        Object codeInSession=redisTemplate.opsForValue().get(email);
        //进行验证码比对（页面提交的验证码和Session中保存的验证码比对）
        if (codeInSession != null && codeInSession.equals(code)) {
            //如果能够比对成功，说明登录成功

            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getEmail, email);
            User user = userService.getOne(queryWrapper);
            if (user == null) {
                //判断当前手机号是否为新用户，如果是新用户则自动完成注册
                user = new User();
                user.setEmail(email);
                user.setStatus(1);
                userService.save(user);
            }
            session.setAttribute("user",user.getId());
            //登陆成功则删除验证码
            redisTemplate.delete(email);
            return R.success(user);
        }
        return R.error("登陆失败");
    }
    //用户退出
    @PostMapping("/loginout")
    public R<String> loginout(HttpServletRequest request){
        //清理Session中保存的当前用户登录的id
       request.getSession().removeAttribute("user");
       return R.success("退出成功");
    }

}
