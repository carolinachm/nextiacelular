package br.com.nextiacelular.nextiacelular.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_itemPedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    @ManyToOne
    @JoinColumn(nullable=false)
    private ProdutoModelo produtoModelo;
    private int quantidade;
    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal valorProduto;
    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal precoParcial = BigDecimal.ZERO;
    @ManyToOne
    @JoinColumn(nullable = false)
    private PedidoModelo pedidoModeloo;

}
