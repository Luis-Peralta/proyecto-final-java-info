package com.finalinfo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "Comentarios")
public class CommentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "comentario_alta")
    private LocalDate creacionComent = LocalDate.now();
    @Column(length = 200)
    private String comentario;

    //relacion con post:
    @ManyToOne
    @JoinColumn(name = "post", referencedColumnName = "id")
    @JsonIgnoreProperties({"descripcion", "contenido", "creacion" ,"publicado","user"})
    @NotNull(message = "El comentario tiene que ser relacionado a un post!")
    private PostModel post;

    //relacion con usuario:
    @ManyToOne
    @JoinColumn(name = "autor_comentario", referencedColumnName = "id")
    @JsonIgnoreProperties({"apellido","email","creationDate","ciudad","provincia","pais"})
    @NotNull(message = "El comentario necesita un usuario!")
    @JsonProperty("autor_comentario")
    private UserModel autor;


    // getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreacionComent() {
        return creacionComent;
    }

    public void setCreacionComent(LocalDate creacionComent) {
        this.creacionComent = creacionComent;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public PostModel getPost() {
        return post;
    }

    public void setPost(PostModel post) {
        this.post = post;
    }

    public UserModel getAutor() {
        return autor;
    }

    public void setAutor(UserModel autor) {
        this.autor = autor;
    }

    //Constructores
    public CommentModel(Long id, LocalDate creacionComent, String comentario, PostModel post, UserModel autor) {
        super();
        this.id = id;
        this.creacionComent = creacionComent;
        this.comentario = comentario;
        this.post = post;
        this.autor = autor;
    }

    public CommentModel() {
        super();
    }

//    @Override
//    public String toString(){
//        return "autor: " + this.autor.getNombre();
//    }
}
