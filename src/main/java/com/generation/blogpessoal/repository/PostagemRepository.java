package com.generation.blogpessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.model.Postagem;

// notação que define que PostagemRepository é um repositório de queries dentro da tabela de postgens (tb_postagem)
@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

}
