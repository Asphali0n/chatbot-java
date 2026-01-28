import java.util.HashMap;
import java.util.Scanner;

public class Etape1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for inputs

        // List of movies
        HashMap<String, Double> movies = new HashMap<String, Double>();
        movies.put("Avatar", 10.0);
        movies.put("Titanic", 13.0);
        movies.put("Tenet", 8.0);

        double total_price = 0;

        // Get user's name
        System.out.printf(
                "Bonjour, bienvenue dans notre cinéma ! \nJe suis GUHHH, votre assistant de réservation. \nS'il-vous-plaît, indiquez-moi votre nom : ");
        String username = sc.nextLine();
        System.out.printf("\nBienvenue %s ! ", username);

        boolean quit = false;

        while (quit == false) {
            // Print menu
            System.out.println("\n\n");
            System.out.println("|--------------------------------------------------------------|");
            System.out.println("| (0) Quitter | (1) Faire une réservation | (2) Voir les Films |");
            System.out.println("|--------------------------------------------------------------|");
            System.out.println("\n\n");

            int choice = 0; // Random initial value
            boolean valid_choice = false;
            while (valid_choice == false) { // Keep asking for user input if the choice is not valid
                System.out.printf("Faites votre choix : ");
                choice = sc.nextInt();

                sc.nextLine(); // Clear the scanner's memory

                // Check if the choice is valid or not
                if (choice == 0 || choice == 1 || choice == 2) {
                    valid_choice = true;
                } else {
                    System.out.printf("Choix incorrect. ");
                }
            }

            System.out.println("\n\n");

            switch (choice) {

                // User wants to leave
                case 0:
                    System.out.printf("Au revoir %s ! Ce fut un plaisir !", username);
                    quit = true;
                    break;

                // Menu to see available movies
                case 2:
                    System.out.println("         |----------------------------------------|");
                    System.out.println("---------|(0) Quitter | (1) Faire une réservation |");
                    System.out.println("|        |----------------------------------------|");
                    System.out.println("|\n| Liste des films disponibles :\n|");
                    for (String i : movies.keySet()) {
                        System.out.printf("| %s (%.2f €)\n", i, movies.get(i));
                    }
                    System.out.println("--------------------------------------------------| \n");
                    while (choice != 0 && choice != 1) {
                        System.out.printf("Veuillez choisir (0 ou 1) : ");
                        choice = sc.nextInt();
                        sc.nextLine(); // Clear the scanner's memory
                    }
                    if (choice == 0) {
                        quit = true;
                        break;
                    }

                    // Menu to book a movie
                case 1:

                    String chosen_movie = "to_fill";
                    while (!movies.keySet().contains(chosen_movie)) {
                        System.out.printf("Choisissez votre film entre %s : ", String.join(",", movies.keySet()));
                        chosen_movie = sc.nextLine();
                    }

                    int nb_places = -1; // Random value
                    while (nb_places > 10 || nb_places < 0) {
                        System.out.printf("\nVeuillez choisir un nombre de places entre 1 et 10 : ");
                        nb_places = sc.nextInt();

                        sc.nextLine(); // Clear the scanner's memory
                    }
                    String tarif = "to_fill";
                    while (!tarif.equals("normal") && !tarif.equals("réduit")) {
                        System.out.printf("Veuillez choisir un tarif entre 'normal' et 'réduit' (moitié-prix) : ");
                        tarif = sc.nextLine();
                    }

                    // Calculate total price
                    if (tarif.equals("normal")) {
                        total_price = total_price + (movies.get(chosen_movie) * nb_places);
                    } else if (tarif.equals("réduit")) {
                        total_price = total_price + (movies.get(chosen_movie) * nb_places) / 2;
                    }

                    System.out.printf("\nLe prix total de votre séance sera de %.2f € \n\n\n", total_price);

                    System.out.println("|-----------------------------|");
                    System.out.println("| (0) Quitter | (1) Continuer |");
                    System.out.println("|-----------------------------|\n\n");

                    choice = -1; // Random value
                    while (choice != 0 && choice != 1) {
                        System.out.printf("Choisissez entre quitter (0) et continuer (1) : ");
                        choice = sc.nextInt();
                        if (choice == 0) {
                            quit = true;
                            break;
                        }
                    }

            }

        }
        sc.close();
    }
}
