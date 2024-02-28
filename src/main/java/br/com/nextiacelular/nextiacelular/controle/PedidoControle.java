package br.com.nextiacelular.nextiacelular.controle;

import br.com.nextiacelular.nextiacelular.modelo.PedidoModelo;
import br.com.nextiacelular.nextiacelular.servico.PedidoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PedidoControle {

    @Autowired
    private PedidoServico pedidoServico;

    @PostMapping("/pedido")
    public ResponseEntity<?> cadastraPedido(@RequestBody PedidoModelo pedidoModelo){
        return pedidoServico.cadastraPedido(pedidoModelo);
    }
}
