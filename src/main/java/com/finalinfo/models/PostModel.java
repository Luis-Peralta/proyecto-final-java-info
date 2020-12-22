package com.finalinfo.models;
import org.apache.catalina.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Posts")
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //atributos
    private Long id;
    private String titulo;
    private String descripcion;
    private String contenido;
    private Date creacion;
    private boolean publicado;

    //relaciones
    //con usuario:
    @ManyToOne
    @JoinColumn(name = "autor", referencedColumnName = "id")
    private UserModel autor;
    //con comentario:
    @OneToMany
    private List<CommentModel> comment;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }

    public UserModel getUser() {
        return autor;
    }

    public void setUser(UserModel user) {
        this.autor = user;
    }

    public List<CommentModel> getComment() {
        return comment;
    }

    public void setComment(List<CommentModel> comment) {
        this.comment = comment;
    }

    //Constructores
    public PostModel(Long id, String titulo, String descripcion, String contenido, Date creacion, String usuario, boolean publicado, UserModel autor, List<CommentModel> comment) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.contenido = contenido;
        this.creacion = creacion;
        this.publicado = publicado;
        this.autor = autor;
        this.comment = comment;
    }

    public PostModel() {
        super();
    }
}
