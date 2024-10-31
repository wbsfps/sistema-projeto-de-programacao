package br.com.GadoForte.projeto_GadoForte.controller;

import br.com.GadoForte.projeto_GadoForte.domain.vacina.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vacina")
public class VacinaController {

    @Autowired
    private VacinaRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<VacinaResponseDTO> vacina(@PathVariable Long id) {
        var vacina = repository.getReferenceById(id);
        return ResponseEntity.ok(new VacinaResponseDTO(vacina));
    }

    @GetMapping
    public ResponseEntity<Page<VacinaResponseDTO>> todasAsVacinas(@PageableDefault(size = 5) Pageable pageable) {
        var vacinas = repository.findAll(pageable).map(VacinaResponseDTO::new);
        return ResponseEntity.ok(vacinas);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<VacinaResponseDTO> cadastrarVacina(@RequestBody VacinaRequestDTO vacinaDTO) {
        var vacina = new Vacina(vacinaDTO);
        repository.save(vacina);
        return ResponseEntity.ok(new VacinaResponseDTO(vacina));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<VacinaResponseDTO> atualizarVacina(@RequestBody VacinaAlterarDados vacinaDTO) {
        var vacina = repository.getReferenceById(vacinaDTO.id());
        vacina.atualizar(vacinaDTO);
        return ResponseEntity.ok(new VacinaResponseDTO(vacina));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarVacina(@PathVariable Long id) {
        var vacina = repository.getReferenceById(id);
        repository.delete(vacina);
        return ResponseEntity.noContent().build();
    }

}
