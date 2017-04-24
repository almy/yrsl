package com.myftiu.yrsl.view;


import com.gluonhq.charm.glisten.mvc.View;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class YRSLView extends View {

   private final String name;
   private View view;
   private FXMLLoader fxmlLoader;

   public YRSLView(String name) {
      super(name);
      this.fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/yrsl.fxml"));
      this.name = name;
   }

   public FXMLLoader getFxmlLoader() {
      return this.fxmlLoader;
   }

   public View getView() {
      try {
         view = fxmlLoader.load();
         view.setName(name);
         return view;
      } catch (IOException e) {
         System.out.println("IOException: " + e);
         return new View(name);
      }
   }
}


