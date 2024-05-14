package ejertienda;

import java.util.Scanner;

/**
 *
 * @author Sebas y Johan
 */
public class EjerTienda {

    public static void main(String[] args) {
        int op;
        String nombre;
        int cantidad;
        Tienda tienda = new Tienda();

        Scanner sc = new Scanner(System.in);
        
        do
        {
            menu();
            System.out.print("Ingrese la opción que desea ejecutar: ");
            op = sc.nextInt();
            sc.nextLine();
      
            switch(op)
            {
                case 1:
                System.out.println("\n\n***********Ingresar Producto**********");
                    Producto p = crearProducto();
                    tienda.agregarProducto(p);
                    
                break;
                
                case 2:
                    System.out.println("\n\n***********Visualizar Productos**********");
                    tienda.visualizarInformacionProductos();
                break;
                
                case 3:
                    System.out.println("\n\n***********Vender Producto**********");
                    System.out.println("Escriba el producto que quiere vender: ");
                    nombre = sc.nextLine();
                    System.out.println("Escriba la cantidad que desea vender: ");
                    cantidad = sc.nextInt();
                    double venta = tienda.venderProducto(nombre, cantidad);
                    if (venta!=0 && venta!=-1){
                        System.out.println("El costo total de la venta es: $"+venta);
                    }else if (venta==0){
                        System.out.println("No se ha podido completar el proceso de venta, no hay Stock del producto");
                    }else{
                        System.out.println("No existe el producto");
                    }
                break;
                
                case 4:
                    System.out.println("\n\n***********Abastecer la tienda con un producto**********");
                    System.out.println("Escriba el producto que quiere reabastecer: ");
                    int abastecer;
                    nombre = sc.nextLine();
                    do{
                        System.out.println("Escriba la cantidad de unidades que de quiere reabastecer: ");
                        cantidad=sc.nextInt();
                    }while(cantidad<=0); 
                    abastecer=tienda.abastecerProducto(nombre, cantidad);
                    if (abastecer==0){
                        System.out.println("Se abasteció con éxito el producto: "+nombre);
                    }else if(abastecer==1){
                        System.out.println("No se abasteció debido a que existe suficiente stock de: "+nombre);
                    }else{
                        System.out.println("No existe el producto");
                    }
                break;
                
                case 5:
                    System.out.println("\n\n***********Cambiar Producto**********");
                    System.out.println("Escriba el producto que desea cambiar: ");
                    nombre =sc.nextLine();
                    System.out.println("***Nueva información de producto***");
                    Producto productoNuevo=crearProducto();
                    tienda.cambiarProducto(nombre, productoNuevo);
                break;
                
                case 6:
                    System.out.println("\n\n***********Calcular estadistica de ventas**********");
                    Producto productoMasVendido=tienda.retornarProductoMasVendido();
                    Producto productoMenosVendido=tienda.retornarProductoMenosVendido();
                    System.out.println("El producto más vendido es: "+productoMasVendido.getNombre());
                    System.out.println("El producto menos vendido es: "+productoMenosVendido.getNombre());
                    System.out.println("La cantidad total obtenida por las ventas de la tienda es: $ "+tienda.getCaja());
                    System.out.println("La cantidad de dinero promedio obtenido por unidad de producto vendida es: $ "+tienda.promedio());
                break;
                
                case 7:
                    System.out.println("Usted ha salido exitosamente!!");
                break;
                
                default :
                    System.out.println("Error, ingrese una opción del 1 al 7");
                    
                break;
                
            }
        }while (op!=7);
    }
    
    public static void menu(){
        System.out.println("\n\n***********TIENDA PLUS**********");
            System.out.println("1.Ingresar Producto");
            System.out.println("2.Visualizar la información de los productos");
            System.out.println("3.Vender un producto");
            System.out.println("4.Abastecer la tienda con un producto");
            System.out.println("5.Cambiar un producto");
            System.out.println("6.Calcular estadísticas de ventas");
            System.out.println("7.Salir");
    }
    
    public static Producto crearProducto(){
        String nombre;
        Tipo tipo=null;
        int stock;
        int cantidadMinima;
        int precio;
        boolean aux;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Ingrese los datos del producto");
        System.out.print("Ingrese el nombre del producto: ");
        nombre = scan.nextLine();
        do{
            System.out.println("Ingrese el tipo de producto - PAPELERIA, SUPERMERCADO, DROGUERIA");
            try{
                tipo=Tipo.valueOf(scan.nextLine());
                aux=true;
            }catch(Exception e){
                aux=false;
            }
        }while(!aux);
        System.out.print("Ingrese el stock del producto: ");
        stock = scan.nextInt();
        System.out.print("Ingrese la cantidad mínima del producto: ");
        cantidadMinima = scan.nextInt();
        System.out.print("Ingrese el precio del producto: $");
        precio = scan.nextInt();
        scan.nextLine();
        Producto p = new Producto(nombre, tipo, stock, cantidadMinima, precio);
        return p;
    }
}
