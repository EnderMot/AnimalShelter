import java.time.LocalDate;

/**
 * Klasa AnimalCare.
 * Odpowiada za rejestrację pojedynczej, wykonanej usługi opieki nad zwierzęciem.
 * Spełnia wymagania hermetyzacji (pola prywatne i publiczne gettery).
 */
public class AnimalCare {

    // POLA KLASY 

    // Wymaganie: Wykorzystanie Enum. Przechowuje typ wykonanej usługi (np. strzyżenie).
    private ServiceType serviceType;

    // Przechowuje datę wykonania usługi (użycie Java Time API).
    private LocalDate serviceDate;

    // Wymaganie: Przygotowanie do Upcastingu. Przechowuje osobę (Employee lub Volunteer), 
    // która wykonała usługę, jako typ nadrzędny Person.
    private Person whoPerformed;

    /**
     * Konstruktor klasy AnimalCare.
     * Inicjalizuje rekord opieki.
     * @param serviceType Typ wykonanej usługi (z enum ServiceType).
     * @param serviceDate Data wykonania usługi.
     * @param whoPerformed Obiekt Person (pracownik lub wolontariusz) wykonujący usługę.
     */
    public AnimalCare(ServiceType serviceType, LocalDate serviceDate, Person whoPerformed) {
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.whoPerformed = whoPerformed;

        // Wymaganie: Komunikat w konsoli ułatwiający interakcję
        System.out.println("Utworzono nowy rekord opieki: " + serviceType.name());
    }

    //METODY

    /**
     * Wymaganie: Nadpisanie metody toString() (drugie z trzech wymaganych w projekcie).
     * Służy do czytelnego wyświetlenia wszystkich informacji o danym rekordzie opieki.
     * @return Sformatowany String zawierający szczegóły usługi.
     */
    @Override
    public String toString() {
        // Sprawdzenie, czy osoba wykonująca istnieje, aby uniknąć NullPointerException.
        // Zakładamy, że klasa Person ma metody getName() i getId().
        String performerInfo = (whoPerformed != null)
                ? whoPerformed.getName() + " (ID: " + whoPerformed.getId() + ")"
                : "Nieznany/a";

        return "--- Zapis Opieki ---\n" +
                "Usługa: " + this.serviceType.name() + "\n" +
                "Data: " + this.serviceDate + "\n" +
                "Wykonana przez: " + performerInfo + "\n" +
                "----------------------";
    }

    //PUBLICZNE GETTERY

    /**
     * Zwraca typ wykonanej usługi.
     * @return Typ usługi (enum ServiceType).
     */
    public ServiceType getServiceType() {
        return serviceType;
    }

    /**
     * Zwraca datę wykonania usługi.
     * @return Data usługi (LocalDate).
     */
    public LocalDate getServiceDate() {
        return serviceDate;
    }

    /**
     * Zwraca obiekt osoby, która wykonała usługę.
     * @return Osoba wykonująca (obiekt Person).
     */
    public Person getWhoPerformed() {
        return whoPerformed;
    }
}