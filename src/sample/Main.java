package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    Text numberOfChips;
    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
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
                new Stop(1.0f, Color.BLACK));
        primaryStage.setTitle("PKoker");
        //Settings of Font
        Font fontOfCard = new Font(45);
        Font fontOfChips = new Font(35);
        //Board
            Ellipse boardOutside = new Ellipse(850,400,655,255);
            boardOutside.setFill(Color.GRAY);

            Ellipse boardInside = new Ellipse(850,400,630,230);
            boardInside.setFill(gradient2);

            Button callButton = new Button("Call");
            callButton.setLayoutX(1300);
            callButton.setLayoutY(800);
            callButton.setMinSize(100,50);
            callButton.setOnAction(event -> {
                player1.call(numberOfChips,50);
            });


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
            Group nameContent = new Group(namePlace,name);
            Group board = new Group(boardOutside,boardInside,numberOfChips,callButton);


        Group core = new Group(board,PlayerOne,nameContent);

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
