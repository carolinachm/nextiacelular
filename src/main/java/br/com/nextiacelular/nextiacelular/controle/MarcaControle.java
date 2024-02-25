package br.com.nextiacelular.nextiacelular.controle;

import br.com.nextiacelular.nextiacelular.modelo.CategoriaModelo;
import br.com.nextiacelular.nextiacelular.modelo.MarcaModelo;
import br.com.nextiacelular.nextiacelular.servico.CategoriaServico;
import br.com.nextiacelular.nextiacelular.servico.MarcaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MarcaControle {

    @Autowired
    private MarcaServico marcaServico;


    @PostMapping("/marca")
    public ResponseEntity<?> cadastrarMarca(@RequestBody MarcaModelo marcaModelo){
        return marcaServico.cadastraMarca(marcaModelo);
    }
    @GetMapping("/marca")
    public ResponseEntity<?> listarTodasMarca(){
        return marcaServico.listarTodasMarca();
    }
    @GetMapping("/marca/{codigo}")
    public ResponseEntity<?> buscarMarcaPorCodigo(@PathVariable Long codigo){
        return marcaServico.buscarMarcaPorCodigo(codigo);
    }
    @PutMapping("/marca")
    public ResponseEntity<?> editarMarca(@RequestBody MarcaModelo marcaModelo){
        return marcaServico.editarMarca(marcaModelo);
    }
    @DeleteMapping("/marca/{codigo}")
    public ResponseEntity<?> removerMarca(@PathVariable Long codigo){
        return marcaServico.removerMarca(codigo);
    }


    
}
