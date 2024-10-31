package br.com.GadoForte.projeto_GadoForte.domain.vacina;

public record VacinaAlterarDados(Long id, String textoRestricoes) {
    public VacinaAlterarDados(Vacina vacina) {
        this(vacina.getId(), vacina.getTextoRestricoes());
    }
}
