package br.com.nextiacelular.nextiacelular.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_usuario")
public class UsuarioModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    private String tipoCadastro;
    private String email;
    private String senha;
    @OneToOne
    @JoinColumn(name = "codigo_pessoa", referencedColumnName = "codigo")
    private PessoaModelo pessoaModelo;
    
}
