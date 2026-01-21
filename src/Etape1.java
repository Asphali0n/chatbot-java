import java.util.Scanner;

public class Etape1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for inputs

        // List of movies
        final String movie1 = "Avatar";
        float price_movie1 = 10;
        final String movie2 = "Titanic";
        float price_movie2 = 13;
        final String movie3 = "Tenet";
        float price_movie3 = 8;

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
            while (valid_choice == false) {
                System.out.printf("Faites votre choix : ");
                choice = sc.nextInt();

                sc.nextLine(); // Clear the scanner's memory
                
                if (choice == 0 || choice == 1 || choice == 2) {
                    valid_choice = true;
                } else {
                    System.out.printf("Choix incorrect. ");
                }
            }

            System.out.println("\n\n");

            switch (choice) {

                // User want to leave
                case 0:
                    System.out.printf("Au revoir %s ! Ce fut un plaisir !", username);
                    quit = true;
                    break;

                // Menu to see available movies
                case 2:
                    System.out.println("         |----------------------------------------|");
                    System.out.println("---------|(0) Quitter | (1) Faire une réservation |");
                    System.out.println("|        |----------------------------------------|");
                    System.out.println("|");
                    System.out.println("| Liste des films disponibles :");
                    System.out.println("|");
                    System.out.printf("| %s (%.2f €)\n", movie1, price_movie1);
                    System.out.printf("| %s (%.2f €)\n", movie2, price_movie2);
                    System.out.printf("| %s (%.2f €)\n", movie3, price_movie3);
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
                    while (!chosen_movie.equals(movie1) && !chosen_movie.equals(movie2) && !chosen_movie.equals(movie3)) {
                        System.out.printf("Choisissez votre film entre %s, %s et %s : ", movie1, movie2, movie3);
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
                    float total_price = 0;
                    switch (chosen_movie) {
                        case movie1:
                            if (!tarif.equals("normal"))
                                total_price = (price_movie1 * nb_places);
                            else
                                total_price = (price_movie1 * nb_places) / 2;
                            break;
                        
                        case movie2:
                            if (!tarif.equals("normal"))
                                total_price = (price_movie2 * nb_places);
                            else
                                total_price = (price_movie2 * nb_places) / 2;
                            break;
                        

                        case movie3:
                            if (!tarif.equals("normal"))
                                total_price = (price_movie3 * nb_places);
                            else
                                total_price = (price_movie3 * nb_places) / 2;
                            break;

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
        

    }
}
