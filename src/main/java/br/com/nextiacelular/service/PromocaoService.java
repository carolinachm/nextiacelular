package br.com.nextiacelular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.nextiacelular.model.ProdutoModel;
import br.com.nextiacelular.model.PromocaoModel;
import br.com.nextiacelular.repository.ProdutoRepository;
import br.com.nextiacelular.repository.PromocaoRepository;
import br.com.nextiacelular.util.Mensagem;

@Service
public class PromocaoService {
    
    @Autowired
    private PromocaoRepository promocaoRepository;

    @Autowired
    private Mensagem mensagem;

    //Método para cadastrar um produto
    public ResponseEntity<?> cadastrar(PromocaoModel promocaoModel) {
        if (promocaoModel.getNome().equals("")) {
            mensagem.setMensagem("O campo nome é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if (promocaoModel.getDesconto().equals("")) {
            mensagem.setMensagem("O campo descrição é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(promocaoRepository.save(promocaoModel), HttpStatus.CREATED);
        }
    }
    //Método para listar todos produtos
    public ResponseEntity<?> listarTodos() {
        return new ResponseEntity<>(promocaoRepository.findAll(), HttpStatus.OK);
    }
    //Método para buscar um produto
    public ResponseEntity<?> buscarPorId(Long id) {
        if (promocaoRepository.countById(id) == 0){
            mensagem.setMensagem("Não foi encontrado nenhum promocao com esse id");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(promocaoRepository.findById(id), HttpStatus.OK);
        }
    }
    //Método para alterar um produto
    public ResponseEntity<?>  alterar(PromocaoModel promocaoModel) {
        if (promocaoModel.getNome().equals("")) {
            mensagem.setMensagem("O campo nome é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if (promocaoModel.getDesconto().equals("")) {
            mensagem.setMensagem("O campo descrição é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(promocaoRepository.save(promocaoModel), HttpStatus.OK);
        }

    }
    //Método para remover um produto
    public ResponseEntity<?> excluir(Long id) {
        if(promocaoRepository.countById(id) == 0){
            mensagem.setMensagem(" O id informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else {
            PromocaoModel promocaoModel = promocaoRepository.findById(id).get();
            promocaoRepository.delete(promocaoModel);
            mensagem.setMensagem("Promocao removido com sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
}
