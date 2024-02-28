package br.com.nextiacelular.nextiacelular.modelo;

import br.com.nextiacelular.nextiacelular.enumerador.StatusEnumerador;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_categoria")
public class CategoriaModelo {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long codigo;
     private String descricao;
     @Enumerated(EnumType.STRING)
     private StatusEnumerador status;

}
