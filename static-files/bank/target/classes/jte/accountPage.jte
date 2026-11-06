<%-- Java imports --%>
@import java.util.Map

<%-- Parameters --%>
@param String title
@param String name
@param String balance
@param Map<String, String> transactions

@template.jte.accountLayout(
    title = title,
    account = @`@template.jte.partials.userAccount(name, balance)`,
    detail = @`@template.jte.partials.transactionsList(transactions)`
)