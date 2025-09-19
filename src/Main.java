import java.util.Scanner;// Importerer Random-klassen til at lave tilfældige tal
import java.util.Random;// Importerer Scanner-klassen til at læse brugerinput

public class Main {
    public static void main(String[] args) {
                // Velkomstbesked og menuvalg
                System.out.println("=== Velkommen til Gæt et tal spillet! ===");
                System.out.println("Tryk 1 for at starte");
                System.out.println("Tryk 2 for at afslutte");

                Scanner input = new Scanner(System.in); // Opretter en scanner til brugerinput
                int menuValg = input.nextInt(); // Bruger vælger 1 eller 2

                // Switch til at styre hovedmenuen
                switch (menuValg) {
                    case 1 -> playGame(); // Hvis 1 vælges, starter spillet
                    case 2 -> {
                        System.out.println("Programmet afsluttes...");
                        System.exit(0); // Afslutter programmet
                    }
                    default -> System.out.println("Ugyldigt valg. Programmet afsluttes."); // Hvis andet vælges
                }
            }

            // Metode til at vælge sværhedsgrad
            public static int chooseDifficulty(Scanner input) {
                System.out.println("Vælg en sværhedsgrad:");
                System.out.println("1. Let (0-10)");
                System.out.println("2. Mellem (0-50)");
                System.out.println("3. Svær (0-100)");

                int valg = input.nextInt(); // Brugerens valg
                int max; // Variabel til den maksimale værdi

                // If-else til at bestemme hvilket interval, der skal bruges
                if (valg == 1) {
                    max = 10;
                } else if (valg == 2) {
                    max = 50;
                } else if (valg == 3) {
                    max = 100;
                } else {
                    System.out.println("Ugyldigt valg, standard = 10"); // Fejlhåndtering
                    max = 10;
                }
                return max; // Returnerer valgt interval
            }

            // Metode til at generere et tilfældigt tal
            public static int generateRandomNumber(int max) {
                Random rand = new Random(); // Ny Random generator
                return rand.nextInt(max + 1); // Giver et tilfældigt tal fra 0 til max
            }

            // Metode til at tjekke brugerens gæt
            public static String checkGuess(int guess, int target) {
                if (guess < target) { // Hvis gættet er for lavt
                    return "Dit gæt er for lavt. Prøv igen!";
                } else if (guess > target) { // Hvis gættet er for højt
                    return "Dit gæt er for højt. Prøv igen!";
                } else { // Hvis gættet er korrekt
                    return "Korrekt! Godt gættet!";
                }
            }

            // Metode med spil-loop
            public static void playGame() {
                Scanner input = new Scanner(System.in); // Scanner til gæt

                int max = chooseDifficulty(input); // Få max ud fra brugerens valg
                int target = generateRandomNumber(max); // Generer tilfældigt tal

                System.out.println("Jeg tænker på et tal mellem 0 og " + max);
                int guess = -1; // Starter med et ugyldigt gæt
                int tries = 0;  // Tæller antal forsøg

                // While-løkke kører, indtil brugerens gæt = det rigtige tal
                while (guess != target) {
                    System.out.print("Indtast dit gæt: ");
                    guess = input.nextInt(); // Læs gæt
                    tries++; // Tæl forsøg
                    System.out.println(checkGuess(guess, target)); // Tjek gæt og print feedback
                }

                // Når brugeren har gættet korrekt
                System.out.println("Du brugte " + tries + " forsøg.");
                handlePlayAgain(input); // Spørger om de vil spille igen
            }

            // Metode til at håndtere spil igen
            public static void handlePlayAgain(Scanner input) {
                System.out.println("Vil du spille igen? (ja/nej)");
                String svar = input.next().toLowerCase(); // Læser brugerens svar (altid små bogstaver)

                // Switch til at håndtere "ja/nej"
                switch (svar) {
                    case "ja" -> playGame(); // Starter spillet igen
                    case "nej" -> {
                        System.out.println("Tak fordi du spillede! Programmet afsluttes.");
                        System.exit(0); // Afslut program
                    }
                    default -> {
                        System.out.println("Ugyldigt svar, spillet afsluttes."); // Fejlhåndtering
                        System.exit(0);
                    }
                }
            }
        }