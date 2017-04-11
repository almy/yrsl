package com.myftiu.yrsl;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.Swatch;
import com.myftiu.yrsl.view.YRSLView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.function.Supplier;

public class Main extends MobileApplication {

    public static final String BASIC_VIEW = HOME_VIEW;
    private View view;

    @Override
    public void init() throws IOException {
        addViewFactory(BASIC_VIEW, () -> new YRSLView(BASIC_VIEW).getView());
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);

    }


}
