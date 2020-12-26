package com.finalinfo.controllers;

import com.finalinfo.models.CommentModel;
import com.finalinfo.models.PostModel;
import com.finalinfo.services.ComentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/comments")
public class ComentarioController {
    @Autowired
    ComentService comentService;

    //Para crear comentario:
    @PostMapping()
    public CommentModel guardarComment(@RequestBody CommentModel comment){
        return this.comentService.guardarComment(comment);
    }

    //Para ver los comentarios:
    @GetMapping()
    public ArrayList<CommentModel> obtenerComments(){
        return comentService.obtenerComment();
    }

    //Para actualizar comentario:
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarComment(@RequestBody CommentModel comentUpt, @PathVariable Long id){
        Optional<CommentModel> comment = comentService.obtenerPorId(id);
        if(!comment.isPresent()){
            return ResponseEntity.notFound().build();
        }
        comment.get().setComentario(comentUpt.getComentario());
        return ResponseEntity.status(HttpStatus.CREATED).body(comentService.guardarComment(comment.get()));
    }

    //Para eliminar un comentario:
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.comentService.eliminarComment(id);
        if (ok){
            return "Se elimino correctamente el comentario con id:" + id;
        }else{
            return "no pudo eliminar el comentario con id: " + id;
        }
    }

    //para buscar por id algun comentario:
    @GetMapping( path= "/{id}")
    public Optional<CommentModel> obtenerComentPorId(@PathVariable("id") Long id){
        return this.comentService.obtenerPorId(id);
    }


}
