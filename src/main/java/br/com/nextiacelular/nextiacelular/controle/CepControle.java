package br.com.nextiacelular.nextiacelular.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nextiacelular.nextiacelular.modelo.EnderecoModelo;
import br.com.nextiacelular.nextiacelular.servico.CepServico;

@RestController
@RequestMapping("/api/cep")
public class CepControle {

        @Autowired
    private CepServico cepServico;

    @GetMapping("/{cep}")
    public EnderecoModelo buscarEnderecoPorCep(@PathVariable String cep) {
        return cepServico.buscarEnderecoPorCep(cep);
    }
    
}
