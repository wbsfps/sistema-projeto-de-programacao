package br.com.GadoForte.projeto_GadoForte.domain.pesagem;

import java.time.LocalDate;

public record PesagemRequestDTO (
        Double peso,
        LocalDate dataDePesagem,
        Long idAnimal
) {
    public PesagemRequestDTO(Pesagem pesagem) {
        this(pesagem.getPeso(), pesagem.getDataPesagem(), pesagem.getAnimal().getId());
    }
}
