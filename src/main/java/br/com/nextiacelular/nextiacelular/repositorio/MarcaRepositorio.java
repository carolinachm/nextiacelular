package br.com.nextiacelular.nextiacelular.repositorio;

import java.util.List;

import br.com.nextiacelular.nextiacelular.modelo.MarcaModelo;
import org.springframework.data.repository.CrudRepository;

import br.com.nextiacelular.nextiacelular.modelo.CategoriaModelo;

public interface MarcaRepositorio extends CrudRepository<MarcaModelo, Long>{
    
    List<MarcaModelo> findAll();
    MarcaModelo findByCodigo(Long codigo);
    Long countByCodigo(Long codigo);
}
