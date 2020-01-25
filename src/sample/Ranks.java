package sample;

public enum Ranks {
    ACES("A"),
    KINGS("K"),
    QUEENS("Q"),
    JACKS("J"),
    TENS("10"),
    NINES("9"),
    EIGHTS("8"),
    SEVENS("7"),
    SIXES("6"),
    FIVES("5"),
    FOURS("4"),
    THREES("3"),
    TWOS("2");

    private String rank;

    private Ranks(String r){
        rank = r;
    }

    public String getRank() {
        return rank;
    }
}


