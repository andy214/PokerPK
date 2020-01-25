package sample;

import javafx.scene.paint.Color;

public enum Colors {
    DIAMONDS("♦", Color.RED),
    CLUBS("♣", Color.BLACK),
    SPADES("♠", Color.BLACK),
    HEARTS("♥", Color.RED);

    private String sign;
    private Color color;

    Colors(String s,Color c){
        sign = s;
        color = c;
    }

    public String getSign() {
        return sign;
    }

    public Color getColor() {
        return color;
    }
}
