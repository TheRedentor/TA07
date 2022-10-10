
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		
		//Declarar variables
		ArrayList<Double> arrayNotas = new ArrayList<>();
		int student = 1;
		String nota = "0";
		String register = "SI";
		Hashtable<String, Double> students = new Hashtable<String, Double>();
		Scanner sc = new Scanner(System.in);
		
		//Mientras quieras registrar un alumno...
		while (register.equals("SI")) {
			
			nota = "0";
			arrayNotas.clear();
			System.out.println("¿Quieres registrar otro alumno?");
			register = sc.nextLine().toUpperCase();
			
			if (!register.equals("SI")) { //Si no quieres registrar mas, sale del programa
				
				break;
				
			}
			
			System.out.println("Alumno " + student + ":");
			
			while (Double.parseDouble(nota) >= 0) { //Mientras la nota sea 0 o mayor, sigue preguntando notas
				
				System.out.println("Introduce una nota:");
				nota = sc.nextLine();
				
				try {
					
					if (Double.parseDouble(nota) >= 0 && Double.parseDouble(nota) <= 10) { //Si la nota está entre 0 y 10, la añade al array de notas, sino sal del bucle
						
						arrayNotas.add(Double.parseDouble(nota));
						
					}
					else {
						
						nota = "-1";
						
					}
					
				}
				
				catch (Exception e) {
					
					nota = "-1";
					
				}
				
			}
			
			students.put(String.valueOf(student), CalcularMedia(arrayNotas)); //Añade el alumno y su media al hashtable
			student++; //Pasa al siguiente alumno
			
		}
		
		for (int i = 1; i <= students.size(); i++) { //Muestra cada alumno y su nota
			
			System.out.println("Media del alumno " + i + ": " + students.get(String.valueOf(i)));
			
		}

	}
	
	public static double CalcularMedia(ArrayList<Double> arrayNotas) {
		
		double notaMedia = 0;
		
		for (int i = 0; i <= (arrayNotas.size() - 1); i++) { //Recorre el array de notas del alumno y suma todas las notas
			
			notaMedia += arrayNotas.get(i);
			
		}
		
		notaMedia = notaMedia / arrayNotas.size(); //Divide la suma entre el número de notas
		
		return notaMedia;
		
	}

}
