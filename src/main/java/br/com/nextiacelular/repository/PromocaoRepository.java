package br.com.nextiacelular.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.nextiacelular.model.PromocaoModel;

@Repository
public interface PromocaoRepository extends CrudRepository<PromocaoModel, Long>{
    
    List<PromocaoModel> findAll();
    PromocaoModel findById(long id);
    Long countById(long id);
}
