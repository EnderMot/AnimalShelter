package People;

import Enums.Jobs;

// Klasa People.Employee, dziedzicząca po People.Person, która dodatkowo przechowuje informacje o salary
public class Employee extends Person{
    private double salary;
    private Jobs job; // odniesienie do enuma Jobs

    public Employee(String name, String surname, int age, double salary, Jobs job) {
        super(name, surname, age); // korzystanie z kontruktora klasy Person:)
        this.salary = salary;
        this.job = job;
    }


// gettery i settery
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Jobs getJobs() {
        return job;
    }

    public void setJobs(Jobs job) {
        this.job = job;
    }

    // metoda toString, która usprawni wyświetlanie danych w mainie
    @Override
    public String toString() {
        return getName() + " " + getSurname() + " wiek: " + getAge() + " stanowisko: " + job + " pensja: " + salary + " zł";
    }

    // nadpisanie metody abstrackyjnej getFullInformationAboutPerson z klasy Person
    @Override
    public String getFullInformationAboutPerson() {
        return getName() + " " + getSurname() + " wiek: " + getAge() + " stanowisko: " + job + " pensja: " + salary + " zł";
    }
}
