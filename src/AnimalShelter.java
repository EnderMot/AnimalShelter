import Animals.Animal;
import People.Client;
import People.Employee;
import People.Person;
import People.Volunteer;
import java.util.ArrayList;

/**
 * Klasa AnimalShelter.
 * Służy do zarządzania głównymi danymi schroniska: zwierzętami, pracownikami i wolontariuszami.
 * Zawiera logikę biznesową, taką jak dodawanie zwierząt.
 */
public class AnimalShelter {

    // POLA KLASY (Wymaganie: Hermetyzacja - wszystkie są prywatne)
    // Oraz ustalenie maksymalnych rozmiarów tablic zgodnie z projektem

    // Wymaganie: Tablica 1/3. Przechowuje zwierzęta w schronisku.
    // Daje możliwość Upcastingu (np. Animals.Dog, Animals.Cat są przechowywane jako Animals.Animal).
    private Animal[] animals;

    // Wymaganie: Tablica 2/3. Przechowuje pracowników (dziedziczą po People.Person).
    private Employee[] employees;

    // Wymaganie: Tablica 3/3. Przechowuje wolontariuszy (dziedziczą po People.Person).
    private Volunteer[] volunteers;

    //Przechowuje dynamiczą listę klientów schroniska
    private ArrayList<Client> clients = new ArrayList<>();

    // Licznik przechowujący aktualną liczbę zwierząt. Potrzebny do zarządzania tablicą (indeksowanie).
    private int animalCount = 0;

    AnimalShelter(Employee[] employees, Volunteer[] volunteers, Animal[] animals){
        this.employees = employees;
        this.volunteers = volunteers;
        this.animals = animals;
        for (Animal animal : animals){
            if (animal != null) {
                animalCount++;
            }
        }
    }


    /**
     * Dodaje nowe zwierzę do tablicy. Implementuje logikę sprawdzania pojemności.
     * Wymaganie: Metoda z funkcjonalnością (niepusta) oraz wywoływana min. 1 raz.
     * * @param newAnimal Obiekt zwierzęcia do dodania (może być Animals.Dog, Animals.Cat, Animals.Fox, Animals.Hamster).
     * @throws ShelterFullException Rzucany, gdy schronisko jest pełne.
     */
    public void addAnimal(Animal newAnimal) throws ShelterFullException {
        try{
            // Przypisanie obiektu (np. Dog) do tablicy Animal[] - jest to Upcasting.
            this.animals[animalCount++] = newAnimal;
        } catch (IndexOutOfBoundsException exception) {
            throw new ShelterFullException("Schronisko jest pełne! Nie można przyjąć zwierząt.");
        }
    }

    // GETTERY

    /**
     * Zwraca aktualną tablicę zwierząt.
     */
    public Animal[] getAnimals() {
        return animals;
    }


    // ... (Gettery dla employees i volunteers powinny być dodane dla kompletności hermetyzacji) ...
    // Dodajmy tutaj metody pozwalające pobrać/działać z pracownikami, wolontariuszami i klientami schroniska

    //Dodałem poniższe metody - Tomek

    public Employee[] getEmployees(){
        return employees;
    }

    public Volunteer[] getVolunteers() {
        return volunteers;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    //Metody pobierania jednej osoby z tablicy zawierającej obiektu dziedziczące po Person
    public void addClient(Client c){
        this.clients.add(c);
    }

    //Metoda pobrania jednej osoby z odpowiednim id z tablicy typu Person
    //W przypadku braku takiej osoby metoda zwaraca null
    public <T extends Person> Person getPersonFromTable(int personId, T[] personTable){
        for (T person : personTable) {
            if (person.getId() == personId) {
                return person;
            }
        }
        return null;
    }
}