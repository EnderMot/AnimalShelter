import java.util.ArrayList;

/**
* Klasa Animal
* Klasa abstrakcyjna mająca na celu być klasą po której będą dziedziczyć klasy gatunków zwierząt
*/
public abstract class Animal {

    //Pole statyczne, zawierające ostatnie ID które zostało przypisane do ostatniego stworzonego obiektu klasy Animal
    private static int lastId;

    //Pole typu final, nie może zostać nigdy zmienione, jest to unikalne ID przypisane do obiektu klasy Animal
    private final int id;

    //Pole age, zawiera wiek zwierzęcia
    private int age;

    //Pole name, zawiera imię zwierzęcia
    private String name;

    //Lista String, jest to lista zawierająca historię imion zwierzęcia
    private ArrayList<String> pastNames = new ArrayList<String>();

    //Pole trait, zawiera jeden trait zwierzęcia
    private Traits trait;

    //Pole adoptedBy, zawiera informację przez kogo jest adoptowane dane zwierze
    private Client adoptedBy;


    /**
    * Konstruktor klasy Animal
    * Wymaga podania name, age oraz trait, przypisuje podane dane do odpowiednich pól
    **/
    Animal(String name, int age, Traits trait){
        this.age = age;
        this.name = name;
        this.trait = trait;
        this.id = lastId+=1;
    }

    //Metoda przeliczająca wiek zwierzęcia na wiek ludzki, do implementacji w klasach dziedziczących
    abstract int calculateAgeInHumanYears();

//Gettery i settery pól klasy
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

    public Traits getTrait() {
        return trait;
    }

    public void setTrait(Traits trait) {
        this.trait = trait;
    }

    //Metoda dodająca podane imię do historii imion o ile dane imie nie jest w niej obecne
    void addPastName(String name) {
        if (!this.pastNames.contains(name)) {
            this.getPastNames().add(name);
        }
    }
}
