package br.com.GadoForte.projeto_GadoForte.controller;


import br.com.GadoForte.projeto_GadoForte.domain.animal.AnimalRepository;
import br.com.GadoForte.projeto_GadoForte.domain.pesagem.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pesagem")
public class PesagemController {

    @Autowired
    private PesagemRepository pesagemRepository;
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/{id}")
    public ResponseEntity<PesagemResponseDTO> pesagemDeUmAnimal(@PathVariable Long id) {
        var pesagem = pesagemRepository.getReferenceById(id);
        return ResponseEntity.ok(new PesagemResponseDTO(pesagem));
    }

    @GetMapping
    public ResponseEntity<Page<PesagemResponseDTO>> todasAsPesagens(@PageableDefault(size = 5) Pageable pageable) {
        var pesagens = pesagemRepository.findAll(pageable).map(PesagemResponseDTO::new);
        return ResponseEntity.ok(pesagens);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PesagemResponseDTO> cadastrarPesagem(@RequestBody PesagemRequestDTO request) {
        var animal = animalRepository
                .findById(request.idAnimal()).orElseThrow(() -> new IllegalArgumentException("Animal não encontrado"));

        var pesagem = new Pesagem(request, animal);
        pesagemRepository.save(pesagem);

        return ResponseEntity.status(HttpStatus.CREATED).body(new PesagemResponseDTO(pesagem));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<PesagemResponseDTO> atualizarPesagem(@RequestBody PesagemAlterarDados request) {
        var pesagem = pesagemRepository.getReferenceById(request.id());
        pesagem.atualizar(request);
        return ResponseEntity.ok(new PesagemResponseDTO(pesagem));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletarPesagem(@PathVariable Long id) {
        var pesagem = pesagemRepository.getReferenceById(id);
        pesagemRepository.delete(pesagem);
        return ResponseEntity.noContent().build();
    }
}
