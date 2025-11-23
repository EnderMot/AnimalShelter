import People.Client;
import People.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //EMPTY UNLESS TESTING

        AnimalShelter ShelterOne = new AnimalShelter();
        AnimalShelter ShelterTwo = new AnimalShelter();

        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Witamy w systemie zarzadzania schoroniskiem.");
        System.out.println();
        System.out.println("Dostepne schroniska:");
        // Lista schronisk zamiast 13. 14.
        System.out.println("Schronisko nr 1");
        System.out.println("Schronisko nr 2");
        System.out.print("Wybierz nr schroniska : ");
        int NrSchroniska = scanner.nextInt();

        while ((NrSchroniska < 1) || (NrSchroniska > 2)){
            System.out.println("Schronisko nieistnieje");
            System.out.print("Podaj własciwy nr schroniska[1-2] : ");
            NrSchroniska = scanner.nextInt();
        }

        if ((NrSchroniska == 1) || (NrSchroniska == 2)) {
            System.out.println("Dostepne funkcje:");
            System.out.println("1. Wyswietl liste gatunkow zwierzat.");
            System.out.println("2. Wyswietl liste pracownikow.");
            System.out.println("3. Wyswietl liste klientow.");
            System.out.println("4. Wyswietl liste wolontariuszy.");
            System.out.println("5. Wyswietl liste czynnosci wolontariuszy.");
            System.out.print("Wybierz funkcje: ");

            int NrFunkcji = scanner.nextInt();
            while (NrFunkcji > 5){
                System.out.println("Bledna wartosc.");
                System.out.print("Podaj poprawna wartosc[1-5] : ");
                NrFunkcji = scanner.nextInt();
            }

            if (NrFunkcji == 1) {
                    System.out.println("Gatunki zwierząt: Chomik, Kot, Lis, Pies.");
            } else if (NrFunkcji == 2) {

            } else if (NrFunkcji == 3) {
               ArrayList<Client> ClientList = ShelterOne.getClients();
               int i = 1;
                for (Client client : ClientList) {
                    System.out.println(i + ". " + client.getId() + "" + client.getName() + " " + client.getSurname());
                }
            } else if (NrFunkcji == 4) {

            } else if (NrFunkcji == 5) {

            } else {

                }
        }


        scanner.close();
    }
}