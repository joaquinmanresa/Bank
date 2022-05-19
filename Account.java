import java.util.Scanner;

public class Account {
	
	// Variables de clase
	int balance;
	int transaccionPrevia;
	String nombreCliente;
	String IDcliente;
	
	// Constructor de clase
	Account(String cnombre, String cid) {
		nombreCliente = cnombre;
		IDcliente = cid;
	}
	
	// Funcion para depositar dinero
	void deposito(int cantidad) {
		if (cantidad != 0) {
			balance = balance + cantidad;
			transaccionPrevia = cantidad;
		}
	}
	
	// Funcion para retiro de dinero
	void retiro(int cantidad) {
		if (cantidad != 0) {
			balance = balance - cantidad;
			transaccionPrevia = - cantidad;
		}
	}
	
	// funcion para la transaccion previa
	void transaccionPrevia() {
		if (transaccionPrevia > 0) {
			System.out.println("Depositado: " + transaccionPrevia);
		} else if (transaccionPrevia < 0) {
			System.out.println("Retiro: " + Math.abs(transaccionPrevia));
		} else {
			System.out.println("No ha habido transacciones.");
		}		
	}
	
	// funcion que calcula el interes de los fondos a partir de una cantidad de años
	void calculoInteres(int años) {
		double porcentajeInteres = 0.39;
		double nuevoBalance = (balance * porcentajeInteres * años) + balance;
		System.out.println("El porcentaje de interes es: " + (100 * porcentajeInteres) + "%");
		System.out.println("Luego de " + años + " años su balance sera de: " + nuevoBalance); 
	}
	
	void showMenu() {
		char opcion = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bienvenido, " + nombreCliente + "!");
		System.out.println("Tu id es: " + IDcliente);
		System.out.println();
		System.out.println("¿Que desearia hacer? ");
		System.out.println();
		System.out.println("A. Chequear su balance total");
		System.out.println("B. Realizar un deposito");
		System.out.println("C. Realizar un retiro");
		System.out.println("D. Ver historial de transacciones");
		System.out.println("E. Clacular interes");
		System.err.println("F. Salir");
		
		do {
			System.out.println();
			System.out.println("Ingresar una opcion: ");
			char opcion1 = scanner.next().charAt(0);
			opcion = Character.toUpperCase(opcion1);
			System.out.println();
			
			switch(opcion) {
			// Caso 'A' permite al usuario chequear su balance total
			case 'A':
				System.out.println("==================================");
				System.out.println("Balance = $" + balance);
				System.out.println("==================================");
				System.out.println();
				break;
			// Caso 'B' permite al usuario depositar dinero
			case 'B':
				System.out.println("Ingresar una cantidad a depositar: ");
				int cantidad = scanner.nextInt();
				deposito(cantidad);
				System.out.println();
				break;
			// caso 'C' permite al usuario retirar dinero
			case 'C':
				System.out.println("Ingrese la cantidad a retirar: ");
				int cantidad2 = scanner.nextInt();
				retiro(cantidad2);
				System.out.println();
				break;
			// caso 'D' permite al usuario ver sus trnasacciones recientes
			case 'D':
				System.out.println("==================================");
				transaccionPrevia();
				System.out.println("==================================");
				System.out.println();
				break;
			// caso 'E' calcular el interes
			case 'E':
				System.out.println("Ingrese la cantidad de años de interes: ");
				int años = scanner.nextInt();
				calculoInteres(años);
				break;
			// caso 'F' el usuario decide salir
			case 'F': 
				System.out.println("==================================");
				break;
			// default, cuando la entrada es invalida
			default:
				System.out.println("Error: opcion invalida. Por favor ingrese A, B, C, D, E, F");
				break;
			}
		} while(opcion != 'F');
		System.out.println("Gracias por operar con nosotros!");
		
	}
}
