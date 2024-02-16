package br.com.nextiacelular.nextiacelular.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.nextiacelular.nextiacelular.modelo.UsuarioModelo;
import br.com.nextiacelular.nextiacelular.repositorio.UsuarioRepositorio;
import br.com.nextiacelular.nextiacelular.util.Mensagem;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private Mensagem mensagem;


    //Metodo para realizar cadastro de usuario
    public ResponseEntity<?> cadastraUsuario(UsuarioModelo usuarioModelo){
        if(usuarioModelo.getEmail().equals("")){
            mensagem.setMensagem("O email é obrigatorio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(usuarioModelo.getSenha().equals("")){
            mensagem.setMensagem("O campo senha é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        //mensagem.setMensagem("Usuário cadastrado com sucesso");
        return new ResponseEntity<>(usuarioRepositorio.save(usuarioModelo), HttpStatus.CREATED);
    }

    //Método para listar todos os usuarios
    public ResponseEntity<?> listarTodosUsuarios() {
       return new ResponseEntity<>(usuarioRepositorio.findAll(), HttpStatus.OK);
    }

    //Metodo para buscar um usuario por codigo
    public ResponseEntity<?> buscarUsuarioPorCodigo(Long codigo){
        if(usuarioRepositorio.countByCodigo(codigo) == 0 ){
            mensagem.setMensagem("Usuário não foi encontrado");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(usuarioRepositorio.findByCodigo(codigo), HttpStatus.OK);
        }

    }
    //Método para editar usuario
    public ResponseEntity<?> editarUsuario(UsuarioModelo usuarioModelo){
        
        if(usuarioRepositorio.countByCodigo(usuarioModelo.getCodigo()) == 0){
            mensagem.setMensagem("O codigo informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(usuarioModelo.getEmail().equals("")){
            mensagem.setMensagem("O email é obrigatorio");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(usuarioModelo.getSenha().equals("")){
            mensagem.setMensagem("O campo senha é obrigatório");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(usuarioRepositorio.save(usuarioModelo), HttpStatus.OK);
    }

    public ResponseEntity<?> removerUsuario(Long codigo) {
        if(usuarioRepositorio.countByCodigo(codigo) == 0){
            mensagem.setMensagem("O codigo informado não existe");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{
            UsuarioModelo usuarioModelo = usuarioRepositorio.findByCodigo(codigo);
            usuarioRepositorio.delete(usuarioModelo);

            mensagem.setMensagem("Usuario removido com sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }
    }
    
}
