package models;

import jdk.swing.interop.SwingInterOpUtils;

import java.sql.SQLOutput;
import java.util.List;

public class Filters {

    public static void showDweller(Dweller dweller) {

        System.out.println("--------------------------------------------------------------------\n" +
                "                       DWELLER <" + dweller.getId() + ">\n\n" +
                "-- Name: |   " + dweller.getName() + "   |\n" +
                "-- Surname: |   " + dweller.getSurname() + "   |\n" +
                "-- Age: |   " + dweller.getAge() + "   |\n" +
                "-- Gender: |   " + dweller.getGender() + "   |\n\n" +
                "-- SPECIAL Attributes:\n");
        SPECIAL.printSPECIAL(dweller.getSpecial());
        Skills.printSkills(dweller.getSkillList());
        System.out.println("-- DEPARTMENT: |   " + dweller.getDepartment() + "   |\n");
    }

    public static void showAllDwellers(List<Dweller> dwellersList) {
        for (Dweller dweller: dwellersList){
            Filters.showDweller(dweller);
            System.out.println("--------------------------------------------------------------------\n");
        }
    }
}
