import java.util.Arrays;

/**
 * Klasa AnimalShelter.
 * Służy do zarządzania głównymi danymi schroniska: zwierzętami, pracownikami i wolontariuszami.
 * Zawiera logikę biznesową, taką jak dodawanie zwierząt.
 */
public class AnimalShelter {

    // POLA KLASY (Wymaganie: Hermetyzacja - wszystkie są prywatne)

    // Wymaganie: Tablica 1/3. Przechowuje zwierzęta w schronisku.
    // Daje możliwość Upcastingu (np. Dog, Cat są przechowywane jako Animal).
    private Animal[] animals;

    // Wymaganie: Tablica 2/3. Przechowuje pracowników (dziedziczą po Person).
    private Employee[] employees;

    // Wymaganie: Tablica 3/3. Przechowuje wolontariuszy (dziedziczą po Person).
    private Volunteer[] volunteers;

    // Licznik przechowujący aktualną liczbę zwierząt. Potrzebny do zarządzania tablicą (indeksowanie).
    private int animalCount;

    // Wymaganie: Pole statyczne (jedno z dwóch). Liczy całkowitą liczbę zwierząt,
    // które kiedykolwiek trafiły do systemu (globalna statystyka).
    private static int totalAnimalsFound = 0;

    /**
     * Konstruktor klasy AnimalShelter.
     * Inicjalizuje tablice i ustala ich stałe maksymalne rozmiary.
     */
    public AnimalShelter() {
        // Ustalenie maksymalnych rozmiarów tablic zgodnie z projektem
        this.animals = new Animal[10];
        this.employees = new Employee[6];
        this.volunteers = new Volunteer[4];

        this.animalCount = 0;

        // Wymaganie: Komunikat ułatwiający interakcję
        System.out.println("Schronisko zostało utworzone. Max. pojemność: 10 zwierząt.");
    }

    /**
     * Dodaje nowe zwierzę do tablicy. Implementuje logikę sprawdzania pojemności.
     * Wymaganie: Metoda z funkcjonalnością (niepusta) oraz wywoływana min. 1 raz.
     * * @param newAnimal Obiekt zwierzęcia do dodania (może być Dog, Cat, Fox, Hamster).
     * @throws ShelterFullException Rzucany, gdy schronisko jest pełne.
     */
    public void addAnimal(Animal newAnimal) throws ShelterFullException {
        // Sprawdzenie, czy jest wolne miejsce
        if (animalCount < animals.length) {
            // Przypisanie obiektu (np. Dog) do tablicy Animal[] - jest to Upcasting.
            this.animals[animalCount] = newAnimal;
            animalCount++;

            // Aktualizacja pola statycznego
            totalAnimalsFound++;

            // Wymaganie: Komunikat ułatwiający interakcję
            System.out.println("Dodano zwierzę: " + newAnimal.getName() + " (ID: " + newAnimal.getId() + ") do schroniska.");
        } else {
            // Wymaganie: Rzucenie zdefiniowanego wyjątku użytkownika
            throw new ShelterFullException("Schronisko jest pełne! Nie można przyjąć zwierząt.")
        }
    }

    /**
     * Wymaganie: Metoda statyczna. Zwraca całkowitą liczbę zwierząt, które trafiły do systemu.
     * @return Globalna liczba znalezionych zwierząt.
     */
    public static int getTotalAnimalsFound() {
        return totalAnimalsFound;
    }

    // GETTERY

    /**
     * Zwraca aktualną tablicę zwierząt.
     */
    public Animal[] getAnimals() {
        return animals;
    }

    /**
     * Zwraca aktualną liczbę zwierząt w schronisku.
     */
    public int getAnimalCount() {
        return animalCount;
    }

    // ... (Gettery dla employees i volunteers powinny być dodane dla kompletności hermetyzacji) ...
}
