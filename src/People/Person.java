package People;

import java.util.Objects;

// Abstrakcyjna klasa bazowa People.Person reprezentująca osobę w systemie schroniska
// Klasa implementuje interfejs Comparable - dzięki temu obiekty mogą być, np. porównywane czy sortowane
public abstract class Person implements Comparable<Person> {
    private static int lastId; // Licznik ostatniego wygenerowanego ID - dzięki temu możliwe jest automatyczne nadawanie unikalnych id każdej osobie
    private int id; // Unikalny identyfikator, id osoby, automatycznie generuje id przy tworzeniu obiektu dzięki
    private String name;
    private String surname;
    private int age;

    // Konstruktor klasy, który będzie wywoływany za każdym razem, jak zostanie dodana nowa osoba, np. w employee
    public Person(String name, String surname, int age) {
        this.id = lastId++;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

// Poniżej gettery i settery
    public int getId() {
        return id;
    } // w ramach id jest tylko getter - do odczytu, poniewaz id jest final

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Metoda toString - zwraca tekstową reprezentację obiektu w postaci ciągu znaków, nadpisanie jej pozwala na uniknięcie błędów wynikających z, np. literówek
    @Override
    public String toString() {
        return this.name +" "+this.surname+" | Wiek: "+this.age+" | Id: "+this.id;
    }

    // Metoda equals(), która porównuje obiekty na podstawie ID danego obiektu i sprawdza czy są takie same
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // jeśli nasz obiekt posiada taki sam adres w pamięci, co obiekt "o" - są sobie równe
        if (o == null || getClass() != o.getClass()) return false; // jeśli obiekt "o" jest nullem lub metoda getClass naszego obiektu nie zwraca tego co wywołana na obiekcie "o" - obiekty nie są równe
        Person person = (Person) o;
        return id == person.id; // najważniejsza zmienna tutaj to id, ponieważ jest ono niepowtarzalne
    }

    // Metoda hashCode() do zwracania wartości skrótu (hasza) obiektu, który jest liczbą całkowitą i identyfikatorem dla obiektu w ramach haszowania w HashMap i HashSet
    @Override
    public int hashCode() {
        return Objects.hashCode(id); // dzięki temu przy testowaniu zwracane są dwa różne numery, ponieważ tworzymy osoby na podstawie id - każdy dostaje unikalne id
    }

    // Metoda compareTo, która jest interfejsem wbudowanym, wybrane kryterium porówniania to "id"
    // Zamiast samodzielnie pisać logikę metody - wykorzystana została logika tej metody na typie Integer (klasy opakowującej dla typu int, która posiada różne metody "wbudowane")
    // Klasa Integer implementuje interfejs Comparable i w tej implementacji jest zawarta logika zwracania wartości -1 0 i 1 -> a < b = -1, a > b = 1, a = b = 0
    @Override
    public int compareTo(Person otherPerson) {
        return ((Integer)(id)).compareTo(otherPerson.id);
    }

    // metoda abstrakcujna do wyświetlania informacji o osobie
    public abstract String getFullInformationAboutPerson();
}

