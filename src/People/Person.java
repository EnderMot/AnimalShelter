package People;

public abstract class Person { // klasa abstrakcyjna People.Person
    private static int lastId;
    private final int id; //?
    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age) { // konstruktor klasy, który będzie wywoływany za każdym razem, jak zostanie dodana nowa osoba, np. w employee
        this.id = lastId++;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

// poniżej gettery i settery
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
}

