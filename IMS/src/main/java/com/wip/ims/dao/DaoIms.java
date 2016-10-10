package com.wip.ims.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DaoIms
{
	public static class ConnectionUtil {

		 @SuppressWarnings("deprecation")
		private static SessionFactory sessionFactory = 
				 new Configuration()
				 	.configure()
				 	.buildSessionFactory();
		
		 public static Session getSession() {
				return sessionFactory.openSession();
			}
	}//end class ConnectionUtil
	
	// Basic Crud Functions
	public <T> void createItem(T obj)
	{
		Session session = ConnectionUtil.getSession();

		try
		{
			Transaction tx = session.beginTransaction();
			//chaged this FROM save TO update - hopefully this will cascade adds
			session.update(obj);
			tx.commit();
		} finally
		{
			session.close();
		}//end finally
	}//end create(T)
	
	@SuppressWarnings("unchecked")
	public <T> T retrieveItemById(Integer id, T sample)
	{
		Session session = ConnectionUtil.getSession();
		T obj = null;
		try
		{
			obj = (T) session.get(sample.getClass(), id);
			System.out.println("obj: " + obj);
		} catch (HibernateException e)
		{
			e.printStackTrace();
		} finally
		{
			session.close();
		}
		return obj;	}

	@SuppressWarnings("unchecked")
	public <T> List<T> retrieveAllItem(T obj)	// takes a type to know what to pull
	{
		Session session = ConnectionUtil.getSession();

		// READ ONLY! Used to add restrictions
//		Criteria criteria = session.createCriteria(FlashCard.class);
		Criteria criteria = session.createCriteria(obj.getClass());

		
		
		//Create list item?
		List<T> objlist = null;
		
		try
		{
			objlist = criteria.list();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return objlist;
	}
	
	public <T> void updateItem(T obj)	// param: item to update, needs to contain an id
	{
		Session session = ConnectionUtil.getSession();
		
		try{
			Transaction tx = session.beginTransaction();
			session.update(obj);
			tx.commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}//end finally

	}//end <T> void updateFC(T obj)
	
	public <T> void deleteItem(T obj)
	{
		Session session = ConnectionUtil.getSession();
		
		try
		{
			Transaction tx = session.beginTransaction();
			session.delete(obj);
			tx.commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}


	

}
