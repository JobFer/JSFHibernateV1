package com.mitocode.dao.auto;
// Generated 04-sep-2017 11:44:05 by Hibernate Tools 5.2.3.Final

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.mitocode.model.Usuario;
import com.mitocode.util.HibernateUtil;

/**
 * Home object for domain model class Usuario.
 * @see com.mitocode.model.Usuario
 * @author Hibernate Tools
 */
public class UsuarioHome {

	private static final Log log = LogFactory.getLog(UsuarioHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			HibernateUtil.getSessionFactory();
			return (SessionFactory) new InitialContext().lookup("MiSesionFactory");			
			
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Usuario transientInstance) {
		log.debug("persisting Usuario instance");
		try {
			
			//Forma 1: Con openSession
			Session sesion = sessionFactory.openSession();
			Transaction et = sesion.beginTransaction();
			sesion.save(transientInstance);
			et.commit();			
			
//			//Forma 2: Con getCurrentSession
//			Transaction et = sessionFactory.getCurrentSession().beginTransaction();
//			sessionFactory.getCurrentSession().persist(transientInstance);
//			et.commit();
			
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}catch (Exception e) {
			System.out.println("Excepci�n: " + e.getMessage());
		}
	}

//	public void attachDirty(Usuario instance) {
//		log.debug("attaching dirty Usuario instance");
//		try {
//			sessionFactory.getCurrentSession().saveOrUpdate(instance);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void attachClean(Usuario instance) {
//		log.debug("attaching clean Usuario instance");
//		try {
//			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
//			log.debug("attach successful");
//		} catch (RuntimeException re) {
//			log.error("attach failed", re);
//			throw re;
//		}
//	}
//
//	public void delete(Usuario persistentInstance) {
//		log.debug("deleting Usuario instance");
//		try {
//			sessionFactory.getCurrentSession().delete(persistentInstance);
//			log.debug("delete successful");
//		} catch (RuntimeException re) {
//			log.error("delete failed", re);
//			throw re;
//		}
//	}
//
//	public Usuario merge(Usuario detachedInstance) {
//		log.debug("merging Usuario instance");
//		try {
//			Usuario result = (Usuario) sessionFactory.getCurrentSession().merge(detachedInstance);
//			log.debug("merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			log.error("merge failed", re);
//			throw re;
//		}
//	}
//
//	public Usuario findById(java.lang.Integer id) {
//		log.debug("getting Usuario instance with id: " + id);
//		try {
//			Usuario instance = (Usuario) sessionFactory.getCurrentSession().get("com.mitocode.model.Usuario", id);
//			if (instance == null) {
//				log.debug("get successful, no instance found");
//			} else {
//				log.debug("get successful, instance found");
//			}
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}
//	
//	public Usuario verificarDatos(Usuario usuario) throws Exception {
//		Usuario us = null;
//
//		try {
//			
//			String hql = "FROM Usuario WHERE nombre = '" + usuario.getNombre() + "' and clave = '" + usuario.getClave() + "'";
//			//String hql = "FROM Usuario WHERE nombre = '" + usuario.getNombre() + "'";
//			Query query = sessionFactory.getCurrentSession().createQuery(hql);
//
//			if (!query.list().isEmpty()) {
//				us = (Usuario) query.list().get(0);
//			}
//			//us = new Usuario(1,"Pepe","perez");
//
//		} catch (Exception e) {
//			System.out.println("EXCEPCIONNNN: "+ e);
//			throw e;
//		}
//
//		return us;
//	}
//	
//	public List findByExample(Usuario instance) {
//		log.debug("finding Usuario instance by example");
//		try {
//			List results = sessionFactory.getCurrentSession().createCriteria("com.mitocode.model.Usuario")
//					.add(Example.create(instance)).list();
//			log.debug("find by example successful, result size: " + results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
	
}
