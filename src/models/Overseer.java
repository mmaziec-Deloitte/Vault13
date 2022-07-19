package models;

public class Overseer extends Dweller{

    private boolean isOverseer = true;
    private String access = "Unlimited";


    public Overseer(int id, String name, String surname, int age, Gender gender, SPECIAL special, Skills skillList,
                    Department department) {
        super(id, name, surname, age, gender, special, skillList, department);

    }
}
