package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Supplier;

@EnableTransactionManagement
@Repository(value = "supplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	// private static org.hibernate.SessionFactory SessionFactory = null;
	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(Supplier supplier) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.save(supplier);
			tx.commit();
			// sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean update(Supplier supplier) {
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.update(supplier);
			tx.commit();
			// sessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean delete(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public Supplier get(String id) {
		String hql = "from Supplier where id=" + " ' " + id + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}

	@Transactional
	public Supplier get1(String name) {
		String hql = "from Supplier where name=" + " ' " + name + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}

	}

	public List<Supplier> list() {
		String hql = "from Supplier";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}
}
