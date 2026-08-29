
package com.empresa.gollinho.repository;

import com.empresa.gollinho.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}



