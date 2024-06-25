package br.com.nextiacelular.service;

import br.com.nextiacelular.model.ProdutoModel;
import br.com.nextiacelular.repository.ProdutoRepository;
import br.com.nextiacelular.util.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private Mensagem mensagem;

    //Método para cadastrar um produto
    public ResponseEntity<?> cadastrar(ProdutoModel produtoModel) {
        if (produtoModel.getNome().equals("")) {
            mensagem.setMensagem("O campo nome é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if (produtoModel.getDescricao().equals("")) {
            mensagem.setMensagem("O campo descrição é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(produtoModel.getValor() == null){
            mensagem.setMensagem("O campo valor deve ser preenchido com um valor válido");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(produtoRepository.save(produtoModel), HttpStatus.CREATED);
        }
    }
    //Método para listar todos produtos
    public ResponseEntity<?> listarTodos() {
        return new ResponseEntity<>(produtoRepository.findAll(), HttpStatus.OK);
    }
    //Método para buscar um produto
    public ResponseEntity<?> buscarPorId(Long id) {
        if (produtoRepository.countById(id) == 0){
            mensagem.setMensagem("Não foi encontrado nenhum produto com esse id");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(produtoRepository.findById(id), HttpStatus.OK);
        }
    }
    //Método para alterar um produto
    public ResponseEntity<?>  alterar(ProdutoModel produtoModel) {
        if (produtoRepository.countById(produtoModel.getId()) == 0){
            mensagem.setMensagem("O id não foi encontrado");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if (produtoModel.getNome().equals("")) {
            mensagem.setMensagem("O campo nome é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if (produtoModel.getDescricao().equals("")) {
            mensagem.setMensagem("O campo descrição é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(produtoModel.getValor() == null){
                mensagem.setMensagem("O campo valor deve ser preenchido com um valor válido");
                return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
            } else {
            return new ResponseEntity<>(produtoRepository.save(produtoModel), HttpStatus.OK);
        }

    }
    //Método para remover um produto
    public ResponseEntity<?> excluir(Long id) {
        if(produtoRepository.countById(id) == 0){
            mensagem.setMensagem(" O id informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else {
            ProdutoModel produtoModel = produtoRepository.findById(id).get();
            produtoRepository.delete(produtoModel);
            mensagem.setMensagem("Produto removido com sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
}
