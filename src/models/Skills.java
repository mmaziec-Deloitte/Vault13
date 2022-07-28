package models;

import java.util.ArrayList;
import java.util.List;

public class Skills {

    List<Skill> skillsList = new ArrayList<>(9);

    public Skills(List<Skill> skillsList, int firstAidValue, int sneakValue, int lockpickValue, int stealValue,
                  int scienceValue, int repairValue, int speechValue, int barterValue, int gamblingValue) {

        this.skillsList.add(0, new Skill(Skill.SkillName.First_Aid, firstAidValue));
        this.skillsList.add(1, new Skill(Skill.SkillName.Sneak, sneakValue));
        this.skillsList.add(2, new Skill(Skill.SkillName.Lockpick, lockpickValue));
        this.skillsList.add(3, new Skill(Skill.SkillName.Steal, stealValue));
        this.skillsList.add(4, new Skill(Skill.SkillName.Science, scienceValue));
        this.skillsList.add(5, new Skill(Skill.SkillName.Repair, repairValue));
        this.skillsList.add(6, new Skill(Skill.SkillName.Speech, speechValue));
        this.skillsList.add(7, new Skill(Skill.SkillName.Barter, barterValue));
        this.skillsList.add(8, new Skill(Skill.SkillName.Gambling, gamblingValue));
    }

    public static void printSkills(Skills skillsList){
        System.out.println("-- Secondary skills: \n\n" +
                "--- > FIRST AID: " + skillsList.skillsList.get(0).getValue() + "\n" +
                "--- > SNEAK: " + skillsList.skillsList.get(1).getValue() + "\n" +
                "--- > LOCKPICK: " + skillsList.skillsList.get(2).getValue() + "\n" +
                "--- > STEAL: " + skillsList.skillsList.get(3).getValue() + "\n" +
                "--- > SCIENCE: " + skillsList.skillsList.get(4).getValue() + "\n" +
                "--- > REPAIR: " + skillsList.skillsList.get(5).getValue() + "\n" +
                "--- > SPEECH: " + skillsList.skillsList.get(6).getValue() + "\n" +
                "--- > BARTER: " + skillsList.skillsList.get(7).getValue() + "\n" +
                "--- > GAMBLING: " + skillsList.skillsList.get(8).getValue() + "\n");
    }

    public static class Skill {
        private SkillName skillName;
        private int value;

        enum SkillName {
            First_Aid,
            Sneak,
            Lockpick,
            Steal,
            Science,
            Repair,
            Speech,
            Barter,
            Gambling
        }

        public Skill(SkillName skillName, int value) {
            this.skillName = skillName;
            this.value = value;
        }

        public SkillName getSkillName() {
            return skillName;
        }

        public void setSkillName(SkillName skillName) {
            this.skillName = skillName;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
