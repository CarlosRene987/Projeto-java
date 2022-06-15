package com.blogpessoal.BlogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogpessoal.BlogPessoal.model.postagem;

@Repository
public interface PostagemRepository extends JpaRepository<postagem, Long>{
	public List<postagem>findAllByTituloContainingIgnoreCase(String titulo);
	

}
