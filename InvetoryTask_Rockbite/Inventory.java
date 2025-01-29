import java.util.*;

public class Inventory {
    private ArrayList<Item> inventory;

    public Inventory() {
        inventory = new ArrayList<>();
    }    

    public ArrayList<Item> getInventory() { return inventory; }

    public void CreateItem(String name, int epicness) {
        Item item = new Item(name, epicness);
        inventory.add(item);
    }

    public Item CreateItem(String name, Rarity rarity) {
        Item item = new Item(name, rarity);
        inventory.add(item);
        return item;
    }

    public Item randomGenerateItem(String name) {
        WeightedRandom wRandom = new WeightedRandom();
        Item item = new Item(name, wRandom.giveRandom());
        inventory.add(item);
        return item;
    }

    public void addItem(Item item) { inventory.add(item); }

    public ArrayList<Item> sortByName() {
        ArrayList<Item> nameSorted = new ArrayList<>(inventory);
        nameSorted.sort(Comparator.comparing(Item::getName));
        return nameSorted;
    }

    public ArrayList<Item> sortByRarity() {
        ArrayList<Item> raritySorted = new ArrayList<>(inventory);
        raritySorted.sort(Comparator.comparing(Item::getRarity));
        return raritySorted;
    }

    public void upgradeItem(int index1, int index2, int index3) {
        if (!isValidIndex(index1) || !isValidIndex(index2) || !isValidIndex(index3)) {
            throw new IndexOutOfBoundsException("Invalid index(es) provided.");
        }

        Item original = inventory.get(index1);
        Item mod1 = inventory.get(index2);
        Item mod2 = inventory.get(index3);

        if (original.getRarity() == Rarity.LEGENDARY) 
            throw new IllegalArgumentException("Max rarity reached, cannot upgrade.");

        if (!original.getName().equals(mod1.getName()) || !original.getName().equals(mod2.getName())) 
            throw new IllegalArgumentException("All items must have the same name.");

        if (original.getRarity() != mod1.getRarity() || 
            original.getRarity() != mod2.getRarity()) 
            throw new IllegalArgumentException("All items must have the same rarity.");

        if (original.getRarity() == Rarity.EPIC && 
            (original.getEpicCounter() != mod1.getEpicCounter() || 
             original.getEpicCounter() != mod2.getEpicCounter() || 
             original.getEpicCounter() != 2)) {
            throw new IllegalArgumentException("Epic items must have an epic counter of 2.");
        }

        original.upgradeRarity();
        inventory.set(index1, original);

        // Remove items in descending order to prevent index shifting
        List<Integer> indicesToRemove = Arrays.asList(index2, index3);
        indicesToRemove.sort(Collections.reverseOrder());
        for (int index : indicesToRemove) {
            inventory.remove(index);
        }
    }

    public void upgradeEpic(int index1, int index2) {
        if (!isValidIndex(index1) || !isValidIndex(index2)) {
            throw new IndexOutOfBoundsException("Invalid index(es) provided.");
        }

        Item original = inventory.get(index1);
        Item mod1 = inventory.get(index2);

        if (original.getRarity() != Rarity.EPIC) 
            throw new IllegalArgumentException("Only epic items can be upgraded.");

        if (!original.getName().equals(mod1.getName())) 
            throw new IllegalArgumentException("All items must have the same name.");

        if (original.getEpicCounter() != mod1.getEpicCounter()) 
            throw new IllegalArgumentException("Epic items must have the same epic counter.");

        original.upgradeEpicness();
        inventory.set(index1, original);
        inventory.remove(index2);
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < inventory.size();
    }
}
