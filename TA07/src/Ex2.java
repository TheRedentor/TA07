import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		
		//Declara las variables
		String price = "0";
		String product = "";
		ArrayList<Double> arrayPrices = new ArrayList<>();
		Hashtable<String, Double> products = new Hashtable<String, Double>();
		
		//Añade productos
		products.put("Merluza", 12.99);
		products.put("Chorizo", 5.45);
		products.put("Manzana", 0.5);
		products.put("Arroz", 0.3);
		products.put("Pechuga", 4.2);
		products.put("Jamón", 55.0);
		products.put("Huevos", 5.3);
		products.put("Pistachos", 2.1);
		products.put("Yogur", 0.45);
		products.put("Lasaña", 7.2);
		
		double totalPrice = 0;
		Scanner sc = new Scanner(System.in);
		
		while (product.isEmpty()) { //Mientras producto no sea vacío, sigue preguntando para registrar productos
			
			System.out.println("Producto:");
			product = sc.nextLine();
			
			if (products.containsKey(product)) { //Si el producto existe en productos, añade el precio al array de precios
				
				arrayPrices.add(products.get(product));
				
			}
			else if (product.isEmpty()) {
				break;
			}
			product = "";
			
		}
		
		System.out.println("Pagado:");
		String paid = sc.nextLine();
		System.out.println();
		
		if (arrayPrices.size() > 0) { //Si hay un producto o mas, muestra cada producto con sus precios
			
			for (int i = 0; i < arrayPrices.size(); i++) {
				
				totalPrice += arrayPrices.get(i);
				System.out.println("Producto " + (i+1) + " con 21% de IVA: " + (arrayPrices.get(i) + (arrayPrices.get(i)*0.21)) + "€");
				System.out.println("Producto " + (i+1) + " con 4% de IVA: " + (arrayPrices.get(i) + (arrayPrices.get(i)*0.04)) + "€");
				System.out.println();
				
			}
			
		}
		System.out.println("Precio total bruto: " + totalPrice + "€");
		System.out.println("Precio total con 21% de IVA: " + (totalPrice + (totalPrice*0.21)) + "€");
		System.out.println("Precio total con 4% de IVA: " + (totalPrice + (totalPrice*0.04)) + "€");
		System.out.println();
		System.out.println("Número de artículos: " + arrayPrices.size());
		System.out.println();
		System.out.println("Pagado: " + paid + "€");
		System.out.println();
		System.out.println("Cambio a devolver: " + (Double.parseDouble(paid) - totalPrice) + "€");
		totalPrice = 0; //Limpia el precio total y el array de precios
		arrayPrices.clear();

	}

}
