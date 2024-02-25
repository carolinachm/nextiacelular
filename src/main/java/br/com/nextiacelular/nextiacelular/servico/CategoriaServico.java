package br.com.nextiacelular.nextiacelular.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.nextiacelular.nextiacelular.modelo.CategoriaModelo;
import br.com.nextiacelular.nextiacelular.repositorio.CategoriaRepositorio;
import br.com.nextiacelular.nextiacelular.util.Mensagem;

@Service
public class CategoriaServico {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    @Autowired
    private Mensagem mensagem;

    //Método para cadastrar categoria
    public ResponseEntity<?> cadastrarCategoria(CategoriaModelo categoriaModelo){
        if(categoriaModelo.getDescricao() == ""){
            mensagem.setMensagem("A descrição é obrigatória");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(categoriaRepositorio.save(categoriaModelo), HttpStatus.CREATED);
        }
    }
    //Método para listar todas as categorias
    public ResponseEntity<?> listarTodasCategorias(){
        return new ResponseEntity<>(categoriaRepositorio.findAll(), HttpStatus.OK);
    }
    //Metodo para buscar uma categoria
    public ResponseEntity<?> buscarCategoriaPorCodigo(Long codigo){
        if(categoriaRepositorio.countByCodigo(codigo) == 0){
            mensagem.setMensagem("O codigo indormado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(categoriaRepositorio.findByCodigo(codigo), HttpStatus.OK);
        }
    }
    //Metodo para editar uma categoria
    public ResponseEntity<?> editarCategoria(CategoriaModelo categoriaModelo){
        
        if(categoriaRepositorio.countByCodigo(categoriaModelo.getCodigo()) == 0){
            mensagem.setMensagem("O codigo informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if(categoriaModelo.getDescricao() == ""){
            mensagem.setMensagem("A descrição é obrigatória");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(categoriaRepositorio.save(categoriaModelo), HttpStatus.OK);
        }
    }
    public ResponseEntity<?> removerCategoria(Long codigo) {
       
    if(categoriaRepositorio.countByCodigo(codigo) == 0){
        mensagem.setMensagem("O codigo informado não existe");
        return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
    }else{
        CategoriaModelo categoriaModelo = categoriaRepositorio.findByCodigo(codigo);
        categoriaRepositorio.delete(categoriaModelo);
    
        mensagem.setMensagem("Categoria removido com sucesso");
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }
}
    
}
