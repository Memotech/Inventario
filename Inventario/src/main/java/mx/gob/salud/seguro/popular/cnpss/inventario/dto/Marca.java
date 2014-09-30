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
 * Marca entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MARCA", schema = "SYSTEM")
public class Marca implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idMarca;
	private String descripcionMarca;
	private Set<Bien> biens = new HashSet<Bien>(0);

	// Constructors

	/** default constructor */
	public Marca() {
	}

	/** minimal constructor */
	public Marca(BigDecimal idMarca, String descripcionMarca) {
		this.idMarca = idMarca;
		this.descripcionMarca = descripcionMarca;
	}

	/** full constructor */
	public Marca(BigDecimal idMarca, String descripcionMarca, Set<Bien> biens) {
		this.idMarca = idMarca;
		this.descripcionMarca = descripcionMarca;
		this.biens = biens;
	}

	// Property accessors
	@Id
	@Column(name = "ID_MARCA", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdMarca() {
		return this.idMarca;
	}

	public void setIdMarca(BigDecimal idMarca) {
		this.idMarca = idMarca;
	}

	@Column(name = "DESCRIPCION_MARCA", nullable = false, length = 100)
	public String getDescripcionMarca() {
		return this.descripcionMarca;
	}

	public void setDescripcionMarca(String descripcionMarca) {
		this.descripcionMarca = descripcionMarca;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "marca")
	public Set<Bien> getBiens() {
		return this.biens;
	}

	public void setBiens(Set<Bien> biens) {
		this.biens = biens;
	}

}