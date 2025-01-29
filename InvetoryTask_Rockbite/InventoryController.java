import java.util.Scanner;
import java.util.*;

public class InventoryController {
    private final Inventory model;
    private final InventoryView view;

    public InventoryController(Inventory model, InventoryView view) {
        this.model = model;
        this.view = view;
    }

    public void DisplayIntro() {
        view.displayIntro();
    }

    public void Choose(Scanner scanner, int i) {
        switch (i) {
            case 1 -> {
                System.out.println("---CREATE---");
                System.out.println("1) Create yourself");
                System.out.println("2) Randomly Generate");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter item name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter rarity as its corresponding number (COMMON - 0, GREAT - 1, RARE - 2, EPIC - 3, LEGENDARY - 4): ");

                        int r = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        if (r == 3) { // Epic items need an extra parameter
                            System.out.print("Enter level of epicness (0, 1, 2): ");
                            int x = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            model.CreateItem(name, x);
                        } else {
                            try {
                                if (r < 0 || r >= Rarity.values().length) {
                                    throw new IllegalArgumentException("Invalid rarity input.");
                                }
                                Rarity rarity = Rarity.values()[r];
                                model.CreateItem(name, rarity);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid rarity input. Try again.");
                            }
                        }
                    }
                    case 2 -> {
                        System.out.println("Please give your item a name");
                        String name = scanner.nextLine();
                        Item item = model.randomGenerateItem(name);
                        System.out.println("Your randomly generated item looks like this:\n" + view.displayItem(item));
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }

                DisplayIntro();
                Choose(scanner, scanner.nextInt());
            }
            case 2 -> {
                System.out.println("Would you like to upgrade item rarity or upgrade epic items?");
                System.out.println("1) Upgrade item rarity \n2) Upgrade epic items");
                int c = scanner.nextInt();

                System.out.println(view.displayInventory(model)); // Show inventory before upgrade

                switch (c) {
                    case 1 -> {
                        System.out.print("Enter item index to upgrade: ");
                        int index = scanner.nextInt();
                        System.out.print("Enter the indexes of the other two items to merge (separate with enter button): ");
                        int one = scanner.nextInt();
                        System.out.print("One more index please: ");
                        int two = scanner.nextInt();
                        upgradeItem(index, one, two);
                    }
                    case 2 -> {
                        System.out.print("Enter epic item index to upgrade: ");
                        int index = scanner.nextInt();
                        System.out.print("Enter the index of the other item to merge: ");
                        int one = scanner.nextInt();
                        upgradeItem(index, one);
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }

                DisplayIntro();
                Choose(scanner, scanner.nextInt());
            }
            case 3 -> {
                System.out.println("How would you like to view your inventory?");
                System.out.println("1) Normal \n2) Sorted by name  \n3) Sorted by rarity");
                int c = scanner.nextInt();

                switch (c) {
                    case 1 -> System.out.println(view.displayInventory(model));
                    case 2 -> System.out.println(view.displayInventory(model.sortByName()));
                    case 3 -> System.out.println(view.displayInventory(model.sortByRarity()));
                    default -> System.out.println("Invalid choice. Please try again.");
                }

                DisplayIntro();
                Choose(scanner, scanner.nextInt());
            }
            case 4 -> {
                System.out.println("Exiting...");
                return;
            }
            default -> {
                System.out.println("That number wasn't listed in the instructions! Please try again.");
                Choose(scanner, scanner.nextInt());
            }
        }
    }

    public void upgradeItem(int original, int one, int two) {
        if (!isValidIndex(original) || !isValidIndex(one) || !isValidIndex(two)) {
            System.out.println("Invalid item index. Try again.");
            return;
        }
        model.upgradeItem(original, one, two);
    }

    public void upgradeItem(int original, int one) {
        if (!isValidIndex(original) || !isValidIndex(one)) {
            System.out.println("Invalid item index. Try again.");
            return;
        }
        model.upgradeEpic(original, one);
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < model.getInventory().size();
    }

    public void DisplayInventory() {
        System.out.println(view.displayInventory(model));
    }
}
