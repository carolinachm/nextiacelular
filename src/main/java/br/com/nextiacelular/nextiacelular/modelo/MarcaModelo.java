package br.com.nextiacelular.nextiacelular.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_marca")
public class MarcaModelo {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long codigo;
     private String descricao;
     private Boolean status;
}
