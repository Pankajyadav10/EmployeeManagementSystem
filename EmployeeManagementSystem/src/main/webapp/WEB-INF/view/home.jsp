<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Employee Management System</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, Helvetica, sans-serif;
}

body{
    min-height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(-45deg,#4facfe,#00f2fe,#6a11cb,#2575fc);
    background-size:400% 400%;
    animation:gradient 10s ease infinite;
}

@keyframes gradient{
    0%{background-position:0% 50%;}
    50%{background-position:100% 50%;}
    100%{background-position:0% 50%;}
}

.container{
    width:90%;
    max-width:1150px;
}

.header{
    display:flex;
    justify-content:space-between;
    align-items:center;
    margin-bottom:40px;
}

.header h1{
    color:#fff;
    font-size:42px;
    text-shadow:2px 2px 8px rgba(0,0,0,.3);
}

.logout{
    text-decoration:none;
    background:#ff4d4d;
    color:#fff;
    padding:12px 28px;
    border-radius:30px;
    font-size:18px;
    font-weight:bold;
    transition:.3s;
}

.logout:hover{
    background:#d63031;
    transform:scale(1.05);
}

.cards{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(240px,1fr));
    gap:30px;
}

.card{
    background:rgba(255,255,255,.18);
    backdrop-filter:blur(12px);
    border-radius:20px;
    padding:35px 25px;
    text-align:center;
    color:#fff;
    box-shadow:0 10px 25px rgba(0,0,0,.2);
    transition:.4s;
}

.card:hover{
    transform:translateY(-12px);
    box-shadow:0 18px 35px rgba(0,0,0,.3);
}

.icon{
    font-size:60px;
    margin-bottom:20px;
}

.card h2{
    margin-bottom:15px;
}

.card p{
    margin-bottom:25px;
    line-height:1.5;
}

.card a{
    display:inline-block;
    text-decoration:none;
    color:#fff;
    border:2px solid #fff;
    padding:12px 28px;
    border-radius:30px;
    transition:.3s;
    font-weight:bold;
}

.card a:hover{
    background:#fff;
    color:#6a11cb;
}

.footer{
    text-align:center;
    color:#fff;
    margin-top:40px;
    font-size:18px;
}

@media(max-width:768px){

.header{
    flex-direction:column;
    gap:20px;
}

.header h1{
    font-size:32px;
}

}
</style>

</head>
<body>

<div class="container">

    <div class="header">
        <h1>Employee Management System</h1>

        <!-- Logout Servlet -->
        <a href="EmpOption?action=logout" class="logout"> Logout</a>
    </div>

    <div class="cards">

        <div class="card">
            <div class="icon"></div>
            <h2>Add Employee</h2>
            <p>Add a new employee to the database.</p>
            <a href="EmpOption?action=add">Open</a>
        </div>

        <div class="card">
            <div class="icon"></div>
            <h2>Read Employee</h2>
            <p>View all employee records and details.</p>
            <a href="EmpOption?action=read">Open</a>
        </div>

        <div class="card">
            <div class="icon"></div>
            <h2>Update Employee</h2>
            <p>Modify employee information and salary.</p>
            <a href="EmpOption?action=update">Open</a>
        </div>

        <div class="card">
            <div class="icon"></div>
            <h2>Delete Employee</h2>
            <p>Remove employee data from the database.</p>
            <a href="EmpOption?action=delete">Open</a>
        </div>

    </div>


    <div class="footer">
        © 2026 Employee Management System
    </div>

</div>

</body>
</html>