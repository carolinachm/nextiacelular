package br.com.nextiacelular.nextiacelular.controller;

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

import br.com.nextiacelular.nextiacelular.model.CategoriaModel;
import br.com.nextiacelular.nextiacelular.service.CategoriaService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CategoriaController {


    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/categoria")
    public ResponseEntity<?> cadastrar(@RequestBody CategoriaModel categoriaModel){
        return categoriaService.cadastrar(categoriaModel);
    }
    @GetMapping("/categoria")
    public ResponseEntity<?> listarTodos(){
        return categoriaService.listarTodas();
    }
    @GetMapping("/categoria/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        return categoriaService.buscarPorId(id);
    }
    @PutMapping("/categoria")
    public ResponseEntity<?> alterar(@RequestBody CategoriaModel categoriaModel){
        return categoriaService.alterar(categoriaModel);
    }
    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id){
        return categoriaService.remover(id);
    }
}
