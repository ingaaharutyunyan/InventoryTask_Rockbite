import java.util.*;

public class InventoryView {

    public void displayIntro() {
        System.out.println("Welcome to the Inventory Manager!");
        System.out.println("Controls: ");
        System.out.println("1. Create item");
        System.out.println("2. Upgrade item");
        System.out.println("3. Display inventory");
        System.out.println("4. Exit");
    }

    public String displayItem(Item item) {
        return item.toString();
    }

    public String displayInventory(Inventory inv){
        ArrayList<Item> arr = inv.getInventory();
        String result = "";
        for (int i = 0; i < arr.size(); i++){
            result +=  "Index: " + i + " Item: " + arr.get(i).toString() + "\n";
        }
        return result;
    }

    public String displayInventory(ArrayList<Item> inv){
        String result = "";
        for (int i = 0; i < inv.size(); i++){
            result +=  "Index: " + i + " Item: " + inv.get(i).toString() + "\n";
        }
        return result;
    }



    
}
