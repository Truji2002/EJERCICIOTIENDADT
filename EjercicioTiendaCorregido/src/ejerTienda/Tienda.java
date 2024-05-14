package ejertienda;

/**
 *
 * @author Sebas y Johan
 */
public class Tienda {
    private Producto productos[];
    private double caja;
    /*private int cont;*/
    
    public Tienda(){
        /* Si mis atributos son objetos o arreglos de objetos INICIALIZAR en el contructor*/
        productos = new Producto[1000];
        caja=0;
        /*cont=0;*/
    }
  
    public double getCaja() {
        return caja;
    }   

    
    public Producto[] getProductos() {
        return productos;
    }
    
    public boolean agregarProducto(Producto producto){
        /*if(cont<100){
            productos[cont]=producto;
            cont++;
            return true;
        }
        else{
            return false;
        }*/ 
        
        /* Si no tengo contador - Mejor Solucion*/
        for (int i=0; i<100; i++) {
            if(productos[i]==null){
                productos[i]=producto;
                return true;
            }
        }
        return false; 
    }
    
    public void visualizarInformacionProductos(){
        int cont=1;
        for(int i=0; i<productos.length;i++){
            if (productos[i] != null){
                System.out.println("*************Producto #"+cont+"***************");
                System.out.println("Nombre: "+productos[i].getNombre());
                System.out.println("Tipo: "+productos[i].getTipo());
                System.out.println("Cantidad minima: "+productos[i].getCantidadMinima());
                System.out.println("Stock: "+productos[i].getStock());
                System.out.println("Precio: "+productos[i].getPrecio());
                System.out.println("IVA: "+Producto.getIVA());
                System.out.println("Cantidad de productos vendidos: "+productos[i].getCantidadVendida());
                System.out.println("\n");
                cont++;
            }   
        }
    }
    
    public double venderProducto(String nombre, int cantidad){
        Producto p = buscarProducto(nombre);
        double venta = 0.0;
        if(p!=null){
            venta = p.vender(cantidad);
            if(venta != 0){
                caja+=venta;
            }     
        }else{
            venta=-1;
        }
        return venta;
    }
    
    public Producto buscarProducto(String nombre){
        for(int i=0; i<productos.length;i++){
            if (productos[i] != null){
                if(productos[i].getNombre().equals(nombre)){ //Se puede usar == pero no es apropiado
                    return productos[i];
                }
            }
        }
        return null;
    }
    
    public int abastecerProducto(String nombre, int cantidad){
        Producto p = buscarProducto(nombre);
        if(p!=null){
            if (p.puedeAbastecer()){
                p.abastecer(cantidad);
                return 0;
            }else{
                return 1;
            }
        }else
        return 2;
    }
    
    public void cambiarProducto(String nombre, Producto producto){
        Producto p = buscarProducto(nombre);
        if (p!=null){
            p.setNombre(producto.getNombre());
            p.setTipo(producto.getTipo());
            p.setStock(producto.getStock());
            p.setCantidadMinima(producto.getCantidadMinima());
            p.setPrecio(producto.getPrecio());
        }else{
            System.out.println("Producto no existe"); 
        }
    }
    
    public Producto retornarProductoMasVendido(){
        int cantidadMasVendida=0;
        int posicionMasVendido=0;
        Producto p = null;
        for(int i=0; i<productos.length;i++){
            if(productos[i]!=null){
                if(productos[i].getCantidadVendida()>cantidadMasVendida){
                    cantidadMasVendida=productos[i].getCantidadVendida();
                    posicionMasVendido=i;
                    p = productos[posicionMasVendido];
                }
            }
        }
        return p;
    }
    
    public Producto retornarProductoMenosVendido(){
        int cantidadMenosVendido=9999;
        int posicionMenosVendido=0;
        Producto p = null;
        for(int i=0; i<productos.length;i++){
            if(productos[i]!=null){
                if(productos[i].getCantidadVendida()<cantidadMenosVendido){
                    cantidadMenosVendido=productos[i].getCantidadVendida();
                    posicionMenosVendido=i;
                    p = productos[posicionMenosVendido];
                }
            }
        }
        return p;
    }
    
    public int calcularTotalProductosVendidos(){
        int suma=0;
        for(int i=0; i<productos.length;i++){
            if(productos[i]!=null){
                suma=suma+productos[i].getCantidadVendida();
            }
        }
        return suma;
    }
    
    public double promedio(){
        return (caja/calcularTotalProductosVendidos()); 
    }
}
