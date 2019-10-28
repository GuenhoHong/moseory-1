package com.moseory.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import com.moseory.domain.ProductDetailVO;
import com.moseory.domain.ProductVO;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private SqlSession sqlSession;
	/**
	 *  1. product�� ������ product_detail�� ���ÿ� insert �Ϸ��� ��.
	 *  2. �ٵ� product_detail�� code�� ������ �� ���� 
	 *  2-1. ������ ��Ʈ�ѷ����� �Ѿ�� product_detailVO�� code�� �𸣱� ����
	 *  2-2. �׷��� product�� insert �ϰ� select�� �ҷ� ������ ��
	 *  2-3. null�� ��
	 *	 3. productVO�� code�� �������� ���� �޾ƿ��� VO�� code�� ��
	 *	 4. ��ǰ���� �ߺ����� �ʰ� �ϰ� ��ǰ������ code�� ������
	 */
	@Override
	public void product_regist(ProductVO productVO) {
		System.out.println("dao���� ��");
		sqlSession.insert("product.regist", productVO);
		System.out.println("dao insert ������");
	}
	@Override
	public int setCode(String name) {
		return sqlSession.selectOne("product.setCode", name);
	}
	@Override
	public void product_detail_regist(ProductDetailVO productdetailVO) {
		sqlSession.insert("product.product_detail_regist", productdetailVO);
	}

}
