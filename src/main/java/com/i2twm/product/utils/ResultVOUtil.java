package com.i2twm.product.utils;

import com.i2twm.product.vo.ResultVo;

public class ResultVOUtil {
    public static ResultVo success(Object object){
        ResultVo resultVo =new ResultVo();
        resultVo.setCode(0);
        resultVo.setMessage("成功");
        resultVo.setData(object);
        return resultVo;

    }
}
