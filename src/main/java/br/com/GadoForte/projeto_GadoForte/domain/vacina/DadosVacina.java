package br.com.GadoForte.projeto_GadoForte.domain.vacina;

import java.time.LocalDate;

public record DadosVacina(
        String nomePopular,
        String nomeTecnico
) {
    public DadosVacina(VacinaModel vacina) {
      this (
               vacina.getNomePopular(), vacina.getNomeTecnico()
      );
   }
}
