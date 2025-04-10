package com.reserva_salas.reserva_salas.domain.repository;

import com.seuapp.reservas.domain.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}