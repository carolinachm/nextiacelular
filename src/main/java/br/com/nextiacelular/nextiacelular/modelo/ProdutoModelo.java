package br.com.nextiacelular.nextiacelular.modelo;

import br.com.nextiacelular.nextiacelular.enumerador.StatusEnumerador;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "tb_produto")
public class ProdutoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    private String nome;
    private String descricaoProduto;
    private BigDecimal valor;
    @OneToMany
    @JoinColumn(name = "codigo_produto")
    private List<MarcaModelo> marcaModeloList;
    @OneToOne
    @JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
    private CategoriaModelo categoriaModelo;
    private int quantidade;
    @Enumerated(EnumType.STRING)
    private StatusEnumerador status;
}
