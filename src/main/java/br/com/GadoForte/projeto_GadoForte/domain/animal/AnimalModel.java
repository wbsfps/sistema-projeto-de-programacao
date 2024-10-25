package br.com.GadoForte.projeto_GadoForte.domain.animal;

import br.com.GadoForte.projeto_GadoForte.domain.interfaces.Desativar;
import br.com.GadoForte.projeto_GadoForte.domain.usuario.UsuarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "animais")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AnimalModel implements Desativar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "raca")
    private String raca;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "id_usuario")
    private UsuarioModel usuario;

    @Column(name = "ativo")
    private Boolean ativo;

//    public AnimalModel(DadosAnimal dados) {
//        this.nome = dados.nome();
//        this.raca = dados.raca();
//        this.dataNascimento = dados.dataNascimento();
//        this.usuario = dados.usuarioModel();
//    }

    @Override
    public void desativar() {
        this.ativo = false;
    }
}
