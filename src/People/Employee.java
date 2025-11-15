package People;

public class Employee extends Person{
    private double salary;

    public Employee(String name, String surname, int age, double salary) {
        super(name, surname, age); // korzystanie z kontruktora klasy Person:)
        this.salary = salary;
    }

// gettery i settery
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
