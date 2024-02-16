package br.com.nextiacelular.nextiacelular.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.nextiacelular.nextiacelular.modelo.EnderecoModelo;

public interface EnderecoRepositorio extends CrudRepository<EnderecoModelo, Long>{

    List<EnderecoModelo> findAll();
    EnderecoModelo findByCodigo(Long codigo);
    Long countByCodigo(Long codigo);
    
}
