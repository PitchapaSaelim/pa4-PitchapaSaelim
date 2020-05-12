package dragontiger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Scanner;

/**
 * A Graphical User Interface (GUI) for Dragon Tiger Game.
 *
 * @author Pitchapa Sae-lim
 */
public class GameUI {
    /**
     * The chips that user use to bet.
     */
    public int userChips = 1000;
    /**
     * Text field that input the amount of chips that user wants to bet.
     */
    public TextField inputBets;
    /**
     * Label that shows the text.
     */
    public Label text;
    /**
     * True when user chooses a side.
     */
    public boolean passChoose = false;
    /**
     * True when user presses confirm button.
     */
    public boolean passConfirm = false;
    /**
     * Value of chooseSides will changed when user chooses a side.
     */
    public int chooseSides = 99;
    /**
     * Get the text from text field.
     */
    public String getTextBets = "";
    /**
     * Label that shows the chips.
     */
    public Label chips;
    /**
     * Get the value of the amount of chips that user bets from text field.
     */
    public int userBets;
    /**
     * Image of back card on left side.
     */
    public ImageView backCardImg1;
    /**
     * Image of back card on right side.
     */
    public ImageView backCardImg2;

    /**
     * Initialize components for the scene graph to display.
     */
    public BorderPane initComponents() {
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10.0));

        // create and add components
        FlowPane flowPaneChips = new FlowPane();
        chips = new Label("YOUR CHIPS : " + userChips);
        chips.setFont(Font.loadFont(getClass().getResourceAsStream("font/CasinoShadow.ttf"), 90));
        chips.setStyle("-fx-text-fill: #ffffff");
        flowPaneChips.getChildren().addAll(chips);
        flowPaneChips.setAlignment(Pos.CENTER);

        Button confirmButton = new Button("CONFIRM");
        confirmButton.setFont(Font.loadFont(getClass().getResourceAsStream("font/BELL.TTF"), 15));
        confirmButton.setMaxSize(100, 200);
        confirmButton.setStyle("-fx-background-color:#1b8c8c");
        confirmButton.setTextFill(Color.web("#ffffff", 0.8));
        confirmButton.setOnAction(new ConfirmHandler());

        Button openCardButton = new Button("OPEN CARD");
        openCardButton.setFont(Font.loadFont(getClass().getResourceAsStream("font/BELL.TTF"), 12));
        openCardButton.setMaxSize(100, 200);
        openCardButton.setStyle("-fx-background-color:#a21a51");
        openCardButton.setTextFill(Color.web("#ffffff", 0.8));
        openCardButton.setOnAction(new OpenCardHandler());

        Button dragonButton = new Button("DRAGON");
        dragonButton.setFont(Font.loadFont(getClass().getResourceAsStream("font/Blackwood Castle.ttf"), 18));
        dragonButton.setMaxSize(100, 200);
        dragonButton.setStyle("-fx-background-color:#db0a0a");
        dragonButton.setTextFill(Color.web("#ffffff", 0.8));
        dragonButton.setOnAction(new ChooseDragonHandler());

        Button tigerButton = new Button("TIGER");
        tigerButton.setFont(Font.loadFont(getClass().getResourceAsStream("font/Blackwood Castle.ttf"), 20));
        tigerButton.setMaxSize(100, 200);
        tigerButton.setStyle("-fx-background-color:#1f1979");
        tigerButton.setTextFill(Color.web("#ffffff", 0.8));
        tigerButton.setOnAction(new ChooseTigerHandler());

        Button drawButton = new Button("DRAW");
        drawButton.setFont(Font.loadFont(getClass().getResourceAsStream("font/Blackwood Castle.ttf"), 20));
        drawButton.setMaxSize(100, 200);
        drawButton.setStyle("-fx-background-color:#000000");
        drawButton.setTextFill(Color.web("#ffffff", 0.8));
        drawButton.setOnAction(new ChooseDrawHandler());

        Button clearButton = new Button("Clear");
        clearButton.setOnAction(new ClearHandler());

        FlowPane flowPaneBets = new FlowPane();
        Label bets = new Label("BET :");
        bets.setStyle("-fx-text-fill: #ffffff");
        bets.setFont(Font.loadFont(getClass().getResourceAsStream("font/CasinoShadow.ttf"), 40));
        inputBets = new TextField();
        inputBets.setOnAction(new ConfirmHandler());
        flowPaneBets.setHgap(20);
        flowPaneBets.getChildren().addAll(clearButton, bets, inputBets, confirmButton, openCardButton);
        flowPaneBets.setAlignment(Pos.CENTER);

        VBox vBoxText = new VBox();
        text = new Label("Which side do you bet on ?");
        text.setFont(Font.loadFont(getClass().getResourceAsStream("font/Blackwood Castle.ttf"), 45));
        text.setStyle("-fx-text-fill: #ffffff");
        vBoxText.setAlignment(Pos.CENTER);
        vBoxText.setSpacing(20);
        vBoxText.getChildren().addAll(text, drawButton);

        VBox vBoxImg1 = new VBox();
        backCardImg1 = new ImageView(getClass().getResource("img/back_card1.png").toExternalForm());
        backCardImg1.setFitHeight(300);
        backCardImg1.setFitWidth(210);
        vBoxImg1.setSpacing(20);
        vBoxImg1.setAlignment(Pos.CENTER);
        vBoxImg1.getChildren().addAll(backCardImg1, dragonButton);

        VBox vBoxImg2 = new VBox();
        backCardImg2 = new ImageView(getClass().getResource("img/back_card2.png").toExternalForm());
        backCardImg2.setFitHeight(300);
        backCardImg2.setFitWidth(210);
        vBoxImg2.setSpacing(20);
        vBoxImg2.setAlignment(Pos.CENTER);
        vBoxImg2.getChildren().addAll(backCardImg2, tigerButton);

        borderPane.setTop(flowPaneChips);
        borderPane.setLeft(vBoxImg1);
        borderPane.setCenter(vBoxText);
        borderPane.setRight(vBoxImg2);
        borderPane.setBottom(flowPaneBets);

        return borderPane;
    }

    /**
     * Method that change passChoose when user chooses a side.
     */
    void display() {
        if (chooseSides == 0) {
            passChoose = true;
        } else if (chooseSides == 1) {
            passChoose = true;
        } else if (chooseSides == 2) {
            passChoose = true;
        } else {
            passChoose = false;
            passConfirm = false;
        }
    }

    /**
     * Method that change chooseSides when user chooses dragon side.
     */
    void chooseDragon() {
        chooseSides = 0;
    }

    /**
     * Method that change chooseSides when user chooses tiger side.
     */
    void chooseTiger() {
        chooseSides = 1;
    }

    /**
     * Method that change chooseSides when user chooses draw side.
     */
    void chooseDraw() {
        chooseSides = 2;
    }

    /**
     * Class that change UI and run method display() when user presses dragon button.
     */
    class ChooseDragonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            chooseDragon();
            text.setText("DRAGON");
            text.setStyle("-fx-text-fill: #ff0000");
            display();
        }
    }

    /**
     * Class that change UI and run method display() when user presses tiger button.
     */
    class ChooseTigerHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            chooseTiger();
            text.setStyle("-fx-text-fill: #5745e5");
            text.setText("TIGER");
            display();
        }
    }

    /**
     * Class that change UI and run method display() when user presses draw button.
     */
    class ChooseDrawHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            chooseDraw();
            text.setStyle("-fx-text-fill: #92e75c");
            text.setText("DRAW");
            display();
        }
    }

    /**
     * Class that read the values from the inputBets, check for error,
     * change UI and run method display() when user presses dragon button.
     */
    class ConfirmHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            inputBets.setStyle(null);
            getTextBets = inputBets.getText();
            Scanner scanText = new Scanner(getTextBets);
            Alert alert = new Alert(Alert.AlertType.NONE);

            if (getTextBets.isEmpty()) {
                inputBets.setStyle("-fx-text-box-border: red");
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill in information.");
                alert.showAndWait();
            }
            if (!getTextBets.isEmpty()) {
                if (!scanText.hasNextInt()) {
                    try {
                        userBets = Integer.parseInt(getTextBets);
                    } catch (NumberFormatException nfe) {
                        inputBets.setStyle("-fx-text-box-border: red");
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Not an Integer Number!");
                        alert.showAndWait();
                    }
                } else if (!(chooseSides == 0 || chooseSides == 1 || chooseSides == 2)) {
                    inputBets.setStyle("-fx-text-box-border: red");
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please Choose dragon OR tiger OR draw.");
                    alert.showAndWait();
                } else {
                    try {
                        userBets = Integer.parseInt(getTextBets);
                        if ((userBets > userChips) || (userBets <= 0)) {
                            inputBets.setStyle("-fx-text-box-border: #ffd811");
                            alert.setAlertType(Alert.AlertType.WARNING);
                            alert.setTitle("Sorry");
                            alert.setHeaderText(null);
                            alert.setContentText("You have lost all your chips.");
                            alert.showAndWait();
                            passConfirm = false;
                        } else {
                            inputBets.setStyle(null);
                            inputBets.setStyle("-fx-text-box-border: #2c5df1");
                            alert.setAlertType(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setHeaderText(null);
                            alert.setContentText("Bet Successful!");
                            alert.showAndWait();
                            passConfirm = true;
                        }
                    } catch (Exception e) {
                        inputBets.setStyle("-fx-text-box-border: red");
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Error message!");
                        alert.showAndWait();
                    }
                }
            }
        }
    }

    /**
     * Class that change UI when user presses open card button then calculate
     * value of the card that which one highest and check for error.
     */
    class OpenCardHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            getTextBets = inputBets.getText();
            Alert alert = new Alert(Alert.AlertType.NONE);

            if (passChoose && passConfirm) {
                userBets = Integer.parseInt(getTextBets);

                int DRAGON = (int) (Math.random() * 13) + 1;
                int TIGER = (int) (Math.random() * 13) + 1;
                int opDragon = (int) (Math.random() * 4) + 1;
                int opTiger = (int) (Math.random() * 4) + 1;

                Image dragonImg = new Image(getClass().getResource("img/cards/" + (DRAGON) + "_" + (opDragon) + ".PNG").toExternalForm());
                Image tigerImg = new Image(getClass().getResource("img/cards/" + (TIGER) + "_" + (opTiger) + ".PNG").toExternalForm());
                backCardImg1.setImage(dragonImg);
                backCardImg2.setImage(tigerImg);

                int win = 99;
                if (DRAGON < TIGER) {
                    win = 1;
                }
                if (DRAGON > TIGER) {
                    win = 0;
                }
                if (DRAGON == TIGER) {
                    win = 2;
                }

                if (chooseSides == win) {
                    if (win != 2) {
                        userBets = userBets * 1;
                    } else {
                        userBets = userBets * 7;
                    }
                    userChips = userChips + userBets;
                    inputBets.setStyle("-fx-text-box-border: #3bac22");
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("You Win");
                    alert.setHeaderText(null);
                    alert.setContentText("+" + userBets + " Chips");
                    alert.showAndWait();
                } else {
                    if (win != 2) {
                        inputBets.setStyle("-fx-text-box-border: #f55656");
                        userChips = userChips - userBets;
                        alert.setAlertType(Alert.AlertType.INFORMATION);
                        alert.setTitle("You Lose");
                        alert.setHeaderText(null);
                        alert.setContentText("- " + userBets + " Chips");
                        alert.showAndWait();
                    } else {
                        userChips = userChips - (userBets / 2);
                        inputBets.setStyle("-fx-text-box-border: #f55656");
                        alert.setAlertType(Alert.AlertType.INFORMATION);
                        alert.setTitle("You Lose");
                        alert.setHeaderText(null);
                        alert.setContentText("- " + (userBets / 2) + " Chips");
                        alert.showAndWait();
                    }
                }
                chips.setText("YOUR CHIPS : " + userChips);
                passConfirm = false;
                passChoose = false;
                chooseSides = 99;
                display();
            } else if (!passChoose || !passConfirm) {
                inputBets.setStyle("-fx-text-box-border: red");
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Betting Unsuccessful.");
                alert.showAndWait();
            }
        }
    }

    /**
     * Class that clear the text fields.
     */
    class ClearHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            inputBets.setText("");
            inputBets.setStyle(null);
        }
    }

    /**
     * Class that provide options for the user.
     *
     * @return menu bar of options in Dragon Tiger Game.
     */
    public MenuBar makeMenuBar() {
        Menu menu = new Menu("Options");

        MenuItem changeChipsItem = new MenuItem("✎ Change user's chips");
        MenuItem newGameItem = new MenuItem("New Game");
        MenuItem howToPlayItem = new MenuItem("How to play");
        MenuItem exitItem = new MenuItem("Exit");
        SeparatorMenuItem separatorItem = new SeparatorMenuItem();

        changeChipsItem.setOnAction(new ChangeChipsHandler());
        newGameItem.setOnAction(new NewGameHandler());
        howToPlayItem.setOnAction(new HowToPlayHandler());
        exitItem.setOnAction(new ExitHandler());

        menu.getItems().add(changeChipsItem);
        menu.getItems().add(newGameItem);
        menu.getItems().add(howToPlayItem);
        menu.getItems().add(separatorItem);
        menu.getItems().add(exitItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);

        return menuBar;
    }

    /**
     * Class that change the user's chips when user want to change and check for error.
     */
    class ChangeChipsHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("Change user's chips");
            alert.setContentText("Do you want to change your chips?");
            ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(yesButton, cancelButton);
            alert.showAndWait().ifPresent(type -> {
                if (type == yesButton) {
                    chooseSides = 99;
                    TextInputDialog inputUserChips = new TextInputDialog(null);
                    inputUserChips.setTitle("✎ Change user's chips");
                    inputUserChips.setHeaderText("Please enter an Integer Number");
                    inputUserChips.setContentText("Enter your chips:");
                    inputUserChips.showAndWait();
                    String getUserChips = inputUserChips.getResult();
                    if (getUserChips != null) {
                        try {
                            userChips = Integer.parseInt(getUserChips);
                        } catch (NumberFormatException nfe) {
                            Alert alert2 = new Alert(Alert.AlertType.NONE);
                            alert2.setAlertType(Alert.AlertType.ERROR);
                            alert2.setTitle("Error");
                            alert2.setHeaderText("Not an Integer Number!");
                            alert2.setContentText("Please try again.");
                            alert2.showAndWait();
                        }
                    }
                    text.setStyle("-fx-text-fill: #ffffff");
                    text.setText("Which side do you bet on ?");
                    chips.setText("YOUR CHIPS : " + userChips);
                }
            });
        }
    }

    /**
     * Class that restart game and set new user's chips.
     */
    class NewGameHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setTitle("New Game");
            alert.setContentText("Do you want to start a new game?");
            ButtonType yesButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(yesButton, cancelButton);
            alert.showAndWait().ifPresent(type -> {
                if (type == yesButton) {
                    Image newBackCard1 = new Image(getClass().getResource("img/back_card1.png").toExternalForm());
                    Image newBackCard2 = new Image(getClass().getResource("img/back_card2.png").toExternalForm());
                    backCardImg1.setImage(newBackCard1);
                    backCardImg2.setImage(newBackCard2);
                    inputBets.setStyle(null);
                    inputBets.setText("");
                    chooseSides = 99;
                    userChips = 1000;
                    text.setStyle("-fx-text-fill: #ffffff");
                    text.setText("Which side do you bet on ?");
                    chips.setText("YOUR CHIPS : " + userChips);
                }
            });
        }
    }

    /**
     * Class that shows how to play Dragon Tiger Game.
     */
    class HowToPlayHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            GameText gameText = new GameText();
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setHeaderText("           Welcome to Dragon-Tiger!");
            alert.setTitle("How to play");
            alert.getDialogPane().setPrefSize(630, 700);
            ImageView howToPlayImg = new ImageView(getClass().getResource("img/cards_icon.png").toExternalForm());
            alert.setGraphic(howToPlayImg);
            alert.setContentText(gameText.msgHowToPlay);
            alert.showAndWait();
        }
    }

    /**
     * Class that exits the game.
     */
    class ExitHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            System.exit(0);
        }
    }
}
