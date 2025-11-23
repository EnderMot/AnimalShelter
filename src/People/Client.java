package People;
import Animals.Animal;

import java.util.ArrayList;

// Klasa People.Client, która dziedziczy po People.Person i przechowuje listę zaadoptowanych zwierząt
public class Client extends Person{
    ArrayList<Animal> adoptedAnimals = new ArrayList<>();

    public Client(String name, String surname, int age) { // konstruktor, który tworzy nowy obiekt i pozwala na ustawienie jego wartości początkowych
        super(name, surname, age);
    }

// gettery i settery
    public ArrayList<Animal> getAdoptedAnimals() {
        return adoptedAnimals;
    }

    public void addAdoptedAnimal(Animal animal){
        adoptedAnimals.add(animal);
    }
}

// zrobić metodę Adoption tutaj i potem dodać powiązanie do klasy Animals.Animal "adoptedBy"