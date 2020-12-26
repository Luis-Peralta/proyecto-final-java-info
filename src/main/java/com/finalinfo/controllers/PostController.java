package com.finalinfo.controllers;

import com.finalinfo.models.PostModel;
import com.finalinfo.models.UserModel;
import com.finalinfo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {
    @Autowired
    PostService postService;

    //para crear post:
    @PostMapping()
    public PostModel guardarPost(@RequestBody PostModel post){
        return this.postService.guardarPost(post);
    }

    //para obtener los posts:
    @GetMapping()
    public ArrayList<PostModel> obtenerPosts() {
        return postService.obtenerPost();
    }

    //para actualizar el post:
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarPost(@RequestBody PostModel postUpt, @PathVariable Long id){
        Optional<PostModel> post = postService.obtenerPorId(id);

        if(!post.isPresent()){
            return ResponseEntity.notFound().build();
        }

        post.get().setTitulo(postUpt.getTitulo());
        post.get().setDescripcion(postUpt.getDescripcion());
        post.get().setContenido(postUpt.getContenido());

        return ResponseEntity.status(HttpStatus.CREATED).body(postService.guardarPost(post.get()));
    }

    //para eliminar el post:
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.postService.eliminarPost(id);
        if (ok){
            return "Se elimino correctamente el post con id:" + id;
        }else{
            return "no pudo eliminar el post con id: " + id;
        }
    }

    //para buscar por id algun post:
    @GetMapping( path= "/{id}")
    public Optional<PostModel> obtenerPostPorId(@PathVariable("id") Long id){
        return this.postService.obtenerPorId(id);
    }

    //para buscar por publicado o no:
    @GetMapping(path = "/no-publicado")
    public ArrayList<PostModel> obtenerNoPublicado(){
        return postService.obtenerNoPublicado();
    }

    //para buscar por palabra en titulo:
    @GetMapping(path= "/titulo")
    public ArrayList<PostModel> obtenerPorTitulo(@RequestParam("filter") String titulo){
        return this.postService.obtenerPorTitulo(titulo);
    }

}
