package com.br.lymtt.easypass.repository;

import com.br.lymtt.easypass.entity.Promoter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoterRepository extends JpaRepository<Promoter, String> {
}