package com.i2twm.product.controller;


import com.i2twm.product.dataobject.ProductCategory;
import com.i2twm.product.dataobject.ProductInfo;
import com.i2twm.product.dto.CartDTO;
import com.i2twm.product.service.ProductCategoryService;
import com.i2twm.product.service.ProductService;
import com.i2twm.product.utils.ResultVOUtil;
import com.i2twm.product.vo.ProductInfoVO;
import com.i2twm.product.vo.ProductVo;
import com.i2twm.product.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductCategoryService productCategoryService;
    @Autowired
    private ProductService productService;
    @GetMapping("/list")
    public ResultVo<ProductVo> list(){
        //查询所有在架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //查询商品类目
        List<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        //从数据库查询类目
        List<ProductCategory> categoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);
        //构造数据
        List<ProductVo> ProductVoList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList){
            ProductVo productVo = new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVo.setProductInfoVOList(productInfoVOList);
            ProductVoList.add(productVo);
        }

        return ResultVOUtil.success(ProductVoList);

    }
    @PostMapping("/listfororder")
    public List<ProductInfo> listfororder(@RequestBody List<String> productIdList){
        return productService.findList(productIdList);
    }
    @PostMapping("/descStock")
    public void descStock(@RequestBody List<CartDTO> cartDTOList){
        productService.descProductStock(cartDTOList);
    }
}
