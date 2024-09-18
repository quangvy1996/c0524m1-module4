<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Simple Calculator</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
  <h1 class="mb-3">Calculator</h1>
  <form action="/calculate" method="POST">
    <div class="mb-3">
      <label for="number1" class="form-label">Number 1:</label>
      <input type="text" class="form-control" id="number1" name="first" required>
    </div>
    <div class="mb-3">
      <label for="number2" class="form-label">Number 2:</label>
      <input type="text" class="form-control" id="number2" name="second" required>
    </div>
    <div class="mb-3">
      <button type="submit" name="operation" value="+" class="btn btn-primary">Addition (+)</button>
      <button type="submit" name="operation" value="-" class="btn btn-secondary">Subtraction (-)</button>
      <button type="submit" name="operation" value="*" class="btn btn-success">Multiplication (X)</button>
      <button type="submit" name="operation" value="/" class="btn btn-danger">Division (/)</button>
    </div>
  </form>
  <h3>Result</h3>
  <p>${result}</p>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
