import Enums.ServiceType;
import People.Person;

import java.time.LocalDate;
import java.util.Objects;

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

    // Wymaganie: Przygotowanie do Upcastingu. Przechowuje osobę (People.Employee lub People.Volunteer),
    // która wykonała usługę, jako typ nadrzędny People.Person.
    private Person whoPerformed;

    /**
     * Konstruktor klasy AnimalCare.
     * Inicjalizuje rekord opieki.
     * @param serviceType Typ wykonanej usługi (z enum Enums.ServiceType).
     * @param serviceDate Data wykonania usługi.
     * @param whoPerformed Obiekt People.Person (pracownik lub wolontariusz) wykonujący usługę.
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
        // Zakładamy, że klasa People.Person ma metody getName() i getId().
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
     * @return Typ usługi (enum Enums.ServiceType).
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
     * @return Osoba wykonująca (obiekt People.Person).
     */
    public Person getWhoPerformed() {
        return whoPerformed;
    }
}
/**
 * Wymaganie: Nadpisanie metody equals.
 * Dwa rekordy opieki są równe, jeśli mają ten sam typ usługi, datę
 * i zostały wykonane przez tę samą osobę.
 */
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AnimalCare that = (AnimalCare) o;
    return serviceType == that.serviceType &&
            Objects.equals(serviceDate, that.serviceDate) &&
            Objects.equals(whoPerformed, that.whoPerformed);
}

/**
 * Wymaganie: Nadpisanie metody hashCode.
 * Generuje unikalny kod haszujący na podstawie kluczowych pól obiektu.
 */
@Override
public int hashCode() {
    return Objects.hash(serviceType, serviceDate, whoPerformed);
}