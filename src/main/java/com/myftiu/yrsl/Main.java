package com.myftiu.yrsl;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.visual.Swatch;
import com.gluonhq.ignite.spring.SpringContext;
import com.myftiu.yrsl.model.sl.Departures;
import com.myftiu.yrsl.presenter.HelloController;
import com.myftiu.yrsl.service.sl.SLService;
import com.myftiu.yrsl.service.yr.YRService;
import com.myftiu.yrsl.view.YRSLView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@ComponentScan("com.myftiu.yrsl")
public class Main extends MobileApplication {

    public static final String BASIC_VIEW = HOME_VIEW;
    private SpringContext context = new SpringContext(this, () -> Arrays.asList(Main.class.getPackage().getName()));
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private BlockingQueue<Departures> departuresBlockingQueue = new LinkedBlockingQueue<>();
    private SLService slService;
    private YRService yrService;
    @Inject FXMLLoader fxmlLoader_inj;
    private static String YR_API_URL = "http://www.yr.no/place/Sweden/Stockholm/Stockholm/forecast.xml";
    private YRSLView yrslView;

    final Lock lock = new ReentrantLock();
    final Condition consume  = lock.newCondition();


    @Override
    public void init() throws IOException {
        context.init();
        yrslView = new YRSLView(BASIC_VIEW);
        addViewFactory(BASIC_VIEW, () -> yrslView.getView());
    }

    @Override
    public void postInit(Scene scene) {
        Swatch.BLUE.assignTo(scene);
        try {
            startWorkers();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void startWorkers() throws IOException {
        FXMLLoader fxmlLoader = yrslView.getFxmlLoader();
        HelloController helloController = fxmlLoader.getController();

        yrService = new YRService(helloController);
        yrService.setExecutor(executorService);
        yrService.setPeriod(Duration.hours(24));
        yrService.start();

        slService = new SLService(departuresBlockingQueue, helloController);
        slService.setExecutor(executorService);
        slService.setPeriod(Duration.minutes(1));
        slService.start();

    }


}
