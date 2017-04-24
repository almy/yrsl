package com.myftiu.yrsl.presenter;

import com.gluonhq.charm.glisten.control.CharmListView;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    @FXML private CharmListView busTable;
    @FXML private Button closeButton;
    @FXML private View appView;

    public HelloController() {
        setup();
    }

    public void initialize(URL location, ResourceBundle resources) {
        appView.getName();
    }



    private void setup() {
        //setting table layout
    }


    @FXML
    private void closeButtonAction(){
        Platform.exit();
        System.exit(0);
    }


    public CharmListView getBusTable() {
        return busTable;
    }

    public void setBusTable(CharmListView busTable) {
        this.busTable = busTable;
    }

    public Button getCloseButton() {
        return closeButton;
    }

    public void setCloseButton(Button closeButton) {
        this.closeButton = closeButton;
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
