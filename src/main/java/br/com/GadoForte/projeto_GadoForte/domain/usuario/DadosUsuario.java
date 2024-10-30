package br.com.GadoForte.projeto_GadoForte.domain.usuario;

public record DadosUsuario (
        String login,
        String senha
) {

    public DadosUsuario (Usuario dados) {
        this(dados.getLogin(), dados.getSenha());
    }
}
