package com.junior.petfriends.aplicacao;

import com.junior.petfriends.dominio.agendamento.DomainEvent;
import java.util.List;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
    default void publishAll(List<DomainEvent> events) {
        if (events == null) return;
        for (DomainEvent e : events) publish(e);
    }
}
