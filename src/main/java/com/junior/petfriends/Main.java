package com.junior.petfriends;

import com.junior.petfriends.aplicacao.AgendamentoService;
import com.junior.petfriends.infra.InMemoryDomainEventPublisher;
import com.junior.petfriends.dominio.agendamento.Agendamento;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        var publisher = new InMemoryDomainEventPublisher();
        var service = new AgendamentoService(publisher, Clock.systemUTC());

        var idPet = UUID.randomUUID();
        var idVet = UUID.randomUUID();
        var dataFutura = LocalDateTime.now().plusDays(1).withHour(10).withMinute(0).withSecond(0).withNano(0);

        var agendamento = new Agendamento(idPet, idVet, dataFutura);
        service.confirmarAgendamento(agendamento);

        System.out.println("Status final: " + agendamento.getStatus());
    }
}
