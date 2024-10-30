package br.com.GadoForte.projeto_GadoForte.domain.aplicacaoVacina;

import java.time.LocalDate;

public record DadosAplicacaoVacina(
        Long idVacina,
        Long idAnimal,
        Long idUsuario,
        LocalDate dataAplicacao
) {
    public DadosAplicacaoVacina(AplicacaoVacina aplicacaoVacina) {
        this(
                aplicacaoVacina.getVacina().getId(),
                aplicacaoVacina.getAnimal().getId(),
                aplicacaoVacina.getUsuario().getId(),
                aplicacaoVacina.getDataAplicacao()
        );
    }
}
