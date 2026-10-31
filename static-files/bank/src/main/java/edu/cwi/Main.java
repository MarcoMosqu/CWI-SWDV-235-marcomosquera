package edu.cwi;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {
    public static void main(String[] args) {

        TransactionController controller = new TransactionController();

        var app = Javalin.create(config -> {

            // Display creation form
            config.routes.get("/transactions/new", ctx -> {
                String view = controller.renderTransactionForm();
                ctx.html(view);
            });

            // Display update form
            config.routes.get("/transactions/{resourceId}/edit", ctx -> {
                String resourceId = ctx.pathParam("resourceId");

                String description = controller.getTransaction(resourceId);

                if (description != null) {
                    String view = controller.renderUpdateForm(resourceId, description);
                    ctx.html(view);
                } else {
                    ctx.status(404).result("Transaction not found");
                }
            });

            // Create transaction
            config.routes.post("/transactions", ctx -> {
                controller.create(ctx);
            });

            // Update transaction
            config.routes.post("/transactions/{resourceId}", ctx -> {
                controller.update(ctx, ctx.pathParam("resourceId"));
            });

            // Delete transaction
            config.routes.post("/transactions/{resourceId}/delete", ctx -> {
                controller.delete(ctx, ctx.pathParam("resourceId"));
            });

            // Existing CRUD routes
            config.routes.apiBuilder(() -> {
                crud("transactions/{resourceId}", controller);
            });
        }).start(7070);
    }

}