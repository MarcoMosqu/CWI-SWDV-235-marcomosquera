package cwi.edu;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {  
          config.routes.get("/hello/{name}", ctx -> { 
          ctx.result("Hello: " + ctx.pathParam("name"));
         });  
          config.staticFiles.add("/public"); 
          config.routes.get("/hello/{name}/html", ctx -> {
          ctx.html("<h1>Hello " + ctx.pathParam("name") +
             "</h1><br><p>Welcome to Javalin!</p>");
         });
          
            
            
        }).start(7070);
    }
}