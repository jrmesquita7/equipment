package com.iema.equipamentSheduler.constantes;

public enum HorarioType {
    // Definição dos tipos de horários com valores específicos
    PRIMEIRO("07:35"),
    SEGUNDO("08:25"),
    TERCEIRO("09:30"),
    QUARTO("10:20"),
    QUINTO("11:10"),
    SEXTO("13:30"),
    SETIMO("14:20"),
    OITAVO("15:20"),
    NONO("16:10");

    // Atributo para armazenar o horário associado a cada constante do enum
    private String horario;

    // Construtor do enum que aceita uma string representando o horário
    HorarioType(String horario) {
        this.horario = horario;  // Atribui o horário passado ao atributo 'horario'
    }

    // Método público para obter o horário associado à constante do enum
    public String getHorario() {
        return horario;  // Retorna o horário associado à constante do enum
    }
}
