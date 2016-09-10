package com.niit.shoppingcart.dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;

@EnableTransactionManagement
@Repository(value = "categoryDAO")

public class CategoryDAOImpl implements CategoryDAO {

	private static final Query SessionFactory = null;
	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public boolean save(Category category) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			// sessionFactory.getCurrentSession().save(category);
			s.save(category);
			tx.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch blockry
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean update(Category category) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			// sessionFactory.getCurrentSession().save(category);
			s.update(category);
			tx.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch blockry
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean delete(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public Category get(String id) {

		String hql = "from Category where id=" + " ' " + id + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}

	@Transactional
	public Category get1(String name) {

		String hql = "from Category where name=" + " ' " + name + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}

	@Transactional
	public List<Category> list() {
		String hql = "from Category";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}
}
