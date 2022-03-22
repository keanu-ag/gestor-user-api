package com.gestor.users.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuario")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long login;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "cliente", nullable = false)
	private float cliente;

	@Column(name = "email")
	private String email;

	@Column(name = "fechaalta", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaalta;

	@Column(name = "fechabaja", columnDefinition = "TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechabaja;

	@Column(name = "status", nullable = false, columnDefinition = "CHAR DEFAULT 'A'")
	private char status;

	@Column(name = "intentos", nullable = false, columnDefinition = "FLOAT DEFAULT 0")
	private float intentos;

	@Column(name = "fecharevocado", columnDefinition = "TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecharevocado;

	@Column(name = "fecha_vigencia", columnDefinition = "TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_vigencia;

	@Column(name = "no_acceso")
	private int no_acceso;

	@Column(name = "apellido_paterno")
	private String apellido_paterno;

	@Column(name = "apellido_materno")
	private String apellido_materno;

	@Column(name = "area", columnDefinition = "DECIMAL")
	private int area;

	@Column(name = "fechamodificacion", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechamodificacion;

	public User() {

	}

	public User(long login, String password, String nombre, float cliente, String email, Date fechaalta, Date fechabaja,
			char status, float intentos, Date fecharevocado, Date fecha_vigencia, int no_acceso,
			String apellido_paterno, String apellido_materno, int area, Date fechamodificacion) {
		super();
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.cliente = cliente;
		this.email = email;
		this.fechaalta = fechaalta;
		this.fechabaja = fechabaja;
		this.status = status;
		this.intentos = intentos;
		this.fecharevocado = fecharevocado;
		this.fecha_vigencia = fecha_vigencia;
		this.no_acceso = no_acceso;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.area = area;
		this.fechamodificacion = fechamodificacion;
	}

	public long getLogin() {
		return login;
	}

	public void setLogin(long login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCliente() {
		return cliente;
	}

	public void setCliente(float cliente) {
		this.cliente = cliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaalta() {
		return fechaalta;
	}

	public void setFechaalta(Date fechaalta) {
		this.fechaalta = fechaalta;
	}

	public Date getFechabaja() {
		return fechabaja;
	}

	public void setFechabaja(Date fechabaja) {
		this.fechabaja = fechabaja;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public float getIntentos() {
		return intentos;
	}

	public void setIntentos(float intentos) {
		this.intentos = intentos;
	}

	public Date getFecharevocado() {
		return fecharevocado;
	}

	public void setFecharevocado(Date fecharevocado) {
		this.fecharevocado = fecharevocado;
	}

	public Date getFecha_vigencia() {
		return fecha_vigencia;
	}

	public void setFecha_vigencia(Date fecha_vigencia) {
		this.fecha_vigencia = fecha_vigencia;
	}

	public int getNo_acceso() {
		return no_acceso;
	}

	public void setNo_acceso(int no_acceso) {
		this.no_acceso = no_acceso;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public Date getFechamodificacion() {
		return fechamodificacion;
	}

	public void setFechamodificacion(Date fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}

}
