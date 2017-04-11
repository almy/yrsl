package com.myftiu.yrsl.presenter;


import javafx.scene.control.ListView;
import com.myftiu.yrsl.service.YRSLService;
import com.myftiu.yrsl.view.YRSLView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;


public class YRSLPresenter implements Initializable {

	@FXML private YRSLView main;
	@FXML private ListView listView;

	@Inject YRSLService service;

	public void initialize(URL location, ResourceBundle resources) {

	}
}
