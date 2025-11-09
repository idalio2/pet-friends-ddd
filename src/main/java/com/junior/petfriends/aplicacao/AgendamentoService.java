package com.junior.petfriends.aplicacao;

import com.junior.petfriends.dominio.agendamento.Agendamento;

import java.time.Clock;

public class AgendamentoService {

    private final DomainEventPublisher publisher;
    private final Clock clock;

    public AgendamentoService(DomainEventPublisher publisher, Clock clock) {
        this.publisher = publisher;
        this.clock = clock;
    }

    public void confirmarAgendamento(Agendamento agendamento) {
        agendamento.confirmar(clock);
        publisher.publishAll(agendamento.eventosPendentes());
        agendamento.limparEventos();
    }
}
