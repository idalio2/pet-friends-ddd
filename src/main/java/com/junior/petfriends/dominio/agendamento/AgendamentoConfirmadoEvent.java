package com.junior.petfriends.dominio.agendamento;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public final class AgendamentoConfirmadoEvent implements DomainEvent {

    private final UUID idAgendamento;
    private final UUID idPet;
    private final UUID idVeterinario;
    private final LocalDateTime dataHora;
    private final Instant occurredOn;

    public AgendamentoConfirmadoEvent(UUID idAgendamento,
                                      UUID idPet,
                                      UUID idVeterinario,
                                      LocalDateTime dataHora,
                                      Instant occurredOn) {
        this.idAgendamento = idAgendamento;
        this.idPet = idPet;
        this.idVeterinario = idVeterinario;
        this.dataHora = dataHora;
        this.occurredOn = occurredOn;
    }

    @Override
    public String eventName() { return "AgendamentoConfirmado"; }

    @Override
    public Instant occurredOn() { return occurredOn; }

    public UUID getIdAgendamento() { return idAgendamento; }
    public UUID getIdPet() { return idPet; }
    public UUID getIdVeterinario() { return idVeterinario; }
    public LocalDateTime getDataHora() { return dataHora; }
}
