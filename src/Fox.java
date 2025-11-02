/**
 * Klasa Fox dziedzicząca po Animal
 */
public class Fox extends Animal{

    /**
     * Konstruktor klasy Fox, wymaga podania danych do kalsy Animal
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
