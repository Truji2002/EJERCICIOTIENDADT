package ejertienda;

/**
 *
 * @author Sebas y Johan
 */
public class Producto {
    private String nombre;
    private Tipo tipo;
    private int stock;
    private int cantidadMinima;
    private int cantidadVendida;
    private double precio;
    private static final double IVA = 0.12;  

    public Producto(String nombre, Tipo tipo, int stock, int cantidadMinima, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.stock = stock;
        this.cantidadMinima = cantidadMinima;
        this.precio = precio;
        cantidadVendida = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public int getStock() {
        return stock;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public double getPrecio() {
        return precio;
    }

    public static double getIVA() {
        return IVA;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public double vender(int cantidad){
        if(stock >= cantidad){
            stock-=cantidad;
            cantidadVendida+=cantidad;
            return (cantidad*precio)*(1+IVA);
        }
        return 0;
    }
    
    public boolean puedeAbastecer(){
        if(stock<cantidadMinima){
            return true;
        }else{
            return false;
        }
    }
    
    public void abastecer(int cantidad){
        stock+=cantidad;
    }                
}
