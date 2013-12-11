function validarCampos() 
{

	var estadoCliente    = document.getElementById("estadoCliente").value;
	var nombreCliente    = document.getElementById("nombreCliente").value;
	var fechaNaCliente   = document.getElementById("fechaNaCliente").value;
	var telefonoCliente  = document.getElementById("telefonoCliente").value;
	var direccionCliente = document.getElementById("direccionCliente").value;
	var emailCliente 	 = document.getElementById("emailCliente").value;

	if(estadoCliente == "" || nombreCliente == "" || fechaNaCliente == "" ||
			telefonoCliente == "" || direccionCliente == "" || emailCliente == "")
	{
		alert("Complete los campos vacíos");
		return false;
	}

	if( !(/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)/.test(emailCliente)) ) {
		alert("Email no válido");
		return false;
	}

	var formato= new RegExp('(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}','g');//formato=dd/mm/aaaa
	if (!formato.test(fechaNaCliente))//validamos el formato de la fecha
	{
		alert('Formato de fecha no válida');
		return false;
	}

	if(!validarFecha(fechaNaCliente))//validamos que una fecha sea correcta
	{
		alert("Fecha no válida");
		return false;
	}
	return true;
}

function validarFecha(fecha){
	var dtCh= "/";
	var minYear=1900;
	var maxYear=2100;
	function isInteger(s){
		var i;
		for (i = 0; i < s.length; i++){
			var c = s.charAt(i);
			if (((c < "0") || (c > "9"))) return false;
		}
		return true;
	}
	function stripCharsInBag(s, bag){
		var i;
		var returnString = "";
		for (i = 0; i < s.length; i++){
			var c = s.charAt(i);
			if (bag.indexOf(c) == -1) returnString += c;
		}
		return returnString;
	}
	function daysInFebruary (year){
		return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
	}
	function DaysArray(n) {
		for (var i = 1; i <= n; i++) {
			this[i] = 31;
			if (i==4 || i==6 || i==9 || i==11) {this[i] = 30;}
			if (i==2) {this[i] = 29;}
		}
		return this;
	}
	function isDate(dtStr){
		var daysInMonth = DaysArray(12);
		var pos1=dtStr.indexOf(dtCh);
		var pos2=dtStr.indexOf(dtCh,pos1+1);
		var strDay=dtStr.substring(0,pos1);
		var strMonth=dtStr.substring(pos1+1,pos2);
		var strYear=dtStr.substring(pos2+1);
		strYr=strYear;
		if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1);
		if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1);
		for (var i = 1; i <= 3; i++) {
			if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1);
		}
		month=parseInt(strMonth);
		day=parseInt(strDay);
		year=parseInt(strYr);
		if (pos1==-1 || pos2==-1){
			return false;
		}
		if (strMonth.length<1 || month<1 || month>12){
			return false;
		}
		if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
			return false;
		}
		if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
			return false;
		}
		if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
			return false;
		}
		return true;
	}
	if(isDate(fecha)){
		return true;
	}else{
		return false;
	}
}

function desabilitarCampos(nombre) 
{
	var elemento = document.getElementsByName("operacion");
	for ( var int = 0; int < elemento.length; int++) {
		if (elemento[i].value == nombre) {
			elemento[i].disabled = true;
		}
	}
}
function eliminarRegistro(idCliente) {
	if(confirm("¿Estas seguro de eliminar el registro?")) {
		document.location.href= "Cliente?operacion=Eliminar&id="+idCliente;
	}
}

function cancelar() {
		document.location.href= "Cliente";
}

function operacion(nombreOperacion)
{
	var elemento = document.getElementsByName("operacion");
	for ( var int = 0; int < elemento.length; int++) {
		if (elemento[i].value == nombre) {
			;
		}
	}
}