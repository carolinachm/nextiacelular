package br.com.nextiacelular.nextiacelular.service;

import br.com.nextiacelular.nextiacelular.model.EnderecoModel;
import br.com.nextiacelular.nextiacelular.repository.EnderecoRepository;
import br.com.nextiacelular.nextiacelular.util.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private Mensagem mensagem;

    //Metodo para cadastrar endereço
    public ResponseEntity<?> cadastrarEndereco(EnderecoModel enderecoModel){
        if(enderecoModel.getCep().equals("")){
            mensagem.setMensagem("O campo cep deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(enderecoRepository.save(enderecoModel), HttpStatus.CREATED);
    }
    //Método para listar todos os endereços
    public ResponseEntity<?> listartodosEndereco(){
        return new ResponseEntity<>(enderecoRepository.findAll(), HttpStatus.OK);
    }
    //Metodo para buscar um endereco
    public ResponseEntity<?> buscarEnderecoPorId(Long id){
        if(enderecoRepository.countById(id) == 0){
            mensagem.setMensagem("Não foi encontrado nenhum endereço");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(enderecoRepository.findById(id), HttpStatus.OK);
    }
    //Método para atualizar o endreco
    public ResponseEntity<?> alterarEndereco(EnderecoModel enderecoModel){
        if(enderecoRepository.countById(enderecoModel.getId()) ==0){
        mensagem.setMensagem("O código não foi encontrado.");
        return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(enderecoModel.getCep().equals("")){
            mensagem.setMensagem("O campo cep deve ser preenchido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(enderecoRepository.save(enderecoModel), HttpStatus.OK);
    }
    //Método para remover um endereco
    public ResponseEntity<?> excluirEndereco(Long id){
        if(enderecoRepository.countById(id) == 0){
            mensagem.setMensagem("O id informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{
            EnderecoModel enderecoModel = enderecoRepository.findById(id).get();
            enderecoRepository.deleteById(id);
            mensagem.setMensagem("Endereço removido com sucesso.");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }

    }
}
