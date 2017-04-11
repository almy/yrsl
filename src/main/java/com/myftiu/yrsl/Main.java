package com.myftiu.yrsl;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.Swatch;
import com.gluonhq.connect.provider.RestClient;
import com.gluonhq.ignite.spring.SpringContext;
import com.myftiu.yrsl.service.YRSLService;
import com.myftiu.yrsl.view.YRSLView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Supplier;

public class Main extends MobileApplication {

    public static final String BASIC_VIEW = HOME_VIEW;
    private SpringContext context = new SpringContext(this, () -> Arrays.asList(Main.class.getPackage().getName()));
    @Inject YRSLService yrslService;

    @Override
    public void init() throws IOException {
        context.init();
        yrslService.setName("test");
        addViewFactory(BASIC_VIEW, () -> new YRSLView(BASIC_VIEW).getView());

    }

    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);



    }


}
