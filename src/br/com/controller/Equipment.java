package br.com.controller;

import br.com.controller.constantes.EquipmentType;
import br.com.controller.constantes.Status;


public class Equipment {

    // Atributos do equipamento
    private int id;
    private String nome;
    private EquipmentType tipo; // Tipo do equipamento (definido por enum EquipmentType)
    private String serialNumber;
    private Status status; // Status do equipamento (definido por enum Status)
    private boolean isBorrowed; // Indica se o equipamento está emprestado
    private User responsavel;
    private EquipmentSheduler equipmentSheduler;// Usuário responsável pelo equipamento

    // Constantes de status para definir o estado do equipamento
    public static final int INATIVO = 0;
    public static final int ATIVO = 1;
    public static final int MANUTENCAO = 2;

    // Construtor que inicializa nome e tipo do equipamento
    public Equipment(String nome, EquipmentType tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.status = Status.ATIVO; // Define o status inicial como ativo
        this.isBorrowed = false; // Define o estado inicial como não emprestado
        this.equipmentSheduler = new EquipmentSheduler();
    }

    // Construtor que inicializa id, nome, tipo e número de série do equipamento
    public Equipment(int id, String nome, EquipmentType tipo, String serialNumber) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.serialNumber = serialNumber;
        this.status = status.ATIVO; // Define o status inicial como ativo
        this.isBorrowed = false; // Define o estado inicial como não emprestado
        this.equipmentSheduler = new EquipmentSheduler();
    }

    // Métodos getters e setters para os atributos do equipamento
    public EquipmentSheduler getEquipmentSheduler(){
      return equipmentSheduler;
    };

    public String getNome() {
        return nome;
    }

    public EquipmentType getTipo() {
        return tipo;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void getResponsavel() {
        if(this.responsavel == null){
            System.out.println("Não existe nenhum responsável com esse equipamento");
        }else {
            System.out.println("O equipamento " + this.nome + " está com " + this.responsavel.getName());
        }

    }

    // Método para emprestar o equipamento
    public void borrowedEquipment(User user) {
        // Verifica se o equipamento está ativo e não está emprestado
        if (this.status == Status.ATIVO && !isBorrowed) {
            this.isBorrowed = true; // Define o equipamento como emprestado
            this.responsavel = user; // Define o responsável pelo equipamento
            System.out.println("Equipamento " + this.nome + " emprestado com sucesso para " + user.getName() + "!");
        } else {
            System.out.println("Equipamento " + this.nome + " não está disponível para empréstimo.");
        }
    }

    // Método para devolver o equipamento
    public void returnEquipment(User user) {
        // Verifica se o equipamento está emprestado e se o usuário que está devolvendo é o responsável
        if (isBorrowed && this.responsavel.equals(user)) {
            this.isBorrowed = false; // Define o equipamento como não emprestado
            this.responsavel = null; // Limpa o responsável
            System.out.println("Equipamento " + this.nome + " devolvido com sucesso por " + user.getName() + "!");
        } else {
            System.out.println("O equipamento não está emprestado por " + user.getName() + ", portanto não pode ser devolvido.");
        }
    }

    // Método toString para exibir informações do equipamento em formato de string
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
