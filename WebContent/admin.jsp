<!DOCTYPE html>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="java.util.List"
		import="com.fdmgroup.model.Company"
		import="java.util.ArrayList"
		import="com.fdmgroup.model.Trade"
		import="java.util.concurrent.ThreadLocalRandom"
		import="com.fdmgroup.model.User"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>AdminPage</title>
    <meta name="author" content="Adtile">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link rel="stylesheet" href="css/styles.css">
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <link rel="stylesheet" href="css/ie.css">
    <script src="js/responsive-nav.js"></script>
    <style>
    <style type="text/css">
    body {
    background-image: url("img/login/loginBackground.jpg");;
    background-size: 100%;
    background-repeat: no-repeat;
}
 
#login_frame {
	float:left;
    width: 400px;
    height: 400px;
    padding: 13px;
 
    
 
    background-color: rgba(240, 255, 255, 0.5);
 
    border-radius: 10px;
    text-align: center;
}
#login_frame3 {
	float:left;
    width: 400px;
    height: 400px;
    padding: 13px;
 
    
 
    background-color: rgba(240, 255, 255, 0.5);
 
    border-radius: 10px;
    text-align: center;
}

#login_frame4 {
	float:right;
    width: 400px;
    height: 400px;
    padding: 13px;
 
    
 
    background-color: rgba(240, 255, 255, 0.5);
 
    border-radius: 10px;
    text-align: center;
}


.footer {
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    background-color: red;
    color: white;
    text-align: center;
}




#bigger-frame{
display: inline;
}

#login_frame2 {
	float:right;
    width: 400px;
    height: 400px;
    padding: 13px;
 
    
 
    background-color: rgba(240, 255, 255, 0.5);
 
    border-radius: 10px;
    text-align: center;
}
 
form p > * {
    display: inline-block;
    vertical-align: middle;
}
h1{
  font-size: 30px;
  color: #fff;
  text-transform: uppercase;
  font-weight: 300;
  text-align: center;
  margin-bottom: 15px;
}
table{
  width:100%;
  table-layout: fixed;
}
.tbl-header{
  background-color: rgba(255,255,255,0.3);
 }
.tbl-content{
  height:300px;
  overflow-x:auto;
  margin-top: 0px;
  border: 1px solid rgba(255,255,255,0.3);
}
th{
  padding: 20px 15px;
  text-align: left;
  font-weight: 500;
  font-size: 12px;
  color: #fff;
  text-transform: uppercase;
}
td{
  padding: 15px;
  text-align: left;
  vertical-align:middle;
  font-weight: 300;
  font-size: 12px;
  color: #fff;
  border-bottom: solid 1px rgba(255,255,255,0.1);
}


/* demo styles */

@import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
body{
 background: -webkit-linear-gradient(left, #25c481, #25b7c4);
  background: linear-gradient(to right, #25c481, #25b7c4); 
  font-family: 'Roboto', sans-serif;
}
section{
  margin: 50px;
}

/* for custom scrollbar for webkit browser*/

::-webkit-scrollbar {
    width: 6px;
} 
::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
} 
::-webkit-scrollbar-thumb {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
}
 
#image_logo {
    margin-top: 22px;
}

img.resize {
  width:50px;
  height:10px;
}
 
.label_input {
    font-size: 14px;
    font-family:serif;
 
    width: 65px;
    height: 28px;
    line-height: 28px;
    text-align: center;
 
    color: white;
    background-color: #3CD8FF;
    border-top-left-radius: 5px;
    border-bottom-left-radius: 5px;
    
    border: solid 2px black;
}
 
.text_field {
    width: 278px;
    height: 28px;
    border-top-right-radius: 5px;
    border-bottom-right-radius: 5px;
    border: solid 2px black;
}
 
#btn_login {
    font-size: 14px;
    font-family: serif;
 
    width: 120px;
    height: 28px;
    line-height: 28px;
    text-align: center;
 
    color: white;
    background-color: #3BD9FF;
    border-radius: 6px;
    border: 0;
 
    float: left;
}
 
#forget_pwd {
    font-size: 12px;
    color: blue;
    text-decoration: none;
    position: relative;
    float: right;
    top: 5px;
 
}

.wrapper{
	background: #2eabe2;
	color: #ffffff;
	padding: 10px;
	margin-top: 10px;
}
 

 
#login_control {
    padding: 0 28px;
}
    </style>
  </head>
  <body>

    <header>
      <a href="#home" class="logo" data-scroll>We.Admin</a>
      <nav class="nav-collapse">
        <ul>
          <li class="menu-item active"><a href="#home" data-scroll>Companies</a></li>
          <li class="menu-item"><a href="#about" data-scroll>ModifyCompanies</a></li>
          <li class="menu-item"><a href="#projects" data-scroll>Users</a></li>
          <li class="menu-item"><a href="#modifyUsers" data-scroll>ModifyUsers</a></li>
          <li class="menu-item"><a href="#tradeHistory" data-scroll>TradeHistory</a></li>
          <li class="menu-item"><a href="logout" data-scroll>Logout</a></li>
        </ul>
      </nav>
    </header>
    
    <%
    	ArrayList<Company> companies = (ArrayList<Company>)session.getAttribute("companies");
		List<Trade> tradeHistory = (ArrayList<Trade>)session.getAttribute("tradeHistory");
		ArrayList<User> users = (ArrayList<User>)session.getAttribute("allUsers");
    	%>

    <section id="home">
    
    
    
    
    
    
    <div id="bigger-frame">
    <section>
  <!--for demo wrap-->
  <h1>Stocks Available</h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Company id</th>
          <th>Company name</th>
          <th>Stock Symbol</th>
          <th>Exchange Id</th>
          <th>Price</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
        <%
			for ( Company c: companies)
			{
			%>
			<tr>
			<td> <%=c.getId()%></td>
			<td><%=c.getName()%> </td>
			<td> <%=c.getStockSymbol()%></td>
			<td><%=c.getExchangeId()%> </td>
			<td> <%=c.getPrice()%></td>
			</tr>
			
			<%       
			}
			%>
      </tbody>
    </table>
  </div>
</section>  
      <div id="login_frame" background-image=url(https://placeimg.com/640/480/nature)>
 
    <p id="image_logo"><img src="img/deleteCompany.png"></p>
 
    <form action="deleteCompany" method="post">
        <p><label class="label_input">ID</label><input type="text" id="username" class="text_field" name="stockid" placeholder="company id"/></p>
        <div id="login_control">
            <input type="submit" id="btn_login" value="Delete"/>
        </div>
        </form>
        </div>
        
   <div id="login_frame2" background-image=url(https://placeimg.com/640/480/nature)>
 
    	<p id="image_logo"><img src="img/addCompany.png"></p>
 
	    <form action="addCompany" method="post">
	        
	        <p><label class="label_input">Name</label><input type="text" id="quantity" class="text_field" placeholder="Company Name" name="companyname"/></p>
	    	<p><label class="label_input">Symbol</label><input type="text" id="username" class="text_field" name="stocksymbol" placeholder="Stock Symbol"/></p>
	        <p><label class="label_input">Id</label><input type="text" id="quantity" class="text_field" placeholder="Exchange ID" name="exchangeid"/></p>
	 		<p><label class="label_input">Price</label><input type="text" id="quantity" class="text_field" placeholder="Price" name="price"/></p>
	        <div id="login_control">
	            <input type="submit" id="btn_login" value="Add" placeholder="sell"/>
        </div>
        </form>
     </div> 
     </div>  
    </section>

    <section id="about">
      <h1>Modify Companies</h1>
    </section>

    <section id="projects">
      <h1>Users</h1>
      <section>
  <!--for demo wrap-->
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>User ID</th>
          <th>UserName</th>
          <th>Email</th>
          <th>First Name</th>
          <th>Last Name</th>
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
        <%
			for ( User u:users)
			{
			%>
			<tr>
			<td> <%=u.getId()%></td>
			<td><%=u.getUsername()%> </td>
			<td> <%=u.getEmail()%></td>
			<td><%=u.getFirstname()%> </td>
			<td> <%=u.getLastname()%></td>
			</tr>
			
			<%       
			}
			%>
      </tbody>
    </table>
  </div>
</section> 
     </section> 
      
      <section id="modifyUsers">
      <h1>Modify Users</h1>
      <div id="login_frame3" background-image=url(https://placeimg.com/640/480/nature)>
 
    <p id="image_logo"><img src="img/deleteUser.jpg"></p>
 
    <form action="deleteUser" method="post">
        <p><label class="label_input">ID</label><input type="text" id="username" class="text_field" name="userid" placeholder="User ID"/></p>
        <div id="login_control">
            <input type="submit" id="btn_login" value="Delete"/>
        </div>
        </form>
        </div>
        
   <div id="login_frame4" background-image=url(https://placeimg.com/640/480/nature)>
 
    <p id="image_logo"><img src="img/addUser.png"></p>
 
    <form action="addUser" method="get">
        <p><label class="label_input">Username</label><input type="text" id="username" class="text_field" name="username" placeholder="Username"/></p>
        <p><label class="label_input">Password</label><input type="password" id="password" class="text_field" placeholder="Password" name="password"/></p>
        <p><label class="label_input">email</label><input type="text" id="email" class="text_field" placeholder="email" name="email"/></p>
        <p><label class="label_input">firstname</label><input type="text" id="firstname" class="text_field" placeholder="firstname" name="firstname"/></p>
        <p><label class="label_input">lastname</label><input type="text" id="firstname" class="text_field" placeholder="lastname" name="lastname"/></p>
 
        <div id="login_control">
            <input type="submit" id="btn_login" value="Add"/>
        </div>
    </form>
</div>
      </section>
      
      
      <section id="tradeHistory">
      <h1>Trade History</h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
        <th>User Id</th>
          <th>Trade Id</th>
          <th>Company Id</th>
          <th>Quantity</th>
          <th>Time</th>
          <th>Price Total</th>
        </tr>
      </thead>
    </table>
  </div>
   <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
        <%
			for ( Trade t : tradeHistory)
			{
			%>
			<tr>
			<td> <%=t.getUser()%></td>
			<td> <%=t.getId()%></td>
			<td> <%=t.getCompanyid()%></td>
			<td> <%=t.getQuantity()%></td>
			<td> <%=t.getTimebought()%></td>
			<td> <%=ThreadLocalRandom.current().nextDouble(1000, 10000)%></td>
			</tr>
			
			<%       
			}
			%>
      </tbody>
    </table>
  </div>
      </section>
      
</script>
    </section>


    <script src="js/fastclick.js"></script>
    <script src="js/scroll.js"></script>
    <script src="js/fixed-responsive-nav.js"></script>
  </body>
</html>