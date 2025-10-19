

public class Dog extends Animal{

    Dog(String name, int age, Traits trait){
        super(name, age, trait);
    }

    @Override
    int calculateAgeInHumanYears() {
        return (int) (16*Math.log(getAge())+31);
    }
}