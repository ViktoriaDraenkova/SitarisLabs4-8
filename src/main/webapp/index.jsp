<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="ru">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Lab 6</title>
</head>

<body>
  <%@page import="service.XmlReader"%>
  <%
    XmlReader reader = new XmlReader();
  %>
  <h2>Список продуктов</h2>
  <table>
    <tr>
      <th>id</th>
      <th>название</th>
      <th>категория</th>
      <th>ограничение по возрасту</th>
      <th>покупатель</th>
      <th>цена</th>
    </tr>
    <%
        java.util.List<entity.Product> products = reader.getAllProducts();
        for (entity.Product p : products) {
            out.println("<tr>");
            out.println("<td>");
            out.println(p.getId());
            out.println("</td>");

            out.println("<td>");
            out.println(p.getName());
            out.println("</td>");

            out.println("<td>");
            out.println(p.getCategory());
            out.println("</td>");

            out.println("<td>");
            out.println(p.getAgeConstraint());
            out.println("</td>");

            out.println("<td>");
            out.println(p.getCustomer());
            out.println("</td>");

            out.println("<td>");
            out.println(p.getPrice());
            out.println("</td>");

            out.println("</tr>");

        }
    %>
  </table>

  <h4>Общая стоимость - <%= reader.getTotalPrice() %></h4>
  <h4>Cтоимость со скидкой - <%= reader.getPriceWithPromocode() %></h4>

  <h2>Товары, отфильтрованные по категории</h2>
  <table>
      <tr>
        <th>id</th>
        <th>название</th>
        <th>категория</th>
        <th>ограничение по возрасту</th>
        <th>покупатель</th>
        <th>цена</th>
      </tr>
      <%
          products = reader.getFilteredProducts();
          for (entity.Product p : products) {
              out.println("<tr>");
              out.println("<td>");
              out.println(p.getId());
              out.println("</td>");

              out.println("<td>");
              out.println(p.getName());
              out.println("</td>");

              out.println("<td>");
              out.println(p.getCategory());
              out.println("</td>");

              out.println("<td>");
              out.println(p.getAgeConstraint());
              out.println("</td>");

              out.println("<td>");
              out.println(p.getCustomer());
              out.println("</td>");

              out.println("<td>");
              out.println(p.getPrice());
              out.println("</td>");

              out.println("</tr>");
          }
      %>
    </table>

  <style>
      table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
        padding: 10px;
      }
      body {
        background-color: #f0f8ff;
      }

      th {
        background-color: #cee1f0;
      }
  </style>
</body>

</html>