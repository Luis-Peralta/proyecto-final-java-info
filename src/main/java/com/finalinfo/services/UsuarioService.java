package com.finalinfo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.finalinfo.models.UserModel;
import com.finalinfo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UserModel> obtenerUsuarios(){
        return (ArrayList<UserModel>) usuarioRepository.findAll();
    }


    public UserModel guardarUsuario(UserModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UserModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public ArrayList<UserModel> obtenerPorCiudad(String ciudad){
        return usuarioRepository.findByCiudad(ciudad);
    }



//    public ArrayList<UserModel> obtenerPorPrioridad(Integer prioridad){
//        return usuarioRepository.findByPrioridad(prioridad);
//    }

    public boolean eliminarUsuario(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}
