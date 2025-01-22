package com.ForoHub.ChallenAlura.services;

import com.ForoHub.ChallenAlura.dto.TopicoRequestDTO;
import com.ForoHub.ChallenAlura.dto.TopicoResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TopicoService {
    List<TopicoResponseDTO> listar();
    TopicoResponseDTO registrar(TopicoRequestDTO topicoRequestDTO);
    TopicoResponseDTO detalle(Long id);
    TopicoResponseDTO actualizar(Long id, TopicoRequestDTO topicoRequestDTO);
    void eliminar(Long id);
    Page<TopicoResponseDTO> listarPaginado(Pageable pageable);
    List<TopicoResponseDTO> listarFiltrado(String curso, int year);
}