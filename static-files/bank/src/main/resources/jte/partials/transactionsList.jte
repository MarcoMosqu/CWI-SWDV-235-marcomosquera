<%-- Java imports --%>
@import java.util.Map

<%-- Parameters --%>
@param Map<String, String> transactions

<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-md-8">

            <div class="card shadow-sm">
                <div class="card-body p-4">

                    <h1 class="text-center mb-4">My Bank</h1>

                    <h2 class="h4 mb-3">Transactions</h2>

                    <ul class="list-group mb-4">

                        <%-- Loop through the transactions map --%>
                        @for(var entry : transactions.entrySet())

                            <li class="list-group-item d-flex justify-content-between align-items-center">

                                <div>
                                    <strong>Transaction ${entry.getKey()}</strong>
                                    <p class="text-muted mb-0">
                                        ${entry.getValue()}
                                    </p>
                                </div>

                                <div class="d-flex gap-2">

                                    <!-- View -->
                                    <a href="/transactions/${entry.getKey()}"
                                       class="btn btn-outline-primary btn-sm">
                                        View
                                    </a>

                                    <!-- Edit -->
                                    <a href="/transactions/${entry.getKey()}/edit"
                                       class="btn btn-outline-warning btn-sm">
                                        Edit
                                    </a>

                                    <!-- Delete -->
                                    <form action="/transactions/${entry.getKey()}/delete"
                                          method="POST">

                                        <button type="submit"
                                                class="btn btn-outline-danger btn-sm">
                                            Delete
                                        </button>

                                    </form>

                                </div>

                            </li>

                        @else
                            <li class="list-group-item text-muted text-center">
                                You have no transactions to display.
                            </li>
                        @endfor

                    </ul>

                    <!-- Create button at the bottom -->
                    <a href="/transactions/new"
                       class="btn btn-primary w-100">
                        Create Transaction
                    </a>

                </div>
            </div>

        </div>
    </div>
</div>