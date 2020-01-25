package sample;

import javafx.scene.text.Text;

public class Player {
    long numberOfChips;
    Cards[] playersHand;

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

    public void call(Text playerChips, int numberToSub){
        numberOfChips -= numberToSub;
        playerChips.setText(""+numberOfChips);
    }

    public int fold(){

        return 0;
    }

    public int raise(int raiseChips){

        return 0;
    }

    public int allin(){

        return 0;
    }
}
