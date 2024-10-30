package br.com.GadoForte.projeto_GadoForte.domain.vacina;

public record DadosVacina(
        String nomePopular,
        String nomeTecnico
) {
    public DadosVacina(Vacina vacina) {
      this (
               vacina.getNomePopular(), vacina.getNomeTecnico()
      );
   }
}
