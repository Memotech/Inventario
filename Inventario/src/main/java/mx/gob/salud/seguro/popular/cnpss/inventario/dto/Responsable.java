package mx.gob.salud.seguro.popular.cnpss.inventario.dto;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Responsable entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "RESPONSABLE", schema = "SYSTEM")
public class Responsable implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idResponsable;
	private Bien bien;
	private Area area;
	private BigDecimal claveResponsable;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;

	// Constructors

	/** default constructor */
	public Responsable() {
	}

	/** minimal constructor */
	public Responsable(BigDecimal idResponsable, Bien bien, Area area,
			BigDecimal claveResponsable) {
		this.idResponsable = idResponsable;
		this.bien = bien;
		this.area = area;
		this.claveResponsable = claveResponsable;
	}

	/** full constructor */
	public Responsable(BigDecimal idResponsable, Bien bien, Area area,
			BigDecimal claveResponsable, String nombre, String apellidoPaterno,
			String apellidoMaterno) {
		this.idResponsable = idResponsable;
		this.bien = bien;
		this.area = area;
		this.claveResponsable = claveResponsable;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
	}

	// Property accessors
	@Id
	@Column(name = "ID_RESPONSABLE", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdResponsable() {
		return this.idResponsable;
	}

	public void setIdResponsable(BigDecimal idResponsable) {
		this.idResponsable = idResponsable;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_BIEN", nullable = false)
	public Bien getBien() {
		return this.bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_AREA", nullable = false)
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@Column(name = "CLAVE_RESPONSABLE", nullable = false, precision = 22, scale = 0)
	public BigDecimal getClaveResponsable() {
		return this.claveResponsable;
	}

	public void setClaveResponsable(BigDecimal claveResponsable) {
		this.claveResponsable = claveResponsable;
	}

	@Column(name = "NOMBRE")
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "APELLIDO_PATERNO")
	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	@Column(name = "APELLIDO_MATERNO")
	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

}