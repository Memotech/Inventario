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
 * EstadoBien entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ESTADO_BIEN", schema = "SYSTEM")
public class EstadoBien implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idEstadoBien;
	private String estadoBien;
	private Set<Bien> biens = new HashSet<Bien>(0);

	// Constructors

	/** default constructor */
	public EstadoBien() {
	}

	/** minimal constructor */
	public EstadoBien(BigDecimal idEstadoBien) {
		this.idEstadoBien = idEstadoBien;
	}

	/** full constructor */
	public EstadoBien(BigDecimal idEstadoBien, String estadoBien,
			Set<Bien> biens) {
		this.idEstadoBien = idEstadoBien;
		this.estadoBien = estadoBien;
		this.biens = biens;
	}

	// Property accessors
	@Id
	@Column(name = "ID_ESTADO_BIEN", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdEstadoBien() {
		return this.idEstadoBien;
	}

	public void setIdEstadoBien(BigDecimal idEstadoBien) {
		this.idEstadoBien = idEstadoBien;
	}

	@Column(name = "ESTADO_BIEN")
	public String getEstadoBien() {
		return this.estadoBien;
	}

	public void setEstadoBien(String estadoBien) {
		this.estadoBien = estadoBien;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "estadoBien")
	public Set<Bien> getBiens() {
		return this.biens;
	}

	public void setBiens(Set<Bien> biens) {
		this.biens = biens;
	}

}