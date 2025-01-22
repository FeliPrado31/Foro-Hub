package com.ForoHub.ChallenAlura.services;

import com.ForoHub.ChallenAlura.dto.TopicoRequestDTO;
import com.ForoHub.ChallenAlura.dto.TopicoResponseDTO;
import com.ForoHub.ChallenAlura.models.Topico;
import com.ForoHub.ChallenAlura.repositories.TopicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicoServiceImpl implements TopicoService {

    private final TopicoRepository topicoRepository;

    public TopicoServiceImpl(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    @Override
    public List<TopicoResponseDTO> listar() {
        return topicoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TopicoResponseDTO registrar(TopicoRequestDTO topicoRequestDTO) {
        Optional<Topico> topicoExistente = topicoRepository.findByTituloAndMensaje(topicoRequestDTO.titulo(), topicoRequestDTO.mensaje());
        if (topicoExistente.isPresent()) {
            throw new RuntimeException("Tópico duplicado");
        }

        Topico topico = new Topico();
        topico.setTitulo(topicoRequestDTO.titulo());
        topico.setMensaje(topicoRequestDTO.mensaje());
        topico.setStatus(topicoRequestDTO.status());
        topico.setAutor(topicoRequestDTO.autor());
        topico.setCurso(topicoRequestDTO.curso());

        Topico nuevoTopico = topicoRepository.save(topico);
        return convertToDTO(nuevoTopico);
    }

    @Override
    public TopicoResponseDTO detalle(Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));
        return convertToDTO(topico);
    }

    @Override
    public TopicoResponseDTO actualizar(Long id, TopicoRequestDTO topicoRequestDTO) {
        Topico topicoExistente = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        topicoExistente.setTitulo(topicoRequestDTO.titulo());
        topicoExistente.setMensaje(topicoRequestDTO.mensaje());
        topicoExistente.setStatus(topicoRequestDTO.status());
        topicoExistente.setAutor(topicoRequestDTO.autor());
        topicoExistente.setCurso(topicoRequestDTO.curso());

        Topico topicoActualizado = topicoRepository.save(topicoExistente);
        return convertToDTO(topicoActualizado);
    }

    @Override
    public void eliminar(Long id) {
        topicoRepository.deleteById(id);
    }

    @Override
    public Page<TopicoResponseDTO> listarPaginado(Pageable pageable) {
        return topicoRepository.findAll(pageable)
                .map(this::convertToDTO);
    }

    @Override
    public List<TopicoResponseDTO> listarFiltrado(String curso, int year) {
        return topicoRepository.findByCursoAndYear(curso, year).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TopicoResponseDTO convertToDTO(Topico topico) {
        return new TopicoResponseDTO(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}