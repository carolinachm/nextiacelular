package br.com.nextiacelular.nextiacelular.modelo;

import br.com.nextiacelular.nextiacelular.enumerador.FormaPagamento;
import br.com.nextiacelular.nextiacelular.enumerador.StatusEnumerador;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalTime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tb_pedido")
public class PedidoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    @ManyToOne
    @JoinColumn(nullable = false)
    private PessoaModelo pessoaModelo;
    @Temporal(TemporalType.DATE)
    private Date dataPedido;
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;
    @OneToMany
    @JoinColumn(name = "codigo_pedido")
    private List<EnderecoModelo> enderecoModeloList;
    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal valorTotal = BigDecimal.ZERO;
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REMOVE }, mappedBy = "pedido", fetch = FetchType.EAGER)
    private List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;



}
