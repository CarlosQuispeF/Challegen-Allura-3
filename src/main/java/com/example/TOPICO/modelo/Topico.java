package com.example.TOPICO.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String mensaje;

    private LocalDateTime fechaCreacion;

    private String status;

    private String autor;

    private String curso;
}
