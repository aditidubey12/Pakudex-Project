import java.util.Scanner;
import java.util.Arrays;

// beginning of pakuri program
public class PakuriProgram {
    public static void main(String[] args) {
        boolean menu = true;
        int input = 0; // variable for input
        boolean h = false; // variable for first while loop
        boolean g = true; // variable for second while loop
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        System.out.println("Enter max capacity of the Pakudex: ");
        Scanner scanner = new Scanner(System.in);
        while (h == false) {
            String f = scanner.next();
            try {
                input = Integer.parseInt(f);
                if (input > 0) {
                    h = true;
                } else {
                    System.out.println("Please enter a valid size.");
                    System.out.println("Enter max capacity of the Pakudex: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid size.");
                System.out.println("Enter max capacity of the Pakudex: ");

            }
        }
        System.out.println("The Pakudex can hold" + " " + input + " " + "species of Pakuri.");

        Pakudex pakudex = new Pakudex(input);
                int count = 1;

                // beginning of loop for menu
                while (menu == true) {
                    System.out.println("Pakudex Main Menu");
                    System.out.println("-----------------");
                    System.out.println("1. List Pakuri");
                    System.out.println("2. Show Pakuri");
                    System.out.println("3. Add Pakuri");
                    System.out.println("4. Evolve Pakuri");
                    System.out.println("5. Sort Pakuri");
                    System.out.println("6. Exit");
                    System.out.println("What would you like to do?");
                    int a = 0;
                    // second loop to check input options
                    while (g == true) {
                        try {
                            String l = scanner.next();
                            a = Integer.parseInt(l);
                            if (a < 1 || a > 6) {
                                throw new Exception();
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Unrecognized menu selection!");
                            System.out.println("Pakudex Main Menu");
                            System.out.println("-----------------");
                            System.out.println("1. List Pakuri");
                            System.out.println("2. Show Pakuri");
                            System.out.println("3. Add Pakuri");
                            System.out.println("4. Evolve Pakuri");
                            System.out.println("5. Sort Pakuri");
                            System.out.println("6. Exit");
                            System.out.println("What would you like to do?");

                        }
                    }
                    //first option
                    if (a == 1) {
                        String[] speciesNames = pakudex.getSpeciesArray();
                        if (speciesNames == null) {
                            System.out.println("No Pakuri in Pakudex yet!");
                        } else {
                            System.out.println("Pakuri In Pakudex: ");
                            for (int i = 0; i < speciesNames.length; i++) {
                                System.out.println(count + "." + " " + speciesNames[i]);
                                count++;

                            }

                        }
                    }
                    //second option
                    if (a == 2) {
                        System.out.println("Enter the name of the species to display:");
                        String name = scanner.next();
                        String[] Name = pakudex.getSpeciesArray();
                        if (Name == null) {
                            System.out.println("Error: No such Pakuri!");
                        } else {
                            int[] statistics = pakudex.getStats(name);
                            System.out.println("Species: " + name);
                            System.out.println("Attack: " + statistics[0]);
                            System.out.println("Defense: " + statistics[1]);
                            System.out.println("Speed: " + statistics[2]);
                        }

                    }
                    //third option
                    if (a == 3) {
                        if (pakudex.getSize() >= pakudex.getCapacity()) {
                            System.out.println("Error: Pakudex is full!");
                        } else {
                            System.out.println("Enter the name of the species to add:");
                            String b = scanner.next();
                            if (pakudex.addPakuri(b)) {
                                System.out.println("Pakuri species" + " " + b + " " + "successfully added!");
                            } else {
                                System.out.println("Error: Pakudex already contains this species!");
                            }

                        }
                    }
                    //fourth option
                    if (a == 4) {
                        System.out.println("Enter the name of the species to evolve:");
                        String d = scanner.next();
                        if (pakudex.evolveSpecies(d)) {
                            System.out.println(d + " has evolved!");
                        } else {
                            System.out.println("Error: No such Pakuri!");
                        }
                    }
                    //fifth option
                    if (a == 5) {
                        System.out.println("Pakuri have been sorted!");
                        pakudex.sortPakuri();

                    }
                    //sixth option
                    if (a == 6) {
                        System.out.println("Thanks for using Pakudex! Bye!");
                        menu = false;
                    }


                }



            }
        }







