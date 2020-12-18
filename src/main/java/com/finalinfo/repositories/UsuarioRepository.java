package com.finalinfo.repositories;


import java.util.ArrayList;
import com.finalinfo.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UsuarioRepository extends CrudRepository<UserModel, Long> {
    public abstract ArrayList<UserModel> findByEmail(String email);
}