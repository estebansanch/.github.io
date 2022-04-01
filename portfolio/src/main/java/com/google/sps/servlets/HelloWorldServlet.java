package com.google.sps.servlets;

import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    private static final ArrayList<String> GREETS = new ArrayList<String>(Arrays.asList(
        "Good Day!", "Hello there!", "How do you do kind stranger?", "Welcome to my website"));

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("application/json;");
    
    
    String greet = selectRandom(GREETS);
    String json = convertToJson(greet);

    response.getWriter().println(json);
  }

  private String convertToJson(String greet) {
      String json = "[";
      json += "\"" + greet + "\"";
      json += "]";
      return json; 
  }
  private String convertToJsonUsingGson(HelloWorldServlet serverStats) {
    Gson gson = new Gson();
    String json = gson.toJson(serverStats);
    return json;
  }

  private String selectRandom(ArrayList<String> greets){
      Random r = new Random();
      return greets.get(r.nextInt(greets.size()));
  }

}
