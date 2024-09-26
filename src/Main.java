import br.com.controller.Equipment;
import br.com.controller.User;
import br.com.controller.constantes.EquipmentType;

public class Main {
    public static void main(String[] args) {
        User user = new User(1, "Cleobeto","cleobeto@iema.edu.br","Professor");
        Equipment equipment = new Equipment("Datashow 1", EquipmentType.DATASHOW);
        Equipment equipment1 = new Equipment("Lab Info", EquipmentType.CHAVE_LABORATORIO);
        Equipment equipment2 = new Equipment("Televisão 1", EquipmentType.TV);

        System.out.println(equipment.toString());
        System.out.println(equipment1.toString());

        equipment1.borrowedEquipment(user);

        equipment1.getResponsavel();
        equipment2.getResponsavel();
        equipment.getResponsavel();
    }
}