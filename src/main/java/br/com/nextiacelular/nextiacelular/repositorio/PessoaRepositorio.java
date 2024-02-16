package br.com.nextiacelular.nextiacelular.repositorio;

import br.com.nextiacelular.nextiacelular.modelo.PessoaModelo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PessoaRepositorio extends CrudRepository<PessoaModelo, Long> {

    List<PessoaModelo> findAll();
    PessoaModelo findByCodigo(Long codigo);
    Long countByCodigo(Long codigo);
}
