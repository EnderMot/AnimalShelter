package People;
import Animals.Animal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Client extends Person{
    private LocalDate dateOfAdoption;
    ArrayList<Animal> adoptedAnimal;

    public Client(String name, String surname, int age, LocalDate dateOfAdoption) { // konstruktor, który tworzy nowy obiekt i pozwala na ustawienie jego wartości początkowych
        super(name, surname, age);
        this.dateOfAdoption = dateOfAdoption;
        this.adoptedAnimal = new ArrayList<>();
    }

// gettery i settery
    public LocalDate getDateOfAdoption() {
        return dateOfAdoption;
    }

    public void setDateOfAdoption (LocalDate dateOfAdoption) {
        this.dateOfAdoption = dateOfAdoption;
    }

    public ArrayList<Animal> getAdoptedAnimal() {
        return adoptedAnimal;
    }
}

// zrobić metodę Adoption tutaj i potem dodać powiązanie do klasy Animals.Animal "adoptedBy"