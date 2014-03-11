import java.io.IOException;
import java.util.Random;

/**
 * Created by erickchali on 2/22/14.
 */
public class HacerMatrices_201314457 {
    public static int[][] matriz;
    public int num;
    Arranque_201314457 arranque;
    public HacerMatrices_201314457(){
        matriz =  new int[4][5];
        crearMatriz();
    }
    public void imprimirMatriz(){
        for(int x=0;x<4;x++){
            for(int y=0;y<5;y++){
                System.out.print(matriz[x][y] + "\t");
            }
            System.out.println("\n");
        }
    }

    public void crearMatriz() {
        Random rand = new Random();
        for(int x=0;x<4;x++){
            for(int y=0;y<5;y++){
                do{
                    num =  rand.nextInt((10-1)+1) + 1;
                }while(verificarNum(num));
                matriz[x][y] = num;
            }
        }
//        imprimirMatriz();
    }

    public boolean verificarNum(int num) {
        int cont=0;
        for(int x=0;x<4;x++){
            for(int y=0;y<5;y++){
                if(matriz[x][y]==num){
                    cont++;
                }
            }
        }
        if(cont==2){
            return true;
        }else{
            return false;
        }

    }
    public boolean verificarPosicion(int x1, int y1, int x2, int y2){
        int num1=0,num2=0;
        for(int x=0;x<4;x++){
            for(int y=0;y<5;y++){
                if(((y==x1)&&(x==y1))||((y==x2)&&(x==y2))){
                    System.out.print(matriz[x][y] + "\t");
                }else{
                    System.out.print("[X]" + "\t");
                }
            }
            System.out.println("\n");
        }
//    	System.out.println("------------------------");
        System.out.println("****************************************");
        if(matriz[y1][x1]==matriz[y2][x2]){
            matriz[y1][x1]=0;
            matriz[y2][x2]=0;
            System.out.println("Pareja encontrada");
        }else{
            System.out.println("Pareja incorrecta");
        }
        System.out.println("****************************************");
        System.out.println("----------------------------------------");
        System.out.println("Jugador: " + arranque.nombre);
        System.out.println("----------------------------------------\n");


        for(int x=0;x<4;x++){
            for(int y=0;y<5;y++){
                if(matriz[x][y]==0){
                    System.out.print("   " + "\t");
                }else{
                    System.out.print("[X]" + "\t");
                }
            }
            System.out.println("\n");
        }
        if(matriz[y1][x1]==matriz[y2][x2]){
            return true;
        }else{
            return false;
        }
    }
    public void imprimirCorregida(){
        for(int x=0;x<4;x++){
            for(int y=0;y<5;y++){
                if(matriz[x][y]==0){
                    System.out.print("   " + "\t");
                }else{
                    System.out.print("[X]" + "\t");
                }
            }
            System.out.println("\n");
        }
    }
}
