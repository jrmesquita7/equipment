package br.com.controller;

import java.util.HashMap;
import java.util.Map;

public class EquipmentSheduler {

    private Map<String, User> schedule;

    private final String[] horarios = {
            "07:35", "08:25", "09:30", "10:20","11:10",
            "13:30","14:20", "15:20", "16:10"
    };

    public EquipmentSheduler() {
        this.schedule = new HashMap<>();
        for (String horario: horarios){
            schedule.put(horario, null);
        }
    }

    public boolean agendarHorario(String horario, User user) {
        if (!schedule.containsKey(horario)) {
            System.out.println("Horário inválido.");
            return false;
        }
        if (schedule.get(horario) == null) {
            schedule.put(horario, user);
            System.out.println("Agendamento realizado para " + user.getName() + " às " + horario + ".");
            return true;
        } else {
            System.out.println("Horário já reservado.");
            return false;
        }
    }

    public boolean cancelarAgendamento(String horario, User user) {
        if (!schedule.containsKey(horario)) {
            System.out.println("Horário inválido.");
            return false;
        }
        if (schedule.get(horario) != null && schedule.get(horario).equals(user)) {
            schedule.put(horario, null);
            System.out.println("Agendamento cancelado para " + user.getName() + " às " + horario + ".");
            return true;
        } else {
            System.out.println("Não é possível cancelar, o horário não está reservado por " + user.getName() + ".");
            return false;
        }
    }

    public void verificarHorariosDisoniveis(){
        System.out.println("Horários disponiveis");
        for (String horario: horarios){
            if(schedule.get(horario) == null){
                System.out.println(horario);
            }
        }
    }
}
