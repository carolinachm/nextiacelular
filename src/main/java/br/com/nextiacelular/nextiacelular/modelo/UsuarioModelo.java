package br.com.nextiacelular.nextiacelular.modelo;

import br.com.nextiacelular.nextiacelular.enumerador.StatusEnumerador;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tb_usuario")
public class UsuarioModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;
    private String nome;
    private String login;
    private String senha;
    private String confirmaSenha;
    private String email;
    @Enumerated(EnumType.STRING)
    private StatusEnumerador statusEnumerador;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date cadastro;
    private String papel;

}
