import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        InventoryView view = new InventoryView();
        InventoryController controller = new InventoryController(inventory, view);

        Scanner scanner = new Scanner(System.in);
        controller.DisplayIntro();

        int choice = scanner.nextInt();
        scanner.nextLine();

        controller.Choose(scanner, choice);
    }
}
