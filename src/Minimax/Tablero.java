/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Minimax;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author AlexAlmora
 */
public class Tablero implements Cloneable {

    private int[][] tablero;
    private int firstMove;
    private int valor;

    
    public Tablero(int valor){
        this.valor = valor;
    }
    public Tablero(int[][] tablero, int firstMove) {
        this.tablero = new int[6][7];
        for(int i = 0;i<6;i++){
            this.tablero[i] = Arrays.copyOf(tablero[i], 7);
        }
        this.firstMove = firstMove;
    }
    public int[][] getMatrix(){
        return tablero;
    }
    public int getValor(){
        return valor;
    }
    public int getFirstMove(){
        return firstMove;
    }
    public boolean isValidMove(int n) {
        return (tablero[0][n] == 0);
    }

    public void makeMove(int n, int tipo) {
        for (int i = 5; i >= 0; i--) {
            if (tablero[i][n] == 0) {
                tablero[i][n] = tipo;
                valor();
                return;
            }
        }
    }
    
   public void testPrint(){
        for(int i=0;i<6;i++){
            System.out.println(Arrays.toString(tablero[i]));  
        }
    }
    public Tablero clone(){
       
        return new Tablero(tablero,firstMove);
    }
    private void valor(){
        int valMaquina = 10000*(cuentaVerticales(1,4)+cuentaDiagonal(1,4)+cuentaHorizontales(1,4))+1000*(cuentaDiagonal(1,3)+cuentaHorizontales(1,3)+cuentaVerticales(1,3))+100*(cuentaHorizontales(1,2)+cuentaVerticales(1,2)+cuentaDiagonal(1,2))+(cuentaHorizontales(1,1)+cuentaVerticales(1,1)+cuentaDiagonal(1,1));
        int valJugador = 10000*(cuentaVerticales(-1,4)+cuentaDiagonal(-1,4)+cuentaHorizontales(-1,4))+1000*(cuentaDiagonal(-1,3)+cuentaHorizontales(-1,3)+cuentaVerticales(-1,3))+100*(cuentaHorizontales(-1,2)+cuentaVerticales(-1,2)+cuentaDiagonal(-1,2))+(cuentaHorizontales(-1,1)+cuentaVerticales(-1,1)+cuentaDiagonal(-1,1));
        valor = valMaquina-valJugador;
        
    }
    private int cuentaVerticales(int tipo, int serie) {
        int cuenta = 0;
        int anterior = 0;
        for (int columna = 0; columna < 7; columna++) {
            anterior = 0;
            for (int renglon = 5; renglon >= 0; renglon--) {
                if (tablero[renglon][columna] == tipo) {
                    anterior++;
                } else if (tablero[renglon][columna] ==-1*tipo) {
                    anterior = 0;
                } else if(tablero[renglon][columna]== 0) {
                        if(serie==anterior){
                            cuenta++;
                        }else{
                            renglon=-1;
                        }
                }
            }
        }
        return cuenta;
    }
    private int cuentaHorizontales(int tipo, int serie) {
       int cuenta = 0;
       for(int i=0;i<6;i++){
           cuenta+= Funciones.cuentaSeriesLineal(tablero[i], tipo, serie); 
       }
       return cuenta;
    }
 
    public int diagonalR( int tipo, int serie) {
        ArrayList<Integer> list = new ArrayList<>();
        int f = 6, c = 7, i = 0, j = 0, flag1 = 1, cuenta = 0;
        i = flag1;

        while (i < f) {
            while (i >= 0) {
                list.add(tablero[i][j]);
                i--;
                j++;
            }
            if (list.size() >= 4) {
                cuenta += Funciones.cuentaSeriesLineal(Funciones.listToArray(list), tipo, serie);
            }
            list.clear();
            flag1++;
            i = flag1;
            j = 0;
        }
        int flag2 = 0;
        int flag3 = 1;
        i = 5;
        j = flag3;
        while (flag2 <= 5) {
            while (i >= flag2) {
                list.add(tablero[i][j]);
                i--;
                j++;
            }
            if (list.size() >= 4) {
                cuenta += Funciones.cuentaSeriesLineal(Funciones.listToArray(list), tipo, serie);
            }
            list.clear();
            flag2++;
            flag3++;
            j = flag3;
            i = 5;
        }
        
        return cuenta;
    }

    public int diagonalL(int tipo, int serie) {

        ArrayList<Integer> list = new ArrayList<>();
        int f = 6, c = 7, i = 0, j = 0, flag1 = 4, cuenta = 0;
        i = flag1;

        while (flag1 >= 0) {
            while (i <= 5) {
                list.add(tablero[i][j]);
                i++;
                j++;
            }
            if (list.size() >= 4) {
                cuenta += Funciones.cuentaSeriesLineal(Funciones.listToArray(list), tipo, serie);
            }
            list.clear();
            flag1--;
            i = flag1;
            j = 0;
        }
        int flag2 = 5;
        int flag3 = 1;
        i = 0;
        j = flag3;
        while (flag2 >= 0) {
            while (i <= flag2) {
                list.add(tablero[i][j]);
                i++;
                j++;
            }
            if (list.size() >= 4) {
                cuenta += Funciones.cuentaSeriesLineal(Funciones.listToArray(list), tipo, serie);
            }
            list.clear();
            flag2--;
            flag3++;
            j = flag3;
            i = 0;
        }
        return cuenta;
    }
    
    public int cuentaDiagonal (int tipo, int serie){
        return diagonalR(tipo,serie)+diagonalL(tipo,serie);
    }
    public int isWinner(){
        if(cuentaVerticales(1,4)>=1 || cuentaHorizontales(1,4)>=1 || cuentaDiagonal(1,4)>=1){
            return 1;
        }else if(cuentaVerticales(-1,4)>=1 || cuentaHorizontales(-1,4)>=1 || cuentaDiagonal(-1,4)>=1){
            return -1;
        }
        else{
            return 0;
        }
    }
}
