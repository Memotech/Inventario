package mx.gob.salud.seguro.popular.cnpss.inventario.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "AREA", schema = "SYSTEM")
public class Area implements java.io.Serializable {
 static final long serialVersionUID = 1L;
	private BigDecimal idArea;
	private BigDecimal claveArea;
	private String descripcionArea;
	private Set<Bien> biens = new HashSet<Bien>(0);
	private Set<Responsable> responsables = new HashSet<Responsable>(0);

	// Constructors

	/** default constructor */
	public Area() {
	}

	/** minimal constructor */
	public Area(BigDecimal idArea, String descripcionArea) {
		this.idArea = idArea;
		this.descripcionArea = descripcionArea;
	}

	/** full constructor */
	public Area(BigDecimal idArea, BigDecimal claveArea,
			String descripcionArea, Set<Bien> biens,
			Set<Responsable> responsables) {
		this.idArea = idArea;
		this.claveArea = claveArea;
		this.descripcionArea = descripcionArea;
		this.biens = biens;
		this.responsables = responsables;
	}

	// Property accessors
	@Id
	@Column(name = "ID_AREA", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdArea() {
		return this.idArea;
	}

	public void setIdArea(BigDecimal idArea) {
		this.idArea = idArea;
	}

	@Column(name = "CLAVE_AREA", precision = 22, scale = 0)
	public BigDecimal getClaveArea() {
		return this.claveArea;
	}

	public void setClaveArea(BigDecimal claveArea) {
		this.claveArea = claveArea;
	}

	@Column(name = "DESCRIPCION_AREA", nullable = false, length = 200)
	public String getDescripcionArea() {
		return this.descripcionArea;
	}

	public void setDescripcionArea(String descripcionArea) {
		this.descripcionArea = descripcionArea;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "area")
	public Set<Bien> getBiens() {
		return this.biens;
	}

	public void setBiens(Set<Bien> biens) {
		this.biens = biens;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "area")
	public Set<Responsable> getResponsables() {
		return this.responsables;
	}

	public void setResponsables(Set<Responsable> responsables) {
		this.responsables = responsables;
	}

}