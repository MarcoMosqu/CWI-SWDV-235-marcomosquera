package edu.cwi;

import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import static j2html.TagCreator.*;

public class TransactionController implements CrudHandler {

    private final Map<String, String> transactions = new ConcurrentHashMap<>();

    public TransactionController() {
        this.transactions.put("1", "Transaction 1");
        this.transactions.put("2", "Transaction 2");
    }

    @Override
    public void getAll(Context ctx) {
        // Use ctx to render all transactions html
        String view = this.renderTransactions();
        ctx.html(view);

    }

    @Override
    public void getOne(Context ctx, String resourceId) {

        String sourceId = ctx.pathParam("resourceId");
        String user = transactions.get(resourceId);

        if (user != null) {
            // Use ctx to render transaction html
            ctx.html(this.renderTransaction(sourceId, user));
        } else {
            ctx.status(404).result("Transaction not found");
        }
    }

    @Override
    public void create(Context ctx) {

        String description = ctx.formParam("description");

        String id = String.valueOf(transactions.size() + 1);
        transactions.put(id, description);

        ctx.html(this.renderTransactions());

    }

    @Override
    public void update(Context ctx, String resourceId) {

        if (transactions.containsKey(resourceId)) {
            String description = ctx.formParam("description");

            transactions.put(resourceId, description);

            ctx.redirect("/transactions");
            // Use ctx to render all transactions html
        } else {
            ctx.status(404).result("Transaction not found");
        }
    }

    @Override
    public void delete(Context ctx, String resourceId) {

        transactions.remove(resourceId);
        ctx.html(this.renderTransactions());

        // Use ctx to render all transactions html
    }

    private String renderTransactions() {
        return html(
                head(
                        title("My Bank - My Transactions"),
                        link()
                                .withRel("stylesheet")
                                .withHref("https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css")),
                body(
                        div().withClass("container py-5")
                                .with(
                                        div().withClass("row justify-content-center")
                                                .with(
                                                        div().withClass("col-md-8")
                                                                .with(
                                                                        div().withClass("card shadow-sm")
                                                                                .with(
                                                                                        div().withClass(
                                                                                                "card-body p-4"),

                                                                                        h1("My Bank")
                                                                                                .withClass(
                                                                                                        "text-center mb-4"),

                                                                                        h2("My Transactions")
                                                                                                .withClass("h4 mb-3"),

                                                                                        ul().withClass(
                                                                                                "list-group mb-4")
                                                                                                .with(
                                                                                                        each(transactions
                                                                                                                .entrySet(),
                                                                                                                transaction -> li()
                                                                                                                        .withClass(
                                                                                                                                "list-group-item d-flex justify-content-between align-items-center")
                                                                                                                        .with(
                                                                                                                                div().with(
                                                                                                                                        strong("Transaction "
                                                                                                                                                + transaction
                                                                                                                                                        .getKey()),
                                                                                                                                        p(transaction
                                                                                                                                                .getValue())
                                                                                                                                                .withClass(
                                                                                                                                                        "text-muted mb-0")),

                                                                                                                                div().withClass(
                                                                                                                                        "d-flex gap-2")
                                                                                                                                        .with(
                                                                                                                                                a("View")
                                                                                                                                                        .withHref(
                                                                                                                                                                "/transactions/"
                                                                                                                                                                        + transaction
                                                                                                                                                                                .getKey())
                                                                                                                                                        .withClass(
                                                                                                                                                                "btn btn-outline-primary btn-sm"),

                                                                                                                                                a("Edit")
                                                                                                                                                        .withHref(
                                                                                                                                                                "/transactions/"
                                                                                                                                                                        + transaction
                                                                                                                                                                                .getKey()
                                                                                                                                                                        + "/edit")
                                                                                                                                                        .withClass(
                                                                                                                                                                "btn btn-outline-warning btn-sm"),

                                                                                                                                                form()
                                                                                                                                                        .withAction(
                                                                                                                                                                "/transactions/"
                                                                                                                                                                        + transaction
                                                                                                                                                                                .getKey()
                                                                                                                                                                        + "/delete")
                                                                                                                                                        .withMethod(
                                                                                                                                                                "post")
                                                                                                                                                        .with(
                                                                                                                                                                button("Delete")
                                                                                                                                                                        .withType(
                                                                                                                                                                                "submit")
                                                                                                                                                                        .withClass(
                                                                                                                                                                                "btn btn-outline-danger btn-sm")))))),

                                                                                        a("Create Transaction")
                                                                                                .withHref(
                                                                                                        "/transactions/new")
                                                                                                .withClass(
                                                                                                        "btn btn-primary w-100")))))))
                .render();
    }

    private String renderTransaction(String resourceId, String user) {

        return html(
                head(
                        title("My Bank - Transaction Details"),
                        link()
                                .withRel("stylesheet")
                                .withHref("https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css")),
                body(
                        div().withClass("container py-5")
                                .with(
                                        div().withClass("row justify-content-center")
                                                .with(
                                                        div().withClass("col-md-6")
                                                                .with(
                                                                        div().withClass("card shadow-sm")
                                                                                .with(
                                                                                        div().withClass("card-body p-4")
                                                                                                .with(
                                                                                                        h1("My Bank")
                                                                                                                .withClass(
                                                                                                                        "text-center mb-4"),

                                                                                                        h2("Transaction Details")
                                                                                                                .withClass(
                                                                                                                        "h4 mb-3"),

                                                                                                        div().withClass(
                                                                                                                "mb-3")
                                                                                                                .with(
                                                                                                                        p("Source ID: "
                                                                                                                                + resourceId)
                                                                                                                                .withClass(
                                                                                                                                        "mb-2"),

                                                                                                                        p("Transaction: "
                                                                                                                                + user)
                                                                                                                                .withClass(
                                                                                                                                        "mb-2")),

                                                                                                        a("Back to Transactions")
                                                                                                                .withHref(
                                                                                                                        "/transactions")
                                                                                                                .withClass(
                                                                                                                        "btn btn-outline-secondary w-100"))))))))
                .render();

    }

    public String renderTransactionForm() {
        return html(
                head(
                        title("My Bank - Create Transaction"),
                        link()
                                .withRel("stylesheet")
                                .withHref("https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css")),
                body(
                        div().withClass("container py-5")
                                .with(
                                        div().withClass("row justify-content-center")
                                                .with(
                                                        div().withClass("col-md-6")
                                                                .with(
                                                                        div().withClass("card shadow-sm")
                                                                                .with(
                                                                                        div().withClass(
                                                                                                "card-body p-4"),
                                                                                        h2("Create Transaction")
                                                                                                .withClass("mb-4"),
                                                                                        form()
                                                                                                .withAction(
                                                                                                        "/transactions")
                                                                                                .withMethod("post")
                                                                                                .with(
                                                                                                        label("Description")
                                                                                                                .withFor(
                                                                                                                        "description")
                                                                                                                .withClass(
                                                                                                                        "form-label"),
                                                                                                        input()
                                                                                                                .withType(
                                                                                                                        "text")
                                                                                                                .withName(
                                                                                                                        "description")
                                                                                                                .withId("description")
                                                                                                                .withClass(
                                                                                                                        "form-control mb-3")
                                                                                                                .attr("required",
                                                                                                                        "required"),
                                                                                                        button("Create Transaction")
                                                                                                                .withType(
                                                                                                                        "submit")
                                                                                                                .withClass(
                                                                                                                        "btn btn-primary w-100")),
                                                                                        a("Cancel")
                                                                                                .withHref(
                                                                                                        "/transactions")
                                                                                                .withClass(
                                                                                                        "btn btn-outline-secondary w-100 mt-2")))))))
                .render();
    }

    public String renderUpdateForm(String resourceId, String description) {
        return html(
                head(
                        title("My Bank - Update Transaction"),
                        link()
                                .withRel("stylesheet")
                                .withHref("https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css")),
                body(
                        div().withClass("container py-5")
                                .with(
                                        div().withClass("row justify-content-center")
                                                .with(
                                                        div().withClass("col-md-6")
                                                                .with(
                                                                        div().withClass("card shadow-sm")
                                                                                .with(
                                                                                        div().withClass(
                                                                                                "card-body p-4"),
                                                                                        h2("Update Transaction")
                                                                                                .withClass("mb-4"),
                                                                                        form()
                                                                                                .withAction(
                                                                                                        "/transactions/"
                                                                                                                + resourceId)
                                                                                                .withMethod("post")
                                                                                                .with(
                                                                                                        label("Description")
                                                                                                                .withFor(
                                                                                                                        "description")
                                                                                                                .withClass(
                                                                                                                        "form-label"),
                                                                                                        input()
                                                                                                                .withType(
                                                                                                                        "text")
                                                                                                                .withName(
                                                                                                                        "description")
                                                                                                                .withId("description")
                                                                                                                .withValue(
                                                                                                                        description)
                                                                                                                .withClass(
                                                                                                                        "form-control mb-3")
                                                                                                                .attr("required",
                                                                                                                        "required"),
                                                                                                        button("Save Changes")
                                                                                                                .withType(
                                                                                                                        "submit")
                                                                                                                .withClass(
                                                                                                                        "btn btn-primary w-100")),
                                                                                        a("Cancel")
                                                                                                .withHref(
                                                                                                        "/transactions")
                                                                                                .withClass(
                                                                                                        "btn btn-outline-secondary w-100 mt-2")))))))
                .render();

    }

    public String getTransaction(String resourceId) {
        return transactions.get(resourceId);
    }

}
