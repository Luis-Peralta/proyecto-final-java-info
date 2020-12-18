package com.finalinfo.controllers;

import java.util.ArrayList;
import java.util.Optional;
import com.finalinfo.models.UserModel;
import com.finalinfo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController{

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UserModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UserModel guardarUsuario(@RequestBody UserModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping( path= "/{id}")
    public Optional<UserModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return  this.usuarioService.obtenerPorId(id);
    }

//    @GetMapping( "/query" )
//    public ArrayList<UserModel> obtenerPorPrioridad(@RequestParam("prioridad") Integer prioridad){
//        return this.usuarioService.obtenerPorPrioridad(prioridad);
//    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se elimino correctamente el usuario con id:" + id;
        }else{
            return "no pudo eliminar el usuario con id: " + id;
        }
    }
}