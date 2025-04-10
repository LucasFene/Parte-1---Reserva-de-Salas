package com.reserva_salas.reservas.infrastructure.rest;

import com.reserva_salas.reservas.domain.model.Reserva;
import ccom.reserva_salas.reservas.domain.service.ReservaDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaDomainService service;

    @PostMapping
    public Reserva criar(@RequestBody Reserva reserva) {
        return service.salvar(reserva);
    }

    @GetMapping
    public List<Reserva> listar() {
        return service.listar();
    }
}
