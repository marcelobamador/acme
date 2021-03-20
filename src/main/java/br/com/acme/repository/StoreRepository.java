package br.com.acme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acme.model.LojaEntity;

@Repository
public interface StoreRepository extends JpaRepository<LojaEntity, Long> {
	
	List<LojaEntity> findByNomeLojaIgnoreCaseContaining(String place);
	
	List<LojaEntity> findByEnderecoLojaIgnoreCaseContaining(String place);
}
