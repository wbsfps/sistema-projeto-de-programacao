package br.com.GadoForte.projeto_GadoForte.controller;

import br.com.GadoForte.projeto_GadoForte.domain.animal.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("animal")
public class AnimalController {

    @Autowired
    private AnimalRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<AnimalResponseDTO> animal(@PathVariable Long id) {
        var animal = repository.getReferenceById(id);
        return ResponseEntity.ok(new AnimalResponseDTO(animal));
    }

    @GetMapping
    public ResponseEntity<Page<AnimalResponseDTO>> animals(@PageableDefault(size = 5 ) Pageable pageable) {
        var animais = repository.findAllByAtivoTrue(pageable).map(AnimalResponseDTO::new);
        return ResponseEntity.ok(animais);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AnimalResponseDTO> cadastrarAnimal(@RequestBody AnimalRequestDTO animalRequest) {
        var animal = new Animal(animalRequest);
        repository.save(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AnimalResponseDTO(animal));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<AnimalResponseDTO> atualizar(@RequestBody AnimalAlterarDados animalAlterar) {
        var animal = repository.getReferenceById(animalAlterar.id());
        animal.atualizar(animalAlterar);

        return ResponseEntity.ok(new AnimalResponseDTO(animal));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        var animal = repository.getReferenceById(id);
        animal.desativar();
        return ResponseEntity.noContent().build();
    }
}
