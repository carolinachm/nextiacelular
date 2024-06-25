package br.com.nextiacelular.controller;

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

import br.com.nextiacelular.model.PromocaoModel;
import br.com.nextiacelular.service.PromocaoService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PromocaoController {

    @Autowired
    private PromocaoService promocaoService;

    @PostMapping("/promocao")
    public ResponseEntity<?> cadastrar(@RequestBody PromocaoModel promocaoModel){
        return promocaoService.cadastrar(promocaoModel);
    }
    @GetMapping("/promocao")
    public ResponseEntity<?> listarTodos(){
        return promocaoService.listarTodos();
    }
    @GetMapping("/promocao/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        return promocaoService.buscarPorId(id);
    }
    @PutMapping("/promocao")
    public ResponseEntity<?> atualizar(@RequestBody PromocaoModel promocaoModel){
        return promocaoService.alterar(promocaoModel);
    }
    @DeleteMapping("/promocao/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id){
        return promocaoService.excluir(id);
    }
}
