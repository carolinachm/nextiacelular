package br.com.nextiacelular.nextiacelular.service;

import br.com.nextiacelular.nextiacelular.model.ClienteModel;
import br.com.nextiacelular.nextiacelular.repository.ClienteRepository;
import br.com.nextiacelular.nextiacelular.util.Mensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private Mensagem mensagem;

    //Metodo para cadastrar
    public ResponseEntity<?> cadastrar(ClienteModel clienteModel) {
        if(clienteModel.getNome().equals("")) {
            mensagem.setMensagem("O campo nome é obrigatorio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(clienteModel.getEmail().equals("")) {
            mensagem.setMensagem("O campo email é obrigatorio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(clienteModel.getCpf().equals("")) {
            mensagem.setMensagem("O campo cpf é obrigatorio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(clienteModel.getTelefone().equals("")){
            mensagem.setMensagem("O campo telefone é obrigatorio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(clienteRepository.save(clienteModel), HttpStatus.CREATED);
        }
    }
    //Metodo para listar todos os cliente
    public ResponseEntity<?> listarTodos() {
    return new ResponseEntity<>(clienteRepository.findAll(), HttpStatus.OK);}

    //Metodo para busca cliente por id
    public ResponseEntity<?> buscarPorId(Long id) {
        if(clienteRepository.countById(id) == 0) {
            mensagem.setMensagem("Não foi encontrado um cliente com o id " + id);
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(clienteRepository.findById(id), HttpStatus.OK);
        }
    }
    //Medoto para alterar cliente
    public ResponseEntity<?> alterar(ClienteModel clienteModel) {
        if(clienteRepository.countById(clienteModel.getId()) == 0) {
            mensagem.setMensagem("O codigo não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if(clienteModel.getNome().equals("")) {
            mensagem.setMensagem("O campo nome é obrigatorio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(clienteModel.getEmail().equals("")) {
            mensagem.setMensagem("O campo email é obrigatorio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(clienteModel.getCpf().equals("")) {
            mensagem.setMensagem("O campo cpf é obrigatorio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(clienteModel.getTelefone().equals("")){
            mensagem.setMensagem("O campo telefone é obrigatorio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else
            return new ResponseEntity<>(clienteRepository.save(clienteModel), HttpStatus.OK);
    }
    //Metodo para remover um cliente
    public ResponseEntity<?> excluir(Long id) {
        if(clienteRepository.countById(id) == 0) {
            mensagem.setMensagem("O id informado não exite");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else {
            ClienteModel clienteModel = clienteRepository.findById(id).get();
            clienteRepository.delete(clienteModel);
            mensagem.setMensagem("Cliente foi removido com sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
}