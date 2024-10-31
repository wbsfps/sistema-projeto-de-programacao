package br.com.GadoForte.projeto_GadoForte.domain.pesagem;


import java.time.LocalDate;

public record PesagemAlterarDados (
        Long id,
        Double peso,
        LocalDate dataDePesagem
) {
    public PesagemAlterarDados(Pesagem pesagem) {
        this(pesagem.getId(), pesagem.getPeso(), pesagem.getDataPesagem());
    }
}
