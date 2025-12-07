package People;

import Enums.ServiceType;
import Interfaces.Helping;

// Klasa People.Volunteer, która dziedziczy po People.Person i przechowuje informacje o tym, w jaki sposób pomaga dany wolontariusz
// Dodatkowo klasa implementuje interfejs Interfaces.Helping, mówiący jakie czynności pomocnicze dany wolontariusz wykonuje
public class Volunteer extends Person implements Helping {
    private ServiceType helpType;

    public Volunteer(String name, String surname, int age, ServiceType helpType) { // konstruktor
        super(name, surname, age);
        this.helpType = helpType;
    }

    // gettery i settery
    public ServiceType getHelpType() {
        return helpType;
    }

    public void setHelpType(ServiceType helpType) {
        this.helpType = helpType;
    }

    @Override
    public String getFullInformationAboutPerson() {
        return getName() + " " + getSurname() + " wiek: " + getAge() + " pełniona funkcja: " + helpType.name();
    }

    // Implementacja metody z interfejsu Helping
    @Override
    public void help() {
        System.out.println(getName() + " zajmuje się: " + helpType);
    }
}
