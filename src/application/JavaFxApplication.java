package application;

import java.util.Arrays;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxApplication extends Application {

    // @Override
    // public void start(Stage window) {
    // TextField text = new TextField();

    // Button button = new Button("Update");
    // Label label = new Label();
    // button.setOnAction((event) -> {
    // label.setText(text.getText());
    // });

    // VBox componentGroup = new VBox();
    // componentGroup.setSpacing(20);
    // componentGroup.getChildren().addAll(text, button, label);

    // Scene scene = new Scene(componentGroup);

    // window.setScene(scene);
    // window.show();
    // }

    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        HBox texts = new HBox();
        Label lettersCount = new Label("Letters: ");
        Label wordCount = new Label("Words: ");
        Label longestWord = new Label("The longest word: ");
        texts.setSpacing(10);
        texts.getChildren().add(lettersCount);
        texts.getChildren().add(wordCount);
        texts.getChildren().add(longestWord);

        TextArea textArea = new TextArea("");
        textArea.textProperty()
                .addListener((ObservableValue<? extends String> change, String oldValue, String newValue) -> {
                    int characters = newValue.length();
                    String[] parts = newValue.split(" ");
                    int words = parts.length;
                    String longest = Arrays.stream(parts).sorted((s1, s2) -> s2.length() - s1.length()).findFirst()
                            .get();

                    lettersCount.setText("Letters: " + characters);
                    wordCount.setText("Words: " + words);
                    longestWord.setText("The longest word: " + longest);

                });

        layout.setBottom(texts);
        layout.setCenter(textArea);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(JavaFxApplication.class);
    }
}