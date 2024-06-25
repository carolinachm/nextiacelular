package br.com.nextiacelular.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.nextiacelular.model.EstoqueModel;

@Repository
public interface EstoqueRepository extends CrudRepository<EstoqueModel, Long>{
    
    List<EstoqueModel> findAll();
    EstoqueModel findById(long id);
    Long countById(long id);
}
