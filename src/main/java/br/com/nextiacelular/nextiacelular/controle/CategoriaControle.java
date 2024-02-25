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

import br.com.nextiacelular.nextiacelular.modelo.CategoriaModelo;
import br.com.nextiacelular.nextiacelular.servico.CategoriaServico;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CategoriaControle {

    @Autowired
    private CategoriaServico categoriaServico;


    @PostMapping("/categoria")
    public ResponseEntity<?> cadastrarCategoria(@RequestBody CategoriaModelo CategoriaModelo){
        return categoriaServico.cadastrarCategoria(CategoriaModelo);
    }
    @GetMapping("/categoria")
    public ResponseEntity<?> listarTodasCategorias(){
        return categoriaServico.listarTodasCategorias();
    }
    @GetMapping("/categoria/{codigo}")
    public ResponseEntity<?> buscarCategoriaPorCodigo(@PathVariable Long codigo){
        return categoriaServico.buscarCategoriaPorCodigo(codigo);
    }
    @PutMapping("/categoria")
    public ResponseEntity<?> editarCategoria(@RequestBody CategoriaModelo categoriaModelo){
        return categoriaServico.editarCategoria(categoriaModelo);
    }
    @DeleteMapping("/categoria/{codigo}")
    public ResponseEntity<?> removerCategoria(@PathVariable Long codigo){
        return categoriaServico.removerCategoria(codigo);
    }


    
}
