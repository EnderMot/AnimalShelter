package People;

// Klasa People.Volunteer, która dziedziczy po People.Person i przechowuje informacje o tym, w jaki sposób pomaga dany wolontariusz
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
