
  package com.moseory.service;
  
  import org.springframework.stereotype.Service;
  
  import com.moseory.domain.ProductDetailVO; import
  com.moseory.domain.ProductVO;
  
  @Service public interface AdminService {
  
  void regist(ProductVO productVO, ProductDetailVO productdetailVO);
  
  }
 
import java.util.List;

import com.moseory.domain.ProductDetailVO;
import com.moseory.domain.ProductVO;

public interface AdminService {

	void product_regist(ProductVO productVO);

	int setCode(String name);

	void product_detail_regist(ProductDetailVO productdetailVO);


}
