package br.com.nextiacelular.nextiacelular.servico;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.nextiacelular.nextiacelular.modelo.EnderecoModelo;

@Service
public class CepServico {

     private static final String VIACEP_URL = "https://viacep.com.br/ws/";

    public EnderecoModelo buscarEnderecoPorCep(String cep) {
        String url = VIACEP_URL + cep + "/json";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, EnderecoModelo.class);
    }
}
