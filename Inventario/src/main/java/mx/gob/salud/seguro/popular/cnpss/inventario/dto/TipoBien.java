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
 * TipoBien entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TIPO_BIEN", schema = "SYSTEM")
public class TipoBien implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idTipoBien;
	private BigDecimal claveBien;
	private String descripcionBien;
	private Set<Bien> biens = new HashSet<Bien>(0);

	// Constructors

	/** default constructor */
	public TipoBien() {
	}

	/** minimal constructor */
	public TipoBien(BigDecimal idTipoBien) {
		this.idTipoBien = idTipoBien;
	}

	/** full constructor */
	public TipoBien(BigDecimal idTipoBien, BigDecimal claveBien,
			String descripcionBien, Set<Bien> biens) {
		this.idTipoBien = idTipoBien;
		this.claveBien = claveBien;
		this.descripcionBien = descripcionBien;
		this.biens = biens;
	}

	// Property accessors
	@Id
	@Column(name = "ID_TIPO_BIEN", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdTipoBien() {
		return this.idTipoBien;
	}

	public void setIdTipoBien(BigDecimal idTipoBien) {
		this.idTipoBien = idTipoBien;
	}

	@Column(name = "CLAVE_BIEN", precision = 22, scale = 0)
	public BigDecimal getClaveBien() {
		return this.claveBien;
	}

	public void setClaveBien(BigDecimal claveBien) {
		this.claveBien = claveBien;
	}

	@Column(name = "DESCRIPCION_BIEN")
	public String getDescripcionBien() {
		return this.descripcionBien;
	}

	public void setDescripcionBien(String descripcionBien) {
		this.descripcionBien = descripcionBien;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tipoBien")
	public Set<Bien> getBiens() {
		return this.biens;
	}

	public void setBiens(Set<Bien> biens) {
		this.biens = biens;
	}

}