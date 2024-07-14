package com.example.TOPICO.service;

import com.example.TOPICO.modelo.Topico;
import com.example.TOPICO.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    public List<Topico> obtenerTodos() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> obtenerPorId(Long id) {
        return topicoRepository.findById(id);
    }

    public Topico guardar(Topico topico) {
        topico.setFechaCreacion(LocalDateTime.now());
        return topicoRepository.save(topico);
    }

    public Topico actualizar(Topico topico) {
        return topicoRepository.save(topico);
    }

    public void eliminar(Long id) {
        topicoRepository.deleteById(id);
    }

    public List<Topico> buscarPorTitulo(String titulo) {
        return topicoRepository.findByTituloContaining(titulo);
    }
}
