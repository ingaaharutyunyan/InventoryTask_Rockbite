public enum Rarity {
    COMMON,
    GREAT,
    RARE,
    EPIC,
    LEGENDARY;

    public Rarity upgrade() {
        int nextOrdinal = this.ordinal() + 1;
        return nextOrdinal < Rarity.values().length ? Rarity.values()[nextOrdinal] : this;
    }
}
