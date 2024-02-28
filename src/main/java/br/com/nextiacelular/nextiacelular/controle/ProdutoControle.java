package br.com.nextiacelular.nextiacelular.controle;

import br.com.nextiacelular.nextiacelular.modelo.ProdutoModelo;
import br.com.nextiacelular.nextiacelular.servico.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProdutoControle {

    @Autowired
    private ProdutoServico produtoServico;

    @PostMapping("/produto")
    public ResponseEntity<?> cadastrarProduto(@RequestBody ProdutoModelo produtoModelo){
        return produtoServico.cadastrarProduto(produtoModelo);
    }
    @GetMapping("/produto")
    public ResponseEntity<?> listarTodosProdutos(){
        return produtoServico.listarTodosProduto();
    }
    @GetMapping("/produto/{codigo}")
    public ResponseEntity<?> buscarProdutoPorCodigo(@PathVariable Long codigo){
        return produtoServico.buscarProdutoPorCodigo(codigo);
    }
    @PutMapping("/produto")
    public ResponseEntity<?> editarProduto(@RequestBody ProdutoModelo produtoModelo){
        return produtoServico.editarProduto(produtoModelo);
    }
    @DeleteMapping("/produto/{codigo}")
    public ResponseEntity<?> removerProduto(@PathVariable Long codigo){
        return produtoServico.removerProduto(codigo);
    }
}
