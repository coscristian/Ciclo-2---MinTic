package com.cristian.desarrollo.aplicacion;

// Imports
import java.util.ArrayList;
import java.util.List;
import com.cristian.desarrollo.modelos.*;
import java.util.Scanner;

public class Aplicacion {
	
    public static Scanner teclado;
    
    // Constantes menu principal
    public static final int GESTION_CLIENTES = 1;
    public static final int GESTION_PROVEEDORES = 2;
    public static final int GESTION_PRODUCTOS = 3;
    public static final int GESTION_FACTURACION = 4;
    public static final Integer SALIR = 0;
    
    // Constantes submenu
    public static final int CREAR = 1;
    public static final int BUSCAR = 2;
    public static final int ACTUALIZAR = 3;
    public static final int ELIMINAR = 4;
    
    
    public static void main(String[] args) {
        teclado = new Scanner(System.in);
        
        List<Cliente> clientes = new ArrayList<>();
        List<Proveedor> proveedores = new ArrayList<>();
        List<Producto> productos = new ArrayList<>();
        List<Factura> facturas = new ArrayList<>();
        Cliente cliente;
        Proveedor proveedor;
        
        Integer opcion, opcionSubmenu;
        do {
        	do {
            	mostrarMenuPrincipal();
        		opcion = capturarNumeroEntero("Seleccione una opción: ");
        		if (opcion < SALIR || opcion > GESTION_FACTURACION) {
        			System.out.println("MENSAJE: Debe digitar un valor entre 0 y 4.");
        		}
			}while (opcion < SALIR || opcion > GESTION_FACTURACION);
        	
        	if(opcion == 0) {
        		break;
        	}
        	
        	switch (opcion) {
				case GESTION_CLIENTES:
					do {
						mostrarSubmenu("Clientes");
						opcionSubmenu = capturarNumeroEntero("Seleccione una opción: ");
						
						if (opcionSubmenu < SALIR || opcionSubmenu > ELIMINAR) {
							System.out.println("MENSAJE: Debe digitar un valor entre 0 y 4.");
						}						
					} while (opcionSubmenu < SALIR || opcionSubmenu > ELIMINAR);
					
					if (opcionSubmenu == 0) {
						break;
					}
					
					switch (opcionSubmenu) {
						case CREAR:				
							cliente = crearCliente(clientes);
							clientes.add(cliente);
							break;
						case BUSCAR:
							cliente = buscarCliente(clientes);
							if (cliente != null) {
								mostrarDatosCliente(cliente);
							}else {
								System.out.println("No se ha encontrado un cliente con el número de cédula especificado");
							}
							break;
						case ACTUALIZAR:
							cliente = buscarCliente(clientes);
							if (cliente != null) {
								actualizarCliente(cliente);
							}else {
								System.out.println("No se ha encontrado un cliente con el número de cédula especificado");
							}
							break;
						case ELIMINAR:
							eliminarCliente(clientes, facturas);
							break;
	
						default:
							break;
					}
					
					break;
				case GESTION_PROVEEDORES:
					do {
						mostrarSubmenu("Proveedores");
						opcionSubmenu = capturarNumeroEntero("Seleccione una opción: ");
						
						if (opcionSubmenu < SALIR || opcionSubmenu > ELIMINAR) {
							System.out.println("MENSAJE: Debe digitar un valor entre 0 y 4.");
						}						
					} while (opcionSubmenu < SALIR || opcionSubmenu > ELIMINAR);
					
					if (opcionSubmenu == 0) {
						break;
					}
					
					switch (opcionSubmenu) {
						case CREAR:				
							// Crear Proveedor
							proveedor = crearProveedor(proveedores);
							proveedores.add(proveedor);
							break;
						case BUSCAR:
							// Buscar Proveedor
							proveedor = buscarProveedor(proveedores);
							if(proveedor != null){
								mostrarDatosProveedor(proveedor);
							}else {
								System.out.println("MENSAJE: No se ha encontrado un proveedor con el número de ID especificado");
							}							
							break;
						case ACTUALIZAR:
							// Actualizar Proveedor
							proveedor = buscarProveedor(proveedores);
							if(proveedor != null) {
								actualizarProveedor(proveedor);
								mostrarDatosProveedor(proveedor);
							}else {
								System.out.println("MENSAJE: No se ha encontrado un proveedor con el número de ID especificado");
							}
							break;
						case ELIMINAR:
							// Eliminar Proveedor
							break;
	
						default:
							break;
					}					
					break;
				case GESTION_PRODUCTOS:
					
					break;
				case GESTION_FACTURACION:
					
					break;
	
				default:
					break;
			}
        }while(opcion != SALIR);
        
    }
    
    private static void actualizarProveedor(Proveedor proveedor) {
    	
    	System.out.println("--- 3. Actualizar Proveedor ---");
    	String nombre, direccion, opcion;
    	Integer telefono;
    	
    	// Nombres del cliente
    	do {
    		opcion = capturarCadenaCaracteres("¿Desea modificar los nombres del proveedor? (Y/N)");
    	}while(!(opcion.equalsIgnoreCase("Y") || opcion.equalsIgnoreCase("N")));
    	
    	if (opcion.equalsIgnoreCase("Y")) {
    		nombre = capturarCadenaCaracteres("Digite los nuevos nombres del proveedor");	
    		proveedor.setNombre(nombre);
    	}
    	    	
    	// Telefono del cliente
    	do {
    		opcion = capturarCadenaCaracteres("¿Desea modificar el telefono del proveedor? (Y/N)");
    	}while(!(opcion.equalsIgnoreCase("Y") || opcion.equalsIgnoreCase("N")));
    	
    	if(opcion.equalsIgnoreCase("Y")) {
			do {
				telefono = capturarNumeroEntero("Digite el nuevo número de telefono del proveedor");
				if(telefono <= 0) {
					System.out.println("MENSAJE: El número de telefono debe ser un valor positivo");
				}
			}while(telefono <= 0);
			proveedor.setTelefono(String.valueOf(telefono));
    	}
    	
    	// Dirección del cliente
    	do {
    		opcion = capturarCadenaCaracteres("¿Desea modificar la dirección del proveedor? (Y/N)");
    	}while(!(opcion.equalsIgnoreCase("Y") || opcion.equalsIgnoreCase("N")));

    	if (opcion.equalsIgnoreCase("Y")) {
    		direccion = capturarCadenaCaracteres("Digite la nueva dirección del proveedor");
    		proveedor.setDireccion(direccion);
    	}
    }
    
    private static void mostrarDatosProveedor(Proveedor proveedor) {
    	System.out.println("Datos del Proveedor");
    	System.out.println("\tCédula: \t" + proveedor.getId());
    	System.out.println("\tNombres: \t" + proveedor.getNombre());
    	System.out.println("\tTelefono: \t" + proveedor.getTelefono());
    	System.out.println("\tDirección: \t" + proveedor.getDireccion());
	}

	private static Proveedor buscarProveedor(List<Proveedor> proveedores) {
		Integer numId;
    	
    	do {
			numId = capturarNumeroEntero("Digite el número de ID del proveedor a buscar");
			if(numId <= 0){
				System.out.println("MENSAJE: El número de ID debe ser un número entero positivo");
				numId = 0;			
			}			
		} while (numId <= 0);
    	return buscarProveedorPorId(proveedores, String.valueOf(numId)); // Si proveedor es null es porque no existe un proveedor con el id ingresada
	}

	private static Proveedor crearProveedor(List<Proveedor> proveedores) {

		System.out.println("--- 1. Crear Proveedor ---");
		Integer numId, telefono;
		String nombres, direccion;
		Proveedor proveedor;
		do {
			numId = capturarNumeroEntero("Digite el número de ID del proveedor nuevo");
			if(numId <= 0){
				System.out.println("MENSAJE: El número de ID debe ser un número entero positivo");
				numId = 0;
				continue;
			}
			proveedor = buscarProveedorPorId(proveedores, String.valueOf(numId)); // Si proveedor es null es porque no existe un proveedor con el id ingresada
			
			if(proveedor != null) {  
				System.out.printf("MENSAJE: Ya existe otro proveedor con el número de ID: %s.\n", String.valueOf(numId));
				numId = 0;
			}
		} while (numId <= 0);
		
		nombres = capturarCadenaCaracteres("Digite los nombres del proveedor nuevo");

		do {
			telefono = capturarNumeroEntero("Digite el número de telefono del proveedor nuevo");
			if(telefono <= 0) {
				System.out.println("MENSAJE: El número de telefono debe ser un valor positivo");
			}
		}while(telefono <= 0);
		
		direccion = capturarCadenaCaracteres("Digite la direccion del cliente nuevo");
		
		return new Proveedor(numId, nombres, String.valueOf(telefono), direccion);
	}

	private static Proveedor buscarProveedorPorId(List<Proveedor> proveedores, String id) {
		for (Proveedor proveedor : proveedores) {
			if(proveedor.getId().equals(id)) return proveedor;
		}
		return null;
	}

	private static void eliminarCliente(List<Cliente> clientes, List<Factura> facturas) {
    	Cliente cliente = buscarCliente(clientes);
    	if (cliente != null) {
    		// El cliente existe, debo verificar que no tenga facturas 
    		Factura factura = buscarFacturaPorCedula(facturas, cliente.getCedula());
    		if(factura == null) {
    			clientes.remove(cliente);
    			System.out.println("MENSAJE: El cliente fue eliminado del sistema correctamente.");
    		}else {
    			System.out.println("MENSAJE: El cliente tiene al menos una factura por lo tanto no es posible eliminarlo.");
    		}
    	}else {
    		System.out.println("MENSAJE: El cliente con la cédula ingresada no existe.");
    	}
    }
    
    private static Factura buscarFacturaPorCedula(List<Factura> facturas, String cedula) {
    	for (Factura factura : facturas) {
			if (factura.getCedulaCliente().equals(cedula)) return factura;
		}
    	return null;
    }
    
    private static void actualizarCliente(Cliente cliente) {
    	
    	System.out.println("--- 3. Actualizar  Cliente ---");
    	String nombre, apellido, direccion, correoElectronico, opcion;
    	Integer telefono;
    	
    	// Nombres del cliente
    	do {
    		opcion = capturarCadenaCaracteres("¿Desea modificar los nombres del cliente? (Y/N)");
    	}while(!(opcion.equalsIgnoreCase("Y") || opcion.equalsIgnoreCase("N")));
    	
    	if (opcion.equalsIgnoreCase("Y")) {
    		nombre = capturarCadenaCaracteres("Digite los nuevos nombres del cliente");	
    		cliente.setNombre(nombre);
    	}
    	
    	// Apellidos del cliente
    	do {
    		opcion = capturarCadenaCaracteres("¿Desea modificar los apellidos del cliente? (Y/N)");
    	}while(!(opcion.equalsIgnoreCase("Y") || opcion.equalsIgnoreCase("N")));
    	
    	if (opcion.equalsIgnoreCase("Y")) {
    		apellido = capturarCadenaCaracteres("Digite los nuevos apellidos del cliente");
    		cliente.setApellido(apellido);
    	}
    	
    	// Telefono del cliente
    	do {
    		opcion = capturarCadenaCaracteres("¿Desea modificar el telefono del cliente? (Y/N)");
    	}while(!(opcion.equalsIgnoreCase("Y") || opcion.equalsIgnoreCase("N")));
    	
    	if(opcion.equalsIgnoreCase("Y")) {
			do {
				telefono = capturarNumeroEntero("Digite el nuevo número de telefono del cliente");
				if(telefono <= 0) {
					System.out.println("MENSAJE: El número de telefono debe ser un valor positivo");
				}
			}while(telefono <= 0);
			cliente.setTelefono(String.valueOf(telefono));
    	}
    	
    	// Dirección del cliente
    	do {
    		opcion = capturarCadenaCaracteres("¿Desea modificar la dirección del cliente? (Y/N)");
    	}while(!(opcion.equalsIgnoreCase("Y") || opcion.equalsIgnoreCase("N")));

    	if (opcion.equalsIgnoreCase("Y")) {
    		direccion = capturarCadenaCaracteres("Digite la nueva dirección del cliente");
    		cliente.setDireccion(direccion);
    	}
		
    	// Correo del cliente
    	do {
    		opcion = capturarCadenaCaracteres("¿Desea modificar el correo del cliente? (Y/N)");
    	}while(!(opcion.equalsIgnoreCase("Y") || opcion.equalsIgnoreCase("N")));
    	
    	if (opcion.equalsIgnoreCase("Y")) {
    		correoElectronico = capturarCadenaCaracteres("Digite el nuevo correo E del cliente");
    		cliente.setCorreoElectronico(correoElectronico);
    	}
    }
    
    private static void mostrarDatosCliente(Cliente cliente) {
    	System.out.println("Datos del Cliente");
    	System.out.println("Cédula: " + cliente.getCedula());
    	System.out.println("Nombres: " + cliente.getNombre());
    	System.out.println("Apellidos: " + cliente.getApellido());
    	System.out.println("Telefono: " + cliente.getTelefono());
    	System.out.println("Dirección: " + cliente.getDireccion());
    	System.out.println("Correo electrónico: " + cliente.getCorreoElectronico());
    }
    
    private static Cliente buscarCliente(List<Cliente> clientes) {
    	Integer numeroCedula;
    	String cedula;
    	
		do {
			numeroCedula = capturarNumeroEntero("Digite la cedula del cliente a buscar");
			if(numeroCedula <= 0){
				System.out.println("MENSAJE: La cédula debe ser un número entero positivo");
				numeroCedula = 0;
			}
		} while (numeroCedula <= 0);
		
		cedula = String.valueOf(numeroCedula);
		return buscarClientePorCedula(clientes, cedula); // Si cliente es null es porque no existe un cliente con la cedula ingresada
    }
    
    private static Cliente crearCliente(List<Cliente> clientes) {
		System.out.println("--- 1. Crear Cliente ---");
		Integer numeroCedula, telefono;
		String cedula = "", nombres, apellidos, direccion, correoElectronico;
		Cliente cliente;
		do {
			numeroCedula = capturarNumeroEntero("Digite la cedula del cliente nuevo");
			if(numeroCedula <= 0){
				System.out.println("MENSAJE: La cédula debe ser un número entero positivo");
				numeroCedula = 0;
				continue;
			}
			
			cedula = String.valueOf(numeroCedula);
			cliente = buscarClientePorCedula(clientes, cedula); // Si cliente es null es porque no existe un cliente con la cedula ingresada
			
			if(cliente != null) {  
				System.out.printf("MENSAJE: Ya existe otro cliente con el número de cédula: %s.\n", cedula);
				numeroCedula = 0;
			}
		} while (numeroCedula <= 0);
		
		nombres = capturarCadenaCaracteres("Digite los nombres del cliente nuevo");
		apellidos = capturarCadenaCaracteres("Digite los apellidos del cliente nuevo");
		do {
			telefono = capturarNumeroEntero("Digite el número de telefono del cliente nuevo");
			if(telefono <= 0) {
				System.out.println("MENSAJE: El número de telefono debe ser un valor positivo");
			}
		}while(telefono <= 0);
		
		direccion = capturarCadenaCaracteres("Digite la direccion del cliente nuevo");
		while(true) {
			correoElectronico = capturarCadenaCaracteres("Digite el correo del cliente nuevo");
			if (!correoElectronicoValido(correoElectronico)) {
				System.out.println("MENSAJE: Valor ingresado no valido");
				continue;
			}
			break;
		}
		
		cliente = new Cliente(cedula, nombres, apellidos, String.valueOf(telefono), direccion, correoElectronico);
		return cliente;
	}
    
    private static Cliente buscarClientePorCedula(List<Cliente> clientes, String cedula) {
    	for (Cliente cliente : clientes) {
			if(cliente.getCedula().equals(cedula)) {
				return cliente;
			}
		}
    	return null;
    }

	public static void mostrarMenuPrincipal() {
    	System.out.println("=== MENU PRINCIPAL ===");
    	System.out.println("1. Gestión Clientes");
    	System.out.println("2. Gestión Proveedores");
    	System.out.println("3. Gestión Productos");
    	System.out.println("4. Gestión Facturación");
    	System.out.println("0. Salir");
    }
    
    public static void mostrarSubmenu(String tipoMenu) {
		System.out.printf("*** Menú Gestión %s ***\n", tipoMenu);
		System.out.println("1. Crear");
		System.out.println("2. Buscar");
		System.out.println("3. Actualizar");
		System.out.println("4. Eliminar");
		System.out.println("0. Salir");
	}
    
    public static void mostrarMenuFacturacion() {
    	System.out.printf("*** Menú Gestión Facturación ***");
    	System.out.println("1. Crear");
    	System.out.println("2. Buscar");
    	System.out.println("0. Salir");
	}
    
    public static String capturarCadenaCaracteres(String mensaje) {
    	String resultado;
    	
    	while(true) {
    		// Strip quita los espacios al inicio y al final de la cadena
    		System.out.printf("%s: ", mensaje);
    		resultado = teclado.nextLine().strip();
    		if(!resultado.isEmpty()) {
    			return resultado;
    		}
			System.out.println("MENSAJE: Ha escrito una cadena vacía, especifique un valor concreto.");
    	}
    }

    public static Integer capturarNumeroEntero(String mensaje){
        while(true){
            try {
                System.out.printf("%s: ", mensaje);
                return Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("MENSAJE: Digite un valor que corresponda a un numero entero.");
            }
        }
    }
    
    public static Double capturarNumeroReal(String mensaje){
        while(true){
            try {
                System.out.printf("%s: ", mensaje);
                return Double.parseDouble(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("MENSAJE: Digite un valor que corresponda a un numero decimal.");
            }
        }
    }
    
    static boolean correoElectronicoValido(String correo) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return correo.matches(regex);
     }
}
