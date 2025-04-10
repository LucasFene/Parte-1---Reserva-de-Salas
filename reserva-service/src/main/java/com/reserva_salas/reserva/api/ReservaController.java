package com.reserva_salas.reserva.api;

import com.reserva_salas.reserva.domain.model.Reserva;
import com.reserva_salas.reserva.domain.service.ReservaDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaDomainService service;

    @PostMapping
    public ResponseEntity<Reserva> criar(@RequestBody Reserva reserva) {
        return ResponseEntity.ok(service.criar(reserva));
    }

    @GetMapping("/sala/{salaId}")
    public ResponseEntity<List<Reserva>> listarPorSala(@PathVariable Long salaId) {
        return ResponseEntity.ok(service.listarPorSala(salaId));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Reserva>> listarPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(service.listarPorUsuario(usuarioId));
    }
}