package CWK02;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class gui extends Application {

    TableView<defaultMember> table;
    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Gym Manager");

        AnchorPane AP = new AnchorPane();
        AP.setPrefSize(1440, 900);
        AP.setStyle("-fx-background-image: url('BGimg.jpg')");

        //-----------------------Table columns-------------------------

        TableColumn<defaultMember, String> ID = new TableColumn<>("Member No");
        ID.setCellValueFactory(new PropertyValueFactory<>("membershipNo"));
        ID.setMinWidth(100);

        TableColumn<defaultMember, String> Name = new TableColumn<>("Member Name");
        Name.setCellValueFactory(new PropertyValueFactory<>("memberName"));
        Name.setMinWidth(120);

        TableColumn<defaultMember, String> Date = new TableColumn<>("Membership start date");
        Date.setCellValueFactory(new PropertyValueFactory<>("membershipStartDate"));
        Date.setMinWidth(200);

        TableColumn<defaultMember, String> Gender = new TableColumn<>("Gender");
        Gender.setCellValueFactory(new PropertyValueFactory<>("memberGender"));
        Gender.setMinWidth(80);

        TableColumn<defaultMember, String> ContactNo = new TableColumn<>("Contact No");
        ContactNo.setCellValueFactory(new PropertyValueFactory<>("memberContactNumber"));
        ContactNo.setMinWidth(120);

        TableColumn<defaultMember, Integer> Age = new TableColumn<>("Age");
        Age.setCellValueFactory(new PropertyValueFactory<>("memberAge"));
        Age.setMinWidth(60);

        TableColumn<defaultMember, String> School = new TableColumn<>("School name");
        School.setCellValueFactory(new PropertyValueFactory<>("studentSchool"));
        School.setMinWidth(200);

        //table
        table = new TableView<>();
        table.setItems(get());
        table.setStyle("-fx-text-fill: black");
        table.getColumns().addAll(ID,Name,Date,Gender,ContactNo,Age,School);

        //Vbox for table
        VBox vBox = new VBox();
        vBox.setLayoutX(40);
        vBox.setLayoutY(200);
        vBox.setPrefSize(900,600);
        vBox.getChildren().addAll(table);

        //Application name
        Label topic = new Label("Gym Manager Application");
        topic.setLayoutX(450);
        topic.setLayoutY(20);
        topic.setStyle("-fx-font-size: 50; -fx-text-fill: snow");

        AP.getChildren().addAll(vBox,topic);
        Scene mainScene = new Scene(AP);
        primaryStage.setScene(mainScene);
        primaryStage.show();

    }

    //observable list
    public ObservableList<defaultMember> get() {
        ObservableList<defaultMember> mem = FXCollections.observableArrayList();
        for (defaultMember member:MyGymManager.memberList){
            mem.add(member);
        }
        return mem;
    }
}







