package com.reserva_salas.reserva_salas.domain.service;

import com.reserva_salas.reservas.domain.model.Reserva;
import com.reserva_salas.reservas.domain.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaDomainService {

    private final ReservaRepository repository;

    public Reserva salvar(Reserva reserva) {
        // Aqui você pode validar conflito de horários, etc.
        return repository.save(reserva);
    }

    public List<Reserva> listar() {
        return repository.findAll();
    }
}
