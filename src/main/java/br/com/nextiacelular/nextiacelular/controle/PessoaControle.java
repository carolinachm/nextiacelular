package br.com.nextiacelular.nextiacelular.controle;

import br.com.nextiacelular.nextiacelular.modelo.PessoaModelo;
import br.com.nextiacelular.nextiacelular.servico.PessoaServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PessoaControle {

    @Autowired
    private PessoaServico pessoaServico;
   
    @PostMapping("/pessoa")
    public ResponseEntity<?> cadastraPessoa(@RequestBody PessoaModelo pessoaModelo){
        return pessoaServico.cadastrarPessoa(pessoaModelo);
    }
    
    @GetMapping("/pessoa")
    public ResponseEntity<?> listarTodasPessoas(){
        return pessoaServico.listarTodasPessoas();
    }
    @GetMapping("/pessoa/{codigo}")
    public ResponseEntity<?> buscarPessoaPorCodigo(@PathVariable Long codigo){
        return pessoaServico.buscarPessoaPorCodigo(codigo);
    }
    @PutMapping("/pessoa")
    public ResponseEntity<?> editarPessoa(@RequestBody PessoaModelo pessoaModelo){
        return pessoaServico.editarPessoa(pessoaModelo);
    }
    @DeleteMapping("/pessoa/{codigo}")
    public ResponseEntity<?> removerPessoa(@PathVariable Long codigo){
        return pessoaServico.removerPessoa(codigo);
    }

}
