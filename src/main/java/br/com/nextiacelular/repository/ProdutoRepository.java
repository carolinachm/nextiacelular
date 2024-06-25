package br.com.nextiacelular.repository;

import br.com.nextiacelular.model.ProdutoModel;
import br.com.nextiacelular.model.PromocaoModel;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<ProdutoModel, Long> {

    List<ProdutoModel> findAll();
    ProdutoModel findById(long id);
    Long countById(long id);
}
