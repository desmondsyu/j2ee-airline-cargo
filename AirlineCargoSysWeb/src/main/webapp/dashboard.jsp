<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-[#7CB9E8] h-screen flex items-center justify-center">

<!-- Main Container -->
<div class="bg-white p-8 rounded-lg shadow-lg w-2/3 md:w-1/2 lg:w-1/3">

    <!-- Title -->
    <h2 class="text-2xl font-bold mb-6 text-[#00308F] text-center">Welcome to Airline Cargo System</h2>

    <!-- Action Buttons -->
    <div class="space-y-4">
        <!-- Book Shipment -->
        <form action="booking.jsp" method="get" class="w-full">
            <button type="submit" class="w-full bg-[#00308F] text-white p-3 rounded hover:bg-[#7CB9E8] transition">
                Book Shipment
            </button>
        </form>

        <!-- Track Shipment -->
        <form action="status.jsp" method="get" class="w-full">
            <button type="submit" class="w-full bg-[#00308F] text-white p-3 rounded hover:bg-[#7CB9E8] transition">
                Track Shipment
            </button>
        </form>

        <!-- Manage Shipments -->
        <form action="manage.jsp" method="get" class="w-full">
            <button type="submit" class="w-full bg-[#00308F] text-white p-3 rounded hover:bg-[#7CB9E8] transition">
                Manage Shipments
            </button>
        </form>
    </div>
</div>
</body>
</html>
