package com.br.lymtt.easypass.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.br.lymtt.easypass.model.entities.Promotor;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotorRepository extends JpaRepository<Promotor, Long>{

}
