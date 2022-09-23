package com.hjp.xywm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjp.xywm.entity.AddressBook;
import com.hjp.xywm.mapper.AddressBookMapper;
import com.hjp.xywm.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
