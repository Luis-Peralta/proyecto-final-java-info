package com.finalinfo.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.catalina.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;
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
    @Column(name = "creacion_post")
    private LocalDate creacion = LocalDate.now();
    private boolean publicado;

    //relaciones
    //con usuario:
    @ManyToOne
    @JoinColumn(name = "autor", referencedColumnName = "id")
    @NotNull
    @JsonIgnoreProperties({"email","creationDate","ciudad","provincia","pais"})
    private UserModel autor;
    //con comentario:
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

    public LocalDate getCreacion() {
        return creacion;
    }

    public void setCreacion(LocalDate creacion) {
        this.creacion = creacion;
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }

    public UserModel getAutor() {
        return autor;
    }

    public void setAutor(UserModel autor) {
        this.autor = autor;
    }

    public List<CommentModel> getComment() {
        return comment;
    }

    public void setComment(List<CommentModel> comment) {
        this.comment = comment;
    }

    //Constructores
    public PostModel(Long id, String titulo, String descripcion, String contenido, LocalDate creacion, boolean publicado, UserModel autor, List<CommentModel> comment) {
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

//    @Override
//    public String toString(){
//        return "Autor:" + autor;
//    }
}
