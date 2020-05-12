package dragontiger;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Dragon Tiger Game is about as simple as gambling gets. It is basically a two-card version of baccarat.
 * To be more specific, two cards are drawn, one to the Dragon and one to the Tiger. The player bets on which one will be higher.
 * There are also some proposition bets on the individual cards. The game is rumored to be found in Cambodia.
 *
 * @author Pitchapa Sae-lim
 */
public class DragonTigerGame extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        GameUI gameUI = new GameUI();
        BorderPane ui = gameUI.initComponents();
        root.setCenter(ui);

        MenuBar menubar = gameUI.makeMenuBar();
        root.setTop(menubar);

        Scene scene = new Scene(root);
        stage.setScene(scene);

        Image icon = new Image(getClass().getResourceAsStream("img/cards_icon.png"));
        stage.getIcons().add(icon);

        Image backgroundImg = new Image(getClass().getResourceAsStream("img/background.png"));
        BackgroundSize backgroundSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
        root.setBackground(new Background(new BackgroundImage(backgroundImg,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize)));

        stage.setHeight(600);
        stage.setWidth(1000);
        stage.setTitle("Dragon Tiger");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Run the class named DragonTigerGame.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
