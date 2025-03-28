<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Shipment</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-[#7CB9E8] h-screen flex items-center justify-center">

<div class="bg-white p-8 rounded-lg shadow-lg w-2/3 md:w-1/2 lg:w-1/3">
    <h2 class="text-2xl font-bold mb-6 text-[#00308F] text-center">Book a New Shipment</h2>

    <!-- Success/Message Alert -->
    <c:if test="${not empty message}">
        <div class="bg-green-100 text-green-700 border-l-4 border-green-500 p-4 mb-4 rounded">
                ${message}
        </div>
    </c:if>

    <!-- Booking Form -->
    <form action="http://localhost:8080/AirlineCargoSysWeb/BookingServlet" method="post" class="space-y-4">

        <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
            <!-- Origin -->
            <div>
                <label for="origin" class="block font-semibold text-black">Origin (3-letter code):</label>
                <input type="text" name="origin" class="w-full p-2 border rounded focus:outline-none focus:ring-2 focus:ring-[#00308F]" required>
            </div>

            <!-- Destination -->
            <div>
                <label for="destination" class="block font-semibold text-black">Destination (3-letter code):</label>
                <input type="text" name="destination" class="w-full p-2 border rounded focus:outline-none focus:ring-2 focus:ring-[#00308F]" required>
            </div>

            <!-- Description -->
            <div>
                <label for="description" class="block font-semibold text-black">Description:</label>
                <input type="text" name="description" class="w-full p-2 border rounded focus:outline-none focus:ring-2 focus:ring-[#00308F]" required>
            </div>

            <!-- Weight -->
            <div>
                <label for="weight" class="block font-semibold text-black">Weight (kg):</label>
                <input type="number" name="weight" step="0.01" class="w-full p-2 border rounded focus:outline-none focus:ring-2 focus:ring-[#00308F]" required>
            </div>

            <!-- Shipper Name -->
            <div>
                <label for="shipperName" class="block font-semibold text-black">Shipper Name:</label>
                <input type="text" name="shipperName" class="w-full p-2 border rounded focus:outline-none focus:ring-2 focus:ring-[#00308F]" required>
            </div>

            <!-- Shipper Contact -->
            <div>
                <label for="shipperContact" class="block font-semibold text-black">Shipper Contact (10 digits):</label>
                <input type="text" name="shipperContact" class="w-full p-2 border rounded focus:outline-none focus:ring-2 focus:ring-[#00308F]" required>
            </div>

            <!-- Consignee Name -->
            <div>
                <label for="consigneeName" class="block font-semibold text-black">Consignee Name:</label>
                <input type="text" name="consigneeName" class="w-full p-2 border rounded focus:outline-none focus:ring-2 focus:ring-[#00308F]" required>
            </div>

            <!-- Consignee Contact -->
            <div>
                <label for="consigneeContact" class="block font-semibold text-black">Consignee Contact (10 digits):</label>
                <input type="text" name="consigneeContact" class="w-full p-2 border rounded focus:outline-none focus:ring-2 focus:ring-[#00308F]" required>
            </div>

            <!-- Declared Value -->
            <div>
                <label for="declaredValue" class="block font-semibold text-black">Declared Value:</label>
                <input type="number" name="declaredValue" step="0.01" class="w-full p-2 border rounded focus:outline-none focus:ring-2 focus:ring-[#00308F]" required>
            </div>
        </div>

        <!-- Submit Button (Full Width) -->
        <button type="submit" class="w-full bg-[#00308F] text-white p-3 rounded hover:bg-[#7CB9E8] transition">Book Shipment</button>
    </form>

    <!-- Return to Dashboard -->
    <div class="mt-4 text-center">
        <a href="dashboard.jsp" class="text-[#00308F] hover:underline">Return to Dashboard</a>
    </div>
</div>
</body>
</html>
