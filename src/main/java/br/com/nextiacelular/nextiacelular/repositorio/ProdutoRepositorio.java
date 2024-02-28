package br.com.nextiacelular.nextiacelular.repositorio;

import br.com.nextiacelular.nextiacelular.modelo.ProdutoModelo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Long> {

    List<ProdutoModelo> findAll();
    ProdutoModelo findByCodigo(Long codigo);
    Long countByCodigo(Long codigo);
}
