package com.myftiu.yrsl.service;

import org.springframework.stereotype.Service;

@Service
public class YRSLService {

   private String name;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
