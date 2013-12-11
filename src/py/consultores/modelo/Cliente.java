package py.consultores.modelo;

public class Cliente 
{
	private int id;
	private String nombre;
	private String fechaNacimiento;
	private String direccion;
	private String telefono;
	private String mail;
	private String estado;
	
	public Cliente(){}
	
	public Cliente(String nombre, String fechaNacimiento, String telefono,
			String direccion, String mail, String estado){
		setNombre(nombre);
		setFechaNacimiento(fechaNacimiento);
		setDireccion(direccion);
		setTelefono(telefono);
		setMail(mail);
		setEstado(estado);
	}
	
	public Cliente(int id, String nombre, String fechaNacimiento, String telefono,
			String direccion, String mail, String estado){
		setId(id);
		setNombre(nombre);
		setFechaNacimiento(fechaNacimiento);
		setDireccion(direccion);
		setTelefono(telefono);
		setMail(mail);
		setEstado(estado);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
