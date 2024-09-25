package br.com.controller.constantes;

public enum Status {

    INATIVO(0),
    ATIVO(1),
    MANUTENCAO(2);

    private final int value;

    public int getValue() {
        return value;
    }

    Status(int value) {
        this.value = value;
    }

    public static Status fromValue(int value){
        for (Status status: Status.values()){
            if (status.getValue() == value){
                return status;
            }
        }
        throw new IllegalArgumentException("Status inválido: " + value);
    }
}
