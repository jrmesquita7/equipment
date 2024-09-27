import com.iema.equipamentSheduler.model.Equipment;
import com.iema.equipamentSheduler.model.User;
import com.iema.equipamentSheduler.constantes.EquipmentType;
import com.iema.equipamentSheduler.constantes.HorarioType;
import com.iema.equipamentSheduler.service.EquipmentLendingService;

public class Main {
    public static void main(String[] args) {
        User user = new User(1, "Cleobeto","cleobeto@iema.edu.br","Professor");
        User user1 = new User(1, "Beto","cleobeto@iema.edu.br","Professor");

        Equipment equipment = new Equipment("Datashow 1", EquipmentType.DATASHOW);
        Equipment equipment1 = new Equipment("Lab Info", EquipmentType.CHAVE_LABORATORIO);
        Equipment equipment2 = new Equipment("Televisão 1", EquipmentType.TV);

        EquipmentLendingService equipmentLendingService = new EquipmentLendingService();

        System.out.println(equipment.toString());
        System.out.println(equipment1.toString());

        equipmentLendingService.borrowEquipment(equipment, user,HorarioType.SEXTO.getHorario());
        equipmentLendingService.borrowEquipment(equipment, user,HorarioType.SETIMO.getHorario());

        equipment.getEquipmentSheduler().verificarHorariosDisoniveis();


    }
}