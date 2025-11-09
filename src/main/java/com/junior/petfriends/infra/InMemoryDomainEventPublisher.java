package com.junior.petfriends.infra;

import com.junior.petfriends.aplicacao.DomainEventPublisher;
import com.junior.petfriends.dominio.agendamento.DomainEvent;

public class InMemoryDomainEventPublisher implements DomainEventPublisher {

    @Override
    public void publish(DomainEvent event) {
        // Demonstração: apenas loga no console
        System.out.printf("[EVENTO] %s em %s%n", event.eventName(), event.occurredOn());
    }
}
