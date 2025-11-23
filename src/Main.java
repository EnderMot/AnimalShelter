import Animals.*;
import Enums.*;
import People.*;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void startProgram(){
        AnimalShelter[] shelters = initAllObjects();
        mainLoop(shelters);
    }

    public static AnimalShelter[] initAllObjects(){
        Employee[] shelterOneEmployees = {
                new Employee("Karina",  "Fabian",       34,5630),
                new Employee("Mateusz", "Latek",        37,6420),
                new Employee("Kamila",  "Darowska",     56,6530),
                new Employee("Jacek",   "Płaczek",      23,4620),
                new Employee("Rudolf",  "Szczeblewski", 25,5630),
                new Employee("Adela",   "Kasprzyk",     42,7700)
        };

        Employee[] shelterTwoEmployees = {
                new Employee("Paulina",     "Kędzierska",   39,4230),
                new Employee("Czesław",     "Mytnik",       26,5302),
                new Employee("Sebastian",   "Kuboszek",     52,7270),
                new Employee("Ludwik",      "Juraszczyk",   31,4650),
                new Employee("Daniel",      "Malesa",       43,5300),
                new Employee("Laura",       "Szafranek",    23,6220)
        };

        Volunteer[] shelterOneVolunteers= {
                new Volunteer("Nikola",     "Gąszczak",34,""),
                new Volunteer("Julianna",   "Medvedieva",37,""),
                new Volunteer("Karol ",     "Buras",56,""),
                new Volunteer("Blanka",     "Jastrzębska",23,"")
        };

        Volunteer[] shelterTwoVolunteers = {
                new Volunteer("Roman",  "Policht",34,""),
                new Volunteer("Adrian", "Sieńko",37,""),
                new Volunteer("Beata ", "Majcher",56,""),
                new Volunteer("Rozalia","Łukaszuk",23,"")
        };


        Animal[] shelterOneAnimals = {
                new Cat(    "Imperializm",  1, Traits.CUTE),
                new Dog(    "Błysk",        1, Traits.PLAYFULL),
                new Hamster("Kulka",        1, Traits.GLUTTON),
                new Fox(    "Brylant",      1, Traits.ACTIVE),
                new Cat(    "Nandor",       1, Traits.GRUMPY),
                null, null, null, null, null
        };

        Animal[] shelterTwoAnimals = {
                new Cat(    "Orfeusz",  1, Traits.GLUTTON),
                new Dog(    "Burza",    1, Traits.PICKYEATER),
                new Hamster("Luke",     1, Traits.SLEEPY),
                new Fox(    "Grom",     1, Traits.LOVELY),
                new Cat(    "Migot",    1, Traits.SLEEPY),
                null, null, null, null, null
        };

        AnimalShelter[] shelters = {
                new AnimalShelter(shelterOneEmployees, shelterOneVolunteers,shelterOneAnimals),
                new AnimalShelter(shelterTwoEmployees, shelterTwoVolunteers, shelterTwoAnimals)
        };

        return shelters;
    }

    public static int menuSelector(int[] allowedValues){


        int provided = 0;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                provided = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Błąd systemu, została podana wartość tekstowa zamiast liczbowej.");
                System.out.print("Podaj właściwy numer z zakresu od "+allowedValues[0]+" do "+allowedValues[allowedValues.length-1]+" : ");
            }
        }
        boolean contains = false;
        while (!contains){
            Scanner scanner = new Scanner(System.in);
            for (int value : allowedValues){
                if (value==provided) contains = true;
            }
            if (!contains) {
                System.out.println("Podana opcja nie istnieje.");
                System.out.print("Podaj właściwy numer z zakresu od "+allowedValues[0]+" do "+allowedValues[allowedValues.length-1]+" : ");
                try {
                    provided = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Błąd systemu, została podana wartość tekstowa zamiast liczbowej.");
                    provided = 0;
                }
            }
        }
        return provided;
    }

    public static void adoption(Animal selectedAnimal, AnimalShelter selectedShelter){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj informacje o osobie adoptującej:");
        System.out.println("Podaj imię: ");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwisko: ");
        String surname = scanner.nextLine();
        System.out.println("Podaj wiek: ");
        int age = 0;
        while (age==0) {
            try {
                age = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Błąd systemu, została podana wartość tekstowa zamiast liczbowej.");
                age = 0;
            }
        }
        System.out.println();
        Client adopter = new Client(name,surname,age);
        selectedAnimal.adoption(adopter, LocalDate.now());
        adopter.addAdoptedAnimal(selectedAnimal);
        selectedShelter.addClient(adopter);


        System.out.println("Zwierzę adoptowane przez "+adopter.getName()+" "+adopter.getSurname());
    }

    public static void animalMangament(AnimalShelter selectedShelter, Animal selectedAnimal){
        while(true) {
            String species = "";
            if (selectedAnimal instanceof Cat) species = "Kot";
            else if (selectedAnimal instanceof Dog) species = "Pies";
            else if (selectedAnimal instanceof Hamster) species = "Chomik";
            else if (selectedAnimal instanceof Fox) species = "Lis";
            System.out.println("\n\n"+species + " " + selectedAnimal);
            if (selectedAnimal.isAdopted()){
                System.out.println("Adoptowany przez: "+selectedAnimal.getAdoptedBy().getName()+" "+selectedAnimal.getAdoptedBy().getSurname());
                System.out.println("Adoptowany od: "+selectedAnimal.getDateOfAdoption());
            }
            else{
                System.out.println("Gotowy do adopcji.");
            }

            System.out.println("Lista przeszłych imion: "+ selectedAnimal.getPastNames());

            System.out.println("\nFunkcje zarządzania zwierzęciem:");
            System.out.println("1. Adopcja.");
            System.out.println("2. Zmień imię.");
            System.out.println("3. Powrót do listy zwierząt.");
            int[] allowedValues = {1,2,3};
            int functionChoice = menuSelector(allowedValues);
            if (functionChoice == 3){
                break;
            } else if (functionChoice == 2) {
                System.out.println("Podaj nowę imię dla zwierzaka: ");
                Scanner scanner = new Scanner(System.in);
                String newName = scanner.nextLine();
                selectedAnimal.setName(newName);
            }
            else adoption(selectedAnimal, selectedShelter);
        }
    }

    public static void addNewAnimal(AnimalShelter selectedShelter){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj informacje o zwierzęciu:");
        System.out.println("Podaj gatunek: ");
        String species = scanner.nextLine();
        while (!species.toLowerCase().equals("kot") && !species.toLowerCase().equals("pies") && !species.toLowerCase().equals("chomik") && !species.toLowerCase().equals("lis")){
            System.out.println("Niepoprawny gatunek. Podaj gatunek: kot, pies, chomik lub lis.");
            species = scanner.nextLine();
        }
        System.out.println("Podaj imie zwierzaka: ");
        String name = scanner.nextLine();
        System.out.println("Podaj wiek: ");
        int age = 0;
        while (age==0) {
            try {
                age = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Błąd systemu, została podana wartość tekstowa zamiast liczbowej.");
                age = 0;
            }
        }
        System.out.println("Podaj cechę charakteru zwierzaka. ");
        System.out.println("Dostępne cechy to: playfull, grumpy, sleepy, active, pickyeater, glutton, cute, lovely.");
        String traitString = "";
        boolean notATrait = true;
        while (notATrait){
            System.out.println("Podaj poprawną cechę: ");
            traitString = scanner.nextLine();
            for (Traits trait : Traits.values()){
                if (trait.toString().equalsIgnoreCase(traitString)){
                    notATrait = false;
                }
            }
            if (!notATrait) break;
        }

        Animal newAnimal = null;

        if (species.toLowerCase().equals("kot")){
            newAnimal = new Cat (name, age, Traits.valueOf(traitString.toUpperCase()));
        }
        else if (species.toLowerCase().equals("pies")){
            newAnimal = new Dog (name, age, Traits.valueOf(traitString.toUpperCase()));
        }
        else if (species.toLowerCase().equals("chomik")){
            newAnimal = new Hamster (name, age, Traits.valueOf(traitString.toUpperCase()));
        }
        else if (species.toLowerCase().equals("lis")){
            newAnimal = new Fox (name, age, Traits.valueOf(traitString.toUpperCase()));
        }
        else System.out.println("Nie można dodać zwierzaka.");

        if (newAnimal != null)
            try {
                selectedShelter.addAnimal(newAnimal);
            }
            catch (ShelterFullException e){
                System.out.println("\nSchronisko jest pełne, nie można dodać więcej zwierzaków.\n");
            }
        else
            System.out.println("Nie można dodać zwierzaka");
    }

    public static void functionOne(AnimalShelter selectedShelter){
        while (true) {
            Animal[] animals = selectedShelter.getAnimals();
            Arrays.sort(animals, new Animal.AnimalIdComparator());
            int animalCount = 0;
            for (Animal animal : animals){
                if (animal!=null){
                    animalCount++;
                }
            }
            int[] allowedValues = new int[animalCount + 2];
            for (int i = 0; i < animalCount; i++) {
                Animal animal = animals[i];
                if (animal != null) {
                    String species = "";
                    if (animal instanceof Cat) species = "Kot";
                    else if (animal instanceof Dog) species = "Pies";
                    else if (animal instanceof Hamster) species = "Chomik";
                    else if (animal instanceof Fox) species = "Lis";
                    System.out.println((i + 1) + ". " + species + " " + animal);
                    allowedValues[i] = i + 1;
                }
            }
            System.out.println((animalCount+1) + ". Dodaj nowe zwierzę do schroniska.");
            allowedValues[animalCount] = animalCount + 1;
            System.out.println((animalCount+2) + ". Powrót do wyboru funkcji.");
            allowedValues[animalCount+1] = animalCount + 2;
            System.out.println("Wybierz numer zwierzęcia którym chcesz zrządzać.");
            System.out.print("Podaj właściwy numer z zakresu od " + allowedValues[0] + " do " + allowedValues[allowedValues.length - 1] + " : ");
            int chosenAnimal = menuSelector(allowedValues);
            if (chosenAnimal == allowedValues[allowedValues.length-1]) {
                break;
            }
            else if (chosenAnimal == allowedValues[allowedValues.length-2]){
                addNewAnimal(selectedShelter);
            }
            else {
                animalMangament(selectedShelter, animals[chosenAnimal - 1]);
            }
        }
    }

    public static void functionTwo(AnimalShelter selectedShelter){

    }

    public static void functionThree(AnimalShelter selectedShelter){

    }

    public static void functionFour(AnimalShelter selectedShelter){

    }
    public static void functionFive(AnimalShelter selectedShelter){

    }

    public static void mainLoop(AnimalShelter[] shelters){
        while (true) {
            System.out.println();
            System.out.println("Witamy w systemie zarzadzania schroniskiem.");
            System.out.println();
            System.out.println("Dostepne schroniska:");

            int[] allowedValues = new int[shelters.length];
            for (int i = 0; i < shelters.length; i++) {
                System.out.println((i + 1) + ". Schronisko nr " + (i + 1));
                allowedValues[i] = i + 1;
            }
            System.out.println("Proszę wybierz schronisko którym chcesz zarządzać.");
            System.out.print("Podaj właściwy numer z zakresu od " + allowedValues[0] + " do " + allowedValues[allowedValues.length - 1] + " : ");
            AnimalShelter selectedShelter = shelters[menuSelector(allowedValues) - 1];

            System.out.println("Wybrano schronisko.");
            System.out.println("Otwieram panel zarządzania.");
            System.out.println("\n");
            while (true) {
                System.out.println("PANEL ZARZĄDZANIA SCHRONISKIEM\n");
                System.out.println("Dostepne funkcje:");
                System.out.println("1. Wyświetl listę zwierząt w schronisku.");
                System.out.println("2. Wyświetl listę pracowników schroniska.");
                System.out.println("3. Wyświetl listę klientów schroniska.");
                System.out.println("4. Wyświetl listę wolontariuszy schroniska.");
                System.out.println("5. Wyświetl listę czynności wolontariuszy.");
                System.out.println("6. Powrót do wyboru schroniska.");
                System.out.print("\nWybierz funkcje którą chcesz wykonać.");
                allowedValues = new int[]{1, 2, 3, 4, 5, 6};
                System.out.print("Podaj właściwy numer z zakresu od " + allowedValues[0] + " do " + allowedValues[allowedValues.length - 1] + " : ");
                int chosenFunction = menuSelector(allowedValues);

                System.out.println();
                if (chosenFunction == 1) {
                    System.out.println("Wybrano listę zwierząt.");
                    functionOne(selectedShelter);
                } else if (chosenFunction == 2) {
                    System.out.println("Wybrano listę pracowników.");
                    functionTwo(selectedShelter);
                } else if (chosenFunction == 3) {
                    System.out.println("Wybrano listę klientów.");
                    functionThree(selectedShelter);
                } else if (chosenFunction == 4) {
                    System.out.println("Wybrano listę wolontariuszy.");
                    functionFour(selectedShelter);
                } else if (chosenFunction == 5) {
                    System.out.println("Wybrano listę czynności.");
                    functionFive(selectedShelter);
                } else if (chosenFunction == 6) {
                    System.out.println("Powrót do wyboru schroniska.");
                    break;
                } else {
                    System.out.println("Wybrana funkcja nie istnieje.");
                }
            }
        }
    }

    public static void main(String[] args){
        startProgram();
    }
}