<%-- Java imports --%>
@import gg.jte.Content

<%-- Parameters --%>
@param String title = "My Bank"
@param Content account
@param Content detail

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title}</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>
        body {
            background-color: #f4f6fa;
            font-family: Arial, sans-serif;
            color: #1e293b;
        }

        .sidebar {
            background-color: #172554;
            min-height: 100vh;
            color: white;
            padding: 30px 20px;
        }

        .brand {
            font-size: 1.5rem;
            font-weight: 700;
            margin-bottom: 45px;
        }

        .sidebar a {
            display: block;
            color: #cbd5e1;
            text-decoration: none;
            padding: 12px 15px;
            border-radius: 8px;
            margin-bottom: 8px;
        }

        .sidebar a:hover,
        .sidebar a.active {
            background-color: #2563eb;
            color: white;
        }

        .main-content {
            padding: 35px;
        }

        .topbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 35px;
        }

        .dashboard-title {
            font-weight: 700;
            color: #172554;
        }

        .dashboard-card {
            background-color: white;
            border: none;
            border-radius: 14px;
            box-shadow: 0 3px 15px rgba(15, 23, 42, 0.05);
            
        }

        .section-heading {
            font-size: 1.1rem;
            font-weight: 700;
            color: #172554;
            margin-bottom: 20px;
        }

        .user-profile {
            background-color: #1e3a8a;
            padding: 15px;
            border-radius: 10px;
            margin-top: 40px;
        }

        @media (max-width: 767px) {
            .sidebar {
                min-height: auto;
                padding: 20px;
            }

            .brand {
                margin-bottom: 20px;
            }

            .user-profile {
                margin-top: 20px;
            }

            .main-content {
                padding: 20px;
            }

            .topbar {
                align-items: flex-start;
                flex-direction: column;
                gap: 10px;
            }
        }
    </style>
</head>

<body>

    <div class="container-fluid">
        <div class="row">

            <!-- Sidebar -->
            <aside class="col-md-3 col-lg-2 sidebar">

                <div class="brand">
                    My Bank
                </div>

                <nav>
                    <a href="/transactions" class="active">
                        Dashboard
                    </a>

                    <a href="/transactions">
                        Transactions
                    </a>
                </nav>

                <div class="user-profile">
                    <strong>Personal Account</strong>
                    <p class="small mb-0 text-white-50">
                        Welcome back!
                    </p>
                </div>

            </aside>

            <!-- Main Content -->
            <main class="col-md-9 col-lg-10 main-content">

                <div class="topbar">
                    <div>
                        <h1 class="dashboard-title h3 mb-1">
                            Dashboard
                        </h1>
                        <p class="text-muted mb-0">
                            Welcome to your banking overview.
                        </p>
                    </div>

                    <span class="badge bg-success-subtle text-success p-2">
                        Account Active
                    </span>
                </div>

                <!-- Dashboard Sections -->
                <div class="row g-4">

                    <!-- Account Information -->
                    <div class="col-lg-4 ">

                        <div class="card dashboard-card">
                            <div class="card-body p-4">

                                <h2 class="section-heading">
                                    Account Overview
                                </h2>

                                ${account}

                            </div>
                        </div>

                    </div>

                    <!-- Transactions -->
                    <div class="col-lg-8">

                        <div class="card dashboard-card">
                            <div class="card-body p-4">

                                <h2 class="section-heading">
                                    Recent Transactions
                                </h2>

                                ${detail}

                            </div>
                        </div>

                    </div>

                </div>


                <!-- Footer -->
                <footer class="text-center text-muted small mt-5">
                    My Bank &copy; 2026. All rights reserved.
                </footer>

            </main>

        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>