package People;
import Animals.Animal;

import java.util.ArrayList;

// Klasa Client, która dziedziczy po Person i przechowuje listę zaadoptowanych zwierząt
public class Client extends Person{
    private ArrayList<Animal> adoptedAnimals = new ArrayList<>();

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

    @Override
    public String getFullInformationAboutPerson() {
        return getName() + " " + getSurname() + " wiek: " + getAge() + " adoptowane zwierzęta: " + adoptedAnimals.size();
    }
}
