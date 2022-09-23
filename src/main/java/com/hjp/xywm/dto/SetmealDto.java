package com.hjp.xywm.dto;
import com.hjp.xywm.entity.Setmeal;
import com.hjp.xywm.entity.SetmealDish;

import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
