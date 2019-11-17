package com.moseory.dao;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.moseory.domain.HighCateVO;
import com.moseory.domain.LowCateVO;
import com.moseory.domain.ProductDetailVO;
import com.moseory.domain.ProductVO;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void product_regist(ProductVO productVO) {
		sqlSession.insert("product.regist", productVO);
	}
	@Override
	public int setCode(String name) {
		return sqlSession.selectOne("product.setCode", name);
	}
	@Override
	public void product_detail_regist(ProductDetailVO productdetailVO) {
		sqlSession.insert("product.product_detail_regist", productdetailVO);
	}
	@Override
	public String getHighCate(int high_code) {
		return sqlSession.selectOne("product.getHighCate", high_code);
	}
	@Override
	public String getLowCate(int low_code) {
		return sqlSession.selectOne("product.getLowCate", low_code);
	}
	@Override
	public List<HighCateVO> getPrantCategory() {
		return sqlSession.selectList("AdminMapper.getPrantCategory");
	}
	@Override
	public void saveParentsCategory(HighCateVO vo) {
		sqlSession.insert("AdminMapper.saveParentsCategory", vo);
		
	}
	@Override
	public int deleteParentsCategory(@Param(value = "codes") ArrayList<Integer> codes) {
		return sqlSession.delete("AdminMapper.deleteParentsCategory", codes);
	}
	@Override
	public List<LowCateVO> getChildCategory(int highCode) {
		return sqlSession.selectList("AdminMapper.getChildCategory", highCode);
	}
	@Override
	public void saveChildCategory(LowCateVO vo) {
		sqlSession.insert("AdminMapper.saveChildCategory", vo);
		
	}

}
