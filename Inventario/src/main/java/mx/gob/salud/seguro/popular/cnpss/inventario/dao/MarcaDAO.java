package mx.gob.salud.seguro.popular.cnpss.inventario.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import mx.gob.salud.seguro.popular.cnpss.inventario.dto.Marca;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Marca
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see mx.gob.salud.seguro.popular.cnpss.inventario.dto.Marca
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class MarcaDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MarcaDAO.class);
	// property constants
	public static final String DESCRIPCION_MARCA = "descripcionMarca";

	public void save(Marca transientInstance) {
		log.debug("saving Marca instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Marca persistentInstance) {
		log.debug("deleting Marca instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Marca findById(java.math.BigDecimal id) {
		log.debug("getting Marca instance with id: " + id);
		try {
			Marca instance = (Marca) getSession().get(
					"mx.gob.salud.seguro.popular.cnpss.inventario.dao.Marca",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Marca> findByExample(Marca instance) {
		log.debug("finding Marca instance by example");
		try {
			List<Marca> results = (List<Marca>) getSession()
					.createCriteria(
							"mx.gob.salud.seguro.popular.cnpss.inventario.dao.Marca")
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
		log.debug("finding Marca instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Marca as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Marca> findByDescripcionMarca(Object descripcionMarca) {
		return findByProperty(DESCRIPCION_MARCA, descripcionMarca);
	}

	public List findAll() {
		log.debug("finding all Marca instances");
		try {
			String queryString = "from Marca";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Marca merge(Marca detachedInstance) {
		log.debug("merging Marca instance");
		try {
			Marca result = (Marca) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Marca instance) {
		log.debug("attaching dirty Marca instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Marca instance) {
		log.debug("attaching clean Marca instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}