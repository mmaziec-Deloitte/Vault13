package models;

import java.util.ArrayList;
import java.util.List;

public class SPECIAL {

    private List<Attribute> special = new ArrayList<>(7);
    //Attribute attribute = new Attribute();

    public SPECIAL(List<Attribute> special, int strengthValue, int perceptionValue, int enduranceValue,
                   int charismaValue, int intelligenceValue, int agilityValue, int luckValue) {

        this.special.add(0, new Attribute(Attribute.Name.STRENGTH, strengthValue));
        this.special.add(1, new Attribute(Attribute.Name.PERCEPTION, perceptionValue));
        this.special.add(2, new Attribute(Attribute.Name.ENDURANCE, enduranceValue));
        this.special.add(3, new Attribute(Attribute.Name.CHARISMA, charismaValue));
        this.special.add(4, new Attribute(Attribute.Name.INTELLIGENCE, intelligenceValue));
        this.special.add(5, new Attribute(Attribute.Name.AGILITY, agilityValue));
        this.special.add(6, new Attribute(Attribute.Name.LUCK, luckValue));

    }

    public static void printSPECIAL(SPECIAL special) {
        System.out.println("--- > STRENGTH: " + special.special.get(0).getValue() + "\n" +
                           "--- > PERCEPTION: " + special.special.get(1).getValue() + "\n" +
                           "--- > ENDURANCE: " + special.special.get(2).getValue() + "\n" +
                           "--- > CHARISMA: " + special.special.get(3).getValue() + "\n" +
                           "--- > INTELLIGENCE: " + special.special.get(4).getValue() + "\n" +
                           "--- > AGILITY: " + special.special.get(5).getValue() + "\n" +
                           "--- > LUCK: " + special.special.get(6).getValue() + "\n");
    }


    public static class Attribute {

        protected Name attributeName;
        private int value;

        private enum Name {
            STRENGTH,
            PERCEPTION,
            ENDURANCE,
            CHARISMA,
            INTELLIGENCE,
            AGILITY,
            LUCK
        }

        public Attribute(Name attributeName, int value) {
            this.attributeName = attributeName;
            this.value = value;
        }

        public Name getAttributeName() {
            return attributeName;
        }

        public void setAttributeName(Name attributeName) {
            this.attributeName = attributeName;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
