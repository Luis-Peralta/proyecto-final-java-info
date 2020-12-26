package com.finalinfo.services;

import com.finalinfo.models.PostModel;
import com.finalinfo.models.UserModel;
import com.finalinfo.repositories.PostRepository;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    //para crear post:
    public PostModel guardarPost(PostModel post) {
        return postRepository.save(post);
    }

    //para buscar un post por id
    public Optional<PostModel> obtenerPorId(Long id){
        return postRepository.findById(id);
    }

    //para buscar por no publicado:
    public ArrayList<PostModel> obtenerNoPublicado(){
        return (ArrayList<PostModel>) postRepository.findByPublicadoFalse();
    }

    //para trear todos los post:
    public ArrayList<PostModel> obtenerPost(){
        return (ArrayList<PostModel>) postRepository.findAll();
    }

    //para eliminar post:
    public Boolean eliminarPost(Long id){
        try{
            postRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

}
