package br.com.nextiacelular.nextiacelular.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "tb_pessoa")
public class PessoaModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private String cpf;
    private String celular;
    private String telefone;
    private String sexo;
    private Date dataNascimento;

    
}
