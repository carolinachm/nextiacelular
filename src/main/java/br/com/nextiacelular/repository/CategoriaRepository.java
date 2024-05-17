package br.com.nextiacelular.nextiacelular.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.nextiacelular.nextiacelular.model.CategoriaModel;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaModel, Long>{
    
    List<CategoriaModel> findAll();
    CategoriaModel findById(long id);
    Long countById(long id);
}
