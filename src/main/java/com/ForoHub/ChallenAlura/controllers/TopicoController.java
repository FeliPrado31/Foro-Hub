package com.ForoHub.ChallenAlura.controllers;

import com.ForoHub.ChallenAlura.dto.TopicoRequestDTO;
import com.ForoHub.ChallenAlura.dto.TopicoResponseDTO;
import com.ForoHub.ChallenAlura.services.TopicoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @GetMapping
    public ResponseEntity<List<TopicoResponseDTO>> listar() {
        return ResponseEntity.ok(topicoService.listar());
    }

    @PostMapping
    public ResponseEntity<TopicoResponseDTO> registrar(@Valid @RequestBody TopicoRequestDTO topicoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(topicoService.registrar(topicoRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> detalle(@PathVariable Long id) {
        return ResponseEntity.ok(topicoService.detalle(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> actualizar(@PathVariable Long id, @Valid @RequestBody TopicoRequestDTO topicoRequestDTO) {
        return ResponseEntity.ok(topicoService.actualizar(id, topicoRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        topicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<TopicoResponseDTO>> listarPaginado(
            @PageableDefault(sort = "fechaCreacion", direction = Sort.Direction.ASC, size = 10) Pageable pageable) {
        return ResponseEntity.ok(topicoService.listarPaginado(pageable));
    }

    @GetMapping("/filtrado")
    public ResponseEntity<List<TopicoResponseDTO>> listarFiltrado(@RequestParam String curso, @RequestParam int year) {
        return ResponseEntity.ok(topicoService.listarFiltrado(curso, year));
    }
}