package br.com.GadoForte.projeto_GadoForte.domain.pesagem;

import java.time.LocalDate;

public record PesagemResponseDTO (
        Long id,
        Double peso,
        LocalDate dataDePesagem,
        Long idAnimal
) {
    public PesagemResponseDTO(Pesagem pesagem) {
        this(pesagem.getId(), pesagem.getPeso(), pesagem.getDataPesagem(), pesagem.getAnimal().getId());
    }
}
