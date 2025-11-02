package Animals;
import Enums.Traits;

/**
 * Klasa Animals.Fox dziedzicząca po Animals.Animal
 */
public class Fox extends Animal{

    /**
     * Konstruktor klasy Animals.Fox, wymaga podania danych do kalsy Animals.Animal
     * */
    Fox(String name, int age, Traits trait){
        super(name, age, trait);
    }

    /*
     * Nadpisanie metody abstrakcyjnej calculateAgeInHumanYears,
     * Implementuje kod pozwalający przeliczyć wiek lisa na jego wiek w ludzkich latach
     * */
    @Override
    int calculateAgeInHumanYears() {
        return getAge()*7;
    }
}
