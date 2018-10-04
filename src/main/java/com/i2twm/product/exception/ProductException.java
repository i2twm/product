package com.i2twm.product.exception;

import com.i2twm.product.enums.ResultEnum;

public class ProductException extends RuntimeException {
    private Integer code;

    private String message;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;

    }
    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = code;
    }
}
