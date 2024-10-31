package br.com.GadoForte.projeto_GadoForte.domain.vacina;

public record VacinaRequestDTO(
        String nomePopular,
        String nomeTecnico,
        String textoRestricoes
) {
    public VacinaRequestDTO(Vacina vacina) {
      this (vacina.getNomePopular(), vacina.getNomeTecnico(), vacina.getTextoRestricoes());
   }
}
