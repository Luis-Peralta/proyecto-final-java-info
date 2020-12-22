package com.finalinfo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Comentarios")
public class CommentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String autor;
    @Column(name = "comentario_alta")
    private Date creacionComent;
    @Column(length = 20)
    private String comentario;

    //relacion con post:
    @ManyToOne
    @JoinColumn(name = "post", referencedColumnName = "id")
    private PostModel post;


    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getCreacionComent() {
        return creacionComent;
    }

    public void setCreacionComent(Date creacionComent) {
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

    //Constructores
    public CommentModel(Long id, String autor, Date creacionComent, String comentario, PostModel post) {
        super();
        this.id = id;
        this.autor = autor;
        this.creacionComent = creacionComent;
        this.comentario = comentario;
        this.post = post;
    }

    public CommentModel() {
        super();
    }
}
