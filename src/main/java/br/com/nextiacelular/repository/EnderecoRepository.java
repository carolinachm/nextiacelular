package br.com.nextiacelular.repository;

import br.com.nextiacelular.model.EnderecoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends CrudRepository<EnderecoModel, Long> {
    
    @SuppressWarnings("null")
    List<EnderecoModel> findAll();
    EnderecoModel findByCep(String cep);
    Long countById(Long id);
}
