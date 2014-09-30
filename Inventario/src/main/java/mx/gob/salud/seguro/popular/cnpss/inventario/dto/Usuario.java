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
 * Usuario entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "USUARIO", schema = "SYSTEM")
public class Usuario implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idUsuario;
	private Rol rol;
	private String usuario;
	private String pass;
	private String email;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;

	// Constructors

	/** default constructor */
	public Usuario() {
	}

	/** minimal constructor */
	public Usuario(BigDecimal idUsuario, Rol rol) {
		this.idUsuario = idUsuario;
		this.rol = rol;
	}

	/** full constructor */
	public Usuario(BigDecimal idUsuario, Rol rol, String usuario, String pass,
			String email, String nombre, String apellidoPaterno,
			String apellidoMaterno) {
		this.idUsuario = idUsuario;
		this.rol = rol;
		this.usuario = usuario;
		this.pass = pass;
		this.email = email;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
	}

	// Property accessors
	@Id
	@Column(name = "ID_USUARIO", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(BigDecimal idUsuario) {
		this.idUsuario = idUsuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROL_ID_ROL", nullable = false)
	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Column(name = "USUARIO", length = 50)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Column(name = "PASS", length = 50)
	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Column(name = "EMAIL", length = 150)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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