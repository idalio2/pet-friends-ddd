package com.junior.petfriends.dominio.agendamento;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Agendamento {

    public enum Status { CRIADO, CONFIRMADO, CANCELADO }

    private final UUID id;
    private final UUID idPet;
    private final UUID idVeterinario;
    private LocalDateTime dataHora;
    private Status status = Status.CRIADO;

    private final List<DomainEvent> eventosPendentes = new ArrayList<>();

    public Agendamento(UUID idPet, UUID idVeterinario, LocalDateTime dataHora) {
        if (dataHora == null) throw new IllegalArgumentException("Data/hora é obrigatória.");
        if (dataHora.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Data/hora não pode ser no passado.");
        }
        this.id = UUID.randomUUID();
        this.idPet = idPet;
        this.idVeterinario = idVeterinario;
        this.dataHora = dataHora;
    }

    public void confirmar(Clock clock) {
        if (status == Status.CANCELADO) {
            throw new IllegalStateException("Não é possível confirmar um agendamento cancelado.");
        }
        this.status = Status.CONFIRMADO;
        eventosPendentes.add(new AgendamentoConfirmadoEvent(
                id, idPet, idVeterinario, dataHora, Instant.now(clock)
        ));
    }

    public List<DomainEvent> eventosPendentes() {
        return Collections.unmodifiableList(eventosPendentes);
    }

    public void limparEventos() {
        eventosPendentes.clear();
    }

    public UUID getId() { return id; }
    public UUID getIdPet() { return idPet; }
    public UUID getIdVeterinario() { return idVeterinario; }
    public LocalDateTime getDataHora() { return dataHora; }
    public Status getStatus() { return status; }
}
