package com.finalinfo.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.finalinfo.models.UserModel;
import com.finalinfo.repositories.UsuarioRepository;
import com.finalinfo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UsuarioController{

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioRepository usuarioRepository;

    //PARA OBTENER TODOS LOS USUARIOS
    @GetMapping()
    public ArrayList<UserModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    //PARA CREAR USUARIOS
    @PostMapping()
    public UserModel guardarUsuario(@RequestBody UserModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    //Para buscar usuarios por un atributo:
    @GetMapping( path= "/{id}")
    public Optional<UserModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);

    }
    //Para buscar usuarios por ciudad:
    @GetMapping("/ciudad")
    public ArrayList<UserModel> obtenerPorCity(@RequestParam("ciudad") String ciudad){
        return this.usuarioService.obtenerPorCiudad(ciudad);
    }

    //para buscar usuarios por fecha
    @GetMapping("/fecha")
    public ResponseEntity<?> buscarUsuariosFecha(@RequestParam("filter") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate creationDate) {
        List<UserModel> users = usuarioRepository.findBycreationDate(creationDate);
       return new ResponseEntity<>(users, HttpStatus.OK);
    }


    //Para modificar usuario:
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody UserModel userUpt, @PathVariable Long id){
        Optional<UserModel> user = usuarioService.obtenerPorId(id);

        if(!user.isPresent()){
            return ResponseEntity.notFound().build();
        }

        user.get().setNombre(userUpt.getNombre());
        user.get().setApellido(userUpt.getApellido());
        user.get().setEmail(userUpt.getEmail());
        user.get().setCiudad(userUpt.getCiudad());
        user.get().setProvincia(userUpt.getProvincia());
        user.get().setPais(userUpt.getPais());

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardarUsuario(user.get()));
    }



    //PARA ELIMINAR USUARIO POR ID:
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