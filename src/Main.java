import Animals.*;
import Enums.*;
import People.*;

import java.awt.*;
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
                new Employee("Karina",  "Fabian",       34,5630, Jobs.ADOPTION_COORDINATOR),
                new Employee("Mateusz", "Latek",        37,6420, Jobs.CARE_WORKER),
                new Employee("Kamila",  "Darowska",     56,6530, Jobs.SHELTER_MANAGER),
                new Employee("Jacek",   "Płaczek",      23,4620, Jobs.ADMINISTRATION),
                new Employee("Rudolf",  "Szczeblewski", 25,5630, Jobs.SECURITY_STAFF),
                new Employee("Adela",   "Kasprzyk",     42,7700, Jobs.VETERINARY_TECHNICIAN)
        };

        Employee[] shelterTwoEmployees = {
                new Employee("Paulina",     "Kędzierska",   39,4230, Jobs.ADOPTION_COORDINATOR),
                new Employee("Czesław",     "Mytnik",       26,5302, Jobs.CARE_WORKER),
                new Employee("Sebastian",   "Kuboszek",     52,7270, Jobs.SHELTER_MANAGER),
                new Employee("Ludwik",      "Juraszczyk",   31,4650, Jobs.VETERINARY_TECHNICIAN),
                new Employee("Daniel",      "Malesa",       43,5300, Jobs.SECURITY_STAFF),
                new Employee("Laura",       "Szafranek",    23,6220, Jobs.ADMINISTRATION)
        };

        Volunteer[] shelterOneVolunteers= {
                new Volunteer("Nikola",     "Gąszczak",34,ServiceType.FEEDING),
                new Volunteer("Julianna",   "Medvedieva",37,ServiceType.GROOMING),
                new Volunteer("Karol ",     "Buras",56,ServiceType.VETERINARY_CHECKUP),
                new Volunteer("Blanka",     "Jastrzębska",23,ServiceType.WALK_ACTIVITY)
        };

        Volunteer[] shelterTwoVolunteers = {
                new Volunteer("Roman",  "Policht",34,ServiceType.WALK_ACTIVITY),
                new Volunteer("Adrian", "Sieńko",37,ServiceType.FEEDING),
                new Volunteer("Beata ", "Majcher",56,ServiceType.GROOMING),
                new Volunteer("Rozalia","Łukaszuk",23,ServiceType.VETERINARY_CHECKUP)
        };


        Animal[] shelterOneAnimals = {
                new Cat(    "Imperializm",  3, Traits.CUTE),
                new Dog(    "Błysk",        5, Traits.PLAYFULL),
                new Hamster("Kulka",        1, Traits.GLUTTON),
                new Fox(    "Brylant",      4, Traits.ACTIVE),
                new Cat(    "Nandor",       7, Traits.GRUMPY),
                null, null, null, null, null
        };

        Animal[] shelterTwoAnimals = {
                new Cat(    "Orfeusz",  7, Traits.GLUTTON),
                new Dog(    "Burza",    3, Traits.PICKYEATER),
                new Hamster("Luke",     2, Traits.SLEEPY),
                new Fox(    "Grom",     6, Traits.LOVELY),
                new Cat(    "Migot",    4, Traits.SLEEPY),
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

    //region [Category: PierwszaFunkcjaUI]
    // METODY PIERWSZEJ FUNCKJI UI ZARZĄDZANIA ZWIERZĘTAMI W SCHRONISKU
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

    public static void animalManagment(AnimalShelter selectedShelter, Animal selectedAnimal){
        while(true) {
            String species = "";
            if (selectedAnimal instanceof Cat) species = "Kot";
            else if (selectedAnimal instanceof Dog) species = "Pies";
            else if (selectedAnimal instanceof Hamster) species = "Chomik";
            else if (selectedAnimal instanceof Fox) species = "Lis";
            System.out.println("\n\n"+species + ": " + selectedAnimal);
            System.out.println("Wiek przeliczony na ludzkie lata: "+selectedAnimal.calculateAgeInHumanYears());
            if (selectedAnimal.isAdopted()){
                System.out.println("Adoptowany przez: "+selectedAnimal.getAdoptedBy().getName()+" "+selectedAnimal.getAdoptedBy().getSurname());
                System.out.println("Adoptowany od: "+selectedAnimal.getDateOfAdoption());
            }
            else{
                System.out.println("Gotowy do adopcji.");
            }

            System.out.println("Lista przeszłych imion: "+ selectedAnimal.getPastNames());

            System.out.println("\nFunkcje zarządzania zwierzęciem:");
            int[] allowedValues = {1,2,3};
            if (!selectedAnimal.isAdopted()){
                System.out.println("1. Adopcja.");
                System.out.println("2. Zmień imię.");
                System.out.println("3. Powrót do listy zwierząt.");
            }
            else{
                System.out.println("1. Oddanie do schroniska.");
                System.out.println("2. Zmień imię.");
                System.out.println("3. Powrót do listy zwierząt.");
            }

            int functionChoice = menuSelector(allowedValues);
            if (functionChoice == allowedValues[allowedValues.length-1]){
                break;
            } else if (functionChoice == allowedValues[allowedValues.length-2]) {
                System.out.println("Podaj nowę imię dla zwierzaka: ");
                Scanner scanner = new Scanner(System.in);
                String newName = scanner.nextLine();
                selectedAnimal.setName(newName);
            }
            else if (selectedAnimal.isAdopted()){
                selectedAnimal.returnToShelter();
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
                animalManagment(selectedShelter, animals[chosenAnimal - 1]);
            }
        }
    }
    //KONIEC METOD PIERWSZEJ FUNKCJI UI
    //endregion [Category: PierwszaFunkcjaUI]

    //region [Category: DrugaFunkcjaUI]
    //METODY DRUGIEJ FUNCKJI UI ZARZĄDZANIA PRACOWNIKAMI W SCHRONISKU

    public static void functionTwo(AnimalShelter selectedShelter){

        while (true) {

            Employee[] employees = selectedShelter.getEmployees();

            // Sprawdzenie liczby pracowników
            int employeeCount = 0;
            for (Employee e : employees) {
                if (e != null) employeeCount++;
            }

            int[] allowedValues = new int[employeeCount + 1];

            System.out.println("\n\nLista pracowników schroniska ");

            int index = 0;
            for (int i = 0; i < employees.length; i++) {
                Employee e = employees[i];
                if (e != null) {
                    System.out.println((index + 1) + ". " + e);
                    allowedValues[index] = index + 1;
                    index++;
                }
            }

            // opcja powrotu do menu głównego
            System.out.println((employeeCount + 1) + ". Powrót do menu głównego");
            allowedValues[employeeCount] = employeeCount + 1;

            System.out.println("Wybierz numer pracownika, którym chcesz zarządzać.");
            System.out.println("Podaj właściwy numer z zakresu od "
                + allowedValues[0] + " do " + allowedValues[allowedValues.length - 1] + " : ");

            int chosen = menuSelector(allowedValues);

            if (chosen == allowedValues[allowedValues.length - 1]) {
                break;
            } else {
                // Przypisanie wybranego pracownika
                int id = employees[chosen-1].getId();
                Employee selectedEmployee = (Employee) selectedShelter.getPersonFromTable(id, employees);
                employeeManagement(selectedEmployee);
            }
        }

    }

    public static void employeeManagement(Employee employee) {

        while (true) {
            System.out.println("\n\nPracownik: " + employee);
            System.out.println("\nZarządzanie pracownikiem:");

            int[] allowedValues = {1, 2, 3};

            System.out.println("1. Zmień stanowisko.");
            System.out.println("2. Zmień pensję.");
            System.out.println("3. Powrót do listy pracowników.");

            int choice = menuSelector(allowedValues);

            if (choice == 3) break;

            Scanner scanner = new Scanner(System.in);

            if (choice == 1) {
                Jobs[] allJobs = Jobs.values(); // dostępne stanowiska w enum - Jobs
                System.out.println("Dostępne stanowiska:");
                for (int i = 0; i < allJobs.length; i++) {
                    System.out.println((i + 1) + ". " + allJobs[i]);
                }

                System.out.print("Wybierz numer nowego stanowiska: ");

                int[] allowedJobNumbers = new int[allJobs.length];
                for (int i = 0; i < allJobs.length; i++) allowedJobNumbers[i] = i + 1;

                int chosenJobNumber = menuSelector(allowedJobNumbers);

                // przypisanie nowego stanowiska
                employee.setJobs(allJobs[chosenJobNumber - 1]);
                System.out.println("Zmieniono stanowisko na: " + allJobs[chosenJobNumber - 1]);

            }

            if (choice == 2) {
                System.out.print("Podaj nową pensję: ");
                try {
                    double newSalary = scanner.nextDouble();
                    employee.setSalary(newSalary);
                    System.out.println("Zmieniono pensję.");
                } catch (Exception e) {
                    System.out.println("Błąd, podano tekst zamiast liczby.");
                }
            }
        }

    }
    // KONIEC METOD DRUGIEJ FUNKCJI UI
    //endregion [Category: DrugaFunkcjaUI]

    //region [Category: TrzeciaFunkcjaUI]
    //METODY TRZECIEJ FUNCKJI UI ZARZĄDZANIA KLIENTAMI W SCHRONISKU
    public static void clientManagment(Client selectedClient, AnimalShelter selectedShelter){
        while(true) {
            System.out.println("\n\n"+selectedClient);
            if (selectedClient.getAdoptedAnimals().size()==0){
                System.out.println("Klient (id: "+selectedClient.getId()+") nie adoptował żadnego zwierzęcia.");
            }
            else{
                System.out.println("Adoptowane zwierzęta klienta (id: +"+selectedClient.getId()+"): ");
                ArrayList<Animal> animals = selectedClient.getAdoptedAnimals();
                for (int i =0; i<animals.size(); i++){
                    Animal animal = animals.get(i);
                    String species = "";
                    if (animal instanceof Cat) species = "Kot";
                    else if (animal instanceof Dog) species = "Pies";
                    else if (animal instanceof Hamster) species = "Chomik";
                    else if (animal instanceof Fox) species = "Lis";
                    System.out.println(i+". "+species + ": " + animal);
                }
            }

            System.out.println("\nFunkcje zarządzania klientem:");
            System.out.println("1. Powrót do listy klientów.");
            int[] allowedValues = {1};
            int functionChoice = menuSelector(allowedValues);
            if (functionChoice == 1){
                break;
            }
        }
    }

    public static void functionThree(AnimalShelter selectedShelter){
        while (true) {
            ArrayList<Client> clients = selectedShelter.getClients();
            int clientCount = 0;
            for (Client client : clients){
                if (client!=null){
                    clientCount++;
                }
            }
            int[] allowedValues = new int[clientCount + 1];
            for (int i = 0; i < clientCount; i++) {
                Client client = clients.get(i);
                if (client != null) {
                    System.out.println((i + 1) + ". " + client);
                    allowedValues[i] = i + 1;
                }
            }
            System.out.println((clientCount+1) + ". Powrót do wyboru funkcji.");
            allowedValues[clientCount] = clientCount + 1;
            System.out.println("Wybierz numer klienta którym chcesz zrządzać.");
            System.out.print("Podaj właściwy numer z zakresu od " + allowedValues[0] + " do " + allowedValues[allowedValues.length - 1] + " : ");
            int chosenClient = menuSelector(allowedValues);
            if (chosenClient == allowedValues[allowedValues.length-1]) {
                break;
            }
            else {
                clientManagment((Client) selectedShelter.getPersonFromTable(clients.get(chosenClient - 1).getId(), (Client[])clients.toArray()), selectedShelter);
            }
        }
    }
    // KONIEC METOD TRZECIEJ FUNKCJI UI
    //endregion [Category: TrzeciaFunkcjaUI]

    //region [Category: CzwartaFunkcjaUI]
    //METODY CZWARTEJ FUNCKJI UI ZARZĄDZANIA WOLONTARIUSZAMI W SCHRONISKU
    public static void functionFour(AnimalShelter selectedShelter){
        while (true) {
            Volunteer[] volunteers = selectedShelter.getVolunteers();
            int volunteerCount = 0;
            for (Volunteer volunteer : volunteers){
                if (volunteer!=null){
                    volunteerCount++;
                }
            }
            int[] allowedValues = new int[volunteerCount + 1];
            for (int i = 0; i < volunteerCount; i++) {
                Volunteer volunteer = volunteers[i];
                if (volunteer != null) {
                    System.out.println((i + 1) + ". " + volunteer);
                    allowedValues[i] = i + 1;
                }
            }
            System.out.println((volunteerCount+1) + ". Powrót do wyboru funkcji.");
            allowedValues[volunteerCount] = volunteerCount + 1;
            System.out.println("Wybierz numer wolontariusza którym chcesz zrządzać.");
            System.out.print("Podaj właściwy numer z zakresu od " + allowedValues[0] + " do " + allowedValues[allowedValues.length - 1] + " : ");
            int chosenClient = menuSelector(allowedValues);
            if (chosenClient == allowedValues[allowedValues.length-1]) {
                break;
            }
            else {
                Volunteer selectedVolunteer = (Volunteer) selectedShelter.getPersonFromTable(
                        volunteers[chosenClient - 1].getId(),
                        volunteers
                );

                System.out.println("\nWybrano wolontariusza: " + selectedVolunteer.getFullInformationAboutPerson());

                volunteerManagement(selectedVolunteer, selectedShelter);
            }
        }
    }

    public static void volunteerManagement(Volunteer volunteer, AnimalShelter selectedShelter) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWolontariusz: " + volunteer.getFullInformationAboutPerson());
            System.out.println("1. Zmień typ pomocy.");
            System.out.println("2. Wykonaj pomoc w ramach opieki nad zwierzęciem.");
            System.out.println("3. Powrót.");

            int choice = menuSelector(new int[]{1,2,3});
            if (choice == 3) break;

            if (choice == 1) {
                System.out.println("Dostępne rodzaje pomocy: ");
                System.out.println("1. FEEDING");
                System.out.println("2. GROOMING");
                System.out.println("3. VETERINARY_CHECKUP");
                System.out.println("4. WALK_ACTIVITY");

                System.out.println("Wybierz nową formę pomocy: ");
                int newType = menuSelector(new int[]{1,2,3,4});

                if (newType == 1) volunteer.setHelpType(ServiceType.FEEDING);
                else if (newType == 2) volunteer.setHelpType(ServiceType.GROOMING);
                else if (newType == 3) volunteer.setHelpType(ServiceType.VETERINARY_CHECKUP);
                else if (newType == 4) volunteer.setHelpType(ServiceType.WALK_ACTIVITY);

                System.out.println("Zmieniono forme pomocy na: " + volunteer.getHelpType());
            }

            if (choice == 2) {
                volunteer.help();
            }
        }
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
                System.out.println("5. Powrót do wyboru schroniska.");
                System.out.print("\nWybierz funkcje którą chcesz wykonać.");
                allowedValues = new int[]{1, 2, 3, 4, 5};
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