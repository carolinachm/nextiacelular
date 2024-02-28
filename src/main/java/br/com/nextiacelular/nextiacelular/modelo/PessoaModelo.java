package br.com.nextiacelular.nextiacelular.modelo;

import br.com.nextiacelular.nextiacelular.enumerador.TipoPessoa;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

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
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;
    @OneToMany
    @JoinColumn(name = "codigo_pessoa")
    private List<EnderecoModelo> enderecoModeloList;


    
}
