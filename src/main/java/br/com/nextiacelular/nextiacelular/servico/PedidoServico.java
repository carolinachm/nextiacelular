package br.com.nextiacelular.nextiacelular.servico;

import br.com.nextiacelular.nextiacelular.modelo.PedidoModelo;
import br.com.nextiacelular.nextiacelular.repositorio.PedidoRepositorio;
import br.com.nextiacelular.nextiacelular.util.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PedidoServico {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;
    @Autowired
    private Mensagem mensagem;

    //Método para cadastra pedido
    public ResponseEntity<?> cadastraPedido(PedidoModelo pedidoModelo) {
        if(pedidoModelo.getItensPedido() == null){
            mensagem.setMensagem("Selecione o pedido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if (pedidoModelo.getPessoaModelo().getNome().equals("")) {
            mensagem.setMensagem("Informe o nome da pessoa que fez o pedido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (pedidoModelo.getDataPedido() == null) {
            mensagem.setMensagem("Informe a data do pedido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (pedidoModelo.getFormaPagamento() == null) {
            mensagem.setMensagem("Informe a forma de pagamento");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(pedidoRepositorio.save(pedidoModelo), HttpStatus.CREATED);
        }
    }

}
