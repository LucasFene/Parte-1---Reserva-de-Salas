package com.reserva_salas.reserva.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(of = "id")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long salaId;

    @Column(nullable = false)
    private Long usuarioId;

    @Column(nullable = false)
    private LocalDateTime dataHoraInicio;

    @Column(nullable = false)
    private LocalDateTime dataHoraFim;

    @Column(nullable = false)
    private String status;

    @Version
    private Long version;

    public boolean conflitaCom(Reserva outraReserva) {
        if (!this.salaId.equals(outraReserva.getSalaId())) {
            return false;
        }
        return !this.dataHoraFim.isBefore(outraReserva.getDataHoraInicio()) &&
               !this.dataHoraInicio.isAfter(outraReserva.getDataHoraFim());
    }
}