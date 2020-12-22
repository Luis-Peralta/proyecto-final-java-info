package com.finalinfo.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class UserModel {
	//atributos
    @Id //aplica id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementa
    private Long id;
	private String nombre;
	private String apellido;
	@Column(unique = true, nullable = false)
	private String email;
	private String password;
	@Column(name = "fecha_alta")
	private Date alta;
	private String ciudad;
	private String provincia;
	private String pais;

	//relacion
	@OneToMany
	private List<PostModel> post;

	// getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<PostModel> getPost() {
		return post;
	}

	public void setPost(List<PostModel> post) {
		this.post = post;
	}

	public UserModel(Long id, String nombre, String apellido, String email, String password, Date alta, String ciudad, String provincia, String pais, List<PostModel> post) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.alta = alta;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
		this.post = post;
	}

	public UserModel() {
		super();
	}
}