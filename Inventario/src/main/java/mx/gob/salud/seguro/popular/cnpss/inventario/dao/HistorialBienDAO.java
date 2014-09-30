package mx.gob.salud.seguro.popular.cnpss.inventario.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import mx.gob.salud.seguro.popular.cnpss.inventario.dto.HistorialBien;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * HistorialBien entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see mx.gob.salud.seguro.popular.cnpss.inventario.dto.HistorialBien
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class HistorialBienDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(HistorialBienDAO.class);
	// property constants
	public static final String AREA = "area";

	public void save(HistorialBien transientInstance) {
		log.debug("saving HistorialBien instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(HistorialBien persistentInstance) {
		log.debug("deleting HistorialBien instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HistorialBien findById(java.math.BigDecimal id) {
		log.debug("getting HistorialBien instance with id: " + id);
		try {
			HistorialBien instance = (HistorialBien) getSession()
					.get("mx.gob.salud.seguro.popular.cnpss.inventario.dao.HistorialBien",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<HistorialBien> findByExample(HistorialBien instance) {
		log.debug("finding HistorialBien instance by example");
		try {
			List<HistorialBien> results = (List<HistorialBien>) getSession()
					.createCriteria(
							"mx.gob.salud.seguro.popular.cnpss.inventario.dao.HistorialBien")
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
		log.debug("finding HistorialBien instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from HistorialBien as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<HistorialBien> findByArea(Object area) {
		return findByProperty(AREA, area);
	}

	public List findAll() {
		log.debug("finding all HistorialBien instances");
		try {
			String queryString = "from HistorialBien";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public HistorialBien merge(HistorialBien detachedInstance) {
		log.debug("merging HistorialBien instance");
		try {
			HistorialBien result = (HistorialBien) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(HistorialBien instance) {
		log.debug("attaching dirty HistorialBien instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HistorialBien instance) {
		log.debug("attaching clean HistorialBien instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}