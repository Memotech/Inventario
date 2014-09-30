package mx.gob.salud.seguro.popular.cnpss.inventario.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import mx.gob.salud.seguro.popular.cnpss.inventario.dto.Modelo;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Modelo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mx.gob.salud.seguro.popular.cnpss.inventario.dto.Modelo
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class ModeloDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ModeloDAO.class);
	// property constants
	public static final String DESCRIPCION_MODELO = "descripcionModelo";

	public void save(Modelo transientInstance) {
		log.debug("saving Modelo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Modelo persistentInstance) {
		log.debug("deleting Modelo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Modelo findById(java.math.BigDecimal id) {
		log.debug("getting Modelo instance with id: " + id);
		try {
			Modelo instance = (Modelo) getSession().get(
					"mx.gob.salud.seguro.popular.cnpss.inventario.dao.Modelo",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Modelo> findByExample(Modelo instance) {
		log.debug("finding Modelo instance by example");
		try {
			List<Modelo> results = (List<Modelo>) getSession()
					.createCriteria(
							"mx.gob.salud.seguro.popular.cnpss.inventario.dao.Modelo")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Modelo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Modelo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Modelo> findByDescripcionModelo(Object descripcionModelo) {
		return findByProperty(DESCRIPCION_MODELO, descripcionModelo);
	}

	public List findAll() {
		log.debug("finding all Modelo instances");
		try {
			String queryString = "from Modelo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Modelo merge(Modelo detachedInstance) {
		log.debug("merging Modelo instance");
		try {
			Modelo result = (Modelo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Modelo instance) {
		log.debug("attaching dirty Modelo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Modelo instance) {
		log.debug("attaching clean Modelo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}