package br.com.GadoForte.projeto_GadoForte.domain.usuario;


import br.com.GadoForte.projeto_GadoForte.domain.interfaces.Desativar;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements Desativar  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;
    @Column(name = "ativo")
    private Boolean ativo;

    public Usuario(DadosUsuario dados) {
        this.login = dados.login();
        this.senha = dados.senha();
        this.ativo = true;
    }

    @Override
    public void desativar() {
        this.ativo = false;
    }
}
