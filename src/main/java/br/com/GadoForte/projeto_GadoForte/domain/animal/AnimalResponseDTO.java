package br.com.GadoForte.projeto_GadoForte.domain.animal;

import java.time.LocalDate;

public record AnimalResponseDTO (
        Long id,
        String nome,
        String raca,
        LocalDate dataNascimento
) {
    public AnimalResponseDTO(Animal animal) {
        this(animal.getId(), animal.getNome(), animal.getRaca(), animal.getDataNascimento());
    }
}
