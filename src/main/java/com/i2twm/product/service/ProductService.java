package com.i2twm.product.service;

import com.i2twm.product.dataobject.ProductInfo;
import com.i2twm.product.dto.CartDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public abstract class ProductService {

    public abstract List<ProductInfo> findUpAll();

    public abstract List<ProductInfo> findList(List<String> productIdList);

    public abstract void descProductStock(List<CartDTO> cartDTOList);
}
