package com.i2twm.product.service.impl;

import com.i2twm.product.ProductApplicationTests;
import com.i2twm.product.dataobject.ProductCategory;
import com.i2twm.product.service.ProductCategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Component
public class ProductCategoryServiceImplTest extends ProductApplicationTests {

    @Autowired
    private ProductCategoryService productCategoryService;
    @Test
    public void findByCategoryTypeIn() {
       List<ProductCategory> list =  productCategoryService.findByCategoryTypeIn(Arrays.asList(11,22));
        Assert.assertTrue(list.size()>0);
    }
}