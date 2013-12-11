<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="py.consultores.controlador.*"%>
<%@page import="py.consultores.modelo.*"%>
<% List<Cliente> lista = (List<Cliente>) request.getAttribute("clientes");%>
<% Cliente cliente = (Cliente) request.getAttribute("cliente"); %>
<% Iterator<Cliente> it = lista.iterator(); %>
<% String operacion = (String)request.getAttribute("operacion"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="js/funciones.js"></script>
		<link rel="stylesheet" type="text/css" href="css/estiloCliente.css" media="screen"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" media="screen"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" media="screen"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.min.css" media="screen"/>
		<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
		<title>
			Clientes
		</title>
	</head>
	<body>
		<form action="Cliente" method="post" onsubmit="return validarCampos()"  class="form-horizontal">
			<h1 align="center">
				ABM CLIENTES  <%= cliente == null %>
			</h1>
			<br>
			<div class="container">
				<div class="row">
					<div class="span10">
						<div class="container">
							<div class="row">
								<div class="span3">
									<label for="idCliente">ID#</label>
									<input type="text" name="idCliente" id="idCliente" value="<%= cliente == null ? "" : cliente.getId()%>" readonly="readonly"/>
								</div>
								<div class="span7">
									<label name="estadoCliente">Activo:</label>
									<select name="estadoCliente" id="estadoCliente">
										<option value="0" selected="<%= cliente == null ? "none" : (cliente.getEstado().equals("0") ? "selected" : "none") %>">SI</option>
										<option value="1" selected="<%= cliente == null ? "none" : (cliente.getEstado().equals("1") ? "selected" : "none") %>">NO</option>
									</select>
								</div>
							</div>
						</div>
						<br>
						<label name="nombreCliente">Nombre</label>
						<input type="text" name="nombreCliente" id="nombreCliente" value="<%= cliente == null ? "" : cliente.getNombre()%>"/>
						<br>
						<label name="fechaNaCliente">Fecha Nac.</label>
												
  							<div id="datetimepicker1" class="input-append date">
								<input type="text" data-format="dd/MM/yyyy" name="fechaNaCliente" id="fechaNaCliente" value="<%= cliente == null ? "" : cliente.getFechaNacimiento()%>"/>
								<span class="add-on">
							      <i class="icon-home" data-time-icon="icon-time" data-date-icon="icon-calendar"></i>
							    </span>
						  </div>
						<label>Telefono</label>
						<input type="text" name="telefonoCliente" id="telefonoCliente" value="<%= cliente == null ? "" : cliente.getTelefono()%> "/>
						<br>
						<label name="direccionCliente">Dirección</label>
						<input type="text" name="direccionCliente" id="direccionCliente" value="<%= cliente == null ? "" : cliente.getDireccion()%> "/>
						<br>
						<label name="emailCliente">Email</label>
						<input type="text" name="emailCliente" id="emailCliente" value="<%= cliente == null ? "" : cliente.getMail()%> "/>
						<br>
					</div>
				</div>
			</div>
			<br>
			
			<div class="container">
				<div class="row">
					<div class="span10">
							<input type="submit" class="btn btn-primary" name="operacion" value="Agregar" <%= operacion == "Editar" ? "disabled=\"disabled\"" : ""%>/>
							<input type="submit" class="btn btn-success" name="operacion" value="Modificar" <%= operacion != "Editar" ? "disabled=\"disabled\"" : ""%>/>
						<input type="button" class="btn btn-info" name="operacion" value="Cancelar" onclick="cancelar();"/>
					</div>
				</div>
			</div>
			
			<br>
			<br>
			
			<div class="container">
				<div class="row">
					<div class="span10">
						<table id="tablaClientes" class="table table-bordered">
			                        <thead>
			                                <tr>
			                                        <th>id</th>
			                                        <th>Nombre</th>
			                                        <th>FecNac</th>
			                                        <th>Telefono</th>
			                                        <th>Direccion</th>
			                                        <th>Email</th>
			                                        <th>Activo</th>
			                                        <th>Opciones</th>
			                                </tr>
			                        </thead>
			                        <tbody>
			                                <%
			                                        while(it.hasNext()){
			                                                Cliente a = it.next();        
			                                %>
			                                <tr id="row">
			                                        <td><span>
			                                                <%= a.getId() %>
			                                                </span>
			                                        </td>
			                                        <td>
			                                                <span>
			                                                <%= a.getNombre() %>
			                                                </span>
			                                        </td>
			                                        <td>
			                                                <span>
			                                                <%= a.getFechaNacimiento()%>
			                                                </span>
			                                        </td>
			                                        <td>
			                                                <span>
			                                                <%= a.getTelefono()%>
			                                                </span>
			                                        </td>
			                                        <td>
			                                                <span>
			                                                <%= a.getDireccion()%>
			                                                </span>
			                                        </td>
			                                        <td>
			                                                <span>
			                                                <%= a.getMail()%>
			                                                </span>
			                                        </td>
			                                        <td>
			                                                <span>
			                                                <%= a.getEstado() %>
			                                                </span>
			                                        </td>
			                                        <td>
			                                                <span>
			                                                <a href="Cliente?operacion=Editar&id=<%= a.getId()%>" onclick="desabilitarCampos('Agregar');"> Editar</a>
			                                                |
			                                                <a href="#" onclick="eliminarRegistro(<%= a.getId()%>);"> Eliminar</a>
			                                                </span>
			                                        </td>
			                                </tr>
			                                <%
			                                        }
			                                %>
			                        </tbody>
			                </table>
			                <a href="CerrarSession" class="btn btn-warning">Cerrar session</a>
			        	</div>
	                </div>
            	</div>
			<br>
		</form>
		
		<script type="text/javascript">
			  $(function() {
			    $('#datetimepicker1').datetimepicker({
			      language: 'es-Es'
			    });
			  });
			  
		</script>
		
	</body>
</html>