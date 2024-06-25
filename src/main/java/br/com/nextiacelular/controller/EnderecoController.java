package br.com.nextiacelular.controller;

import br.com.nextiacelular.model.EnderecoModel;
import br.com.nextiacelular.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/endereco")
    public ResponseEntity<?> cadastrar(@RequestBody EnderecoModel enderecoModel) {
        return enderecoService.cadastrarEndereco(enderecoModel);
    }
    @GetMapping("/endereco")
    public ResponseEntity<?> listar() {
        return enderecoService.listartodosEndereco();
    }
    @GetMapping("/enedereco/{id}")
    public ResponseEntity<?> buscarEnderecoPorId(@PathVariable Long id) {
        return enderecoService.buscarEnderecoPorId(id);
    }
    @PutMapping("/endereco")
    public ResponseEntity<?> atualizar(@RequestBody EnderecoModel enderecoModel) {
        return enderecoService.alterarEndereco(enderecoModel);
    }
    @DeleteMapping("/endereco/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        return enderecoService.excluirEndereco(id);
    }

}
