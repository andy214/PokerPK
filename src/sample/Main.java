package sample;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.*;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    Text numberOfChips;
    Group PlayerOne;
    int pool = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Deck deck = new Deck();
        deck.createDeck();
        deck.shuffleDeck();
        HumanPlayer player1 = new HumanPlayer("Andrew214", "test123");
        LinearGradient gradient2 = new LinearGradient(
                0,   // start X
                1,   // start Y
                0,   // end X
                0, // end Y
                true, // proportional
                CycleMethod.NO_CYCLE, // cycle colors

                // stops
                new Stop(0.1f, Color.LIGHTGREEN),
                new Stop(1.0f, Color.BLACK)
        );

        primaryStage.setTitle("PKoker");

        //Settings of Font
        Font fontOfCard = new Font(45);
        Font fontOfChips = new Font(35);

        //Board
        Ellipse boardOutside = new Ellipse(850,400,655,255);
        boardOutside.setFill(Color.GRAY);

        Ellipse boardInside = new Ellipse(850,400,630,230);
        boardInside.setFill(gradient2);

        Text poolText = new Text(850,460,""+pool);
        poolText.setFont(fontOfChips);
        poolText.setFill(Color.YELLOW);


        //Player
            //Cards 1
            Rectangle cardOne = new Rectangle(705,670,100,150);
            cardOne.setFill(Color.WHITE);
            cardOne.setStroke(Color.BLACK);

            Text textOfCardOne = new Text(725,760,deck.deck.get(0).getRanks().getRank()+""+deck.deck.get(0).getColor().getSign());
            textOfCardOne.setFont(fontOfCard);
            textOfCardOne.setFill(deck.deck.get(0).getColor().getColor());

            //Cards 2
            Rectangle cardTwo = new Rectangle(815,670,100,150);
            cardTwo.setFill(Color.WHITE);
            cardTwo.setStroke(Color.BLACK);

            Text textOfCardTwo = new Text(835,760,deck.deck.get(9).getRanks().getRank()+""+deck.deck.get(9).getColor().getSign());
            textOfCardTwo.setFont(fontOfCard);
            textOfCardTwo.setFill(deck.deck.get(9).getColor().getColor());

            //Name
            Ellipse namePlace = new Ellipse(810,860,130,30);
            namePlace.setFill(Color.DARKGREEN);
            namePlace.setStroke(Color.BLACK);
            Text name = new Text(770,865, player1.getLogin());

            //Chips
            numberOfChips = new Text(770,600, ""+player1.getNumberOfChips());
            numberOfChips.setFill(Color.YELLOW);
            numberOfChips.setFont(fontOfChips);

            //Groups
            Group PlayerOne = new Group(cardOne,textOfCardOne,cardTwo,textOfCardTwo);

        //flop

        Rectangle cardOneFlop = new Rectangle(605,270,100,150);
        cardOneFlop.setFill(Color.WHITE);
        cardOneFlop.setStroke(Color.BLACK);

        Text textOfCardOneFlop = new Text(625,360,deck.deck.get(10).getRanks().getRank()+""+deck.deck.get(10).getColor().getSign());
        textOfCardOneFlop.setFont(fontOfCard);
        textOfCardOneFlop.setFill(deck.deck.get(10).getColor().getColor());

        Rectangle cardTwoFlop = new Rectangle(709,270,100,150);
        cardTwoFlop.setFill(Color.WHITE);
        cardTwoFlop.setStroke(Color.BLACK);

        Text textOfCardTwoFlop = new Text(729,360,deck.deck.get(11).getRanks().getRank()+""+deck.deck.get(11).getColor().getSign());
        textOfCardTwoFlop.setFont(fontOfCard);
        textOfCardTwoFlop.setFill(deck.deck.get(11).getColor().getColor());

        Rectangle cardThreeFlop = new Rectangle(813,270,100,150);
        cardThreeFlop.setFill(Color.WHITE);
        cardThreeFlop.setStroke(Color.BLACK);

        Text textOfCardThreeFlop = new Text(833,360,deck.deck.get(12).getRanks().getRank()+""+deck.deck.get(12).getColor().getSign());
        textOfCardThreeFlop.setFont(fontOfCard);
        textOfCardThreeFlop.setFill(deck.deck.get(12).getColor().getColor());

        Group flop = new Group(cardOneFlop,textOfCardOneFlop,cardTwoFlop,textOfCardTwoFlop,cardThreeFlop,textOfCardThreeFlop);

        //turn
        Rectangle cardTurn = new Rectangle(920,270,100,150);
        cardTurn.setFill(Color.WHITE);
        cardTurn.setStroke(Color.BLACK);

        Text textOfCardTurn = new Text(939,360,deck.deck.get(14).getRanks().getRank()+""+deck.deck.get(14).getColor().getSign());
        textOfCardTurn.setFont(fontOfCard);
        textOfCardTurn.setFill(deck.deck.get(14).getColor().getColor());

        Group turn = new Group(cardTurn,textOfCardTurn);

        //river
        Rectangle cardRiver = new Rectangle(1030,270,100,150);
        cardRiver.setFill(Color.WHITE);
        cardRiver.setStroke(Color.BLACK);

        Text textOfCardRiver = new Text(1051,360,deck.deck.get(15).getRanks().getRank()+""+deck.deck.get(15).getColor().getSign());
        textOfCardRiver.setFont(fontOfCard);
        textOfCardRiver.setFill(deck.deck.get(14).getColor().getColor());

        Group river = new Group(cardRiver,textOfCardRiver);

        //call button
        Button callButton = new Button("Call");
        callButton.setLayoutX(1300);
        callButton.setLayoutY(800);
        callButton.setMinSize(100,50);
        callButton.setOnAction(event -> {
            pool = player1.call(numberOfChips,pool,poolText,50);
        });

        // raise button
        Slider raiseChips = new Slider();
        raiseChips.setMin(10);
        raiseChips.setMax(player1.getNumberOfChips());


        raiseChips.setLayoutX(1300);
        raiseChips.setLayoutY(750);
        raiseChips.setShowTickLabels(true);
        raiseChips.setBlockIncrement(1);
        Label text = new Label();
        text.setTextFill(Color.WHITE);
        text.setLayoutX(1500);
        text.setLayoutY(750);
        text.setText(""+raiseChips.getValue());
        raiseChips.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                text.setText(String.format("%.2f", new_val));
            }
        });

        Button raiseButton = new Button("Raise");
        raiseButton.setLayoutX(1510);
        raiseButton.setLayoutY(800);
        raiseButton.setMinSize(100,50);
        raiseButton.setOnAction(event -> {
            double numberOfChipsToRaise = raiseChips.getValue();
            pool = player1.raise(numberOfChips,pool,poolText,numberOfChipsToRaise,callButton);
        });

        //fold button
        Button foldButton = new Button("Fold");
        foldButton.setLayoutX(1405);
        foldButton.setLayoutY(800);
        foldButton.setMinSize(100,50);
        foldButton.setOnAction(event -> {
            player1.fold(PlayerOne, callButton, raiseButton);
        });

        Group nameContent = new Group(namePlace,name);
        Group buttons = new Group(callButton,foldButton,raiseButton);
        Group board = new Group(boardOutside,boardInside);
        Group texts = new Group(numberOfChips,raiseChips,text);
        Group boardCards = new Group(flop,turn,river);
        Group core = new Group(board,PlayerOne,buttons,boardCards, nameContent,poolText,texts);

        //Game
        Scene game = new Scene(core, 1700, 900);
        RadialGradient gradient1 = new RadialGradient(0,.1,850,400,600,false, CycleMethod.NO_CYCLE,new Stop(0, Color.WHITE),new Stop(1, Color.BLACK));
        game.setFill(gradient1);
        primaryStage.setScene(game);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
