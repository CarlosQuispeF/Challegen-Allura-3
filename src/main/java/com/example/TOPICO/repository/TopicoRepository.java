package com.example.TOPICO.repository;

import com.example.TOPICO.modelo.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findByTituloContaining(String titulo);
}
