import java.util.ArrayList;

public abstract class Animal {
    private static int lastId;
    private final int id;
    private int age;
    private String name;
    private ArrayList<String> pastNames = new ArrayList<String>();
    private Traits trait;
    //private Client adoptedBy;


    Animal(String name, int age, Traits trait){
        this.age = age;
        this.name = name;
        this.trait = trait;
        this.id = lastId+=1;
    }

    abstract int calculateAgeInHumanYears();

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        addPastName(this.name);
        this.name = name;
    }

    public ArrayList<String> getPastNames() {
        return pastNames;
    }

    void addPastName(String name) {
        if (!this.pastNames.contains(name)) {
            this.getPastNames().add(name);
        }
    }

    public Traits getTrait() {
        return trait;
    }

    public void setTrait(Traits trait) {
        this.trait = trait;
    }
}
