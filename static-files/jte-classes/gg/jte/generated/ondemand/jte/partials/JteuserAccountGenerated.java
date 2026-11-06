package gg.jte.generated.ondemand.jte.partials;
@SuppressWarnings("unchecked")
public final class JteuserAccountGenerated {
	public static final String JTE_NAME = "jte/partials/userAccount.jte";
	public static final int[] JTE_LINE_INFO = {1,1,1,1,1,19,19,19,19,24,24,24,37,37,37,1,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String name, String balance) {
		jteOutput.writeContent("\r\n<div class=\"container py-5\">\r\n    <div class=\"row justify-content-center\">\r\n        <div class=\"col-md-8\">\r\n\r\n            <div class=\"card shadow-sm\">\r\n                <div class=\"card-body p-4\">\r\n\r\n                    <h1 class=\"text-center mb-4\">My Bank</h1>\r\n\r\n                    <h2 class=\"h4 mb-4\">Account Information</h2>\r\n\r\n                    <div class=\"list-group mb-4\">\r\n\r\n                        <div class=\"list-group-item\">\r\n                            <strong>Name:</strong>\r\n                            <span class=\"text-muted\">");
		jteOutput.setContext("span", null);
		jteOutput.writeUserContent(name);
		jteOutput.writeContent("</span>\r\n                        </div>\r\n\r\n                        <div class=\"list-group-item\">\r\n                            <strong>Balance:</strong>\r\n                            <span class=\"text-success fw-bold\">$");
		jteOutput.setContext("span", null);
		jteOutput.writeUserContent(balance);
		jteOutput.writeContent("</span>\r\n                        </div>\r\n\r\n                    </div>\r\n\r\n                    \r\n\r\n                </div>\r\n            </div>\r\n\r\n        </div>\r\n    </div>\r\n</div>\r\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String name = (String)params.get("name");
		String balance = (String)params.get("balance");
		render(jteOutput, jteHtmlInterceptor, name, balance);
	}
}
