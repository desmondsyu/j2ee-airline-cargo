<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cancel Shipment</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-[#7CB9E8] h-screen flex items-center justify-center">

<div class="bg-white p-8 rounded-lg shadow-lg w-2/3 md:w-1/2 lg:w-1/3">
    <h2 class="text-2xl font-bold mb-6 text-[#00308F] text-center">Cancel a Shipment</h2>

    <!-- Success/Message Alert -->
    <c:if test="${not empty cancelMessage}">
        <div class="bg-red-100 text-red-700 border-l-4 border-red-500 p-4 mb-4 rounded">
                ${cancelMessage}
        </div>
    </c:if>

    <!-- Cancel Form -->
    <form action="http://localhost:8080/AirlineCargoSysWeb/CancelServlet" method="post" class="space-y-4">

        <!-- Tracking Number -->
        <label for="trackingNumber" class="block font-semibold text-black">Tracking Number:</label>
        <input type="text" name="trackingNumber" class="w-full p-2 border rounded focus:outline-none focus:ring-2 focus:ring-[#00308F]" required>

        <!-- Submit Button -->
        <button type="submit" class="w-full bg-[#00308F] text-white p-3 rounded hover:bg-[#7CB9E8] transition">
            Cancel Shipment
        </button>
    </form>

    <!-- Return to Dashboard -->
    <div class="mt-4 text-center">
        <a href="dashboard.jsp" class="text-[#00308F] hover:underline">Return to Dashboard</a>
    </div>
</div>
</body>
</html>
