<%-- Parameters --%>
@param String name
@param String balance

<div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-md-8">

            <div class="card shadow-sm">
                <div class="card-body p-4">

                    <h1 class="text-center mb-4">My Bank</h1>

                    <h2 class="h4 mb-4">Account Information</h2>

                    <div class="list-group mb-4">

                        <div class="list-group-item">
                            <strong>Name:</strong>
                            <span class="text-muted">${name}</span>
                        </div>

                        <div class="list-group-item">
                            <strong>Balance:</strong>
                            <span class="text-success fw-bold">$${balance}</span>
                        </div>

                    </div>

                    

                </div>
            </div>

        </div>
    </div>
</div>
