package com.moseory.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddedOrderInfoVO {
    
    // product 정보
    private int code;
    private String name;
    private int price;
    
    // product detail 정보
    private int product_detail_no;
    private String product_color;
    private String product_size;
    
    // product file 정보
    private String file_path;
    private String thumbnail_name;
    
    // order 정보
    private int quantity;
    
}
