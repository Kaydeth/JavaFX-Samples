package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = null;

        if(true){
            root = createManually();
        }
        else {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));

            Scene scene = new Scene(root, 300, 275);
        }

        Scene main_scene = new Scene(root, 300, 275);
        primaryStage.setTitle("JavaFx Form");
        primaryStage.setScene(main_scene);
        main_scene.getStylesheets().add(Main.class.getResource("Main.css").toExternalForm());

        primaryStage.show();
    }

    public Parent createManually()
    {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Howdy");
        scenetitle.setId("welcome-text");
        root.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        root.add(userName, 0, 1);

        TextField userTextField = new TextField();
        root.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        root.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        root.add(pwBox, 1, 2);

        final Text actiontarget = new Text();
        root.add(actiontarget, 1, 6);
        actiontarget.setId("action-target");

        Button btn = new Button();
        btn.setText("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                actiontarget.setText("Sign in button pressed");
            }
        });
        root.add(hbBtn, 1, 4);


        root.setGridLinesVisible(false);

        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
