package br.com.nextiacelular.controller;

import br.com.nextiacelular.model.ProdutoModel;
import br.com.nextiacelular.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    public ProdutoService produtoService;

    @PostMapping("/produto")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModel produtoModel){
        return produtoService.cadastrar(produtoModel);
    }
    @GetMapping("/produto")
    public ResponseEntity<?> listarTodos(){
        return produtoService.listarTodos();
    }
    @GetMapping("/produto/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        return  produtoService.buscarPorId(id);
    }
    @PutMapping("/produto")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModel produtoModel){
        return produtoService.alterar(produtoModel);
    }
    @DeleteMapping("/produto/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id){
        return produtoService.excluir(id);
    }
}
