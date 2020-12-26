package com.finalinfo.services;

import com.finalinfo.models.CommentModel;
import com.finalinfo.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ComentService {
    @Autowired
    CommentRepository commentRepository;

    //Para crear comentario:
    public CommentModel guardarComment(CommentModel comment){
        return commentRepository.save(comment);
    }

    //Para buscar un comentario:
    public Optional<CommentModel> obtenerPorId(Long id){
        return commentRepository.findById(id);
    }

    //Para ver todos los comentarios:
    public ArrayList<CommentModel> obtenerComment(){
        return (ArrayList<CommentModel>) commentRepository.findAll();
    }

    //Para eliminar un comentario:
    public Boolean eliminarComment(Long id){
        try{
            commentRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }


}
