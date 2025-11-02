package Animals;
import Enums.Traits;

/**
* Klasa Animals.Cat dziedzicząca po Animals.Animal
*/
public class Cat extends Animal{

    /**
     * Konstruktor klasy Animals.Cat, wymaga podania danych do kalsy Animals.Animal
     * */
    Cat(String name, int age, Traits trait){
        super(name, age, trait);
    }

    /*
    * Nadpisanie metody abstrakcyjnej calculateAgeInHumanYears,
    * Implementuje kod pozwalający przeliczyć wiek kota na jego wiek w ludzkich latach
    * */
    @Override
    int calculateAgeInHumanYears() {
        int currentAge = super.getAge();
        if (currentAge==1){
            return 15;
        }
        else if (currentAge==2) {
            return 24;
        }
        else if (currentAge>2) {
            return 24+(currentAge-2)*4;
        }
        else{
            return 0;
        }
    }
}