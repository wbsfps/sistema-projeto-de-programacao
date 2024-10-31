package br.com.GadoForte.projeto_GadoForte.controller;

import br.com.GadoForte.projeto_GadoForte.domain.animal.AnimalRepository;
import br.com.GadoForte.projeto_GadoForte.domain.aplicacaoVacina.AplicacaoVacina;
import br.com.GadoForte.projeto_GadoForte.domain.aplicacaoVacina.AplicacaoVacinaRequestDTO;
import br.com.GadoForte.projeto_GadoForte.domain.aplicacaoVacina.AplicacaoVacinaResponseDTO;
import br.com.GadoForte.projeto_GadoForte.domain.aplicacaoVacina.AplicaoVacinaRepository;
import br.com.GadoForte.projeto_GadoForte.domain.usuario.UsuarioRepository;
import br.com.GadoForte.projeto_GadoForte.domain.vacina.VacinaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("aplicacaoVacina")
public class AplicacaoVacinaController {

    @Autowired
    private AplicaoVacinaRepository aplicaoVacinaRepository;
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private VacinaRepository vacinaRepository;

    @GetMapping("/{id}")
    public ResponseEntity<AplicacaoVacinaResponseDTO> umaAplicacaoDeVacina(@PathVariable Long id) {
        var aplicacaoVacina = aplicaoVacinaRepository.getReferenceById(id);
        return ResponseEntity.ok(new AplicacaoVacinaResponseDTO(aplicacaoVacina));
    }

    @GetMapping
    public ResponseEntity<Page<AplicacaoVacinaResponseDTO>> aplicacoesDeVacina(@PageableDefault(size = 5) Pageable pageable) {
        var aplicacoes = aplicaoVacinaRepository.findAll(pageable).map(AplicacaoVacinaResponseDTO::new);
        return ResponseEntity.ok(aplicacoes);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AplicacaoVacinaResponseDTO> cadastrarAplicacaoDeVacina(@RequestBody AplicacaoVacinaRequestDTO request) {
        var animal = animalRepository.findById(request.idAnimal())
               .orElseThrow(() -> new IllegalArgumentException("Animal não encontrado"));
        var usuario = usuarioRepository.findById(request.idUsuario())
               .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        var vacina = vacinaRepository.findById(request.idVacina())
               .orElseThrow(() -> new IllegalArgumentException("Vacina não encontrada"));

        var aplicacaoVacina = new AplicacaoVacina(request, vacina, animal, usuario);
        aplicaoVacinaRepository.save(aplicacaoVacina);

        return ResponseEntity.status(HttpStatus.CREATED).body(new AplicacaoVacinaResponseDTO(aplicacaoVacina));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteAplicacaoVacina(@PathVariable Long id) {
        var aplicacaoVacina = aplicaoVacinaRepository.getReferenceById(id);
        aplicaoVacinaRepository.delete(aplicacaoVacina);
        return ResponseEntity.noContent().build();
    }
}