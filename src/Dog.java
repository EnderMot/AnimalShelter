/**
 * Klasa Dog dziedzicząca po Animal
 */
public class Dog extends Animal{

    /**
     * Konstruktor klasy Dog, wymaga podania danych do kalsy Animal
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