package com.worksplit.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.worksplit.WorksplitProjectApplication;
import com.worksplit.dao.interfaces.DatabasePlugger;
import com.worksplit.exceptions.DatabaseInsertException;
import java.util.List;

import javax.annotation.PreDestroy;

import com.worksplit.models.UserModel;

@Repository
public class DatabasePluggerImpl<T> implements DatabasePlugger {

	private Session session;
	private Transaction transaction;
	private List<T> objects;

	public DatabasePluggerImpl() {
		try {
			session = WorksplitProjectApplication.factory.openSession();
			transaction = session.beginTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();

		}
	}

	@Override
	public Object saveValues(Object object) {

		try {
			session.saveOrUpdate(object);
			transaction.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return object;
	}

	@Override
	public boolean isPresent(String tableName, String column, String value) {
		return (session.createQuery("from " + tableName + "  value where value." + column + " = '" + value + "'"))
				.uniqueResult() != null;

	}
	
	

	@SuppressWarnings("unchecked")
	public List<T> getValues(String tableName, String column, String value) {
		try {
		objects = session.createQuery("from " + tableName + "  value where value." + column + " = '" + value + "'")
				.getResultList();
		}catch(HibernateException he) {
			throw new DatabaseInsertException();
		}
		return objects;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserModel> getFriendList(Integer userId) {
		List<String> friends = null;
		List<UserModel> friendList = null;
		friends = session.createQuery("from Relationship rel where ( rel.user_one_id = " + userId
				+ " or rel.user_two_id = " + userId + " ) and rel.status = 1 ").getResultList();
		if (friends != null && !friends.isEmpty()) {
			friendList = session.createQuery(" from User user where user.id IN :list").setParameter("list", friends)
					.getResultList();
		}
		return friendList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public  List<T> getAllValues(String tableName) {
		objects = session.createQuery("from " + tableName ).getResultList();				
		return  objects;
	}

	@Override
	public Object saveOrUpdateMultipleValues(List<?> objects) {
		try {
			for(Object singleObject : objects) {
				session.saveOrUpdate(singleObject);
				
			}
			transaction.commit();
			}catch(Exception e) {
				
				e.printStackTrace();
				
				throw new DatabaseInsertException();
			}
		return objects;
	}
	
	@PreDestroy
	public void closeSession() {
		session.close();
		
	}


}
