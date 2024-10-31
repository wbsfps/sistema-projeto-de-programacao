package br.com.GadoForte.projeto_GadoForte.domain.vacina;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vacinas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_popular", length = 100)
    private String nomePopular;
    @Column(name = "nome_tecnico", length = 100)
    private String nomeTecnico;
    @Column(name = "textoRestricoes", length = 500)
    private String textoRestricoes;

    public Vacina(VacinaRequestDTO dados) {
        this.nomePopular = dados.nomePopular();
        this.nomeTecnico = dados.nomeTecnico();
        this.textoRestricoes = dados.textoRestricoes();
    }

    public void atualizar(VacinaAlterarDados vacinaDTO) {
        if (vacinaDTO.textoRestricoes() != null) {
            this.textoRestricoes = vacinaDTO.textoRestricoes();
        }
    }

}
