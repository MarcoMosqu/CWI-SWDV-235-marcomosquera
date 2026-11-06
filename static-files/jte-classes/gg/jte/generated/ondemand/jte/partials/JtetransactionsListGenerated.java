package gg.jte.generated.ondemand.jte.partials;
import java.util.Map;
@SuppressWarnings("unchecked")
public final class JtetransactionsListGenerated {
	public static final String JTE_NAME = "jte/partials/transactionsList.jte";
	public static final int[] JTE_LINE_INFO = {1,1,4,4,4,4,19,19,20,20,20,20,25,25,25,27,27,27,33,34,34,34,34,39,40,40,40,40,45,46,46,46,46,60,60,60,64,64,68,79,79,79,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Map<String, String> transactions) {
		jteOutput.writeContent("\r\n<div class=\"container py-5\">\r\n    <div class=\"row justify-content-center\">\r\n        <div class=\"col-md-8\">\r\n\r\n            <div class=\"card shadow-sm\">\r\n                <div class=\"card-body p-4\">\r\n\r\n                    <h1 class=\"text-center mb-4\">My Bank</h1>\r\n\r\n                    <h2 class=\"h4 mb-3\">Transactions</h2>\r\n\r\n                    <ul class=\"list-group mb-4\">\r\n\r\n                        ");
		jteOutput.writeContent("\r\n                        ");
		boolean __jte_for_loop_entered_1 = false;
		for (var entry : transactions.entrySet()) {
			__jte_for_loop_entered_1 = true;
			jteOutput.writeContent("\r\n\r\n                            <li class=\"list-group-item d-flex justify-content-between align-items-center\">\r\n\r\n                                <div>\r\n                                    <strong>Transaction ");
			jteOutput.setContext("strong", null);
			jteOutput.writeUserContent(entry.getKey());
			jteOutput.writeContent("</strong>\r\n                                    <p class=\"text-muted mb-0\">\r\n                                        ");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(entry.getValue());
			jteOutput.writeContent("\r\n                                    </p>\r\n                                </div>\r\n\r\n                                <div class=\"d-flex gap-2\">\r\n\r\n                                    ");
			jteOutput.writeContent("\r\n                                    <a href=\"/transactions/");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(entry.getKey());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"\r\n                                       class=\"btn btn-outline-primary btn-sm\">\r\n                                        View\r\n                                    </a>\r\n\r\n                                    ");
			jteOutput.writeContent("\r\n                                    <a href=\"/transactions/");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(entry.getKey());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("/edit\"\r\n                                       class=\"btn btn-outline-warning btn-sm\">\r\n                                        Edit\r\n                                    </a>\r\n\r\n                                    ");
			jteOutput.writeContent("\r\n                                    <form action=\"/transactions/");
			jteOutput.setContext("form", "action");
			jteOutput.writeUserContent(entry.getKey());
			jteOutput.setContext("form", null);
			jteOutput.writeContent("/delete\"\r\n                                          method=\"POST\">\r\n\r\n                                        <button type=\"submit\"\r\n                                                class=\"btn btn-outline-danger btn-sm\">\r\n                                            Delete\r\n                                        </button>\r\n\r\n                                    </form>\r\n\r\n                                </div>\r\n\r\n                            </li>\r\n\r\n                        ");
		}
		if (!__jte_for_loop_entered_1) {
			jteOutput.writeContent("\r\n                            <li class=\"list-group-item text-muted text-center\">\r\n                                You have no transactions to display.\r\n                            </li>\r\n                        ");
		}
		jteOutput.writeContent("\r\n\r\n                    </ul>\r\n\r\n                    ");
		jteOutput.writeContent("\r\n                    <a href=\"/transactions/new\"\r\n                       class=\"btn btn-primary w-100\">\r\n                        Create Transaction\r\n                    </a>\r\n\r\n                </div>\r\n            </div>\r\n\r\n        </div>\r\n    </div>\r\n</div>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Map<String, String> transactions = (Map<String, String>)params.get("transactions");
		render(jteOutput, jteHtmlInterceptor, transactions);
	}
}
