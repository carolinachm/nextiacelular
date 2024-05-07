package br.com.nextiacelular.nextiacelular.repository;

import br.com.nextiacelular.nextiacelular.model.EnderecoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends CrudRepository<EnderecoModel, Long> {
    List<EnderecoModel> findAll();
    EnderecoModel findByCep(String cep);
    Long countById(Long id);
}
