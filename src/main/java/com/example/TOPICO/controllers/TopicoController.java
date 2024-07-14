package com.example.TOPICO.controllers;

import com.example.TOPICO.modelo.Topico;
import com.example.TOPICO.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<Topico> obtenerTopicos() {
        return topicoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerTopicoPorId(@PathVariable Long id) {
        Optional<Topico> topico = topicoService.obtenerPorId(id);
        return topico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Topico crearTopico(@RequestBody Topico topico) {
        return topicoService.guardar(topico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody Topico topico) {
        if (topicoService.obtenerPorId(id).isPresent()) {
            topico.setId(id);
            return ResponseEntity.ok(topicoService.actualizar(topico));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        if (topicoService.obtenerPorId(id).isPresent()) {
            topicoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar")
    public List<Topico> buscarTopicosPorTitulo(@RequestParam String titulo) {
        return topicoService.buscarPorTitulo(titulo);
    }
}
