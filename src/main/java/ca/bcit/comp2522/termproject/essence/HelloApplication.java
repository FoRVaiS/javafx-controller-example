package ca.bcit.comp2522.termproject.essence;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import ca.bcit.comp2522.termproject.essence.controllers.Controller;
import ca.bcit.comp2522.termproject.essence.controllers.PlayerController;

public class HelloApplication extends Application {
    @Override
    public void start(final Stage primaryStage) {
        Image alienImg = new Image("alien.png", true);
        final ImageView sprite = new ImageView(alienImg);
        final int alienStartCoordinate = 20;

        final Actor alien = new Actor(sprite, alienStartCoordinate, alienStartCoordinate, 10);

        final Group root = new Group(sprite);

        final int appWidth = 600;
        final int appHeight = 600;
        final Scene scene = new Scene(root, appWidth, appHeight, Color.BLACK);

        // Register the key listener here
        final Controller playerController = new PlayerController(scene);
        alien.possess(playerController);

        primaryStage.setTitle("AlienDirection");
        primaryStage.setScene(scene);
        primaryStage.show();

        Engine.run();
    }

    public static void main(String[] args) {
        HelloApplication.launch(args);
    }
}