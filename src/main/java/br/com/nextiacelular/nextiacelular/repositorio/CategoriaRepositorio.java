package br.com.nextiacelular.nextiacelular.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.nextiacelular.nextiacelular.modelo.CategoriaModelo;

public interface CategoriaRepositorio extends CrudRepository<CategoriaModelo, Long>{
    
    List<CategoriaModelo> findAll();
    CategoriaModelo findByCodigo(Long codigo);
    Long countByCodigo(Long codigo);
}
