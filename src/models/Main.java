package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Department> departmentsList = new ArrayList<>();
        Department cafeteria = new Department(Department.DepartmentName.CAFETERIA);
        Department armoury = new Department(Department.DepartmentName.ARMOURY);
        Department commandCenter = new Department(Department.DepartmentName.COMMAND_CENTER);
        Department office = new Department(Department.DepartmentName.OFFICE);
        Department entrance = new Department(Department.DepartmentName.ENTRANCE);
        Department lab = new Department(Department.DepartmentName.LAB);
        Collections.addAll(departmentsList, cafeteria, armoury, commandCenter, office, entrance, lab);

        List<Dweller> dwellersList = new ArrayList<>();

        Dweller dweller1 = new Dweller(3,"Michał", "Maziec", 22, Dweller.Gender.MALE,
                new SPECIAL(new ArrayList<>(), 5, 8, 5,
                        5, 7, 4, 5),
                new Skills(new ArrayList<>(), 20, 30, 6,
                        10, 80, 35, 66, 35, 7),
                lab);

        Dweller dweller2 = new Dweller(4,"Bartosz", "Soczynski", 22, Dweller.Gender.MALE,
                new SPECIAL(new ArrayList<>(), 4, 6, 6,
                        8, 6, 6, 7),
                new Skills(new ArrayList<>(), 30, 45, 15,
                        6, 50, 30, 92, 67, 46),
                office);

        Dweller dweller3 = new Dweller(5,"Julia", "Wiśniewska", 21, Dweller.Gender.FEMALE,
                new SPECIAL(new ArrayList<>(), 4, 9, 6,
                        10, 6, 7, 5),
                new Skills(new ArrayList<>(), 55, 36, 58,
                        32, 61, 13, 69, 22, 13),
                office);

        Overseer overseer = new Overseer(1,"Jacoren", "Richardson", 53, Dweller.Gender.MALE,
                new SPECIAL(new ArrayList<>(), 6, 6, 5,
                        5, 8, 5, 6),
                new Skills(new ArrayList<>(), 33, 45, 35,
                        15, 85, 45, 90, 55, 4),
                commandCenter);

        Collections.addAll(dwellersList, dweller1, dweller2, dweller3, overseer);

        UserDialog.greeting();
        UserDialog.whatToDo();
        UserDialog.dialog(dwellersList);
    }
}