package People;

public class Volunteer extends Person{
    String howIsHelping;

    public Volunteer(String name, String surname, int age, String howIsHelping) { // konstruktor
        super(name, surname, age);
        this.howIsHelping = howIsHelping;
    }

    // gettery i settery
    public String getHowIsHelping() {
        return howIsHelping;
    }

    public void setHowIsHelping(String howIsHelping) {
        this.howIsHelping = howIsHelping;
    }
}
