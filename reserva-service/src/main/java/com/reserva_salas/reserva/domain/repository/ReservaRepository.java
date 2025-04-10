package com.reserva_salas.reserva.domain.repository;

import com.reserva_salas.reserva.domain.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query("SELECT r FROM Reserva r WHERE r.salaId = :salaId AND " +
           "((r.dataHoraInicio BETWEEN :inicio AND :fim) OR " +
           "(r.dataHoraFim BETWEEN :inicio AND :fim) OR " +
           "(:inicio BETWEEN r.dataHoraInicio AND r.dataHoraFim))")
    List<Reserva> findReservasConflitantes(
        @Param("salaId") Long salaId,
        @Param("inicio") LocalDateTime inicio,
        @Param("fim") LocalDateTime fim
    );

    List<Reserva> findBySalaId(Long salaId);
    
    List<Reserva> findByUsuarioId(Long usuarioId);
}