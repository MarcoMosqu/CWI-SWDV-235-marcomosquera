
<%-- Java imports --%>
@import java.util.Map

<%-- Parameters --%>
@param Map<String, String> transactions

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>My Bank - My Transactions</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/styles.css">
</head>

<body>

    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-8">

                <div class="card shadow-sm">
                    <div class="card-body p-4">

                        <h1 class="text-center mb-4">My Bank</h1>

                        <h2 class="h4 mb-3">My Transactions</h2>

                        <ul class="list-group mb-4">

                            <%-- Loop through transactions --%>
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

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
