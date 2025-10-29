/**
 * Klasa ShelterFullException.
 * Wymaganie: Zdefiniowany wyjątek użytkownika.
 * Dziedziczy po Exception, co czyni go wyjątkiem kontrolowanym (checked exception).
 * Musi być obsłużony w blokach try-catch w miejscu wywołania.
 */
public class ShelterFullException extends Exception {

    /**
     * Konstruktor wyjątku.
     * @param message Komunikat błędu wyjaśniający, dlaczego wyjątek został rzucony
     * (np. "Schronisko jest pełne!").
     */
    public ShelterFullException(String message) {
        // Przekazanie komunikatu do konstruktora klasy nadrzędnej Exception.
        super(message);
    }
}