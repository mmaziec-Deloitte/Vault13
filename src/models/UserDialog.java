package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Filter;

public class UserDialog {

    public static void greeting(){
        System.out.print("--------------------------------------------------------------------\n" +
                "--------------Welcome to the Vault 13 Internal System!--------------");

    }

    public static void whatToDo(){
        System.out.println("\n\n-- What would you like to do?\n" +
                "-- 1. Show all the Dwellers' details\n" +
                "-- 2. Search by specific criteria\n" +
                "-- 3. Add a new Dweller to the database\n" +
                "-- 4. Show all Dwellers working in the given department\n" +
                "-- 5. Show Skills of the given Dweller\n" +
                "-- 6. Show Dwellers grouped by a specific skill\n" +
                "-- 7. Sort Dwellers by gender and calculate arithmetic mean of each Skill\n" +
                "-- 8. Exit\n");
    }

    public static void dialog(List<Dweller> dwellerList) {
        while(true){
            int choice;
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    Filters.showAllDwellers(dwellerList);
                    UserDialog.whatToDo();
                    break;

                case 2:
                    System.out.println("-- Please type in id to search:\n");
                    int choice2 = scanner.nextInt();
                    for (Dweller dweller: dwellerList) {
                        if(choice2 == dweller.getId()){
                            Filters.showDweller(dweller);
                            System.out.println("--------------------------------------------------------------------\n");
                        }
                    } //TODO and what if the student is not found?
                    UserDialog.whatToDo();
                    break;

                case 3:
                    System.out.println("-- Please type in id to begin:\n");
                    int id = scanner.nextInt();
                    System.out.println("-- Please type in the Dweller's name:\n");
                    String name = scanner.next();
                    System.out.println("-- Please type in the Dweller's surname:\n");
                    String surname = scanner.next();
                    System.out.println("-- Please type in the Dweller's age:\n");
                    int age = scanner.nextInt();
                    System.out.println("-- Please type in the Dweller's gender (MALE or FEMALE):\n");
                    String gender = scanner.next().toUpperCase();
                    /*System.out.println("-- Please type in the Dweller's Department:\n" +
                            "Current Departments' List:\n\n" +
                            "--- CAFETERIA --> Cafeteria\n" +
                            "--- ARMOURY --> Armoury\n" +
                            "--- COMMAND_CENTER --> Command Center (AUTHORISED MEMBERS ONLY)\n" +
                            "--- ENTRANCE --> the Vault entrance\n" +
                            "--- LAB --> the Vault's laboratory\n");
                    String department = scanner.next().toUpperCase();*/
                    System.out.println("-- Please, type in your SPECIAL values in the chronological order, \n" +
                            "(!) Values in range from 1 up to 10 separated by the spacebar:\n");
                    //String specialValues = scanner.nextLine();
                    String[] specials =scanner.nextLine().split("\\s"); // split by spaces
                    System.out.println("-- Please, type in your Secondary Skills values in the chronological order, \n" +
                            "(!) Values in range from 1 up to 100 separated by the spacebar:\n" +
                            "[FIRST AID, SNEAK, LOCKPICK, STEAL, SCIENCE, REPAIR, SPEECH, BARTER, GAMBLING]");
                    String[] skills = scanner.nextLine().split("\\s"); // split by spaces

                    Dweller newDweller = new Dweller(id, name, surname, age, Dweller.Gender.valueOf(gender),
                            new SPECIAL(new ArrayList<>(), Integer.valueOf(specials[0]), Integer.valueOf(specials[1]),
                                    Integer.valueOf(specials[2]), Integer.valueOf(specials[3]),
                                    Integer.valueOf(specials[4]), Integer.valueOf(specials[5]), Integer.valueOf(specials[6])),
                            new Skills(new ArrayList<>(), Integer.valueOf(skills[0]), Integer.valueOf(skills[1]), Integer.valueOf(skills[2]),
                                    Integer.valueOf(skills[3]), Integer.valueOf(skills[4]), Integer.valueOf(skills[5]),
                                    Integer.valueOf(skills[6]), Integer.valueOf(skills[7]), Integer.valueOf(skills[8])));

                    dwellerList.add(newDweller);
                    UserDialog.whatToDo();










            }
        }


    }
}
