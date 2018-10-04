package com.i2twm.product.service.impl;

import com.i2twm.product.dataobject.ProductCategory;
import com.i2twm.product.repository.ProductCategoryRepository;
import com.i2twm.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categrayList) {
        return productCategoryRepository.findByCategoryTypeIn(categrayList);
    }
}
