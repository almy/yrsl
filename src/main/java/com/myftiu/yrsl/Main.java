package com.myftiu.yrsl;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.Swatch;
import com.myftiu.yrsl.view.YRSLView;
import javafx.scene.Scene;

import java.util.function.Supplier;

public class Main extends MobileApplication {

    public static final String BASIC_VIEW = HOME_VIEW;

    @Override
    public void init() {
        addViewFactory(BASIC_VIEW, (Supplier<View>) new YRSLView().getView());
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);


    }
}
