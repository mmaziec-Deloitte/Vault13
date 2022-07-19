package models;

public class Dweller {

    private int id;
    private String name;
    private String surname;
    private int age;

    private Gender gender;
    private SPECIAL special;
    private Skills skillList;
    private Department department;

    public Dweller(int id, String name, String surname, int age, Gender gender, SPECIAL special, Skills skillList, Department department) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.special = special;
        this.skillList = skillList;
        this.department = department;
    }

    public Dweller(int id, String name, String surname, int age, Gender gender, SPECIAL special, Skills skillList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.special = special;
        this.skillList = skillList;
    }

    enum Gender {
        MALE("MALE"),
        FEMALE("FEMALE");

        private String gender;

        Gender(String gender){
            this.gender=gender;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public SPECIAL getSpecial() {
        return special;
    }

    public void setSpecial(SPECIAL special) {
        this.special = special;
    }

    public Skills getSkillList() {
        return skillList;
    }

    public void setSkillList(Skills skillList) {
        this.skillList = skillList;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
