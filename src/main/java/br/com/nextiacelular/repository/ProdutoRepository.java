package br.com.nextiacelular.nextiacelular.repository;

import br.com.nextiacelular.nextiacelular.model.ProdutoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<ProdutoModel, Long> {
    Long countById(Long id);
}
