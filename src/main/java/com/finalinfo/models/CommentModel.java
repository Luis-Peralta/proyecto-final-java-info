package com.finalinfo.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Comentario")
public class CommentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String autor;
    @Column(name = "comentario_alta")
    private Date creacionComent;
    private String comentario;

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
}
