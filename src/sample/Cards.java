package sample;

public class Cards {
    private Ranks rank;
    private Colors color;

    public Cards(Ranks rank, Colors color) {
        this.rank = rank;
        this.color = color;
    }

    public Ranks getRanks() {
        return rank;
    }

    public Colors getColor() {
        return color;
    }

}
