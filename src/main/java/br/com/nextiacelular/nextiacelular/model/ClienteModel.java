package br.com.nextiacelular.nextiacelular.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="tb_cliente")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
}
