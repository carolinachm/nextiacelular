package br.com.nextiacelular.controller;


import br.com.nextiacelular.model.ClienteModel;
import br.com.nextiacelular.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ClienteControler {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")
    public ResponseEntity<?> cadastrar(@RequestBody ClienteModel clienteModel){
        return clienteService.cadastrar(clienteModel);
    }
    @GetMapping("/cliente")
    public ResponseEntity<?> listar(){
        return clienteService.listarTodos();
    }
    @GetMapping("/cliente/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        return clienteService.buscarPorId(id);
    }
    @PutMapping("/cliente")
    public ResponseEntity<?> atualizar(@RequestBody ClienteModel clienteModel){
        return clienteService.alterar(clienteModel) ;
    }
    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id){
        return clienteService.excluir(id);
    }
}
