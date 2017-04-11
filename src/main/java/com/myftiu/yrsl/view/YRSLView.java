package com.myftiu.yrsl.view;


import com.gluonhq.charm.glisten.mvc.View;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class YRSLView  {

   private final String name;

   public YRSLView(String name) {
      this.name = name;
   }

   public View getView() {
      try {
         View view = FXMLLoader.load(YRSLView.class.getClassLoader().getResource("fxml/hello.fxml"));
         view.setName(name);

         return view;
      } catch (IOException e) {
         System.out.println("IOException: " + e);
         return new View(name);
      }
   }
}


