package br.com.GadoForte.projeto_GadoForte.domain.vacina;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vacinas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class VacinaModel {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nome_popular")
    private String nomePopular;
    @Column(name = "nome_tecnico")
    private String nomeTecnico;
//    @Column(name = "restricoes")
//    private String restric

    public VacinaModel(DadosVacina dados) {
    }
}
