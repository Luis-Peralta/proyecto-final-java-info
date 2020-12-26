package com.finalinfo.repositories;

import com.finalinfo.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long> {
    List<PostModel> findByPublicadoFalse();
    //ArrayList<PostModel> findByTituloIgnoreCaseContaining(String titulo);
    //Query sql para buscar con metodo like
    @Query("Select titulo from PostModel titulo where titulo.titulo like %:titulo%")
    List<PostModel> findByTituloContaining(@Param("titulo")String titulo);
}
