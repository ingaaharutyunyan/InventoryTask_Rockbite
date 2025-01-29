public class Rarity{
    private String rarity;
    private int index;
    private String[] rarityNames = {"Common", "Great", "Rare", "Epic", "Legendary"}; 

    public Rarity(int r) {
        if (r < 0 || r >= rarityNames.length) {
            throw new IllegalArgumentException("Invalid rarity index: " + r);
        }
        this.rarity = rarityNames[r];
        this.index = r;
    }
    public int getIndex(){
        return index;
    }

    public void upgradeRarity(){
        index++;
        rarity = rarityNames[index];
    }
    public String getRarity(){
        return rarity;
    }
}

// I could also use enums but would rather immedietely upgrade the types by index.