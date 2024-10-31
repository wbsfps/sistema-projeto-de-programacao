package br.com.GadoForte.projeto_GadoForte.controller;


import br.com.GadoForte.projeto_GadoForte.domain.usuario.DadosAutenticacao;
import br.com.GadoForte.projeto_GadoForte.domain.usuario.Usuario;
import br.com.GadoForte.projeto_GadoForte.infra.security.DataTokenJWT;
import br.com.GadoForte.projeto_GadoForte.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService service;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        // Extraindo o usuário autenticado a partir do principal
        var usuario = (Usuario) authentication.getPrincipal();

        var tokenJwt = service.gerarToken(usuario);
        return ResponseEntity.ok(new DataTokenJWT(tokenJwt));
    }
}
