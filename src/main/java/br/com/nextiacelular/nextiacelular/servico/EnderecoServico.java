package br.com.nextiacelular.nextiacelular.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.nextiacelular.nextiacelular.modelo.EnderecoModelo;
import br.com.nextiacelular.nextiacelular.repositorio.EnderecoRepositorio;
import br.com.nextiacelular.nextiacelular.util.Mensagem;

@Service
public class EnderecoServico {

    @Autowired
    private EnderecoRepositorio enderecoRepositorio;

    @Autowired
    private Mensagem mensagem;


    //Metodo para cadastrar endereço
    public ResponseEntity<?>  cadastrarEndereco(EnderecoModelo enderecoModelo){
        
        if(enderecoModelo.getCep() == ""){
            mensagem.setMensagem("O campo cep é obrigatorio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(enderecoRepositorio.save(enderecoModelo), HttpStatus.CREATED);
        }
    }
    //Metodo para listar todos os endereco
    public ResponseEntity<?> listarTodosEndereco(){
        return new ResponseEntity<>(enderecoRepositorio.findAll(), HttpStatus.OK);
    }
    //Metodo para buscar endereco por codigo
    public ResponseEntity<?> buscarEnderecoPorCodigo(Long codigo){
        if(enderecoRepositorio.countByCodigo(codigo) == 0){
            mensagem.setMensagem("O codigo informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(enderecoRepositorio.findByCodigo(codigo), HttpStatus.OK);
        }
    }
    //Metodo para editar endereco
    public ResponseEntity<?>  editarEndereco(EnderecoModelo enderecoModelo){
        if(enderecoRepositorio.countByCodigo(enderecoModelo.getCodigo()) == 0){
            mensagem.setMensagem("O codigo infomrado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);

        }else if(enderecoModelo.getCep() == ""){
            mensagem.setMensagem("O campo cep é obrigatorio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(enderecoRepositorio.save(enderecoModelo), HttpStatus.OK);
        }
    }
    //Metodo para remover endereco
    public ResponseEntity<?> removerEndereco(Long codigo){
        if(enderecoRepositorio.countByCodigo(codigo) == 0){
            mensagem.setMensagem("O codigo informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{
            EnderecoModelo enderecoModelo = enderecoRepositorio.findByCodigo(codigo);
            enderecoRepositorio.delete(enderecoModelo);

            mensagem.setMensagem("Endereço removido com sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
    
}
