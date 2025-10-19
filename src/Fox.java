public class Fox extends Animal{

    Fox(String name, int age, Traits trait){
        super(name, age, trait);
    }

    @Override
    int calculateAgeInHumanYears() {
        return getAge()*7;
    }
}
