package mx.gob.salud.seguro.popular.cnpss.inventario.dao;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import mx.gob.salud.seguro.popular.cnpss.inventario.dto.Bien;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Bien
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see mx.gob.salud.seguro.popular.cnpss.inventario.dto.Bien
 * @author MyEclipse Persistence Tools
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class BienDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(BienDAO.class);
	// property constants
	public static final String CLAVE_BIEN = "claveBien";
	public static final String DESCRIPCION_BIEN = "descripcionBien";
	public static final String SERIE = "serie";
	public static final String NOTAS_BIEN = "notasBien";
	public static final String UBICACION_BIEN = "ubicacionBien";
	public static final String FACTURA = "factura";
	public static final String COSTO = "costo";
	public static final String ESTADO_BAJA = "estadoBaja";
	public static final String PROVEEDOR = "proveedor";
	public static final String REQUISICION = "requisicion";
	public static final String REFERENCIA = "referencia";

	public void save(Bien transientInstance) {
		log.debug("saving Bien instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Bien persistentInstance) {
		log.debug("deleting Bien instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bien findById(java.math.BigDecimal id) {
		log.debug("getting Bien instance with id: " + id);
		try {
			Bien instance = (Bien) getSession()
					.get("mx.gob.salud.seguro.popular.cnpss.inventario.dao.Bien",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Bien> findByExample(Bien instance) {
		log.debug("finding Bien instance by example");
		try {
			List<Bien> results = (List<Bien>) getSession()
					.createCriteria(
							"mx.gob.salud.seguro.popular.cnpss.inventario.dao.Bien")
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
		log.debug("finding Bien instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Bien as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Bien> findByClaveBien(Object claveBien) {
		return findByProperty(CLAVE_BIEN, claveBien);
	}

	public List<Bien> findByDescripcionBien(Object descripcionBien) {
		return findByProperty(DESCRIPCION_BIEN, descripcionBien);
	}

	public List<Bien> findBySerie(Object serie) {
		return findByProperty(SERIE, serie);
	}

	public List<Bien> findByNotasBien(Object notasBien) {
		return findByProperty(NOTAS_BIEN, notasBien);
	}

	public List<Bien> findByUbicacionBien(Object ubicacionBien) {
		return findByProperty(UBICACION_BIEN, ubicacionBien);
	}

	public List<Bien> findByFactura(Object factura) {
		return findByProperty(FACTURA, factura);
	}

	public List<Bien> findByCosto(Object costo) {
		return findByProperty(COSTO, costo);
	}

	public List<Bien> findByEstadoBaja(Object estadoBaja) {
		return findByProperty(ESTADO_BAJA, estadoBaja);
	}

	public List<Bien> findByProveedor(Object proveedor) {
		return findByProperty(PROVEEDOR, proveedor);
	}

	public List<Bien> findByRequisicion(Object requisicion) {
		return findByProperty(REQUISICION, requisicion);
	}

	public List<Bien> findByReferencia(Object referencia) {
		return findByProperty(REFERENCIA, referencia);
	}

	public List findAll() {
		log.debug("finding all Bien instances");
		try {
			String queryString = "from Bien";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Bien merge(Bien detachedInstance) {
		log.debug("merging Bien instance");
		try {
			Bien result = (Bien) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Bien instance) {
		log.debug("attaching dirty Bien instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bien instance) {
		log.debug("attaching clean Bien instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}