
import java.io.Console;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
/**
 * Created by erickchali on 2/22/14.
 */
/*
*
*
*
*
*
*
*
*
* */
public class Arranque_201314457 {
    
    public static HacerMatrices_201314457 newMatriz;
    public static Scanner entrada = new Scanner(System.in);
    public static int puntos=0,vidas=3;
    public static String nombre;
    public static void main(String[] args){

        crearJuego();
    }
    public static void crearJuego(){
        puntos=0;
        vidas=3;
        System.out.println("Ingrese su nombre");
        Scanner name = new Scanner(System.in);
//        try{
        nombre = name.nextLine();
        mascara(nombre);
//        }catch(Exception e){
//        	System.out.println("Algo");
//        }
    }
    private static void mascara(String nombre) {
//    	HacerMatrices_201314457 nuevaMatriz = new HacerMatrices_201314457();
        newMatriz = new HacerMatrices_201314457();
        String[][] mask = new String[4][5];
        System.out.println("****************************************");
        System.out.println("----------------------------------------");
        System.out.println("Jugador: " + nombre);
        System.out.println("----------------------------------------\n");
        for(int x=0;x<4;x++){
            for(int y=0;y<5;y++){
                mask[x][y] = "[X]";
                System.out.print(mask[x][y] + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("Vidas: " + vidas);
        System.out.println("Puntos: " + puntos);
        System.out.println("----------------------------------------");
        System.out.println("Menu: \nReiniciar: r\nVoltear: v");
        System.out.println("----------------------------------------");
        System.out.println("****************************************");
        Opciones();
    }

    public static void Opciones() {
        System.out.println("Ingrese la opcion que desee");
        String op;
//        try{
        op = entrada.nextLine().toString();
        if(op.equals("v")){
            voltearCarta();
        }
        else if(op.equals("r")){
            limpiarConsola();
            crearJuego();
        }
        else{
            System.out.println("Debes ingresar -r o -v");
            Opciones();
        }
//        }catch(Exception e){
//        }

    }

    public static int voltearCarta(){
        Scanner posicion = new Scanner(System.in);
        int x1=0,x2=0,y1=0,y2=0;
        System.out.println("Ingrese posicion x,y de la primera carta a voltear");
        try{
            x1 = Integer.parseInt(posicion.nextLine());
            y1 = Integer.parseInt(posicion.nextLine());
        }catch(Exception e){
            System.out.println("Debes ingresar una posicion");
            voltearCarta();
        }
        System.out.println("Ingrese posicion x,y de la segunda carta a voltear");
        try{
            x2 = Integer.parseInt(posicion.nextLine());
            y2 = Integer.parseInt(posicion.nextLine());
            if((x1==x2)&&(y1==y2)){
                System.out.println("Las posiciones no pueden ser las mismas");
                voltearCarta();
            }
        }catch(Exception e){
            System.out.println("Debes ingresar una posicion");
            voltearCarta();
        }
        limpiarConsola();
//    	System.out.println("****************************************");
//        System.out.println("----------------------------------------");
//        System.out.println("Jugador: " + nombre);
//        System.out.println("----------------------------------------\n");
        if(newMatriz.verificarPosicion(x1, y1, x2, y2)){
            puntos =puntos + 2;
        }else{
            vidas = vidas - 1;
        }
        System.out.println("Vidas: " + vidas);
        System.out.println("Puntos: " + puntos);
        System.out.println("----------------------------------------");
        System.out.println("Menu: \nReiniciar: r\nVoltear: v");
        System.out.println("----------------------------------------");
        System.out.println("****************************************");
        if(vidas==0){
            System.out.println("**********LO SIENTO TE QUEASTE SIN VIDAS**********");
            System.out.println("TU PUNTEO TOTAL FUE DE: " + puntos);
            System.exit(0);

        }
        if(puntos==20){
            System.out.println("**********GANASTE**********");
        }
        Opciones();
        return 0;
    }
    public static void limpiarConsola(){
        for(int x=0;x<1000;x++){
            System.out.println();
        }
//        try
//        {
//            String os = System.getProperty("os.name");
//
//            if (os.contains("Windows"))
//            {
//                Runtime.getRuntime().exec("cls");
//            }
//            else
//            {
//                Runtime.getRuntime().exec("clear");
//            }
//        }
//        catch (Exception exception)
//        {
//        }
    }
}


