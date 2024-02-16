package br.com.nextiacelular.nextiacelular.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tb_endereco")
public class EnderecoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;

    // getters e setters
}

