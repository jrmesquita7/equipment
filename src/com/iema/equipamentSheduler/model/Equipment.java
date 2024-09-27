package com.iema.equipamentSheduler.model;

import com.iema.equipamentSheduler.constantes.EquipmentType;
import com.iema.equipamentSheduler.constantes.Status;
import com.iema.equipamentSheduler.service.EquipmentShedulerService;


public class Equipment {

    // Atributos do equipamento
    private int id;
    private String nome;
    private EquipmentType tipo; // Tipo do equipamento (definido por enum EquipmentType)
    private Status status; // Status do equipamento (definido por enum Status)
    private boolean isBorrowed; // Indica se o equipamento está emprestado
    private User responsavel;
    private EquipmentShedulerService equipmentSheduler;// Usuário responsável pelo equipamento

    // Construtor que inicializa nome e tipo do equipamento
    public Equipment(String nome, EquipmentType tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.status = Status.ATIVO; // Define o status inicial como ativo
        this.isBorrowed = false; // Define o estado inicial como não emprestado
        this.equipmentSheduler = new EquipmentShedulerService();
    }

    // Construtor que inicializa id, nome, tipo e número de série do equipamento
    public Equipment(int id, String nome, EquipmentType tipo, String serialNumber) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.status = status.ATIVO; // Define o status inicial como ativo
        this.isBorrowed = false; // Define o estado inicial como não emprestado
        this.equipmentSheduler = new EquipmentShedulerService();
    }

    // Métodos getters e setters para os atributos do equipamento
    public EquipmentShedulerService getEquipmentSheduler(){
      return equipmentSheduler;
    };

    public String getNome() {
        return nome;
    }

    public EquipmentType getTipo() {
        return tipo;
    }


    public Status getStatus() {
        return status;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public void setResponsavel(User responsavel){
        this.responsavel = responsavel;
    }

    public Object getResponsavel() {
        return responsavel;
    }


    // Método toString para exibir informações do equipamento em formato de string
    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", status=" + status +
                '}';
    }
}
