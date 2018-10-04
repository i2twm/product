package com.i2twm.product.service;

import com.i2twm.product.dataobject.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categrayList);
}
