package cwi.edu;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {  
          config.routes.get("/hello/{name}", ctx -> { 
          ctx.result("Hello: " + ctx.pathParam("name"));
         });  
          config.staticFiles.add("/public"); 
          
            
            
        }).start(7070);
    }
}