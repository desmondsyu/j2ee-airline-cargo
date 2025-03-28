<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Manage Shipments</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-[#7CB9E8] h-screen flex items-center justify-center">

<!-- Main Container -->
<div class="bg-white p-8 rounded-lg shadow-lg w-2/3 md:w-1/2 lg:w-1/3">

  <!-- Title -->
  <h2 class="text-2xl font-bold mb-6 text-[#00308F] text-center">Manage Shipments</h2>

  <!-- Action Buttons -->
  <div class="space-y-4">
    <!-- Update Shipment Events -->
    <form action="update.jsp" method="get" class="w-full">
      <button type="submit" class="w-full bg-[#00308F] text-white p-3 rounded hover:bg-[#7CB9E8] transition">
        Update Shipment Events
      </button>
    </form>

    <!-- Cancel Shipment -->
    <form action="cancel.jsp" method="get" class="w-full">
      <button type="submit" class="w-full bg-[#00308F] text-white p-3 rounded hover:bg-[#7CB9E8] transition">
        Cancel Shipment
      </button>
    </form>

    <!-- Return to Dashboard -->
    <div class="mt-4 text-center">
      <a href="dashboard.jsp" class="text-[#00308F] hover:underline">Return to Dashboard</a>
    </div>
  </div>
</div>
</body>
</html>
