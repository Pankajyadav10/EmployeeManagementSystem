<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee Salary</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, Helvetica, sans-serif;
}

body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(135deg,#4facfe,#6a11cb);
}

.container{
    width:420px;
    background:#fff;
    padding:35px;
    border-radius:15px;
    box-shadow:0 10px 25px rgba(0,0,0,.3);
}

h1{
    text-align:center;
    color:#333;
    margin-bottom:25px;
}

.input-box{
    margin-bottom:18px;
}

.input-box label{
    display:block;
    margin-bottom:6px;
    font-weight:bold;
    color:#444;
}

.input-box input{
    width:100%;
    padding:12px;
    border:1px solid #ccc;
    border-radius:8px;
    outline:none;
    font-size:15px;
    transition:.3s;
}

.input-box input:focus{
    border-color:#4facfe;
    box-shadow:0 0 8px rgba(79,172,254,.4);
}

button{
    width:100%;
    padding:13px;
    background:#4facfe;
    color:white;
    border:none;
    border-radius:8px;
    font-size:17px;
    cursor:pointer;
    transition:.3s;
}

button:hover{
    background:#007bff;
}

.back{
    text-align:center;
    margin-top:15px;
}

.back a{
    text-decoration:none;
    color:#4facfe;
    font-weight:bold;
}

.back a:hover{
    text-decoration:underline;
}

.message{
    text-align:center;
    color:green;
    margin-bottom:15px;
    font-weight:bold;
}

.error{
    text-align:center;
    color:red;
    margin-bottom:15px;
    font-weight:bold;
}
</style>

</head>
<body>

<div class="container">

<h1>Update Employee Salary</h1>

<%
String msg = (String)request.getAttribute("msg");

if(msg != null){
    if(msg.equals("Salary Updated Successfully")){
%>

<p class="message"><%=msg%></p>

<%
    }else{
%>

<p class="error"><%=msg%></p>

<%
    }
}
%>

<form action="UpdateEmployee" method="post">

    <div class="input-box">
        <label>Employee ID</label>
        <input type="text"
               name="eid"
               placeholder="Enter Employee ID"
               required>
    </div>

    <div class="input-box">
        <label>New Salary</label>
        <input type="number"
               name="salary"
               placeholder="Enter New Salary"
               required>
    </div>

    <button type="submit">Update Salary</button>

</form>

<div class="back">
    <a href="EmpOption?action=home">Back to Home</a>
</div>

</div>

</body>
</html>