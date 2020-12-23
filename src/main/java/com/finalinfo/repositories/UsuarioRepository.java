package com.finalinfo.repositories;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.finalinfo.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UserModel, Long> {
    public abstract  ArrayList<UserModel> findByCiudad(String ciudad);
    List<UserModel> findBycreationDate(LocalDate creationDate);
}