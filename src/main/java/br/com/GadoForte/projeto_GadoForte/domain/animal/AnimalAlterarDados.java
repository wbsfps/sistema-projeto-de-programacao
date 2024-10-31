package br.com.GadoForte.projeto_GadoForte.domain.animal;

public record AnimalAlterarDados(Long id, String nome) {
    public AnimalAlterarDados(Animal animal) { this(animal.getId(), animal.getNome());}
}
