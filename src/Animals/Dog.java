package Animals;
import Enums.Traits;

/**
 * Klasa Animals.Dog dziedzicząca po Animals.Animal
 */
public class Dog extends Animal{

    /**
     * Konstruktor klasy Animals.Dog, wymaga podania danych do kalsy Animals.Animal
     * */
    Dog(String name, int age, Traits trait){
        super(name, age, trait);
    }


    /*
     * Nadpisanie metody abstrakcyjnej calculateAgeInHumanYears,
     * Implementuje kod pozwalający przeliczyć wiek psa na jego wiek w ludzkich latach
     * */
    @Override
    int calculateAgeInHumanYears() {
        return (int) (16*Math.log(getAge())+31);
    }
}