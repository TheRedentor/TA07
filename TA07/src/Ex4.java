import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		
		//Declara las variables
		double totalPrice = 0;
		String productPrice = "0";
		String productName = "";
		ArrayList<Double> arrayPrices = new ArrayList<>();
		
		int metodo = -1;
		Scanner sc = new Scanner(System.in);
		Hashtable<String, Double> products = new Hashtable<String, Double>();
		Hashtable<Hashtable<String, Double>, Integer> stocks = new Hashtable<Hashtable<String, Double>, Integer>();
		
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
		
		//Por cada producto del hashtable, crea y guarda un nuevo producto con el mismo nombre y precio que añadimos al hashtable stocks junto con su stock
		products.forEach((name, price) -> {
			Hashtable<String, Double> product = new Hashtable<String, Double>();
			product.put(name, price);
			stocks.put(product, 10);
		});
		
		while (metodo != 0) { //Mientras el método no sea 0, sigue preguntando
			System.out.println("1. Añadir producto, 2. Mostrar un producto, 3. Mostrar todos los productos, 4. Comprar productos");
			metodo = Integer.parseInt(sc.nextLine());
			while (metodo < 1 || metodo > 4) {
				if (metodo == 0) {
					break;
				}
				System.out.println("1. Añadir producto, 2. Mostrar un producto, 3. Mostrar todos los productos, 4. Comprar productos");
				metodo = Integer.parseInt(sc.nextLine());
			}
			
			if (metodo == 1) {
				System.out.println("Nombre del producto:");
				String name = sc.nextLine();
				System.out.println("Precio del producto:");
				double price = Double.parseDouble(sc.nextLine());
				System.out.println("Stock del producto:");
				int stock = Integer.parseInt(sc.nextLine());
				
				products.put(name, price); //Añadimos el nuevo producto al hashtable de productos
				Hashtable<String, Double> product = new Hashtable<String, Double>(); //Creamos un hashtable producto que usaremos para tener el producto que hemos añadido recientemente
				product.put(name, price); //Añadimos el producto
				stocks.put(product, stock); //Añadimos el producto junto con su stock al hashtable de stocks
			}
			
			if (metodo == 2) {
				System.out.println("Nombre del producto:");
				String name = sc.nextLine();
				double price = products.get(name); //Coge el precio del producto
				products.forEach((n, p) -> { //Recorre todos los productos
					if (n.equals(name) && p.equals(price)) { //Si el nombre y el precio del objeto es el mismo que el nombre y el precio del objeto que queremos mostrar
						Hashtable<String, Double> product = new Hashtable<String, Double>(); //Creamos un hashtable producto que usaremos para tener el producto que queremos mostrar
						product.put(name, price); //Añadimos el producto
						System.out.println("Nombre: " + name);
						System.out.println("Precio: " + price);
						System.out.println("Stock: " + stocks.get(product)); //Cogemos el stock del producto mediante el hashtable de stocks
					}
				});
			}
			
			if (metodo == 3) {
				System.out.println(stocks.toString()); //Nos muestra los productos con su respectivo stock
			}
			
			if (metodo == 4) {
				while (productName.isEmpty()) { //Mientras producto no sea vacío, sigue preguntando para registrar productos
					
					System.out.println("Producto:");
					productName = sc.nextLine();
					
					if (products.containsKey(productName)) { //Si el producto existe en productos, añade el precio al array de precios
						
						arrayPrices.add(products.get(productName));
						Hashtable<String, Double> product = new Hashtable<String, Double>();
						product.put(productName, products.get(productName));
						stocks.forEach((h, s) -> {
							if (h.equals(product)) {
								int numStock = stocks.get(h);
								numStock--;
								stocks.replace(h, numStock);
							}
						});
						
					}
					else if (productName.isEmpty()) {
						break;
					}
					productName = "";
					
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
		
	}
		
}
