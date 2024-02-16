package br.com.nextiacelular.nextiacelular.repositorio;

import br.com.nextiacelular.nextiacelular.modelo.PessoaModelo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class PessoaRepositorioTest {

    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    @Test
    void findAll() {
        List<PessoaModelo> pessoas = pessoaRepositorio.findAll();
        assertNotNull(pessoas);
        assertEquals(0, pessoas.size());
    }

    @Test
    void findByCodigo() {
    }

    @Test
    void countByCodigo() {
    }
}