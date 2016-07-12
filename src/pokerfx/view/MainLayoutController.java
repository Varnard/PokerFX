package pokerfx.view;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import pokerfx.Main;
import pokerfx.model.Deck;
import pokerfx.verdict.Poker;

import java.util.*;

public class MainLayoutController {

    private Map<String,Image> imageMap;

    private ArrayList<String> whiteHand;
    private ArrayList<String> blackHand;

    private int whiteChanges;
    private int blackChanges;

    private int whiteScore;
    private int blackScore;

    private ImageView selected;

    @FXML
    AnchorPane table;

    @FXML
    ImageView white1;

    @FXML
    ImageView white2;

    @FXML
    ImageView white3;

    @FXML
    ImageView white4;

    @FXML
    ImageView white5;

    @FXML
    ImageView black1;

    @FXML
    ImageView black2;

    @FXML
    ImageView black3;

    @FXML
    ImageView black4;

    @FXML
    ImageView black5;

    @FXML
    Label whiteChangesLabel;

    @FXML
    Label blackChangesLabel;

    @FXML
    Label whiteScoreLabel;

    @FXML
    Label blackScoreLabel;

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

        loadImages();

        giveCards();

        white1.setId("white1");
        white1.setId("white2");
        white1.setId("white3");
        white1.setId("white4");
        white1.setId("white5");

        black1.setId("black1");
        black1.setId("black2");
        black1.setId("black3");
        black1.setId("black4");
        black1.setId("black5");

        whiteChangesLabel.setText("Changes: 2");
        blackChangesLabel.setText("Changes: 2");

        whiteScore=0;
        blackScore=0;

        whiteScoreLabel.setText("Score: 0");
        blackScoreLabel.setText("Score: 0");
    }

    private void loadImages()
    {
        imageMap = new HashMap<>();

        imageMap.put("2D",new Image("file:src/images/cards/d02.bmp"));
        imageMap.put("3D",new Image("file:src/images/cards/d03.bmp"));
        imageMap.put("4D",new Image("file:src/images/cards/d04.bmp"));
        imageMap.put("5D",new Image("file:src/images/cards/d05.bmp"));
        imageMap.put("6D",new Image("file:src/images/cards/d06.bmp"));
        imageMap.put("7D",new Image("file:src/images/cards/d07.bmp"));
        imageMap.put("8D",new Image("file:src/images/cards/d08.bmp"));
        imageMap.put("9D",new Image("file:src/images/cards/d09.bmp"));
        imageMap.put("TD",new Image("file:src/images/cards/d10.bmp"));
        imageMap.put("JD",new Image("file:src/images/cards/d11.bmp"));
        imageMap.put("QD",new Image("file:src/images/cards/d12.bmp"));
        imageMap.put("KD",new Image("file:src/images/cards/d13.bmp"));
        imageMap.put("AD",new Image("file:src/images/cards/d01.bmp"));

        imageMap.put("2C",new Image("file:src/images/cards/c02.bmp"));
        imageMap.put("3C",new Image("file:src/images/cards/c03.bmp"));
        imageMap.put("4C",new Image("file:src/images/cards/c04.bmp"));
        imageMap.put("5C",new Image("file:src/images/cards/c05.bmp"));
        imageMap.put("6C",new Image("file:src/images/cards/c06.bmp"));
        imageMap.put("7C",new Image("file:src/images/cards/c07.bmp"));
        imageMap.put("8C",new Image("file:src/images/cards/c08.bmp"));
        imageMap.put("9C",new Image("file:src/images/cards/c09.bmp"));
        imageMap.put("TC",new Image("file:src/images/cards/c10.bmp"));
        imageMap.put("JC",new Image("file:src/images/cards/c11.bmp"));
        imageMap.put("QC",new Image("file:src/images/cards/c12.bmp"));
        imageMap.put("KC",new Image("file:src/images/cards/c13.bmp"));
        imageMap.put("AC",new Image("file:src/images/cards/c01.bmp"));

        imageMap.put("2S",new Image("file:src/images/cards/s02.bmp"));
        imageMap.put("3S",new Image("file:src/images/cards/s03.bmp"));
        imageMap.put("4S",new Image("file:src/images/cards/s04.bmp"));
        imageMap.put("5S",new Image("file:src/images/cards/s05.bmp"));
        imageMap.put("6S",new Image("file:src/images/cards/s06.bmp"));
        imageMap.put("7S",new Image("file:src/images/cards/s07.bmp"));
        imageMap.put("8S",new Image("file:src/images/cards/s08.bmp"));
        imageMap.put("9S",new Image("file:src/images/cards/s09.bmp"));
        imageMap.put("TS",new Image("file:src/images/cards/s10.bmp"));
        imageMap.put("JS",new Image("file:src/images/cards/s11.bmp"));
        imageMap.put("QS",new Image("file:src/images/cards/s12.bmp"));
        imageMap.put("KS",new Image("file:src/images/cards/s13.bmp"));
        imageMap.put("AS",new Image("file:src/images/cards/s01.bmp"));

        imageMap.put("2H",new Image("file:src/images/cards/h02.bmp"));
        imageMap.put("3H",new Image("file:src/images/cards/h03.bmp"));
        imageMap.put("4H",new Image("file:src/images/cards/h04.bmp"));
        imageMap.put("5H",new Image("file:src/images/cards/h05.bmp"));
        imageMap.put("6H",new Image("file:src/images/cards/h06.bmp"));
        imageMap.put("7H",new Image("file:src/images/cards/h07.bmp"));
        imageMap.put("8H",new Image("file:src/images/cards/h08.bmp"));
        imageMap.put("9H",new Image("file:src/images/cards/h09.bmp"));
        imageMap.put("TH",new Image("file:src/images/cards/h10.bmp"));
        imageMap.put("JH",new Image("file:src/images/cards/h11.bmp"));
        imageMap.put("QH",new Image("file:src/images/cards/h12.bmp"));
        imageMap.put("KH",new Image("file:src/images/cards/h13.bmp"));
        imageMap.put("AH",new Image("file:src/images/cards/h01.bmp"));
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

        white1.setImage(imageMap.get(whiteHand.get(0)));
        white2.setImage(imageMap.get(whiteHand.get(1)));
        white3.setImage(imageMap.get(whiteHand.get(2)));
        white4.setImage(imageMap.get(whiteHand.get(3)));
        white5.setImage(imageMap.get(whiteHand.get(4)));

        black1.setImage(imageMap.get(blackHand.get(0)));
        black2.setImage(imageMap.get(blackHand.get(1)));
        black3.setImage(imageMap.get(blackHand.get(2)));
        black4.setImage(imageMap.get(blackHand.get(3)));
        black5.setImage(imageMap.get(blackHand.get(4)));
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
        if (selected!=null) {
            selected.getStyleClass().remove("active");

            if (selected.getId().contains("white")) {
                if (whiteChanges > 0) {
                    animateCardChange(selected);
                    String newCard = Deck.giveOne();
                    selected.setImage(imageMap.get(newCard));
                    int i = Integer.parseInt(String.valueOf(selected.getId().charAt(5))) - 1;
                    whiteHand.remove(i);
                    whiteHand.add(i, newCard);
                    whiteChanges--;
                    whiteChangesLabel.setText("Changes: "+whiteChanges);

                } else {
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
            } else if (selected.getId().contains("black")) {
                if (blackChanges > 0) {
                    animateCardChange(selected);
                    String newCard = Deck.giveOne();
                    selected.setImage(imageMap.get(newCard));
                    int i = Integer.parseInt(String.valueOf(selected.getId().charAt(5))) - 1;
                    blackHand.remove(i);
                    blackHand.add(i, newCard);
                    blackChanges--;
                    blackChangesLabel.setText("Changes: "+blackChanges);

                } else {
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
            selected=null;
        }
    }

    @FXML
    public void handleCheckCards()
    {
   String result = Poker.compareHands(whiteHand,blackHand);

        if (result.contains("White")){
            whiteScore++;
            whiteScoreLabel.setText("Score: "+whiteScore);
        }
        else if (result.contains("Black")){
            blackScore++;
            blackScoreLabel.setText("Score: "+blackScore);
        }
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

    @FXML
    private void select(MouseEvent e) {
        if (selected!=null)
        {
            selected.getStyleClass().remove("active");
        }
        selected = (ImageView) e.getSource();
        selected.getStyleClass().add("active");
    }

    public void animateCardChange(ImageView selected)
    {
        final Image oldImage=selected.getImage();
        ImageView old = new ImageView(oldImage);
        table.getChildren().add(old);
        selected.toFront();
        int i=1;
        int j=0;
        if (selected.getId().contains("black"))
        {
            i=-1;
            j=50;
        }

        old.setLayoutX(selected.getLayoutX());
        old.setLayoutY(selected.getLayoutY()+selected.getParent().getParent().getParent().getLayoutY());

        TranslateTransition translateTransition =
                new TranslateTransition(Duration.millis(1500), selected);
        translateTransition.setFromX(-500);
        translateTransition.setToX(0);
        translateTransition.setFromY(300*i);
        translateTransition.setToY(-0);
        translateTransition.setCycleCount(1);
        RotateTransition rotateTransition =
                new RotateTransition(Duration.millis(1500), selected);
        rotateTransition.setByAngle(360f);
        rotateTransition.setCycleCount(1);
        ScaleTransition scaleTransition =
                new ScaleTransition(Duration.millis(1500), selected);
        scaleTransition.setFromX(1.5f);
        scaleTransition.setFromY(1.5f);
        scaleTransition.setToX(1.3f);
        scaleTransition.setToY(1.3f);
        scaleTransition.setCycleCount(1);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                translateTransition,
                rotateTransition,
                scaleTransition
        );
        parallelTransition.setCycleCount(1);
        parallelTransition.play();

        TranslateTransition translateTransition2 =
                new TranslateTransition(Duration.millis(1500), old);
        translateTransition2.setFromX(0);
        translateTransition2.setToX(700);
        translateTransition2.setFromY(j);
        translateTransition2.setToY(-400*i);
        translateTransition2.setCycleCount(1);
        RotateTransition rotateTransition2 =
                new RotateTransition(Duration.millis(1500), old);
        rotateTransition2.setByAngle(360f);
        rotateTransition2.setCycleCount(1);
        ScaleTransition scaleTransition2 =
                new ScaleTransition(Duration.millis(1500), old);
        scaleTransition2.setFromX(1.3f);
        scaleTransition2.setFromY(1.3f);
        scaleTransition2.setToX(1.5f);
        scaleTransition2.setToY(1.5f);
        scaleTransition2.setCycleCount(1);

        ParallelTransition parallelTransition2 = new ParallelTransition();
        parallelTransition2.getChildren().addAll(
                translateTransition2,
                rotateTransition2,
                scaleTransition2
        );
        parallelTransition2.setCycleCount(1);
        parallelTransition2.play();


    }
}
