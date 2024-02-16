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

import br.com.nextiacelular.nextiacelular.modelo.EnderecoModelo;
import br.com.nextiacelular.nextiacelular.servico.EnderecoServico;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EnderecoControle {

    @Autowired
    private EnderecoServico enderecoServico;

    @PostMapping("/endereco")
    public ResponseEntity<?> cadastrarEndereco(@RequestBody EnderecoModelo enderecoModelo){
        return enderecoServico.cadastrarEndereco(enderecoModelo);
    }
    @GetMapping("/endereco")
    public ResponseEntity<?> listarTodosEndereco(){
        return enderecoServico.listarTodosEndereco();
    }
    @GetMapping("/endereco/{codigo}")
    public ResponseEntity<?> buscarEnderecoPorCodogo(@PathVariable Long codigo){
        return enderecoServico.buscarEnderecoPorCodigo(codigo);
    }
    @PutMapping("/endereco")
    public ResponseEntity<?> editarEndereco(@RequestBody EnderecoModelo enderecoModelo){
        return enderecoServico.editarEndereco(enderecoModelo);
    }
    @DeleteMapping("/endereco/{codigo}")
    public ResponseEntity<?> removerEndereco(@PathVariable Long codigo){
        return enderecoServico.removerEndereco(codigo);
    }
    
    
}
