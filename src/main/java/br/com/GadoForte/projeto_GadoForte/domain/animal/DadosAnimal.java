package br.com.GadoForte.projeto_GadoForte.domain.animal;

import br.com.GadoForte.projeto_GadoForte.domain.usuario.Usuario;

import java.time.LocalDate;

public record DadosAnimal(
        Long id,
        String nome,
        String raca,
        LocalDate dataNascimento,
        Usuario usuarioModel
) {
    public DadosAnimal(Animal animal) {
        this(animal.getId(), animal.getNome(), animal.getRaca(), animal.getDataNascimento(), animal.getUsuario());
    }
}
