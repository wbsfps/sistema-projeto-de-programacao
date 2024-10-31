package br.com.GadoForte.projeto_GadoForte.domain.aplicacaoVacina;

import br.com.GadoForte.projeto_GadoForte.domain.animal.Animal;
import br.com.GadoForte.projeto_GadoForte.domain.usuario.Usuario;
import br.com.GadoForte.projeto_GadoForte.domain.vacina.Vacina;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "aplicacoes_vacinas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class AplicacaoVacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vacina")
    private Vacina vacina;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_animal")
    private Animal animal;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "data_aplicacao")
    private LocalDate dataAplicacao;

    public AplicacaoVacina(AplicacaoVacinaRequestDTO dadosAplicacaoVacina, Vacina vacina, Animal animal, Usuario usuario) {
        this.dataAplicacao = dadosAplicacaoVacina.dataAplicacao();
        this.vacina = vacina;
        this.animal = animal;
        this.usuario = usuario;
    }
}
