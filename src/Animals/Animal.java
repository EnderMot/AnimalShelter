package Animals;

import java.util.ArrayList;
import java.util.Comparator;

import Enums.Traits;
import People.Client;

/**
* Klasa Animals.Animal
* Klasa abstrakcyjna mająca na celu być klasą po której będą dziedziczyć klasy gatunków zwierząt
*/
public abstract class Animal implements Comparable<Animal>{

    //Pole statyczne, zawierające ostatnie ID które zostało przypisane do ostatniego stworzonego obiektu klasy Animals.Animal
    private static int lastId;

    //Pole typu int, jest to unikalne ID przypisane do obiektu klasy Animals.Animal
    private int id;

    //Pole age, zawiera wiek zwierzęcia
    private int age;

    //Pole name, zawiera imię zwierzęcia
    private String name;

    //Lista String, jest to lista zawierająca historię imion zwierzęcia
    private ArrayList<String> pastNames = new ArrayList<>();

    //Pole trait, zawiera jeden trait zwierzęcia
    private Traits trait;

    //Pole adoptedBy, zawiera informację przez kogo jest adoptowane dane zwierze
    private Client adoptedBy;
    private String dateOfAdoption;


    /**
    * Konstruktor klasy Animals.Animal
    * Wymaga podania name, age oraz trait, przypisuje podane dane do odpowiednich pól
    **/
    Animal(String name, int age, Traits trait){
        this.age = age;
        this.name = name;
        this.trait = trait;
        this.id = lastId+=1;
        this.adoptedBy = null;
    }

    //Metoda przeliczająca wiek zwierzęcia na wiek ludzki, do implementacji w klasach dziedziczących
    public abstract int calculateAgeInHumanYears();

//Gettery i settery pól klasy
    public int getAge() {
        return age;
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

    //Metoda dodająca podane imię do historii imion o ile dane imie nie jest w niej obecne
    void addPastName(String name) {
        if (!this.pastNames.contains(name)) {
            this.getPastNames().add(name);
        }
    }

    //Metoda ustawiająca zmienne adoptedBy oraz dateOfAdoption, ustawienie ich oznacza że zwierzę zostało zaadoptowane
    public void adoption(Client client, String date){
        this.adoptedBy = client;
        this.dateOfAdoption = date;
    }

    //Metoda ustawiająca zmienne adoptedBy oraz dateOfAdoption na null, ustawienie ich na null oznacza że zwierzę zostało oddane do schorniska
    public void returnToShelter(){
        this.adoptedBy.getAdoptedAnimals().remove(this);
        this.adoptedBy = null;
        this.dateOfAdoption = null;
    }

    //Metoda sprawdzająca czy zwierzak jest zadaptowany
    public boolean isAdopted(){
        return adoptedBy != null;
    }

    public Client getAdoptedBy(){
        return adoptedBy;
    }

    public String getDateOfAdoption(){
        return dateOfAdoption;
    }

    // Implementacja intefejsu Comparable
    @Override
    public int compareTo(Animal otherAnimal) {
        return ((Integer)(id)).compareTo(otherAnimal.id);
    }

    // Implementacja intefejsu Comparator
    public static class AnimalIdComparator implements Comparator<Animal>{
        @Override
        public int compare(Animal animal1, Animal animal2) {
            if (animal1 == null || animal2 == null) return 0;
            return Integer.compare(animal1.id, animal2.id);
        }
    }

    @Override
    public String toString() {
        return this.name +" | wiek: "+this.age+" | id: "+this.id;
    }
}
