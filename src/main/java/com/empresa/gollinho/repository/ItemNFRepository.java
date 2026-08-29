package com.empresa.gollinho.repository;

import com.empresa.gollinho.model.ItemNF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemNFRepository extends JpaRepository<Long, ItemNF> {
}
