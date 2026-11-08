package edu.cwi;


import io.javalin.http.Context;
import java.util.Map;

import io.javalin.http.UnauthorizedResponse;

public class AccountController {
    public static void renderAccount(Context ctx) {

        String userId = ctx.cookieStore().get("user-id");

        UserAccount user = AuthController.getUser(userId)
                .orElseThrow(UnauthorizedResponse::new);

        ctx.render("jte/accountPage.jte",
            Map.of(
                    "title", "My Account",
                    "name", user.name(),
                    "balance", user.formatBalance(),
                    "transactions", user.transactions()
            ));
    }

}
