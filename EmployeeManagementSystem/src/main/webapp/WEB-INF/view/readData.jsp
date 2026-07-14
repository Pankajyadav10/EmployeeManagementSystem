<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee List</title>

<style>
body{
    font-family: Arial, sans-serif;
    background:#f4f4f4;
    margin:0;
    padding:30px;
}

.container{
    width:90%;
    margin:auto;
    background:#fff;
    padding:20px;
    border-radius:10px;
    box-shadow:0 0 10px rgba(0,0,0,0.2);
}

h2{
    text-align:center;
    color:#333;
}

table{
    width:100%;
    border-collapse:collapse;
    margin-top:20px;
}

table th, table td{
    border:1px solid #ddd;
    padding:12px;
    text-align:center;
}

table th{
    background:#007BFF;
    color:white;
}

table tr:nth-child(even){
    background:#f2f2f2;
}

table tr:hover{
    background:#ddd;
}
</style>

</head>
<body>

<div class="container">

<h2>Employee Details</h2>

<table>
<tr>
    <th>Employee ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Address</th>
    <th>Salary</th>
</tr>

<%
Connection con = null;
PreparedStatement ps = null;
ResultSet rs = null;

try{

    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/test";
    String username = "root";
    String password = "";

    con = DriverManager.getConnection(url, username, password);

    String sql = "SELECT * from employee";

    ps = con.prepareStatement(sql);

    rs = ps.executeQuery();

    while(rs.next()){
%>

<tr>
    <td><%= rs.getString("eid") %></td>
    <td><%= rs.getString("name") %></td>
    <td><%= rs.getString("email") %></td>
    <td><%= rs.getString("address") %></td>
    <td><%= rs.getString("salary") %></td>
</tr>

<%
    }

}catch(Exception e){
%>

<tr>
    <td colspan="5">
        <%= e.getMessage() %>
    </td>
</tr>

<%
}finally{

    if(rs != null) rs.close();
    if(ps != null) ps.close();
    if(con != null) con.close();

}
%>

</table>

<div class="back">
    <a href="EmpOption?action=home">Back to Home</a>
</div>

</div>

</body>
</html>