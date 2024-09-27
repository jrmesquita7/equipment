package com.iema.equipamentSheduler.service;

import com.iema.equipamentSheduler.constantes.HorarioType;
import com.iema.equipamentSheduler.model.User;

import java.util.HashMap;
import java.util.Map;

public class EquipmentShedulerService {

    // Mapa para armazenar os agendamentos do equipamento, onde a chave é o horário (String) e o valor é o usuário que reservou o horário.
    protected Map<String, User> schedule;

    public Map<String, User> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, User> schedule) {
        this.schedule = schedule;
    }

    public HorarioType getHorarioType() {
        return horarioType;
    }

    public void setHorarioType(HorarioType horarioType) {
        this.horarioType = horarioType;
    }

    public String[] getHorarios() {
        return horarios;
    }

    // Instância do enum HorarioType (não está sendo usada diretamente no código, mas presente no escopo da classe).
    private HorarioType horarioType;

    // Array contendo os horários disponíveis para agendamento. Os horários são obtidos diretamente dos valores do enum HorarioType.
    private final String[] horarios = {
            horarioType.PRIMEIRO.getHorario(),  // Obtém o horário definido no enum HorarioType
            horarioType.SEGUNDO.getHorario(),
            horarioType.TERCEIRO.getHorario(),
            horarioType.QUARTO.getHorario(),
            horarioType.QUINTO.getHorario(),
            horarioType.SEXTO.getHorario(),
            horarioType.SETIMO.getHorario(),
            horarioType.OITAVO.getHorario(),
            horarioType.NONO.getHorario(),
    };

    // Construtor da classe EquipmentSheduler. Inicializa o mapa de agendamentos com os horários definidos.
    public EquipmentShedulerService() {
        this.schedule = new HashMap<>();
        // Percorre o array de horários e adiciona cada horário ao mapa 'schedule', definindo-os como disponíveis (valor null).
        for (String horario : horarios) {
            schedule.put(horario, null);
        }
    }

    // Método para agendar um horário para um usuário específico.
    // Retorna true se o agendamento for bem-sucedido, e false caso contrário.
    public boolean agendarHorario(String horario, User user) {
        // Verifica se o horário é válido (existe no mapa 'schedule').
        if (!schedule.containsKey(horario)) {
            System.out.println("Horário inválido.");
            return false;
        }
        // Verifica se o horário está disponível (valor null no mapa).
        if (schedule.get(horario) == null) {
            // Realiza o agendamento, associando o usuário ao horário.
            schedule.put(horario, user);
            System.out.println("Agendamento realizado para " + user.getName() + " às " + horario + ".");
            return true;
        } else {
            // Caso o horário já esteja reservado, informa que o agendamento não é possível.
            System.out.println("Horário já reservado.");
            return false;
        }
    }

    // Método para cancelar um agendamento de um horário específico para um usuário.
    // Retorna true se o cancelamento for bem-sucedido, e false caso contrário.
    public boolean cancelarAgendamento(String horario, User user) {
        // Verifica se o horário é válido (existe no mapa 'schedule').
        if (!schedule.containsKey(horario)) {
            System.out.println("Horário inválido.");
            return false;
        }
        // Verifica se o horário está reservado pelo usuário fornecido.
        if (schedule.get(horario) != null && schedule.get(horario).equals(user)) {
            // Cancela o agendamento, definindo o horário como disponível (valor null).
            schedule.put(horario, null);
            System.out.println("Agendamento cancelado para " + user.getName() + " às " + horario + ".");
            return true;
        } else {
            // Caso o horário não esteja reservado pelo usuário fornecido, informa que não é possível cancelar.
            System.out.println("Não é possível cancelar, o horário não está reservado por " + user.getName() + ".");
            return false;
        }
    }

    // Método para verificar e exibir os horários que estão disponíveis (não reservados).
    public void verificarHorariosDisoniveis() {
        System.out.println("Horários disponíveis:");
        // Percorre o array de horários e verifica se estão disponíveis (valor null no mapa 'schedule').
        for (String horario : horarios) {
            if (schedule.get(horario) == null) {
                System.out.println(horario);
            }
        }
    }
}
