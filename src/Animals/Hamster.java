package Animals;
import Enums.Traits;

/**
 * Klasa Animals.Hamster dziedzicząca po Animals.Animal
 */
public class Hamster extends Animal{

    /**
     * Konstruktor klasy Animals.Hamster, wymaga podania danych do kalsy Animals.Animal
     * */
    public Hamster(String name, int age, Traits trait){
        super(name, age, trait);
    }


    /*
     * Nadpisanie metody abstrakcyjnej calculateAgeInHumanYears,
     * Implementuje kod pozwalający przeliczyć wiek chomika na jego wiek w ludzkich latach
     * */
    @Override
    int calculateAgeInHumanYears() {
        return (int) (getAge()*365)/9;
    }
}
