package br.com.controller;

import br.com.controller.constantes.EquipmentType;
import br.com.controller.constantes.Status;

import java.util.Date;

public class Equipment {

    private int id;
    private String nome;
    private EquipmentType tipo;
    private String serialNumber;
    private Status status;

    public static final int INATIVO = 0;
    public static final int ATIVO = 1;
    public static final int MANUTENCAO = 2;

    public Equipment(String nome, EquipmentType tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.status = Status.INATIVO;
    }

    public Equipment(int id, String nome, EquipmentType tipo, String serialNumber) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.serialNumber = serialNumber;
        this.status = status.INATIVO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }else {
            this.nome = nome;
        }

    }

    public EquipmentType getTipo() {
        return tipo;
    }

    public void setTipo(EquipmentType tipo) {
        if(tipo == null){
            throw new IllegalArgumentException("Tipo não pode ser nulo ou vazio");
        }else {
            this.tipo = tipo;
        }

    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    //Métodos

    public void updateEquipment(String nome){
        this.nome = nome;
    }

    public void activate(){
        this.status = status.ATIVO;
        System.out.println("Equipamento está ativado");
    }

    public void desactivate(){
        this.status = status.INATIVO;
        System.out.println("Equipamento está desativado");
    }

    public void requestMaintenance(){
        this.status = status.MANUTENCAO; // O equipamento entra em manutenção, logo fica inativo
        System.out.println("Manutenção solicitada para o equipamento.");
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", status=" + status +
                '}';
    }
}
