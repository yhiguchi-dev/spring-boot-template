package dev.yhiguchi.template.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample")
public class SampleApi {

  @PostMapping
  ResponseEntity<?> post(@RequestBody String json) {
    SampleResponse response = new SampleResponse("hoge");
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
