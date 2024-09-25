import br.com.controller.Equipment;
import br.com.controller.constantes.EquipmentType;

public class Main {
    public static void main(String[] args) {

        Equipment equipment = new Equipment("Laboratório de Info", EquipmentType.DATASHOW);

        System.out.println(equipment.toString());
    }
}