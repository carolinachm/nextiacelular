package br.com.nextiacelular.repository;

import br.com.nextiacelular.model.ClienteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Long> {
    List<ClienteModel> findAll();
    ClienteModel findById(long id);
    Long countById(long id);
}
