package com.i2twm.product.service;

import com.i2twm.product.dataobject.ProductInfo;
import com.i2twm.product.dto.CartDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size()>0);
    }
    @Test
    public void findList() {
        List<ProductInfo> list = productService.findList(Arrays.asList("157875196366160022", "157875196366160345"));
        Assert.assertTrue(list.size()>0);
    }
    @Test
    public void descProductStock() {
        CartDTO cartDTO = new CartDTO("157875196366160345", 4);
        productService.descProductStock(Arrays.asList(cartDTO));
    }

}