package com.iema.equipamentSheduler.service;

import com.iema.equipamentSheduler.constantes.Status;
import com.iema.equipamentSheduler.model.Equipment;
import com.iema.equipamentSheduler.model.User;

public class EquipmentLendingService extends EquipmentShedulerService{

    public void borrowEquipment(Equipment equipment, User user, String horario) {
        // Verifica se o equipamento está ativo e disponível para empréstimo
        if (equipment.getStatus() == Status.ATIVO && !equipment.isBorrowed()) {

            // Verifica se o horário é válido no mapa schedule
            if (!getSchedule().containsKey(horario)) {
                System.out.println("Horário inválido.");
                return;
            }

            // Verifica se o horário está disponível (não reservado por outro usuário)
            if (getSchedule().get(horario) == null) {
                // Realiza o empréstimo, associando o usuário ao horário
                getSchedule().put(horario, user);
                equipment.setBorrowed(true);
                equipment.setResponsavel(user);
                System.out.println("Equipamento " + equipment.getNome()
                        + " emprestado com sucesso para " + user.getName()
                        + " no horário " + horario);
            } else {
                // Caso o horário já esteja reservado
                System.out.println("Horário já reservado.");
            }

        } else {
            // Se o equipamento não estiver ativo ou já estiver emprestado
            System.out.println("Equipamento " + equipment.getNome() + " não está disponível para empréstimo.");
        }
    }

    public void returnEquipment(Equipment equipment, User user){
        if(equipment.isBorrowed() && equipment.getResponsavel().equals(user)){
            equipment.setBorrowed(false);
            equipment.setResponsavel(null);
            System.out.println("Equipamento " + equipment.getNome() + " devolvido com sucesso por " + user.getName() + "!");
        }else {
            System.out.println("O equipamento não está emprestado por " + user.getName() + ", portanto não pode ser devolvido.");
        }
    }
}
