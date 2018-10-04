package com.i2twm.product.enums;

import lombok.Getter;

/**
 * 商品上下架 枚举
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),
    DUWN(1,"下架"),
    ;
    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
