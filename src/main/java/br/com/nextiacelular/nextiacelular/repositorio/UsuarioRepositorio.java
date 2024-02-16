package br.com.nextiacelular.nextiacelular.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.nextiacelular.nextiacelular.modelo.UsuarioModelo;

public interface UsuarioRepositorio extends CrudRepository<UsuarioModelo, Long>{
    List<UsuarioModelo> findAll();
    UsuarioModelo findByCodigo(Long codigo);
    Long countByCodigo(Long codigo);
}
