package sample;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Player {
    private long numberOfChips;
    private Cards[] playersHand;
    private Boolean isFold;

    public long getNumberOfChips() {
        return numberOfChips;
    }

    public void setNumberOfChips(long numberOfChips) {
        this.numberOfChips = numberOfChips;
    }

    public Cards[] getPlayersHand() {
        return playersHand;
    }

    public void setPlayersHand(Cards[] playersHand) {
        this.playersHand = playersHand;
    }

    public int call(Text playerChips, int pool, Text poolText, int callChips){
        numberOfChips -= callChips;
        pool += callChips;
        playerChips.setText(""+numberOfChips);
        poolText.setText(""+pool);

        return pool;
    }

    public void fold(Group cards, Button call, Button raise){
        cards.getChildren().clear();
        call.setDisable(true);
        raise.setDisable(true);
    }

    public int raise(Text playerChips, int pool, Text poolText, double raiseChips, Button call){
        numberOfChips -= raiseChips;
        pool += raiseChips;
        playerChips.setText(""+numberOfChips);
        poolText.setText(""+pool);

        return pool;
    }

}
