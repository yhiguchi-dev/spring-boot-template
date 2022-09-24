package com.example.demo.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyConfig {

  private static final Logger logger = LoggerFactory.getLogger(MyConfig.class);

  String bar;

  public MyConfig(@Value("${foo.bar}") String bar) {
    this.bar = bar;
    logger.info("bar: " + bar);
  }
}
