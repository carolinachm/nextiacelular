package br.com.nextiacelular.nextiacelular.servico;

import br.com.nextiacelular.nextiacelular.modelo.CategoriaModelo;
import br.com.nextiacelular.nextiacelular.modelo.MarcaModelo;
import br.com.nextiacelular.nextiacelular.repositorio.CategoriaRepositorio;
import br.com.nextiacelular.nextiacelular.repositorio.MarcaRepositorio;
import br.com.nextiacelular.nextiacelular.util.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MarcaServico {

    @Autowired
    private MarcaRepositorio marcaRepositorio;
    @Autowired
    private Mensagem mensagem;

    //Método para cadastrar categoria
    public ResponseEntity<?> cadastraMarca(MarcaModelo marcaModelo){
        if(marcaModelo.getDescricao() == ""){
            mensagem.setMensagem("A descrição é obrigatória");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(marcaRepositorio.save(marcaModelo), HttpStatus.CREATED);
        }
    }
    //Método para listar todas as marca
    public ResponseEntity<?> listarTodasMarca(){
        return new ResponseEntity<>(marcaRepositorio.findAll(), HttpStatus.OK);
    }
    //Metodo para buscar uma marca
    public ResponseEntity<?> buscarMarcaPorCodigo(Long codigo){
        if(marcaRepositorio.countByCodigo(codigo) == 0){
            mensagem.setMensagem("O codigo indormado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(marcaRepositorio.findByCodigo(codigo), HttpStatus.OK);
        }
    }
    //Metodo para editar uma marca
    public ResponseEntity<?> editarMarca(MarcaModelo marcaModelo){
        
        if(marcaRepositorio.countByCodigo(marcaModelo.getCodigo()) == 0){
            mensagem.setMensagem("O codigo informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if(marcaModelo.getDescricao() == ""){
            mensagem.setMensagem("A descrição é obrigatória");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(marcaRepositorio.save(marcaModelo), HttpStatus.OK);
        }
    }
    public ResponseEntity<?> removerMarca(Long codigo) {
       
    if(marcaRepositorio.countByCodigo(codigo) == 0){
        mensagem.setMensagem("O codigo informado não existe");
        return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
    }else{
        MarcaModelo marcaModelo = marcaRepositorio.findByCodigo(codigo);
        marcaRepositorio.delete(marcaModelo);
    
        mensagem.setMensagem("Categoria removido com sucesso");
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }
}
    
}
