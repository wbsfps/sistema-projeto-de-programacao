package br.com.GadoForte.projeto_GadoForte.domain.pesagem;

import br.com.GadoForte.projeto_GadoForte.domain.animal.Animal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "pesagem")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pesagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "data_pesagem")
    private LocalDate dataPesagem;

    @JoinColumn(name = "id_animal")
    @OneToOne(fetch = FetchType.LAZY)
    private Animal animal;

    public Pesagem(PesagemRequestDTO pesagemRequestDTO,  Animal animal) {
        this.peso = pesagemRequestDTO.peso();
        this.dataPesagem = pesagemRequestDTO.dataDePesagem();
        this.animal = animal;
    }

    public void atualizar(PesagemAlterarDados pesagemAlterarDados) {
        if (pesagemAlterarDados.dataDePesagem() != null) {
            this.dataPesagem = pesagemAlterarDados.dataDePesagem();
        }
        if (pesagemAlterarDados.peso()!= null) {
            this.peso = pesagemAlterarDados.peso();
        }
    }
}
