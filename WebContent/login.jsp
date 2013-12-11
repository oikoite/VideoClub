<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/estiloCliente.css" media="screen"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" media="screen"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" media="screen"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" media="screen"/>
		<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
		<style type="text/css">
		/* Override some defaults */
      html, body {
        background-color: #eee;
      }
      body {
        padding-top: 40px;
      }
      .container {
        width: 300px;
      }

      /* The white background content wrapper */
      .container > .content {
        background-color: #fff;
        padding: 20px;
        margin: 0 -20px;
        -webkit-border-radius: 10px 10px 10px 10px;
           -moz-border-radius: 10px 10px 10px 10px;
                border-radius: 10px 10px 10px 10px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.15);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.15);
                box-shadow: 0 1px 2px rgba(0,0,0,.15);
      }

         .login-form {
                margin-left: 65px;
         }
        
         legend {
                margin-right: -50px;
                font-weight: bold;
                 color: #404040;
         }
		</style>
		<title>
			Login
		</title>
	</head>
	<body>
	
	<div class="container">
    <div class="content">
      <div class="row">
        <div class="login-form">
          <h2>Iniciar sessión</h2>
          <form action="LoginServlet" method="post">
            <fieldset>
              <div class="clearfix">
                <input type="text" name="user" placeholder="Usuario">
              </div>
              <div class="clearfix">
                <input type="password" name="password" placeholder="Contraseña">
              </div>
              <button class="btn btn-primary" type="submit">Ingresar</button>
            </fieldset>
          </form>
        </div>
      </div>
    </div>
  </div>
	</body>
</html>