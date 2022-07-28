package models;

import java.util.*;
import java.util.logging.Filter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                "-- 4. Show all male Dwellers\n" +
                "-- 5. Show Skills of the given Dweller\n" +
                "-- 6. Show Dwellers grouped by a specific skill (speech)\n" +
                "-- 7. Get MIN and MAX values of every skill (related to the current population)\n" +
                "-- 8. Sort Dwellers by ID and calculate their average age)\n" +
                "-- 9. Exit\n");
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
                    }
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
                    System.out.println("-- Please, type in your SPECIAL values in the chronological order, \n" +
                            "(!) Values in range from 1 up to 10 separated by ENTER:\n");
                    Integer[] specials = new Integer[7];
                    for (int i = 0; i < 7; i++){
                        specials[i] = scanner.nextInt();
                    }
                    System.out.println("-- Please, type in your Secondary Skills values in the chronological order, \n" +
                            "(!) Values in range from 1 up to 100 separated by ENTER:\n" +
                            "[FIRST AID, SNEAK, LOCKPICK, STEAL, SCIENCE, REPAIR, SPEECH, BARTER, GAMBLING]");
                    Integer[] skills = new Integer[9];
                    for (int i = 0; i < 9; i++){
                        skills[i] = scanner.nextInt();
                    }
                    Dweller newDweller = new Dweller(id, name, surname, age, Dweller.Gender.valueOf(gender),
                            new SPECIAL(new ArrayList<>(), (specials[0]), (specials[1]),
                                    (specials[2]), (specials[3]),
                                    (specials[4]), (specials[5]), (specials[6])),
                            new Skills(new ArrayList<>(), (skills[0]), (skills[1]), (skills[2]),
                                    (skills[3]), (skills[4]), (skills[5]),
                                    (skills[6]), (skills[7]), (skills[8])));

                    dwellerList.add(newDweller);
                    UserDialog.whatToDo();
                    break;

                case 4:
                    List<Dweller> genders = dwellerList.stream()
                            .filter(dweller -> dweller.getGender().toString().equals("MALE")).collect(Collectors.toList());
                    genders.forEach(dweller -> System.out.println(dweller.getSurname() + " " + dweller.getName() + " " + dweller.getGender()));
                    UserDialog.whatToDo();
                    break;

                case 5:
                    break;

                case 6:
                    List<Dweller> speech = dwellerList.stream()
                            .filter(dweller -> dweller.getSkillList().skillsList.get(6).getSkillName().toString().equals("Speech")).collect(Collectors.toList());
                    speech.forEach(dweller -> System.out.println(dweller.getSurname() + " " + dweller.getName() + " Speech value: " + dweller.getSkillList().skillsList.get(6).getValue()));

                    UserDialog.whatToDo();
                    break;

                case 7:
                    //Min-Max of Skills
                    for(int i = 0; i < 9; i++){
                        int finalI = i;
                        Dweller minDweller = dwellerList.stream().min(Comparator.comparing(dweller -> dweller.getSkillList().skillsList.get(finalI).getValue())).get();
                        System.out.println("Dweller with the lowest " + dwellerList.get(0).getSkillList().skillsList.get(i).getSkillName().toString().toUpperCase()
                                + " skill: " + minDweller.getSurname() + " " + minDweller.getName());

                        Dweller maxDweller = dwellerList.stream().max(Comparator.comparing(dweller -> dweller.getSkillList().skillsList.get(finalI).getValue())).get();
                        System.out.println("Dweller with the highest " + dwellerList.get(0).getSkillList().skillsList.get(i).getSkillName().toString().toUpperCase()
                                + " skill: " + maxDweller.getSurname() + " " + maxDweller.getName());

                        System.out.println("");
                    }
                    break;

                case 8:
                    var groupById = dwellerList.stream()
                        .collect(Collectors.groupingBy(Dweller::getId,
                                Collectors.mapping(Dweller::getName, Collectors.toList())));
                    System.out.println("Dwellers sorted by Name: ");
                    System.out.println(groupById);
                    double meanAge = dwellerList.stream().mapToDouble(Dweller::getAge).average().getAsDouble();
                    System.out.println("Average age of Dwellers: " + meanAge);
                    break;
            }
        }
    }
}
