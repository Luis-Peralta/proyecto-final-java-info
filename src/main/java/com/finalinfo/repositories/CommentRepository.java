package com.finalinfo.repositories;

import com.finalinfo.models.CommentModel;

import com.finalinfo.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CommentRepository extends JpaRepository<CommentModel, Long> {
    @Query(value = "select * from comentarios where post=?1 ORDER BY comentarios.id desc", nativeQuery = true)
    ArrayList<CommentModel> findByPost(Long id);

    @Query(value = "select * from comentarios where post=:id ORDER BY comentarios.id desc LIMIT :limit", nativeQuery = true)
    ArrayList<CommentModel> findByLimite(@Param("id") Long id,@Param("limit")Integer limit);
}

