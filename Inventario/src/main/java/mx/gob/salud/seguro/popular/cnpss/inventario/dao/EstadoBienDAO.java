package mx.gob.salud.seguro.popular.cnpss.inventario.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import mx.gob.salud.seguro.popular.cnpss.inventario.dto.EstadoBien;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * EstadoBien entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mx.gob.salud.seguro.popular.cnpss.inventario.dto.EstadoBien
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class EstadoBienDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EstadoBienDAO.class);
	// property constants
	public static final String ESTADO_BIEN = "estadoBien";

	public void save(EstadoBien transientInstance) {
		log.debug("saving EstadoBien instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(EstadoBien persistentInstance) {
		log.debug("deleting EstadoBien instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EstadoBien findById(java.math.BigDecimal id) {
		log.debug("getting EstadoBien instance with id: " + id);
		try {
			EstadoBien instance = (EstadoBien) getSession()
					.get("mx.gob.salud.seguro.popular.cnpss.inventario.dao.EstadoBien",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<EstadoBien> findByExample(EstadoBien instance) {
		log.debug("finding EstadoBien instance by example");
		try {
			List<EstadoBien> results = (List<EstadoBien>) getSession()
					.createCriteria(
							"mx.gob.salud.seguro.popular.cnpss.inventario.dao.EstadoBien")
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
		log.debug("finding EstadoBien instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from EstadoBien as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<EstadoBien> findByEstadoBien(Object estadoBien) {
		return findByProperty(ESTADO_BIEN, estadoBien);
	}

	public List findAll() {
		log.debug("finding all EstadoBien instances");
		try {
			String queryString = "from EstadoBien";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public EstadoBien merge(EstadoBien detachedInstance) {
		log.debug("merging EstadoBien instance");
		try {
			EstadoBien result = (EstadoBien) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(EstadoBien instance) {
		log.debug("attaching dirty EstadoBien instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EstadoBien instance) {
		log.debug("attaching clean EstadoBien instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}