package com.junior.petfriends.dominio.agendamento;

import java.time.Instant;

public interface DomainEvent {
    String eventName();
    Instant occurredOn();
}
