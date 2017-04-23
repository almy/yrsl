package com.myftiu.yrsl.presenter;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class HelloController  implements Initializable
{

    @FXML private Text cityId;
    @FXML private Text sunText;
    @FXML private GridPane forecast;

    @FXML private ListView yrTable;
    @FXML private ListView busTable;
    @FXML private javafx.scene.control.Button closeButton;


    public HelloController() {
        setup();
    }

    public void initialize(URL location, ResourceBundle resources) {

    }



    private void setup() {
        //setting table layout
    }


    @FXML
    private void closeButtonAction(){
        Platform.exit();
        System.exit(0);
    }


    public ListView getBusTable() {
        return busTable;
    }

    public void setBusTable(ListView busTable) {
        this.busTable = busTable;
    }

    public ListView getYrTable() {return yrTable;
    }

    public void setYrTable(ListView yrTable) {this.yrTable = yrTable;
    }

    public Text getCityId() {
        return cityId;
    }

    public void setCityId(Text cityId) {
        this.cityId = cityId;
    }

    public Text getSunText() {
        return sunText;
    }

    public void setSunText(Text sunText) {
        this.sunText = sunText;
    }

    public GridPane getForecast() {
        return forecast;
    }

    public void setForecast(GridPane forecast) {
        this.forecast = forecast;
    }
}
