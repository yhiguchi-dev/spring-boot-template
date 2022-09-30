package dev.yhiguchi.template.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SampleResponse {

  @JsonProperty("id")
  String id;

  public SampleResponse(String id) {
    this.id = id;
  }
}
