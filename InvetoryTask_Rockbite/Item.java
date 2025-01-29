public class Item{

    private String name;
    private Rarity rarity;
    private int epicCounter;

    public Item(String name, Rarity rarity){
        this.name = name;
        this.rarity = rarity;
        this.epicCounter = 0;
    }

    public Item(String name, int epicCounter){
        if (epicCounter < 0 || epicCounter > 2){
            throw new IllegalArgumentException("You can't assign a level besides 0,1,2 to epic types");
        }
        this.name = name;
        this.rarity = new Rarity(3);
        this.epicCounter = epicCounter;
    }

    public String getName(){
        return name;
    }

    public String getRarity(){
        return rarity.getRarity();
    }

    public int getEpicCounter(){
        if (rarity.getRarity() != "Epic"){
            throw new IllegalArgumentException("Epic counter is only available for Epic items");
        }
        return epicCounter;
    }

    public void upgradeRarity(){
        rarity.upgradeRarity();
    }

    public void upgradeEpicness(){
        epicCounter++;
    }

    @Override
    public String toString() {
        if (rarity.getRarity() == "Epic"){
            return name + " (" + rarity.getRarity() + " " + epicCounter + ")";
        }
        return name + " (" + rarity.getRarity() + ")";
    }
}