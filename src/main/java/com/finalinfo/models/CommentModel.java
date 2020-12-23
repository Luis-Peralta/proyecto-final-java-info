package com.finalinfo.models;

import javax.persistence.*;
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
    @Column(length = 20)
    private String comentario;

    //relacion con post:
    @ManyToOne
    @JoinColumn(name = "post", referencedColumnName = "id")
    private PostModel post;

    //relacion con usuario:
    @ManyToOne
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
}
