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

import br.com.nextiacelular.model.EstoqueModel;
import br.com.nextiacelular.service.EstoqueService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;


    @PostMapping("/estoque")
    public ResponseEntity<?> cadastrar(@RequestBody EstoqueModel estoqueModel){
        return estoqueService.cadastrar(estoqueModel);
    }
    @GetMapping("/estoque")
    public ResponseEntity<?> listarTodos(){
        return estoqueService.listarTodos();
    }
    @GetMapping("/estoque/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        return estoqueService.buscarPorId(id);
    }
    @PutMapping("/estoque")
    public ResponseEntity<?> alterar(@RequestBody EstoqueModel estoqueModel){
        return estoqueService.atualizar(estoqueModel);
    }
    @DeleteMapping("/estoque/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id){
        return estoqueService.remover(id);
    }
    
}
