<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Shipment Events</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-[#7CB9E8] h-screen flex items-center justify-center">

<!-- Main Container -->
<div class="bg-white p-8 rounded-lg shadow-lg w-2/3 md:w-1/2 lg:w-1/3">

    <!-- Title -->
    <h2 class="text-2xl font-bold mb-6 text-[#00308F] text-center">Update Shipment Events</h2>

    <!-- Update Message -->
    <c:if test="${not empty updateMessage}">
        <div class="bg-green-100 text-green-700 border-l-4 border-green-500 p-4 mb-4 rounded">
                ${updateMessage}
        </div>
    </c:if>

    <!-- Update Form -->
    <form action="http://localhost:8080/AirlineCargoSysWeb/UpdateServlet" method="post" class="space-y-4">

        <!-- Tracking Number -->
        <label for="trackingNumber" class="block font-semibold text-black">Tracking Number:</label>
        <input type="text" name="trackingNumber" class="w-full p-2 border rounded focus:outline-none focus:ring-2 focus:ring-[#00308F]" required>

        <!-- Event Status -->
        <label for="eventStatus" class="block font-semibold text-black">Select Status:</label>
        <select name="eventStatus" class="w-full p-2 border rounded focus:outline-none focus:ring-2 focus:ring-[#00308F]" required>
            <option value="BOOKED">Booked</option>
            <option value="IN_TRANSIT">In Transit</option>
            <option value="DELIVERED">Delivered</option>
        </select>

        <!-- Submit Button -->
        <button type="submit" class="w-full bg-[#00308F] text-white p-3 rounded hover:bg-[#7CB9E8] transition">
            Update Shipment
        </button>
    </form>

    <!-- Return to Dashboard -->
    <div class="mt-4 text-center">
        <a href="dashboard.jsp" class="text-[#00308F] hover:underline">Return to Dashboard</a>
    </div>
</div>
</body>
</html>
