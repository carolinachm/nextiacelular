package br.com.nextiacelular.nextiacelular.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nextiacelular.nextiacelular.modelo.UsuarioModelo;
import br.com.nextiacelular.nextiacelular.servico.UsuarioServico;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UsuarioControle {

    @Autowired
    private UsuarioServico usuarioServico;
    
    @PostMapping("/usuario")
    public ResponseEntity<?> cadastraUsuario(@RequestBody UsuarioModelo usuarioModelo){
        return  usuarioServico.cadastraUsuario(usuarioModelo);
    }
    @GetMapping("/usuario")
    public ResponseEntity<?> listarTodosUsuarios(){
        return usuarioServico.listarTodosUsuarios();
    }
    @GetMapping("/usuario/{codigo}")
    public ResponseEntity<?> buscarUsuarioPorCodigo(@PathVariable Long codigo){
        return usuarioServico.buscarUsuarioPorCodigo(codigo);
    }
    @PutMapping("/usuario")
    public ResponseEntity<?> editarUsuario(@RequestBody UsuarioModelo usuarioModelo){
        return usuarioServico.editarUsuario(usuarioModelo);
    }
    @DeleteMapping("/usuario/{codigo}")
    public ResponseEntity<?> removerUsuario(@PathVariable Long codigo){
        return usuarioServico.removerUsuario(codigo);
    }

}
