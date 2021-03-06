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
//    private void valor(){
//        int valMaquina = 10000*(cuentaVerticales(1,4)+cuentaDiagonal(1,4)+cuentaHorizontales(1,4))+1000*(cuentaDiagonal(1,3)+cuentaHorizontales(1,3)+cuentaVerticales(1,3))+100*(cuentaHorizontales(1,2)+cuentaVerticales(1,2)+cuentaDiagonal(1,2))+(cuentaHorizontales(1,1)+cuentaVerticales(1,1)+cuentaDiagonal(1,1));
//        int valJugador = 10000*(cuentaVerticales(-1,4)+cuentaDiagonal(-1,4)+cuentaHorizontales(-1,4))+1000*(cuentaDiagonal(-1,3)+cuentaHorizontales(-1,3)+cuentaVerticales(-1,3))+100*(cuentaHorizontales(-1,2)+cuentaVerticales(-1,2)+cuentaDiagonal(-1,2))+(cuentaHorizontales(-1,1)+cuentaVerticales(-1,1)+cuentaDiagonal(-1,1));
//        valor = valMaquina-valJugador;
//        
//    }
private int[] getSubLine(int[] line, int n, int m ){
    int[] subLine = new int[m-n+1];
    for(int i=0; i<subLine.length;i++){
        subLine[i] = line[n+i];
    }
    return subLine;
}
private ArrayList<int[]> getSub4Lines(int[] line){
    int size = line.length;
    ArrayList<int[]> listLine = new ArrayList<>();
    if(size==4){
        listLine.add(line);
        return listLine;
    }
    if(size<4){
        System.out.println("Error");
        return null;
    }
    for(int i = 0; i<= size-4;i++){
        listLine.add(getSubLine(line,i,i+3));
    }
    return listLine;
}
private ArrayList<int[]> getDiagonales(){
       ArrayList<int[]> listLine = new ArrayList<>();
       listLine.add(new int[]{tablero[3][0],tablero[2][1],tablero[1][2],tablero[0][3]});
       listLine.add(new int[] {tablero[4][0],tablero[3][1],tablero[2][2],tablero[1][3],tablero[4][0]});
       listLine.add(new int[] {tablero[5][0],tablero[4][1],tablero[3][2],tablero[2][3],tablero[1][4],tablero[0][5]});
       listLine.add(new int[] {tablero[5][1],tablero[4][2],tablero[3][3],tablero[2][4],tablero[1][5],tablero[0][6]});
       listLine.add(new int[] {tablero[5][2],tablero[4][3],tablero[3][4],tablero[2][5],tablero[1][6]});
       listLine.add(new int[] {tablero[5][3],tablero[4][4],tablero[3][5],tablero[2][6]});
       listLine.add(new int[] {tablero[0][0],tablero[1][1],tablero[2][2],tablero[3][3],tablero[4][4],tablero[5][5]});
       listLine.add(new int[] {tablero[0][1],tablero[1][2],tablero[2][3],tablero[3][4],tablero[4][5],tablero[5][6]});
       listLine.add(new int[] {tablero[0][2],tablero[1][3],tablero[2][4],tablero[3][5],tablero[4][6]});
       listLine.add(new int[] {tablero[0][3],tablero[1][4],tablero[2][5],tablero[3][6]});
       listLine.add(new int[] {tablero[1][0],tablero[2][1],tablero[3][2],tablero[4][3],tablero[5][4]});
       listLine.add(new int[] {tablero[2][0],tablero[3][1],tablero[4][2],tablero[5][3]});
       return listLine;
       
}
private ArrayList<int[]> getVerticales(){
    ArrayList<int[]> listLine = new ArrayList<>();
     int[] aux;
    
    for(int i=0;i<tablero[0].length;i++){
        int x=0;
        aux = new int[7];
        for(int j=tablero.length-1;j>=0;j--){
            aux[x]=(tablero[j][i]);
            x++;
        }
        listLine.add(aux);
    }
    return listLine;
}
private int[] reverse(int[] original){
    int[] inverse = new int[original.length];
    for(int i=0;i<inverse.length;i++){
        inverse[i] = original[inverse.length-1-i];
    }
    return inverse;
}
private int cuentaSeguidos(int[] list4, int player){
    int cuenta =0;
    if(list4[0]==0 && list4[1]==0){
        return 0;
    }
    if(list4[0]==0){
        return 0;
    }
    for(int i=0;i<4;i++){
        if(list4[i]== -1*player){
            return 0;
        }
        if(list4[i]==player){
            cuenta++;
        }
    }
    return cuenta;
}
private int cuentaHorizontales(int player){
        int suma = 0;
        int cuantos;
        for (int[] row : tablero) {
            ArrayList<int[]> subSets = getSub4Lines(row);
            for (int[] subSet : subSets) {
                cuantos = cuentaSeguidos(subSet, player);
                switch(cuantos){
                    case 1:
                        suma++;
                        break;
                    case 2:
                        suma+=10;
                        break;
                    case 3:
                        suma+=100;
                        break;
                    case 4:
                        suma = Integer.MAX_VALUE;
                        return suma;
                }
                cuantos = cuentaSeguidos(reverse(subSet),player);
                switch(cuantos){
                    case 1:
                        suma++;
                        break;
                    case 2:
                        suma+=10;
                        break;
                }
            }
        }
        return suma;
}
private int cuentaVertical(int player){
    int suma = 0;
    int cuantos = 0;
    ArrayList<int[]> verticales = getVerticales();
        for (int[] col : verticales) {
            ArrayList<int[]> subSets = getSub4Lines(col);
            for(int[] list4:subSets){
                cuantos = cuentaSeguidos(list4,player);
                switch(cuantos){
                    case 1:
                        suma++;
                        break;
                    case 2:
                        suma+=10;
                        break;
                    case 3:
                        suma+=100;
                        break;
                    case 4:
                        suma = Integer.MAX_VALUE;
                        return suma;
                }
            }
        }
    return suma;
}
private int cuentaDiagonal(int player){
    ArrayList<int[]> diagonales = getDiagonales();
    int suma = 0;
    int cuantos;
    for(int[] diag: diagonales){
        ArrayList<int[]> subSets = getSub4Lines(diag);
        for(int[] list4:subSets){
            cuantos = cuentaSeguidos(list4,player);
            switch(cuantos){
                    case 1:
                        suma++;
                        break;
                    case 2:
                        suma+=10;
                        break;
                    case 3:
                        suma+=100;
                        break;
                    case 4:
                        suma = Integer.MAX_VALUE;
                        return suma;
                }
                cuantos = cuentaSeguidos(reverse(list4),player);
                switch(cuantos){
                    case 1:
                        suma++;
                        break;
                    case 2:
                        suma+=10;
                        break;
                }
            
        }
    }
    return suma;
}
private void valor(){
    int valMaquina = cuentaHorizontales(1)+cuentaVertical(1)+cuentaDiagonal(1);
    int valJugador = cuentaHorizontales(-1)+cuentaVertical(-1)+cuentaDiagonal(-1);
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
