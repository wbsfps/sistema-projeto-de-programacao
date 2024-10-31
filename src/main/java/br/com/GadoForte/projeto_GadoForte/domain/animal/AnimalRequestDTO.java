package br.com.GadoForte.projeto_GadoForte.domain.animal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AnimalRequestDTO(
        @NotBlank
        String nome,
        @NotBlank
        String raca,
        @NotNull
        LocalDate dataNascimento
) {
    public AnimalRequestDTO(Animal animal) {
        this(animal.getNome(), animal.getRaca(), animal.getDataNascimento());
    }
}
