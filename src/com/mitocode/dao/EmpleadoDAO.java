package com.mitocode.dao;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.mitocode.model.Empleado;
import com.mitocode.util.HibernateUtil;

public class EmpleadoDAO {

	private Session session;
	private Transaction trans;
	private List<Empleado> lstEmpleados;

	public void Registrar(Empleado emp) throws Exception {
		try {
			
			System.out.println("emp.getNombres(): " + emp.getNombres());
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(emp);
//			session.save(null);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public void Eliminar(Empleado emp) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.delete(emp);
//			session.delete(null);
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	public void Modificar(Empleado emp) throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.update(emp);
//			session.update(null);
			trans.commit();
		} catch (Exception ex) {
			System.out.println("Excepcion: " + ex.getMessage());
			trans.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Empleado> Listar() throws Exception {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			Criteria cri = session.createCriteria(Empleado.class);
			cri.addOrder(Order.asc("apellidos"));
			lstEmpleados = cri.list();
			trans.commit();
		} catch (Exception ex) {
			throw ex;
		}finally {
			session.close();
		}
		return lstEmpleados;
	}
}
