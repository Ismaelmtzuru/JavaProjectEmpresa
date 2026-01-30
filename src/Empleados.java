
public class Empleados {
	private int numEmpleado;
	private String nombre;
	private String departamento;
	private float sueldo;
	
	
	public Empleados(int numEmpleado, String nombre, String departamento, float sueldo) {
		super();
		this.numEmpleado = numEmpleado;
		this.nombre = nombre;
		this.departamento = departamento;
		this.sueldo = sueldo;
	}


	@Override
	public String toString() {
		return "Datos [#Empleado= " + numEmpleado 
				+ ",Nombre= " + nombre 
				+ ",Departamento= " + departamento
				+ ",Salario= " + sueldo + "]\n";
	}


	public int getNumEmpleado() {
		return numEmpleado;
	}


	public void setNumEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public float getSueldo() {
		return sueldo;
	}


	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	
	
	
	
	
	
}
