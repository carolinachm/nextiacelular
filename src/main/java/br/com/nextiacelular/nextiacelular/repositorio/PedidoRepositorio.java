package br.com.nextiacelular.nextiacelular.repositorio;

import br.com.nextiacelular.nextiacelular.modelo.EnderecoModelo;
import br.com.nextiacelular.nextiacelular.modelo.PedidoModelo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PedidoRepositorio extends CrudRepository<PedidoModelo, Long> {

    List<PedidoModelo> findAll();
    PedidoModelo findByCodigo(Long codigo);
    Long countByCodigo(Long codigo);

}
