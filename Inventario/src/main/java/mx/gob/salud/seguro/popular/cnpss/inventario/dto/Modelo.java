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
 * Modelo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MODELO", schema = "SYSTEM")
public class Modelo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idModelo;
	private String descripcionModelo;
	private Set<Bien> biens = new HashSet<Bien>(0);

	// Constructors

	/** default constructor */
	public Modelo() {
	}

	/** minimal constructor */
	public Modelo(BigDecimal idModelo, String descripcionModelo) {
		this.idModelo = idModelo;
		this.descripcionModelo = descripcionModelo;
	}

	/** full constructor */
	public Modelo(BigDecimal idModelo, String descripcionModelo, Set<Bien> biens) {
		this.idModelo = idModelo;
		this.descripcionModelo = descripcionModelo;
		this.biens = biens;
	}

	// Property accessors
	@Id
	@Column(name = "ID_MODELO", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdModelo() {
		return this.idModelo;
	}

	public void setIdModelo(BigDecimal idModelo) {
		this.idModelo = idModelo;
	}

	@Column(name = "DESCRIPCION_MODELO", nullable = false, length = 200)
	public String getDescripcionModelo() {
		return this.descripcionModelo;
	}

	public void setDescripcionModelo(String descripcionModelo) {
		this.descripcionModelo = descripcionModelo;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "modelo")
	public Set<Bien> getBiens() {
		return this.biens;
	}

	public void setBiens(Set<Bien> biens) {
		this.biens = biens;
	}

}