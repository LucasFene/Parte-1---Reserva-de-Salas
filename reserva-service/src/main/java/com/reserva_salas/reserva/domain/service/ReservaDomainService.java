package com.reserva_salas.reserva.domain.service;

import com.reserva_salas.reserva.domain.model.Reserva;
import com.reserva_salas.reserva.domain.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaDomainService {

    private final ReservaRepository repository;

    @Transactional
    public Reserva criar(Reserva reserva) {
        validarReserva(reserva);
        return repository.save(reserva);
    }

    @Transactional(readOnly = true)
    public List<Reserva> listarPorSala(Long salaId) {
        return repository.findBySalaId(salaId);
    }

    @Transactional(readOnly = true)
    public List<Reserva> listarPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    private void validarReserva(Reserva reserva) {
        if (reserva.getDataHoraInicio().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Não é possível fazer reservas para datas passadas");
        }

        List<Reserva> reservasConflitantes = repository.findReservasConflitantes(
            reserva.getSalaId(),
            reserva.getDataHoraInicio(),
            reserva.getDataHoraFim()
        );

        if (!reservasConflitantes.isEmpty()) {
            throw new IllegalStateException("Já existe uma reserva para este horário");
        }
    }
}