package com.reserva_salas.reserva.domain.model;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HorarioReserva {
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;

    public HorarioReserva(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        if (dataHoraInicio == null || dataHoraFim == null) {
            throw new IllegalArgumentException("Data e hora de início e fim são obrigatórios");
        }
        if (dataHoraInicio.isAfter(dataHoraFim)) {
            throw new IllegalArgumentException("Data e hora de início deve ser anterior à data e hora de fim");
        }
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
    }

    public boolean conflitaCom(HorarioReserva outro) {
        return !this.dataHoraFim.isBefore(outro.dataHoraInicio) &&
               !this.dataHoraInicio.isAfter(outro.dataHoraFim);
    }

    public boolean estaNoFuturo() {
        return dataHoraInicio.isAfter(LocalDateTime.now());
    }
}