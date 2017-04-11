package com.myftiu.yrsl;

import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.Swatch;
import com.gluonhq.connect.provider.RestClient;
import com.gluonhq.ignite.spring.SpringContext;
import com.myftiu.yrsl.model.sl.Departures;
import com.myftiu.yrsl.service.YRSLService;
import com.myftiu.yrsl.service.sl.SLService;
import com.myftiu.yrsl.service.yr.YRService;
import com.myftiu.yrsl.view.YRSLView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import java.util.function.Supplier;

public class Main extends MobileApplication {

    public static final String BASIC_VIEW = HOME_VIEW;
    private SpringContext context = new SpringContext(this, () -> Arrays.asList(Main.class.getPackage().getName()));
    @Inject YRSLService yrslService;
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private BlockingQueue<Departures> departuresBlockingQueue = new LinkedBlockingQueue<>();
    private SLService slService;
    private YRService yrService;
    private final FXMLLoader loader = new FXMLLoader();
    private static String YR_API_URL = "http://www.yr.no/place/Sweden/Stockholm/Stockholm/forecast.xml";

    final Lock lock = new ReentrantLock();
    final Condition consume  = lock.newCondition();


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


    private void startWorkers() {
        yrService = new YRService(loader);
        yrService.setExecutor(executorService);
        yrService.setPeriod(Duration.hours(24));
        yrService.start();

        slService = new SLService(departuresBlockingQueue, loader);
        slService.setExecutor(executorService);
        slService.setPeriod(Duration.minutes(1));
        slService.start();

    }


}
