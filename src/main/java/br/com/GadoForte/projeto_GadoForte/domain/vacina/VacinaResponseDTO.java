package br.com.GadoForte.projeto_GadoForte.domain.vacina;

public record VacinaResponseDTO (
        Long id,
        String nomePopular,
        String nomeTecnico,
        String textoRestricoes
) {
    public VacinaResponseDTO(Vacina vacina) {
        this(vacina.getId(), vacina.getNomePopular(), vacina.getNomeTecnico(), vacina.getTextoRestricoes());
    }
}
