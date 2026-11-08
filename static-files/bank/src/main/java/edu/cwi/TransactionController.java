package edu.cwi;

import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import static j2html.TagCreator.*;

public class TransactionController implements CrudHandler {

        private final Map<String, String> transactions = new ConcurrentHashMap<>();
        private final UserAccount account;

        public TransactionController() {
                this.transactions.put("1", "Transaction 1");
                this.transactions.put("2", "Transaction 2");
                // Initialize the UserAccount object
                this.account = new UserAccount("94f6901f-cd0f-4c90-81dc-3601a071c077", "Alice Jones", AppRole.CUSTOMER, 750.00, Map.of("1", "Deposited $750.00"));
        }

        @Override
        public void getAll(Context ctx) {
                // Use ctx to render all transactions html
                ctx.render("jte/accountPage.jte",
                                Map.of(
                                                "title", "Account Transactions",
                                                "name", account.name(),
                                                "balance", account.formatBalance(),
                                                "transactions", account.transactions()));

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

                int nextId = 1;

                for (String existingId : transactions.keySet()) {
                        int currentId = Integer.parseInt(existingId);

                        if (currentId >= nextId) {
                                nextId = currentId + 1;
                        }
                }

                String id = String.valueOf(nextId);

                transactions.put(id, description);

                ctx.render("jte/accountPage.jte",
                                Map.of(
                                                "title", "Account Transactions",
                                                "name", account.name(),
                                                "balance", account.formatBalance(),
                                                "transactions", account.transactions()));
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
                ctx.render("jte/accountPage.jte",
                                Map.of(
                                                "title", "Account Transactions",
                                                "name", account.name(),
                                                "balance", account.formatBalance(),
                                                "transactions", account.transactions()));

                // Use ctx to render all transactions html
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
