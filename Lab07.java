package Labs.Lab07;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
import java.io.*;

public class Lab07 extends Application{
    public static int count1 = 0;
    public static int count2 = 0;
    public static int count3 = 0;
    public static int count4 = 0;
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\jaden\\IdeaProjects\\CSCI2020U\\src\\main\\java\\Labs\\Lab07\\weatherwarnings-2015.csv");
        String[] words = null;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String str;

        String search1 = "TORNADO";
        String search2 = "FLASH FLOOD";
        String search3 = "SEVERE THUNDERSTORM";
        String search4 = "SPECIAL MARINE";



        while ((str = br.readLine()) != null) {
            words = str.split(",");
            for (String word : words) {
                if (word.equals(search1)) {
                    count1++;
                }
                else if (word.equals(search2)) {
                    count2++;
                }
                else if (word.equals(search3)) {
                    count3++;
                }
                else if (word.equals(search4)) {
                    count4++;
                }
            }
        }

        fr.close();

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Tornados", count1),
                        new PieChart.Data("Flash Flooding", count2),
                        new PieChart.Data("Severe Thunderstorms", count3),
                        new PieChart.Data("Special Marines", count4)
                );

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Weather Alerts for 2015");

        Scene scene = new Scene(new Group());
        stage.setTitle("Weather Alerts for 2015");
        stage.setWidth(500);
        stage.setHeight(500);
        scene.getStylesheets().add("lab06.css");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
}
