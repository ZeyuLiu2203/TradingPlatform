<!DOCTYPE html>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="java.util.List"
		import="com.fdmgroup.model.Company"
		import="java.util.ArrayList"
		import="com.fdmgroup.model.Trade"
		import="java.util.concurrent.ThreadLocalRandom" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>TradingPlatform</title>
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
    height: 260px;
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
    height: 260px;
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

<script>
$(window).on("load resize ", function() {
	  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
	  $('.tbl-header').css({'padding-right':scrollWidth});
	}).resize();
</script>
  </head>
  <body>

    <header>
      <a href="#home" class="logo" data-scroll>We.Trade</a>
      <nav class="nav-collapse">
        <ul>
          <li class="menu-item active"><a href="#home" data-scroll>Home</a></li>
          <li class="menu-item"><a href="#about" data-scroll>Trade</a></li>
          <li class="menu-item"><a href="#projects" data-scroll>Portfolio</a></li>
          <li class="menu-item"><a href="logout" data-scroll>Logout</a></li>
          <li class="menu-item"><a href="#blog" data-scroll>Profile Update</a></li>
          <li class="menu-item"><a href="https://twitter.com/realDonaldTrump?lang=en" target="_blank">Google Us</a></li>
        </ul>
      </nav>
    </header>

    <section id="home">
		<%
    	ArrayList<Company> companies = (ArrayList<Company>)session.getAttribute("companies");
		List<Trade> tradeHistory = (ArrayList<Trade>)session.getAttribute("tradeHistory");
		List<Trade> portfolio = (ArrayList<Trade>)request.getAttribute("portfolio");
    	%>

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

    
    
    
    
    
    
    <div id="bigger-frame">
      <div id="login_frame" background-image=url(https://placeimg.com/640/480/nature) >
 
    <p id="image_logo"><img src="img/Buy_Online-128.png"></p>
 
    <form action="buy" method="get">
        <p><label class="label_input">Stock id</label><input type="text" id="username" class="text_field" name="stockid" placeholder="stockid"/></p>
        <p><label class="label_input">Quantity</label><input type="text" id="quantity" class="text_field" placeholder="quantity" name="quantity"/></p>
    
 
        <div id="login_control">
            <input type="submit" id="btn_login" value="Buy" placeholder="buy"/>
        </div>
        </form>
        </div>
        
   <div id="login_frame2" background-image=url(https://placeimg.com/640/480/nature)>
 
    	<p id="image_logo"><img src="img/sell_button_shopping-512.png"></p>
 
	    <form action="sell" method="get">
	        <p><label class="label_input">Stock id</label><input type="text" id="username" class="text_field" name="stockid2" placeholder="stockid"/></p>
	        <p><label class="label_input">Quantity</label><input type="text" id="quantity" class="text_field" placeholder="quantity" name="quantity2"/></p>
	    
	 
	        <div id="login_control">
	            <input type="submit" id="btn_login" value="Sell" placeholder="sell"/>
        </div>
        </form>
     </div> 
     </div>  
    </section>

    
    <section id="about">
      <h1>Trade</h1>
    </section>

    <section id="projects">
      <section>
  <!--for demo wrap-->
  <h1>Trade History</h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
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
			<td> <%=t.getId()%></td>
			<td> <%=t.getCompanyid()%></td>
			<td> <%=t.getQuantity()%></td>
			<td> <%=t.getTimebought()%></td>
			<td> <%=ThreadLocalRandom.current().nextDouble(5.0, 30)%></td>
			</tr>
			
			<%       
			}
			%>
      </tbody>
    </table>
  </div> 
</section>
      
      
      
      
      
    </section>

    <section id="blog" style="width:400px; margin:0 auto;">
      <h1>Profile Update</h1>
      <div id="login_frame" background-image=url(https://placeimg.com/640/480/nature)>
 
    <!-- <p id="image_logo"><img src="img/login/welcome.png"></p> -->
 
    <form action="updateProfile" method="get">
        <p><label class="label_input">new</label><input type="text" id="username" class="text_field" name="username3" placeholder="Username"/></p>
        <p><label class="label_input">old</label><input type="password" id="password" class="text_field" placeholder="Password" name="password3"/></p>
        <p><label class="label_input">new</label><input type="password" id="password" class="text_field" placeholder="Password" name="password4"/></p>
        <p><label class="label_input">new</label><input type="text" id="email" class="text_field" placeholder="email" name="email3"/></p>
        <p><label class="label_input">new</label><input type="text" id="firstname" class="text_field" placeholder="firstname" name="firstname3"/></p>
        <p><label class="label_input">new</label><input type="text" id="firstname" class="text_field" placeholder="lastname" name="lastname3"/></p>
 
        <div id="login_control">
            <input type="submit" id="btn_login" value="submit"/>
            ${error}
        </div>
    </form>
</div>
      
      
    </section>

    <script src="js/fastclick.js"></script>
    <script src="js/scroll.js"></script>
    <script src="js/fixed-responsive-nav.js"></script>
  </body>
  
  <footer>
  <p>Posted by: Zeyu Liu</p>
  <p>Contact information: <a href="mailto:liuzeyu00@gmail.com">
  liuzeyu00@gmail.com</a>.</p>
</footer>
</html>
