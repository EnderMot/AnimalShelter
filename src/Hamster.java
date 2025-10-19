public class Hamster extends Animal{

    Hamster(String name, int age, Traits trait){
        super(name, age, trait);
    }

    @Override
    int calculateAgeInHumanYears() {
        return (int) (getAge()*365)/9;
    }
}
