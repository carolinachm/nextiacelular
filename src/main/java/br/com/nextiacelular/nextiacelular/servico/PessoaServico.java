package br.com.nextiacelular.nextiacelular.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.nextiacelular.nextiacelular.modelo.PessoaModelo;
import br.com.nextiacelular.nextiacelular.repositorio.PessoaRepositorio;
import br.com.nextiacelular.nextiacelular.util.Mensagem;

@Service
public class PessoaServico {

    @Autowired
    private Mensagem mensagem;
    @Autowired PessoaRepositorio pessoaRepositorio;

    //Metodo para cadastrar pessoa
    public ResponseEntity<?> cadastrarPessoa(PessoaModelo pessoaModelo){
        
        if(pessoaModelo.getNome().equals("")){
            mensagem.setMensagem("O campo nome é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(pessoaModelo.getCpf().equals("")){
            mensagem.setMensagem("O campo cpf é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(pessoaModelo.getEnderecoModeloList().equals("")){
            mensagem.setMensagem("O campo endereço é obrigátorio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(pessoaRepositorio.save(pessoaModelo), HttpStatus.CREATED);
        }
    }

    //Metodo para listar todas as pessoas
    public ResponseEntity<?> listarTodasPessoas(){
        return new ResponseEntity<>(pessoaRepositorio.findAll(), HttpStatus.OK);
    }
    //Método para selecionar uma pessoa pelo código
    public ResponseEntity<?> buscarPessoaPorCodigo(Long codigo){

        if(pessoaRepositorio.countByCodigo(codigo) == 0) {
            mensagem.setMensagem("Não foi encontrado a pessoa");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
           
            return new ResponseEntity<>(pessoaRepositorio.findByCodigo(codigo), HttpStatus.OK);
        }
    }
    //Método para editar pessoa
    public ResponseEntity<?> editarPessoa(PessoaModelo pessoaModelo){

        if(pessoaRepositorio.countByCodigo(pessoaModelo.getCodigo()) == 0){
            mensagem.setMensagem("O código informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(pessoaModelo.getNome().equals("")){
            mensagem.setMensagem("O campo nome é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(pessoaModelo.getCpf().equals("")){
            mensagem.setMensagem("O campo cpf é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(pessoaModelo.getEnderecoModeloList().equals("")){
            mensagem.setMensagem("O campo endereço é obrigátorio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(pessoaRepositorio.save(pessoaModelo), HttpStatus.OK);
        }

    }
    //Método para remover pessoa
    public ResponseEntity<?> removerPessoa(Long codigo){
        if(pessoaRepositorio.countByCodigo(codigo) == 0){
            mensagem.setMensagem("O código informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{
            PessoaModelo pessoaModelo = pessoaRepositorio.findByCodigo(codigo);
            pessoaRepositorio.delete(pessoaModelo);
            mensagem.setMensagem("Pessoa removida com sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
}
