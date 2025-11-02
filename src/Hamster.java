/**
 * Klasa Hamster dziedzicząca po Animal
 */
public class Hamster extends Animal{

    /**
     * Konstruktor klasy Hamster, wymaga podania danych do kalsy Animal
     * */
    Hamster(String name, int age, Traits trait){
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
