package br.com.GadoForte.projeto_GadoForte.domain.aplicacaoVacina;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AplicacaoVacinaRequestDTO(
        @NotNull
        Long idVacina,
        @NotNull
        Long idAnimal,
        @NotNull
        Long idUsuario,
        @NotNull
        LocalDate dataAplicacao
) {
    public AplicacaoVacinaRequestDTO(AplicacaoVacina aplicacaoVacina) {
        this(
                aplicacaoVacina.getVacina().getId(),
                aplicacaoVacina.getAnimal().getId(),
                aplicacaoVacina.getUsuario().getId(),
                aplicacaoVacina.getDataAplicacao()
        );
    }
}
