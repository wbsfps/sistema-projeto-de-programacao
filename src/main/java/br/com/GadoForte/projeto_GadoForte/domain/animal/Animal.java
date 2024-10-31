package br.com.GadoForte.projeto_GadoForte.domain.animal;

import br.com.GadoForte.projeto_GadoForte.domain.interfaces.Desativar;
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
public class Animal implements Desativar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "raca")
    private String raca;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "ativo")
    private Boolean ativo;

    public Animal(AnimalRequestDTO dados) {
        this.nome = dados.nome();
        this.raca = dados.raca();
        this.dataNascimento = dados.dataNascimento();
        this.ativo = true;
    }

    public void atualizar(AnimalAlterarDados dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
    }

    @Override
    public void desativar() {
        this.ativo = false;
    }
}
