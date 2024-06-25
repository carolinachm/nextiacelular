package br.com.nextiacelular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.nextiacelular.model.EstoqueModel;
import br.com.nextiacelular.repository.EstoqueRepository;
import br.com.nextiacelular.util.Mensagem;

@Service
public class EstoqueService {
    
    @Autowired
    private EstoqueRepository estoqueRepository;
    @Autowired
    private Mensagem mensagem;

    //Método para cadastrar um estoque
    public ResponseEntity<?> cadastrar(EstoqueModel estoqueModel) {
        return new ResponseEntity<>(estoqueRepository.save(estoqueModel), HttpStatus.CREATED);
     }
     
    //Método para listar todo estoque
    public ResponseEntity<?> listarTodos(){
        return new ResponseEntity<>(estoqueRepository.findAll(), HttpStatus.OK);
    }
    //Metodo para buscar um produto no estoque
    public ResponseEntity<?> buscarPorId(Long id){
        return new ResponseEntity<>(estoqueRepository.countById(id), HttpStatus.OK);
    }
    //Metodo para atualizar o estoque
    public ResponseEntity<?> atualizar(EstoqueModel estoqueModel){
        return new ResponseEntity<>(estoqueRepository.save(estoqueModel), HttpStatus.OK);
    }
    //Metodo para remover o estoque
    public ResponseEntity<?> remover(Long id){
        if(estoqueRepository.countById(id) == 0){
            mensagem.setMensagem(" O id informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else {
            EstoqueModel estoqueModel = estoqueRepository.findById(id).get();
            estoqueRepository.delete(estoqueModel);
            mensagem.setMensagem("Estoque removido com sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
    
    
}
