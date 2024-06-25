package br.com.nextiacelular.model;

import br.com.nextiacelular.enumerador.TipoEndereco;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_endereco")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String localizacao;
    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;
}
