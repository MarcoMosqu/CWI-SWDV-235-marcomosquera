package edu.cwi;

import io.javalin.Javalin;
import io.javalin.http.UnauthorizedResponse;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.apibuilder.ApiBuilder.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        TransactionController controller = new TransactionController();

        var app = Javalin.create(config -> {

            config.fileRenderer(new JavalinJte());

            config.staticFiles.add("/public");

            // Route security
            config.routes.beforeMatched(ctx -> {

                // If the route has no roles, allow it
                if (ctx.routeRoles().isEmpty()) {
                    return;
                }

                String role = ctx.cookieStore().get("user-role");

                // No role means the user is not logged in
                if (role == null) {
                    throw new UnauthorizedResponse();
                }

                try {
                    AppRole appRole = AppRole.valueOf(role);

                    // User does not have the required role
                    if (!ctx.routeRoles().contains(appRole)) {
                        throw new UnauthorizedResponse();
                    }

                } catch (IllegalArgumentException e) {
                    throw new UnauthorizedResponse();
                }
            });

            config.routes.apiBuilder(() -> {

                // Authentication
                post("/account", AuthController::authenticate);
                get("/logout", AuthController::logout);

                // Account
                path("/account", List.of(AppRole.CUSTOMER), () -> {
                    get(AccountController::renderAccount);
                });

                // Transactions
                path("/transactions", List.of(AppRole.CUSTOMER), () -> {

                    // Display creation form
                    get("/new", ctx -> {
                        String view = controller.renderTransactionForm();
                        ctx.html(view);
                    });

                    // Display update form
                    get("/{resourceId}/edit", ctx -> {
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
                    post("", ctx -> {
                        controller.create(ctx);
                    });

                    // Update transaction
                    post("/{resourceId}", ctx -> {
                        controller.update(ctx, ctx.pathParam("resourceId"));
                    });

                    // Delete transaction
                    post("/{resourceId}/delete", ctx -> {
                        controller.delete(ctx, ctx.pathParam("resourceId"));
                    });

                    // CRUD routes
                    crud("{resourceId}", controller);
                });
            });

        }).start(7070);
    }
}