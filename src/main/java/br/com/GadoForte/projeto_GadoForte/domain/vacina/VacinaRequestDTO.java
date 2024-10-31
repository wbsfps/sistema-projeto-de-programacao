package br.com.GadoForte.projeto_GadoForte.domain.vacina;

import jakarta.validation.constraints.NotBlank;

public record VacinaRequestDTO(
        @NotBlank
        String nomePopular,
        @NotBlank
        String nomeTecnico,
        @NotBlank
        String textoRestricoes
) {
    public VacinaRequestDTO(Vacina vacina) {
      this (vacina.getNomePopular(), vacina.getNomeTecnico(), vacina.getTextoRestricoes());
   }
}
