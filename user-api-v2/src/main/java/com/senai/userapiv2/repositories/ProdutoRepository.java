package com.senai.userapiv2.repositories;

import com.senai.userapiv2.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
