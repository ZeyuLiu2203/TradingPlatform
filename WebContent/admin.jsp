<!DOCTYPE html>
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
    height: 260px;
    padding: 13px;
 
    
 
    background-color: rgba(240, 255, 255, 0.5);
 
    border-radius: 10px;
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
 

 
#login_control {
    padding: 0 28px;
}
    </style>
    
    </style>
  </head>
  <body>

    <header>
      <a href="#home" class="logo" data-scroll>We.Trade</a>
      <nav class="nav-collapse">
        <ul>
          <li class="menu-item active"><a href="#home" data-scroll>Home</a></li>
          <li class="menu-item"><a href="#about" data-scroll>Portfolio</a></li>
          <li class="menu-item"><a href="#projects" data-scroll>About</a></li>
          <li class="menu-item"><a href="logout" data-scroll>Logout</a></li>
          <li class="menu-item"><a href="http://www.google.com" target="_blank">Google</a></li>
        </ul>
      </nav>
    </header>

    <section id="home">
    <div id="bigger-frame">
      <div id="login_frame" background-image=url(https://placeimg.com/640/480/nature)>
 
    <p id="image_logo"><img src="img/Buy-Now-logo-3.jpg"></p>
 
    <form action="buy" method="get">
        <p><label class="label_input">Stock id</label><input type="text" id="username" class="text_field" name="stockid" placeholder="stockid"/></p>
        <p><label class="label_input">Quantity</label><input type="text" id="quantity" class="text_field" placeholder="quantity" name="quantity"/></p>
    
 
        <div id="login_control">
            <input type="submit" id="btn_login" value="Buy" placeholder="buy"/>
        </div>
        </form>
        </div>
        
   <div id="login_frame2" background-image=url(https://placeimg.com/640/480/nature)>
 
    	<p id="image_logo"><img src="img/download (1).png"></p>
 
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
      <h1>About</h1>
    </section>

    <section id="projects">
      <h1>Projects</h1>
      
      <form id="whatever" name="whatever" onSubmit="xyz();">
    	Here is your entire form
    	<input type="submit">
	</form>;

		<script type=text/javascript>
			function xyz() {
			  document.getElementById('whatever').action = <%request.getSession().setAttribute("movie","godFather");%>
			}
</script>
    </section>

    <section id="blog">
      <h1>Blog</h1>
    </section>

    <script src="js/fastclick.js"></script>
    <script src="js/scroll.js"></script>
    <script src="js/fixed-responsive-nav.js"></script>
  </body>
</html>