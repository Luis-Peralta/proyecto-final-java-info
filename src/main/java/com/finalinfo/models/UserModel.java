package com.finalinfo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class UserModel {
	//atributos
    @Id //aplica id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementa
	private Long id;
	@NotNull
	private String nombre;
	@NotNull
	private String apellido;
	@Column(unique = true, nullable = false)
	private String email;
	//oculta el password al realizar el get
	@JsonIgnore
	private String password;
	@Column(name = "fecha_alta")
	private LocalDate creationDate = LocalDate.now();
	private String ciudad;
	private String provincia;
	private String pais;

	//relacion con post
	@OneToMany
	@JsonIgnore
	private List<PostModel> post;
	//relacion con comentario
	@OneToMany
	@JsonIgnore
	private List<CommentModel> comment;

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

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
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

	public List<CommentModel> getComment() {
		return comment;
	}

	public void setComment(List<CommentModel> comment) {
		this.comment = comment;
	}

	public UserModel(Long id, @NotNull String nombre, @NotNull String apellido, String email, String password, LocalDate creationDate, String ciudad, String provincia, String pais, List<PostModel> post, List<CommentModel> comment) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
		this.post = post;
		this.comment = comment;
	}

	public UserModel() {
		super();
	}
}