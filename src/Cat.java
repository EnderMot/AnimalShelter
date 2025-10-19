public class Cat extends Animal{

    Cat(String name, int age, Traits trait){
        super(name, age, trait);
    }

    @Override
    int calculateAgeInHumanYears() {
        int currentAge = super.getAge();
        if (currentAge==1){
            return 15;
        }
        else if (currentAge==2) {
            return 24;
        }
        else if (currentAge>2) {
            return 24+(currentAge-2)*4;
        }
        else{
            return 0;
        }
    }
}