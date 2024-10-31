package br.com.GadoForte.projeto_GadoForte.domain.animal;

import java.time.LocalDate;

public record AnimalRequestDTO(
        String nome,
        String raca,
        LocalDate dataNascimento
) {
    public AnimalRequestDTO(Animal animal) {
        this(animal.getNome(), animal.getRaca(), animal.getDataNascimento());
    }
}
