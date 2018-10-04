package com.i2twm.product.service.impl;

import com.i2twm.product.dataobject.ProductInfo;
import com.i2twm.product.dto.CartDTO;
import com.i2twm.product.enums.ProductStatusEnum;
import com.i2twm.product.enums.ResultEnum;
import com.i2twm.product.exception.ProductException;
import com.i2twm.product.repository.ProductInfoRepository;
import com.i2twm.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl extends ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
       return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());

    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void descProductStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList){
            Optional<ProductInfo> byId = productInfoRepository.findById(cartDTO.getProductId());
            if (!byId.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = byId.get();
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result<0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
