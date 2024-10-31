package br.com.GadoForte.projeto_GadoForte.domain.aplicacaoVacina;

import java.time.LocalDate;

public record AplicacaoVacinaResponseDTO(
        Long id,
        Long idVacina,
        Long idAnimal,
        Long idUsuario,
        LocalDate dataAplicacao
) {
    public AplicacaoVacinaResponseDTO(AplicacaoVacina aplicacaoVacina) {
        this(
                aplicacaoVacina.getId(), aplicacaoVacina.getVacina().getId(),
                aplicacaoVacina.getAnimal().getId(), aplicacaoVacina.getUsuario().getId(),
                aplicacaoVacina.getDataAplicacao()
        );
    }
}
