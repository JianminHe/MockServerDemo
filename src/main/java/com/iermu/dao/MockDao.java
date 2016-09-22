package com.iermu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.iermu.model.Mock;
import com.iermu.persistence.HibernateUtil;



public class MockDao {

	public Mock getMethod(String url,  String requestParameter) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		

		

		String hql = "from Mock where requestMethod = 0 and requestUrl=:requestUrl";
		
		
//		if(requestParameter!=null)
//			hql += " and requestParameter:=requestParameter";
		
		
		Query query = session.createQuery(hql);

		query.setParameter("requestUrl", url);
		

//		if(requestParameter != null)
//			query.setParameter("requestParameter", requestParameter);
		


		List<?> mock = query.list();
		
		session.close();
		
		if( mock.size()>0)
			return (Mock) mock.get(0);
		else 
			return null;

	}
	

	public Mock postMethod(String url, String requestParameter, String requestBody) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		

		

		String hql = "from Mock where requestMethod = 1 and requestUrl=:requestUrl and requestBody=:requestBody";
		
		Query query = session.createQuery(hql);
		
		query.setParameter("requestUrl", url);
		query.setParameter("requestBody", requestBody);
		
		System.out.println(url);
		System.out.println(requestBody);
		System.out.println(query);
		
		List<?> mock = query.list();
		
		System.out.println(mock.size());
		session.close();
		
		if( mock.size()>0)
			return (Mock) mock.get(0);
		else 
			return null;
	}
}
