import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner lectura = null;

		int numeroEmpleado, menuPrincipal, subMenu, indice;
		String nombre, departamento;
		float sueldo;

		Empleados empleado;

		List<Empleados> lista = new ArrayList<Empleados>();
		
		
		
		do {
			System.out.println("\nBienvenidos al gestor de empleados\n");
			System.out.println("1.Realizar Alta de empleado");
			System.out.println("2.Visualizar Empleado");
			System.out.println("3.Buscar Empleado");
			System.out.println("4.Editar registro de empleado");
			System.out.println("5.Eliminar registro de empleado");
			// Realizar lo de abajo en el case
			System.out.println("6.Buscar por nombre");
			System.out.println("7.Buscar por departamento");
			System.out.println("8.Calcular el total de dinero a pagar");
			System.out.println("9.Eliminar buscando por numero de empleado");
			System.out.println("10.Salir");
			
			lectura = new Scanner(System.in);
			menuPrincipal = lectura.nextInt();
			
			switch (menuPrincipal) {
			case 1:
				try {
					System.out.println("Ingresa num empleado");
					lectura = new Scanner(System.in);
					numeroEmpleado = lectura.nextInt();
					
					System.out.println("Ingresa el nombre de empleado: ");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();
					
					
					System.out.println("Ingresa el departamento del empleado");
					lectura = new Scanner(System.in);
					departamento = lectura.nextLine();
					
					
					System.out.println("Ingresa el sueldo de empleado");
					lectura = new Scanner(System.in);
					sueldo = lectura.nextFloat();
					
					
					empleado = new Empleados(numeroEmpleado, nombre, departamento, sueldo);
					lista.add(empleado);
					System.out.println("Registro Ingresado\n");
				}catch(Exception e) {
					System.out.println("Error al guardar\n");
				};
				break;
			case 2:
				if(lista.size()>0)
					System.out.println(lista);
				else
					System.out.println("Lista empleados está vacía");
				break;
			case 3:
				try {
					if(lista.size()>0) {
						System.out.println("Ingresa el indice a buscar");
						lectura = new Scanner(System.in);
						indice = lectura.nextInt();
						
						empleado = lista.get(indice);
						
						System.out.println(empleado);
						
						
					}else
						System.out.println("No hay registros en la lista");
				}catch(Exception e) {
					System.out.println("No existe el registro");
				}
				break;
				
			case 4:
				try {
					System.out.println("Ingrese índice de registro para editar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();
					
					empleado = lista.get(indice);
					
					System.out.println("Empleado encontrado: " + empleado.getNombre());
					
					do {
						System.out.println("Submenu para editar");
						System.out.println("1.Nombre");
						System.out.println("2.Sueldo");
						System.out.println("3.Regresar");
						
						lectura = new Scanner(System.in);
						subMenu = lectura.nextInt();
						
						switch (subMenu) {
						case 1:
							System.out.println("Ingresa el nuevo nombre");
							lectura = new Scanner(System.in);
							nombre = lectura.nextLine();
							
							empleado.setNombre(nombre);
							System.out.println("Nombre editado");
							break;
						case 2:
							System.out.println("Ingresa Sueldo nuevo");
							lectura = new Scanner(System.in);
							sueldo = lectura.nextFloat();
							empleado.setSueldo(sueldo);
							System.out.println("Sueldo editado");
							break;
						case 3:
							break;
						}
					}while(subMenu<3);
					
				}catch(Exception e) {
					System.out.println("No se pudo editar");
				}
				break;
			case 5:
				try {
					System.out.println("Introduce indice del registro a eliminar");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();
					
					lista.remove(indice);
					System.out.println("Registro eliminado");
					
				}catch(Exception e) {
					System.out.println("No se pudo eliminar");
				}
				break;
			case 6:
				try {
					System.out.println("Introduce el nombre a buscar");
					lectura = new Scanner(System.in);
					nombre = lectura.nextLine();
					for (Empleados empleados : lista) {
						if (empleados.getNombre().toLowerCase().trim().equalsIgnoreCase(nombre.trim())) {
							System.out.println("Empleado encontrado...");
							System.out.println(empleados);
							break;
						}
					}
					
					
				}catch(Exception e) {
					System.out.println("No se encontró el nombre");
				}
				break;
				
				
			case 7:
				try {
					boolean empleadoEncontrado = false;
					System.out.println("Escribe el departamento a buscar");
					lectura = new Scanner(System.in);
					departamento = lectura.nextLine().trim();
					for (Empleados empleados :lista) {
						if (empleados.getDepartamento().toLowerCase().trim().equalsIgnoreCase(departamento.trim())){
							System.out.println("NumeroEmpleado: " + empleados.getNumEmpleado()
									+"\n Nombre: " + empleados.getNombre()
									+"\n Departamento: " + empleados.getDepartamento());
							empleadoEncontrado =true;
						}
						
					}
					if (!empleadoEncontrado) {
						System.out.println("No se encontró el departamento ingresado por usuario");
					}
					
				}catch(Exception e) {
					System.out.println("No se encontró el departamento");
				}
				
				break;
			case 8:
				System.out.println("Calculando el total a pagar de nómina");
				System.out.println("...");
				float totalNomina = 0;
				for (Empleados empleados : lista) {
					totalNomina += empleados.getSueldo();
				}
				System.out.println("Total de sueldo a pagar: " + totalNomina);
				break;
			case 9:
				try {
					List<Integer> numerosEmpleados = new ArrayList<Integer>();
					boolean empleadoEncontrado = false;
					System.out.println("Ingresa número de empleado a eliminar registro");
					lectura = new Scanner(System.in);
					numeroEmpleado = lectura.nextInt();
					for (Empleados empleados : lista) {
						numerosEmpleados.add(empleados.getNumEmpleado());
						if (empleados.getNumEmpleado() == numeroEmpleado) {
							empleadoEncontrado = true;
							indice = lista.indexOf(empleados);
							
							System.out.println("Empleado: " + empleados.getNombre() + " ha sido eliminado");
							lista.remove(indice);
							break;
						}
					}
					if (!empleadoEncontrado) {
						System.out.println("No fue encontrado empleado con ese numero de empleado");
						System.out.println("Estos son los números de empleados actuales: " + numerosEmpleados);
					}
					break;
				}catch (Exception e) {
					System.out.println("No se pudo eliminar registro");
				}
			case 10:
				System.out.println("Gracias por utilizar el programa. Sesión finalizada.");
				break;
			default:
				System.out.println("Opción inválida\n");
				break;
				
			}
		}while(menuPrincipal !=10 );
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
