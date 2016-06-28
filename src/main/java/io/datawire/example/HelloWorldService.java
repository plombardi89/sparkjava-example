package io.datawire.example;

import com.google.gson.Gson;
import java.time.Instant;

import static java.time.Instant.*;
import static spark.Spark.*;

public class HelloWorldService {

  public static void main(String... args) throws Exception {
    port(5000);
    final Gson gson = new Gson();
    get("/", (req, res) -> new HelloResult("Hello, world!"), gson::toJson);
  }

  private static class HelloResult {

    private final String text;
    private final Instant creationTime;

    HelloResult(String text) {
      this.text = text;
      this.creationTime = now();
    }
  }
}
