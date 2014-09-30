package mx.gob.salud.seguro.popular.cnpss.inventario.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import mx.gob.salud.seguro.popular.cnpss.inventario.dto.TipoBien;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TipoBien entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see mx.gob.salud.seguro.popular.cnpss.inventario.dto.TipoBien
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class TipoBienDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TipoBienDAO.class);
	// property constants
	public static final String DESCRIPCION_BIEN = "descripcionBien";

	public void save(TipoBien transientInstance) {
		log.debug("saving TipoBien instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TipoBien persistentInstance) {
		log.debug("deleting TipoBien instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TipoBien findById(java.math.BigDecimal id) {
		log.debug("getting TipoBien instance with id: " + id);
		try {
			TipoBien instance = (TipoBien) getSession()
					.get("mx.gob.salud.seguro.popular.cnpss.inventario.dao.TipoBien",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TipoBien> findByExample(TipoBien instance) {
		log.debug("finding TipoBien instance by example");
		try {
			List<TipoBien> results = (List<TipoBien>) getSession()
					.createCriteria(
							"mx.gob.salud.seguro.popular.cnpss.inventario.dao.TipoBien")
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
		log.debug("finding TipoBien instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TipoBien as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<TipoBien> findByDescripcionBien(Object descripcionBien) {
		return findByProperty(DESCRIPCION_BIEN, descripcionBien);
	}

	public List findAll() {
		log.debug("finding all TipoBien instances");
		try {
			String queryString = "from TipoBien";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TipoBien merge(TipoBien detachedInstance) {
		log.debug("merging TipoBien instance");
		try {
			TipoBien result = (TipoBien) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TipoBien instance) {
		log.debug("attaching dirty TipoBien instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TipoBien instance) {
		log.debug("attaching clean TipoBien instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}