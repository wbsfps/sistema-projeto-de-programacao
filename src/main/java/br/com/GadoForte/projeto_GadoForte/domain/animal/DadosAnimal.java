package br.com.GadoForte.projeto_GadoForte.domain.animal;

import java.time.LocalDate;

public record DadosAnimal(
        String nome,
        String raca,
        LocalDate dataNascimento
) {
    public DadosAnimal(Animal animal) {
        this(animal.getNome(), animal.getRaca(), animal.getDataNascimento());
    }
}
