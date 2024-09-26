import br.com.controller.Equipment;
import br.com.controller.User;
import br.com.controller.constantes.EquipmentType;
import br.com.controller.constantes.HorarioType;

public class Main {
    public static void main(String[] args) {
        User user = new User(1, "Cleobeto","cleobeto@iema.edu.br","Professor");
        User user1 = new User(1, "Beto","cleobeto@iema.edu.br","Professor");

        Equipment equipment = new Equipment("Datashow 1", EquipmentType.DATASHOW);
        Equipment equipment1 = new Equipment("Lab Info", EquipmentType.CHAVE_LABORATORIO);
        Equipment equipment2 = new Equipment("Televisão 1", EquipmentType.TV);

        System.out.println(equipment.toString());
        System.out.println(equipment1.toString());

        equipment1.borrowedEquipment(user);

        equipment2.getEquipmentSheduler().agendarHorario(HorarioType.PRIMEIRO.getHorario(), user);
        equipment2.getEquipmentSheduler().agendarHorario(HorarioType.SETIMO.getHorario(), user);
        equipment2.getEquipmentSheduler().verificarHorariosDisoniveis();
        equipment2.getEquipmentSheduler().cancelarAgendamento(HorarioType.SEXTO.getHorario(),user);


        equipment.getEquipmentSheduler().verificarHorariosDisoniveis();

        equipment1.getEquipmentSheduler().agendarHorario(HorarioType.SEXTO.getHorario(), user);
        equipment1.getEquipmentSheduler().agendarHorario(HorarioType.SETIMO.getHorario(), user);
        equipment1.getEquipmentSheduler().agendarHorario(HorarioType.OITAVO.getHorario(), user);
        equipment1.getEquipmentSheduler().agendarHorario(HorarioType.NONO.getHorario(), user);

        equipment1.getEquipmentSheduler().verificarHorariosDisoniveis();

    }
}