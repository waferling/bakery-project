<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bakery Products</title>
    <link rel="icon" type="image/x-icon" href="/images/cake.png"> <!--Favicon-->
    <link rel="stylesheet" href="/css/styles.css">
    <style>
        .products-table-container {
            display: flex;
            justify-content: center;
            align-items: flex-start;
            margin-top: 2rem;
        }
        table.products-table {
            background: #fff;
            border-radius: 1.5rem;
            box-shadow: 0 4px 24px rgba(55, 150, 131, 0.07);
            border-collapse: separate;
            border-spacing: 0;
            min-width: 400px;
            max-width: 700px;
            width: 100%;
            font-family: 'Montserrat', 'Helvetica Neue', Helvetica, Arial, sans-serif;
            text-align: center;
        }
        .products-table th {
            background: #c0f7e2;
            color: #379683;
            font-weight: 700;
            padding: 1rem;
            font-size: 1.1rem;
        }
        .products-table td {
            padding: 1rem;
            color: #379683;
            font-size: 1rem;
        }
        .products-table tr:nth-child(even) td {
            background: #ffccd6;
        }
        .products-table tr:nth-child(odd) td {
            background: #fff;
        }
        .products-table tr:last-child td:first-child {
            border-bottom-left-radius: 1.5rem;
        }
        .products-table tr:last-child td:last-child {
            border-bottom-right-radius: 1.5rem;
        }

        @media (max-width: 700px) {
            .products-table th, .products-table td {
                padding: 0.5rem;
                font-size: 0.95rem;
            }
            .products-table {
                min-width: 0;
                font-size: 0.95rem;
            }
        }
    </style>
</head>
<body>
    <h1 style="text-align:center; color:#379683; font-family:'Montserrat',sans-serif;">Bakery Products</h1>
    <div class="products-table-container">
        <table class="products-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Category</th>
                    <th>Stock</th>
                </tr>
            </thead>
            <tbody>
                <tr th:each="product : ${products}">
                    <td th:text="${product.id}">ID</td>
                    <td th:text="${product.name}">Product Name</td>
                    <td th:text="${product.price}">Price</td>
                    <td th:text="${product.category}">Category</td>
                    <td th:text="${product.stock}">Stock</td>
                </tr>
            </tbody>
        </table>
    </div>

</body>

