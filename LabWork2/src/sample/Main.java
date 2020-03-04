package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;


public class Main extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // создаем список объектов
        ObservableList<Furniture> furniture = FXCollections.observableArrayList(
                new Furniture("table","Maxsi", 70,45,66, "black"),
                new Furniture("chair","Kristofer", 90,90,90, "red"),
                new Furniture("table","MacBook", 67,48,77, "green"),
                new Furniture("chair","Kybay", 99,33,66, "yellow")
        );

        // определяем таблицу и устанавливаем данные
        TableView<Furniture> table = new TableView<Furniture>(furniture);
        table.setPrefWidth(367);
        table.setPrefHeight(150);


        // столбец для вывода имени
        TableColumn<Furniture, String> typeColumn = new TableColumn<Furniture, String>("Type");
        // определяем фабрику для столбца с привязкой к свойству name
        typeColumn.setCellValueFactory(new PropertyValueFactory<Furniture, String>("type"));
        // добавляем столбец
        table.getColumns().add(typeColumn);

        TableColumn<Furniture, String> nameColumn = new TableColumn<Furniture, String>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<Furniture, String>("name"));
        table.getColumns().add(nameColumn);

        // столбец для вывода возраста
        TableColumn<Furniture, Integer> widthColumn = new TableColumn<Furniture, Integer>("Width");
        widthColumn.setCellValueFactory(new PropertyValueFactory<Furniture, Integer>("width"));
        table.getColumns().add(widthColumn);

        TableColumn<Furniture, Integer> heightColumn = new TableColumn<Furniture, Integer>("Height");
        heightColumn.setCellValueFactory(new PropertyValueFactory<Furniture, Integer>("height"));
        table.getColumns().add(heightColumn);

        TableColumn<Furniture, Integer> lengthColumn = new TableColumn<Furniture, Integer>("Length");
        lengthColumn.setCellValueFactory(new PropertyValueFactory<Furniture, Integer>("length"));
        table.getColumns().add(lengthColumn);

        TableColumn<Furniture, String> colorColumn = new TableColumn<Furniture, String>("Color");
        colorColumn.setCellValueFactory(new PropertyValueFactory<Furniture, String>("color"));
        table.getColumns().add(colorColumn);


        Label labelField = new Label("Field:");
        TextField fieldInput = new TextField();

        Label labelValue = new Label("Value:");
        TextField valueInput = new TextField();


        Button btn = new Button("Find");
        btn.setPrefWidth(80);
        String field = "name";
        String value = "MacBook";

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               //field = fieldInput.getText();
               //value = valueInput.getText();
            }
        });

        for (Furniture objects: table.getItems()) {
            String [] arrayTable = objects.returnArray();
        }



        FlowPane root = new FlowPane(Orientation.HORIZONTAL, 10, 15, labelField, fieldInput, labelValue, valueInput, btn, table);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 600, 300);

        stage.setScene(scene);

        stage.setTitle("TableView in JavaFX");
        stage.show();
    }
}