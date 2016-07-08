package pokerfx.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;
import pokerfx.Main;
import pokerfx.model.Deck;
import pokerfx.verdict.Poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainLayoutController {

    private ArrayList<String> whiteHand;
    private ArrayList<String> blackHand;

    private int whiteChanges;
    private int blackChanges;

    private Label selected;

    @FXML
    Label white1;

    @FXML
    Label white2;

    @FXML
    Label white3;

    @FXML
    Label white4;

    @FXML
    Label white5;

    @FXML
    Label black1;

    @FXML
    Label black2;

    @FXML
    Label black3;

    @FXML
    Label black4;

    @FXML
    Label black5;

    // Reference to the main application
    private Main main;

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param main
     */
    public void setMain(Main main) {
        this.main = main;
    }


    @FXML
    public void initialize() {

        giveCards();

        white1.setId("white1");
        white1.setOnMouseClicked(e->select(white1));
        white1.setId("white2");
        white1.setOnMouseClicked(e->select(white2));
        white1.setId("white3");
        white1.setOnMouseClicked(e->select(white3));
        white1.setId("white4");
        white1.setOnMouseClicked(e->select(white4));
        white1.setId("white5");
        white1.setOnMouseClicked(e->select(white5));

        black1.setId("black1");
        black1.setOnMouseClicked(e->select(black1));
        black1.setId("black2");
        black1.setOnMouseClicked(e->select(black2));
        black1.setId("black3");
        black1.setOnMouseClicked(e->select(black3));
        black1.setId("black4");
        black1.setOnMouseClicked(e->select(black4));
        black1.setId("black5");
        black1.setOnMouseClicked(e->select(black5));

    }

    /**
     * Starts a new round, resetting the deck and generating new hands
     */
    private void giveCards()
    {
        Deck.shuffleDeck();

        whiteChanges=2;
        blackChanges=2;

        whiteHand = new ArrayList<String>(Arrays.asList(Deck.giveFive().split(" ")));
        blackHand =new ArrayList<String>(Arrays.asList(Deck.giveFive().split(" ")));

        white1.setText(whiteHand.get(0));
        white2.setText(whiteHand.get(1));
        white3.setText(whiteHand.get(2));
        white4.setText(whiteHand.get(3));
        white5.setText(whiteHand.get(4));

        black1.setText(blackHand.get(0));
        black2.setText(blackHand.get(1));
        black3.setText(blackHand.get(2));
        black4.setText(blackHand.get(3));
        black5.setText(blackHand.get(4));
    }

    public List<String> getWhiteHand() {
        return whiteHand;
    }


    @FXML
    public void handleNewCards()
    {
        giveCards();
    }

    @FXML
    public void handleChangeCard()
    {
        if (selected.getId().contains("white"))
        {
            if (whiteChanges>0)
            {
                String newCard = Deck.giveOne();
                selected.setText(newCard);
                int i =Integer.parseInt(String.valueOf(selected.getId().charAt(5)))-1;
                whiteHand.remove(i);
                whiteHand.add(i,newCard);
                whiteChanges--;
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setGraphic(null);
                alert.setTitle("Result");
                alert.setHeaderText(null);
                alert.setContentText("Sorry, only two changes allowed. Cannot make more.");

                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("Style.css").toExternalForm());
                dialogPane.getStyleClass().add("dialog");

                alert.showAndWait();
            }
        }
        else if (selected.getId().contains("black"))
        {
            if (blackChanges>0)
            {
                String newCard = Deck.giveOne();
                selected.setText(newCard);
                int i =Integer.parseInt(String.valueOf(selected.getId().charAt(5)))-1;
                blackHand.remove(i);
                blackHand.add(i,newCard);
                blackChanges--;
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setGraphic(null);
                alert.setTitle("Result");
                alert.setHeaderText(null);
                alert.setContentText("Sorry, only two changes allowed. Cannot make more.");

                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                        getClass().getResource("Style.css").toExternalForm());
                dialogPane.getStyleClass().add("dialog");

                alert.showAndWait();
            }
        }
    }

    @FXML
    public void handleCheckCards()
    {
        String result = Poker.compareHands(whiteHand,blackHand);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setGraphic(null);
        alert.setTitle("Result");
        alert.setHeaderText(null);
        alert.setContentText(result);

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
                getClass().getResource("Style.css").toExternalForm());
        dialogPane.getStyleClass().add("dialog");

        alert.initStyle(StageStyle.UTILITY);


        alert.showAndWait();
    }

    @FXML
    public void handleShowRules()
    {
        main.showRules();
    }

    public Label getSelected() {
        return selected;
    }

    private void select(Label selected) {
        this.selected = selected;
    }
}
