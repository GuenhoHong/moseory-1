package com.moseory.service;

import java.util.List;

import com.moseory.domain.ProductVO;

public interface HomeService {

    public List<ProductVO> readProductSaleCount();
    
    public List<ProductVO> readProductNew();
}