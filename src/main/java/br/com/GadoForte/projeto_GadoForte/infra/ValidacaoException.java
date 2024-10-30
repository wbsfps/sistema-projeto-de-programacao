package br.com.GadoForte.projeto_GadoForte.infra;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
