package br.com.nextiacelular.nextiacelular.servico;

import br.com.nextiacelular.nextiacelular.modelo.PessoaModelo;
import br.com.nextiacelular.nextiacelular.modelo.ProdutoModelo;
import br.com.nextiacelular.nextiacelular.repositorio.ProdutoRepositorio;
import br.com.nextiacelular.nextiacelular.util.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;
    @Autowired
    private Mensagem mensagem;

    //Metodo para cadastrar produto
    public ResponseEntity<?> cadastrarProduto(ProdutoModelo produtoModelo) {
        if (produtoModelo.getNome().equals("")) {
            mensagem.setMensagem("Informe o nome do produto");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (produtoModelo.getCategoriaModelo() == null) {
            mensagem.setMensagem("Informe a categoria do produto");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (produtoModelo.getMarcaModeloList() == null || produtoModelo.getMarcaModeloList().isEmpty()) {
            mensagem.setMensagem("Informe a marca do produto");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (produtoModelo.getValor() == null || produtoModelo.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            mensagem.setMensagem("Informe um valor válido para o produto");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(produtoRepositorio.save(produtoModelo), HttpStatus.CREATED);
        }
    }

    //Metodo para Listar produtos
    public ResponseEntity<?> listarTodosProduto(){
        return new ResponseEntity<>(produtoRepositorio.findAll(), HttpStatus.OK);
    }
    //Metodo para buscar um produto
    public ResponseEntity<?> buscarProdutoPorCodigo(Long codigo){
        if(produtoRepositorio.countByCodigo(codigo) == 0){
            mensagem.setMensagem("Codigo informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(produtoRepositorio.findByCodigo(codigo), HttpStatus.OK);
        }
    }
    //Metodo para editar produto
    public ResponseEntity<?> editarProduto(ProdutoModelo produtoModelo){
        if(produtoRepositorio.countByCodigo(produtoModelo.getCodigo()) == 0){
            mensagem.setMensagem("O codigo infomando não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if(produtoModelo.getNome().equals("")){
            mensagem.setMensagem("Informe o nome do produto");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if (produtoModelo.getCategoriaModelo().equals("")){
            mensagem.setMensagem("Informe a categoria do produto");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (produtoModelo.getMarcaModeloList().equals("")) {
            mensagem.setMensagem("Informe a marca do produto");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(produtoModelo.getValor() == null || produtoModelo.getValor().compareTo(BigDecimal.ZERO) <= 0){
            mensagem.setMensagem("Informe o valor do produto");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(produtoRepositorio.save(produtoModelo), HttpStatus.CREATED);
        }
    }
    // Metodo para remover Produto
    public ResponseEntity<?> removerProduto(Long codigo){
        if(produtoRepositorio.countByCodigo(codigo) == 0){
            mensagem.setMensagem("O código informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{
            ProdutoModelo produtoModelo = produtoRepositorio.findByCodigo(codigo);
            produtoRepositorio.delete(produtoModelo);
            mensagem.setMensagem("O produto foi removida com sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }

}


