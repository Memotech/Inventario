package mx.gob.salud.seguro.popular.cnpss.inventario.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import mx.gob.salud.seguro.popular.cnpss.inventario.dto.Area;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Area
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see mx.gob.salud.seguro.popular.cnpss.inventario.dto.Area
 * @author MyEclipse Persistence Tools
 */
public class AreaDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AreaDAO.class);
	// property constants
	public static final String DESCRIPCION_AREA = "descripcionArea";

	public void save(Area transientInstance) {
		log.debug("saving Area instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Area persistentInstance) {
		log.debug("deleting Area instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Area findById(java.math.BigDecimal id) {
		log.debug("getting Area instance with id: " + id);
		try {
			Area instance = (Area) getSession()
					.get("mx.gob.salud.seguro.popular.cnpss.inventario.dao.Area",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Area> findByExample(Area instance) {
		log.debug("finding Area instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Area> results = (List<Area>) getSession()
					.createCriteria(
							"mx.gob.salud.seguro.popular.cnpss.inventario.dao.Area")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("rawtypes")
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Area instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Area as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Area> findByDescripcionArea(Object descripcionArea) {
		return findByProperty(DESCRIPCION_AREA, descripcionArea);
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		log.debug("finding all Area instances");
		try {
			String queryString = "from Area";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

//	public Area merge(Area detachedInstance) {
//		log.debug("merging Area instance");
//		try {
//			Area result = (Area) getSession().merge(detachedInstance);
//			log.debug("merge successful");
//			return result;
//		} catch (RuntimeException re) {
//			log.error("merge failed", re);
//			throw re;
//		}
//	}
//	public Area merge(Area detachedInstance) {
//	log.debug("merging Area instance");
//	try {
//		Area result = (Area) getSession().merge(detachedInstance);
//		log.debug("merge successful");
//		return result;
//	} catch (RuntimeException re) {
//		log.error("merge failed", re);
//		throw re;
//	}
//}

//	public Area merge(Area detachedInstance) {
//	log.debug("merging Area instance");
//	try {
//		Area result = (Area) getSession().merge(detachedInstance);
//		log.debug("merge successful");
//		return result;
//	} catch (RuntimeException re) {
//		log.error("merge failed", re);
//		throw re;
//	}
//}

//	public Area merge(Area detachedInstance) {
//	log.debug("merging Area instance");
//	try {
//		Area result = (Area) getSession().merge(detachedInstance);
//		log.debug("merge successful");
//		return result;
//	} catch (RuntimeException re) {
//		log.error("merge failed", re);
//		throw re;
//	}
//}

//	public Area merge(Area detachedInstance) {
//	log.debug("merging Area instance");
//	try {
//		Area result = (Area) getSession().merge(detachedInstance);
//		log.debug("merge successful");
//		return result;
//	} catch (RuntimeException re) {
//		log.error("merge failed", re);
//		throw re;
//	}
//}

//	public Area merge(Area detachedInstance) {
//	log.debug("merging Area instance");
//	try {
//		Area result = (Area) getSession().merge(detachedInstance);
//		log.debug("merge successful");
//		return result;
//	} catch (RuntimeException re) {
//		log.error("merge failed", re);
//		throw re;
//	}
//}

//	public Area merge(Area detachedInstance) {
//	log.debug("merging Area instance");
//	try {
//		Area result = (Area) getSession().merge(detachedInstance);
//		log.debug("merge successful");
//		return result;
//	} catch (RuntimeException re) {
//		log.error("merge failed", re);
//		throw re;
//	}
//}

//	public Area merge(Area detachedInstance) {
//	log.debug("merging Area instance");
//	try {
//		Area result = (Area) getSession().merge(detachedInstance);
//		log.debug("merge successful");
//		return result;
//	} catch (RuntimeException re) {
//		log.error("merge failed", re);
//		throw re;
//	}
//}

//	public Area merge(Area detachedInstance) {
//	log.debug("merging Area instance");
//	try {
//		Area result = (Area) getSession().merge(detachedInstance);
//		log.debug("merge successful");
//		return result;
//	} catch (RuntimeException re) {
//		log.error("merge failed", re);
//		throw re;
//	}
//}

//	public Area merge(Area detachedInstance) {
//	log.debug("merging Area instance");
//	try {
//		Area result = (Area) getSession().merge(detachedInstance);
//		log.debug("merge successful");
//		return result;
//	} catch (RuntimeException re) {
//		log.error("merge failed", re);
//		throw re;
//	}
//}

//	public Area merge(Area detachedInstance) {
//	log.debug("merging Area instance");
//	try {
//		Area result = (Area) getSession().merge(detachedInstance);
//		log.debug("merge successful");
//		return result;
//	} catch (RuntimeException re) {
//		log.error("merge failed", re);
//		throw re;
//	}
//}

	


	public Area merge(Area detachedInstance) {
		log.debug("merging Area instance");
		try {
			Area result = (Area) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Area instance) {
		log.debug("attaching dirty Area instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
//	sdfhdfhsgjfffs
//	sdf
//	sd
//	f
//	sdf
//	s
//	df

	public void attachClean(Area instance) {
		log.debug("attaching clean Area instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}


//tumama
//tumama