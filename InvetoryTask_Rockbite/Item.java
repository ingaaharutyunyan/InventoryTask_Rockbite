public class Item {
    private String name;
    private Rarity rarity;
    private int epicCounter;

    public Item(String name, Rarity rarity) {
        this.name = name;
        this.rarity = rarity;
        this.epicCounter = 0;
    }

    public Item(String name, int epicCounter) {
        if (epicCounter < 0 || epicCounter > 2) {
            throw new IllegalArgumentException("You can't assign a level besides 0,1,2 to epic types");
        }
        this.name = name;
        this.rarity = Rarity.EPIC;
        this.epicCounter = epicCounter;
    }

    public String getName() {
        return name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getEpicCounter() {
        if (rarity != Rarity.EPIC) {
            throw new IllegalArgumentException("Epic counter is only available for Epic items");
        }
        return epicCounter;
    }

    public void upgradeRarity() {
        rarity = rarity.upgrade();
    }

    public void upgradeEpicness() {
        epicCounter++;
    }

    @Override
    public String toString() {
        return (rarity == Rarity.EPIC) ? name + " (" + rarity + " " + epicCounter + ")" : name + " (" + rarity + ")";
    }
}
