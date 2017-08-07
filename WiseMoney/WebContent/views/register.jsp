<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="css/main.css">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Lobster" />
</head>

<body>

<div class="video-background">
	<div class="video-foreground">
<iframe id="player" type="text/html" 
	src="https://www.youtube.com/embed/86MKzstijzI?
			controls=0&showinfo=0&rel=0&autoplay=1&loop=1&playlist=86MKzstijzI" 
	frameborder="0" allowfullscreen></iframe>
	
	</div>
</div> 

<h3 class="projectTitle">Wise Money</h3>


<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="account-wall">
            		<h3 class="headerSign">Sign Up</h3>
                <img class="profile-img" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" alt="">
                <form class="form-signin" action="register" method="POST">
                <input type="text" class="form-control" placeholder="First Name" name="firstName" required autofocus>
                <input type="text" class="form-control" placeholder="Last Name" name="lastName" required>
                <input type="text" class="form-control" placeholder="Username" name="username" value="${fn:escapeXml(param.username)}" required>
                <span class="error">${messages.username}</span>
                
                <input type="text" class="form-control" placeholder="Email" name="email" required>
                <input type="password" class="form-control" placeholder="Password" name="password" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    Register</button>
                <a href="/WiseMoney/login" class="pull-left sign-in">Sign in</a><span></span>
                <a href="#" class="pull-right need-help">Need help? </a><span></span>
                </form>
            </div>
        </div>
    </div>
</div>
    
    <script src="js/player.js"></script>
</body>
</html>