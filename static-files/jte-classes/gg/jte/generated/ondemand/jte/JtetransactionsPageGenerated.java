package gg.jte.generated.ondemand.jte;
import java.util.Map;
@SuppressWarnings("unchecked")
public final class JtetransactionsPageGenerated {
	public static final String JTE_NAME = "jte/transactionsPage.jte";
	public static final int[] JTE_LINE_INFO = {2,2,5,5,5,5,33,33,34,34,39,39,39,41,41,41,47,48,48,48,48,53,54,54,54,54,59,60,60,60,60,74,74,78,95,95,95,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Map<String, String> transactions) {
		jteOutput.writeContent("\r\n<!doctype html>\r\n<html lang=\"en\">\r\n<head>\r\n    <meta charset=\"utf-8\">\r\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n    <title>My Bank - My Transactions</title>\r\n\r\n    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n    <link rel=\"stylesheet\" href=\"/css/styles.css\">\r\n</head>\r\n\r\n<body>\r\n\r\n    <div class=\"container py-5\">\r\n        <div class=\"row justify-content-center\">\r\n            <div class=\"col-md-8\">\r\n\r\n                <div class=\"card shadow-sm\">\r\n                    <div class=\"card-body p-4\">\r\n\r\n                        <h1 class=\"text-center mb-4\">My Bank</h1>\r\n\r\n                        <h2 class=\"h4 mb-3\">My Transactions</h2>\r\n\r\n                        <ul class=\"list-group mb-4\">\r\n\r\n                            ");
		jteOutput.writeContent("\r\n                            ");
		for (var entry : transactions.entrySet()) {
			jteOutput.writeContent("\r\n\r\n                                <li class=\"list-group-item d-flex justify-content-between align-items-center\">\r\n\r\n                                    <div>\r\n                                        <strong>Transaction ");
			jteOutput.setContext("strong", null);
			jteOutput.writeUserContent(entry.getKey());
			jteOutput.writeContent("</strong>\r\n                                        <p class=\"text-muted mb-0\">\r\n                                            ");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(entry.getValue());
			jteOutput.writeContent("\r\n                                        </p>\r\n                                    </div>\r\n\r\n                                    <div class=\"d-flex gap-2\">\r\n\r\n                                        ");
			jteOutput.writeContent("\r\n                                        <a href=\"/transactions/");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(entry.getKey());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"\r\n                                           class=\"btn btn-outline-primary btn-sm\">\r\n                                            View\r\n                                        </a>\r\n\r\n                                        ");
			jteOutput.writeContent("\r\n                                        <a href=\"/transactions/");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(entry.getKey());
			jteOutput.setContext("a", null);
			jteOutput.writeContent("/edit\"\r\n                                           class=\"btn btn-outline-warning btn-sm\">\r\n                                            Edit\r\n                                        </a>\r\n\r\n                                        ");
			jteOutput.writeContent("\r\n                                        <form action=\"/transactions/");
			jteOutput.setContext("form", "action");
			jteOutput.writeUserContent(entry.getKey());
			jteOutput.setContext("form", null);
			jteOutput.writeContent("/delete\"\r\n                                              method=\"POST\">\r\n\r\n                                            <button type=\"submit\"\r\n                                                    class=\"btn btn-outline-danger btn-sm\">\r\n                                                Delete\r\n                                            </button>\r\n\r\n                                        </form>\r\n\r\n                                    </div>\r\n\r\n                                </li>\r\n\r\n                            ");
		}
		jteOutput.writeContent("\r\n\r\n                        </ul>\r\n\r\n                        ");
		jteOutput.writeContent("\r\n                        <a href=\"/transactions/new\"\r\n                           class=\"btn btn-primary w-100\">\r\n                            Create Transaction\r\n                        </a>\r\n\r\n                    </div>\r\n                </div>\r\n\r\n            </div>\r\n        </div>\r\n    </div>\r\n\r\n    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js\"></script>\r\n\r\n</body>\r\n</html>\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Map<String, String> transactions = (Map<String, String>)params.get("transactions");
		render(jteOutput, jteHtmlInterceptor, transactions);
	}
}
