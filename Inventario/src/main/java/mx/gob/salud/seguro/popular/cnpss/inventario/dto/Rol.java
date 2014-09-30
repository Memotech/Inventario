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
 * Rol entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ROL", schema = "SYSTEM")
public class Rol implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idRol;
	private String descripcion;
	private String clave;
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	// Constructors

	/** default constructor */
	public Rol() {
	}

	/** minimal constructor */
	public Rol(BigDecimal idRol) {
		this.idRol = idRol;
	}

	/** full constructor */
	public Rol(BigDecimal idRol, String descripcion, String clave,
			Set<Usuario> usuarios) {
		this.idRol = idRol;
		this.descripcion = descripcion;
		this.clave = clave;
		this.usuarios = usuarios;
	}

	// Property accessors
	@Id
	@Column(name = "ID_ROL", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdRol() {
		return this.idRol;
	}

	public void setIdRol(BigDecimal idRol) {
		this.idRol = idRol;
	}

	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "CLAVE")
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}