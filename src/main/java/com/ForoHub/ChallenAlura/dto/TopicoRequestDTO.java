package com.ForoHub.ChallenAlura.dto;

public record TopicoRequestDTO(
        String titulo,
        String mensaje,
        String status,
        String autor,
        String curso
) {}