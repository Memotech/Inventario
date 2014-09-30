package mx.gob.salud.seguro.popular.cnpss.inventario.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Bien entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BIEN", schema = "SYSTEM")
public class Bien implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idBien;
	private TipoBien tipoBien;
	private Marca marca;
	private Modelo modelo;
	private Area area;
	private EstadoBien estadoBien;
	private String claveBien;
	private String descripcionBien;
	private String serie;
	private String notasBien;
	private String ubicacionBien;
	private Date fechaAdquisicion;
	private String factura;
	private Double costo;
	private String estadoBaja;
	private Date fechaBaja;
	private String proveedor;
	private String requisicion;
	private Date fechaRequisicion;
	private String referencia;
	private Set<Responsable> responsables = new HashSet<Responsable>(0);
	private Set<HistorialBien> historialBiens = new HashSet<HistorialBien>(0);

	// Constructors

	/** default constructor */
	public Bien() {
	}

	/** minimal constructor */
	public Bien(BigDecimal idBien, TipoBien tipoBien, Marca marca,
			Modelo modelo, Area area, EstadoBien estadoBien, String claveBien,
			String descripcionBien, String ubicacionBien, Date fechaAdquisicion) {
		this.idBien = idBien;
		this.tipoBien = tipoBien;
		this.marca = marca;
		this.modelo = modelo;
		this.area = area;
		this.estadoBien = estadoBien;
		this.claveBien = claveBien;
		this.descripcionBien = descripcionBien;
		this.ubicacionBien = ubicacionBien;
		this.fechaAdquisicion = fechaAdquisicion;
	}

	/** full constructor */
	public Bien(BigDecimal idBien, TipoBien tipoBien, Marca marca,
			Modelo modelo, Area area, EstadoBien estadoBien, String claveBien,
			String descripcionBien, String serie, String notasBien,
			String ubicacionBien, Date fechaAdquisicion, String factura,
			Double costo, String estadoBaja, Date fechaBaja, String proveedor,
			String requisicion, Date fechaRequisicion, String referencia,
			Set<Responsable> responsables, Set<HistorialBien> historialBiens) {
		this.idBien = idBien;
		this.tipoBien = tipoBien;
		this.marca = marca;
		this.modelo = modelo;
		this.area = area;
		this.estadoBien = estadoBien;
		this.claveBien = claveBien;
		this.descripcionBien = descripcionBien;
		this.serie = serie;
		this.notasBien = notasBien;
		this.ubicacionBien = ubicacionBien;
		this.fechaAdquisicion = fechaAdquisicion;
		this.factura = factura;
		this.costo = costo;
		this.estadoBaja = estadoBaja;
		this.fechaBaja = fechaBaja;
		this.proveedor = proveedor;
		this.requisicion = requisicion;
		this.fechaRequisicion = fechaRequisicion;
		this.referencia = referencia;
		this.responsables = responsables;
		this.historialBiens = historialBiens;
	}

	// Property accessors
	@Id
	@Column(name = "ID_BIEN", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdBien() {
		return this.idBien;
	}

	public void setIdBien(BigDecimal idBien) {
		this.idBien = idBien;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_BIEN", nullable = false)
	public TipoBien getTipoBien() {
		return this.tipoBien;
	}

	public void setTipoBien(TipoBien tipoBien) {
		this.tipoBien = tipoBien;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MARCA", nullable = false)
	public Marca getMarca() {
		return this.marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MODELO", nullable = false)
	public Modelo getModelo() {
		return this.modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_AREA", nullable = false)
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ESTADO_BIEN", nullable = false)
	public EstadoBien getEstadoBien() {
		return this.estadoBien;
	}

	public void setEstadoBien(EstadoBien estadoBien) {
		this.estadoBien = estadoBien;
	}

	@Column(name = "CLAVE_BIEN", nullable = false)
	public String getClaveBien() {
		return this.claveBien;
	}

	public void setClaveBien(String claveBien) {
		this.claveBien = claveBien;
	}

	@Column(name = "DESCRIPCION_BIEN", nullable = false)
	public String getDescripcionBien() {
		return this.descripcionBien;
	}

	public void setDescripcionBien(String descripcionBien) {
		this.descripcionBien = descripcionBien;
	}

	@Column(name = "SERIE")
	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	@Column(name = "NOTAS_BIEN", length = 100)
	public String getNotasBien() {
		return this.notasBien;
	}

	public void setNotasBien(String notasBien) {
		this.notasBien = notasBien;
	}

	@Column(name = "UBICACION_BIEN", nullable = false, length = 100)
	public String getUbicacionBien() {
		return this.ubicacionBien;
	}

	public void setUbicacionBien(String ubicacionBien) {
		this.ubicacionBien = ubicacionBien;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_ADQUISICION", nullable = false, length = 7)
	public Date getFechaAdquisicion() {
		return this.fechaAdquisicion;
	}

	public void setFechaAdquisicion(Date fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}

	@Column(name = "FACTURA", length = 15)
	public String getFactura() {
		return this.factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	@Column(name = "COSTO", precision = 14)
	public Double getCosto() {
		return this.costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	@Column(name = "ESTADO_BAJA", length = 2)
	public String getEstadoBaja() {
		return this.estadoBaja;
	}

	public void setEstadoBaja(String estadoBaja) {
		this.estadoBaja = estadoBaja;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_BAJA", length = 7)
	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	@Column(name = "PROVEEDOR", length = 150)
	public String getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	@Column(name = "REQUISICION")
	public String getRequisicion() {
		return this.requisicion;
	}

	public void setRequisicion(String requisicion) {
		this.requisicion = requisicion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_REQUISICION", length = 7)
	public Date getFechaRequisicion() {
		return this.fechaRequisicion;
	}

	public void setFechaRequisicion(Date fechaRequisicion) {
		this.fechaRequisicion = fechaRequisicion;
	}

	@Column(name = "REFERENCIA")
	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bien")
	public Set<Responsable> getResponsables() {
		return this.responsables;
	}

	public void setResponsables(Set<Responsable> responsables) {
		this.responsables = responsables;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bien")
	public Set<HistorialBien> getHistorialBiens() {
		return this.historialBiens;
	}

	public void setHistorialBiens(Set<HistorialBien> historialBiens) {
		this.historialBiens = historialBiens;
	}

}