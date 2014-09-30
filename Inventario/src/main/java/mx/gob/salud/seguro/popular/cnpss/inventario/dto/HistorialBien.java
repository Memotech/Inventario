package mx.gob.salud.seguro.popular.cnpss.inventario.dto;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * HistorialBien entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "HISTORIAL_BIEN", schema = "SYSTEM")
public class HistorialBien implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idHistorial;
	private Bien bien;
	private Date fechaModificacion;
	private String area;
	private BigDecimal responsable;

	// Constructors

	/** default constructor */
	public HistorialBien() {
	}

	/** minimal constructor */
	public HistorialBien(BigDecimal idHistorial, Bien bien) {
		this.idHistorial = idHistorial;
		this.bien = bien;
	}

	/** full constructor */
	public HistorialBien(BigDecimal idHistorial, Bien bien,
			Date fechaModificacion, String area, BigDecimal responsable) {
		this.idHistorial = idHistorial;
		this.bien = bien;
		this.fechaModificacion = fechaModificacion;
		this.area = area;
		this.responsable = responsable;
	}

	// Property accessors
	@Id
	@Column(name = "ID_HISTORIAL", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdHistorial() {
		return this.idHistorial;
	}

	public void setIdHistorial(BigDecimal idHistorial) {
		this.idHistorial = idHistorial;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_BIEN", nullable = false)
	public Bien getBien() {
		return this.bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_MODIFICACION", length = 7)
	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@Column(name = "AREA", length = 100)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "RESPONSABLE", precision = 22, scale = 0)
	public BigDecimal getResponsable() {
		return this.responsable;
	}

	public void setResponsable(BigDecimal responsable) {
		this.responsable = responsable;
	}

}