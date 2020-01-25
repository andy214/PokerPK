package sample;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    ArrayList<Cards> deck = new ArrayList();
    Colors[] colors = Colors.values();
    Ranks[] ranks = Ranks.values();

    public void createDeck(){
        for(Ranks figure: ranks){
            for(Colors color: colors){
                Cards card = new Cards(figure,color);
                deck.add(card);
            }
        };
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
        for(Cards card: deck){
            System.out.print(card.getRanks().getRank()+""+card.getColor().getSign()+" ");
        }

    }




}
