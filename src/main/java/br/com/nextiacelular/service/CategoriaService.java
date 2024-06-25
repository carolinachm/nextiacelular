package br.com.nextiacelular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.nextiacelular.model.CategoriaModel;
import br.com.nextiacelular.repository.CategoriaRepository;
import br.com.nextiacelular.util.Mensagem;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private Mensagem mensagem;


    //Método para cadastrar Categoria
    public ResponseEntity<?> cadastrar(CategoriaModel categoriaModel){
        if(categoriaModel.getNome().equals("")){
            mensagem.setMensagem("O campo nome é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(categoriaRepository.save(categoriaModel), HttpStatus.CREATED);
        }
        
    }
    //Método para listar todas categorias
    public ResponseEntity<?> listarTodas(){
        return new ResponseEntity<>(categoriaRepository.findAll(), HttpStatus.OK);
    }
    //Método para buscar uma categoria
    public ResponseEntity<?> buscarPorId(Long id){
        if (categoriaRepository.countById(id) == 0) {
            mensagem.setMensagem("Não foi encontrado um cliente com o id " + id);
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(categoriaRepository.findById(id), HttpStatus.OK);
        }
    }
    //Mégodo para alterar categoria
    public ResponseEntity<?> alterar(CategoriaModel categoriaModel){
        if(categoriaModel.getNome().equals("")){
            mensagem.setMensagem("O campo nome é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(categoriaRepository.save(categoriaModel), HttpStatus.OK);
        }
    }
    //Médoto para excluir categoria
    public ResponseEntity<?> remover(Long id){
         if(categoriaRepository.countById(id) == 0) {
            mensagem.setMensagem("O id informado não exite");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else {
            CategoriaModel categoriaModel = categoriaRepository.findById(id).get();
            categoriaRepository.delete(categoriaModel);
            mensagem.setMensagem("Categoria foi removido com sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
    
}
