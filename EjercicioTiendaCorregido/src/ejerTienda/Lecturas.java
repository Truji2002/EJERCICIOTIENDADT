package ejertienda;

import java.util.Scanner;

/**
 *
 * @author Sebas y Johan
 */
public class Lecturas {
  
        
    public static int leerEntero(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        int numero = sc.nextInt();
        sc.close();
        return numero;
    }

    public static double leerDouble(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        double numero = sc.nextDouble();
        sc.close();
        return numero;
    }

    public static float leerFloat(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        float numero = sc.nextFloat();
        sc.close();
        return numero;
    }
    
    public static String leerTexto(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        String texto = sc.nextLine();
        sc.close();
        return texto;
    }
        
    public static String leerPalabra(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        String palabra = sc.next();
        sc.close();
        return palabra;
    }
        
    
    public static int leerEnteroMayorQue(String mensaje, int minimo){
        Scanner sc = new Scanner(System.in);
        int numero;
        do{
            System.out.println(mensaje);
            numero = sc.nextInt();
        }while(numero<minimo);
        sc.close();
        return numero;
    }
    
    public static double leerDoubleMayorQue(String mensaje, double minimo){
        Scanner sc = new Scanner(System.in);
        double numero;
        do{
            System.out.println(mensaje);
            numero = sc.nextDouble();
        }while(numero<minimo);
        sc.close();
        return numero;
    }
    
    public static float leerFloatMayorQue(String mensaje, float minimo){
        Scanner sc = new Scanner(System.in);
        float numero;
        do{
            System.out.println(mensaje);
            numero = sc.nextFloat();
        }while(numero<minimo);
        sc.close();
        return numero;
    }
    
    public static int leerEnteroMenorQue(String mensaje, int maximo){
        Scanner sc = new Scanner(System.in);
        int numero;
        do{
            System.out.println(mensaje);
            numero = sc.nextInt();
        }while(numero>maximo);
        sc.close();
        return numero;
    }
    
    public static double leerDoubleMenorQue(String mensaje, double maximo){
        Scanner sc = new Scanner(System.in);
        double numero;
        do{
            System.out.println(mensaje);
            numero = sc.nextDouble();
        }while(numero>maximo);
        sc.close();
        return numero;
    }
    
    public static float leerFloatMenorQue(String mensaje, float maximo){
        Scanner sc = new Scanner(System.in);
        float numero;
        do{
            System.out.println(mensaje);
            numero = sc.nextFloat();
        }while(numero>maximo);
        sc.close();
        return numero;
    }
    
    public static int leerEnteroEntre(String mensaje, int rangoMinimo, int rangoMaximo){
        Scanner sc = new Scanner(System.in);
        int numero;
        do{
            System.out.println(mensaje);
            numero = sc.nextInt();
        }while(numero<rangoMinimo&&numero>rangoMaximo);
        sc.close();
        return numero;
    }
    
    public static double leerDoubleEntre(String mensaje, double rangoMinimo, double rangoMaximo){
        Scanner sc = new Scanner(System.in);
        double numero;
        do{
            System.out.println(mensaje);
            numero = sc.nextDouble();
        }while(numero<rangoMinimo&&numero>rangoMaximo);
        sc.close();
        return numero;
    }
    
    public static float leerFloatEntre(String mensaje, float rangoMinimo, float rangoMaximo){
        Scanner sc = new Scanner(System.in);
        float numero;
        do{
            System.out.println(mensaje);
            numero = sc.nextFloat();
        }while(numero<rangoMinimo&&numero>rangoMaximo);
        sc.close();
        return numero;
    }
    
}
