package com.blogpessoal.BlogPessoal.repository;

import java.util.List;
import com.blogpessoal.BlogPessoal.model.postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PostagemRepository extends JpaRepository<postagem, Long>{
public List <postagem> findAllByTituloContainingIgnoreCase(@Param("titulo")String titulo);
	

}
