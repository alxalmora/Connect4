/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Minimax;

import java.util.Arrays;

/**
 *
 * @author AlexAlmora
 */
public class Minimax {

    private  Tablero tablero;
    private final int maxNivel;
    private final boolean iniciaMaquina;
    private int movimientos;
    public int isWinner(){
        return tablero.isWinner();
    }
    
    public Minimax(Tablero tab, int nivel, boolean iniciaMaquina) {
        this.tablero = tab;
        this.maxNivel = nivel;
        this.iniciaMaquina = iniciaMaquina;
        this.movimientos=0;
    }

    private Tablero getMaximized(Tablero tabActual, int nivel, Tablero beta) {
        if (nivel < maxNivel) {
            Tablero maximo = beta;
            for (int i = 0; i < 7; i++) {
                if (tabActual.isValidMove(i)) {
                    Tablero tabAux = tabActual.clone();
                    tabAux.makeMove(i, 1);
                    maximo = Funciones.max(maximo, getMinimized(tabAux, nivel + 1,maximo));
                }
                if(beta.getValor() <= maximo.getValor()){
                break;
            }
            }
            return maximo;
        } else {
            return tabActual;
        }
    }
    private Tablero getMinimized(Tablero tabActual, int nivel, Tablero alpha) {
        if (nivel < maxNivel) {
            Tablero minimo = alpha;
            for (int i = 0; i < 7; i++) {
                if (tabActual.isValidMove(i)) {
                    Tablero tabAux = tabActual.clone();
                    tabAux.makeMove(i, -1);
                    minimo = Funciones.min(minimo, getMaximized(tabAux, nivel + 1,minimo));
                }
                if(minimo.getValor()<=alpha.getValor()){
                    break;
                }
            }
            return minimo;
        } else {
            return tabActual;
        }
    }
    
    private Tablero alphaBetaMinimax(Tablero tabActual, int nivel, Tablero alpha, Tablero beta, boolean maquinaPlayer){
        if(tabActual.isWinner()==1 || nivel>=maxNivel){
            return tabActual;
        }
        if(maquinaPlayer){
            for(int i=0;i<7;i++){
                 Tablero tabAux = tabActual.clone();
                 tabAux.makeMove(i,1);
                alpha = Funciones.max(alpha,alphaBetaMinimax(tabAux,nivel+1,alpha,beta,false));
                if(beta.getValor()<=alpha.getValor()){
                    break;
                }
            }
            return alpha;
        }else{
            for(int i=0;i<7;i++){
                Tablero tabAux = tabActual.clone();
                 tabAux.makeMove(i,-1);
                beta = Funciones.min(beta,alphaBetaMinimax(tabAux,nivel+1,alpha,beta,true));
                if(beta.getValor()<=alpha.getValor()){
                    break;
                }
            }
            return beta;
        }
    }
    public int playGame(){
        if(iniciaMaquina&&movimientos==0){
            tablero.makeMove(3,1);
            movimientos++;
            return 3;
        }else{
            Tablero maximo = new Tablero(Integer.MIN_VALUE);
            for(int i=0;i<7;i++){
                if(tablero.isValidMove(i)){
                    Tablero tabAux = new Tablero(tablero.getMatrix(),i);
                    tabAux.makeMove(i, 1);
                    maximo = Funciones.max(maximo,alphaBetaMinimax(tabAux,0,new Tablero(Integer.MIN_VALUE),new Tablero(Integer.MAX_VALUE),false));
                }
            }
            tablero.makeMove(maximo.getFirstMove(),1);
            //tablero.testPrint();
            //System.out.println("======================");
            //tablero.testPrint();
            movimientos++;
            //System.out.println(maximo.getFirstMove()+" | "+maximo.getValor());
            return maximo.getFirstMove();
        }
    }
    
    public boolean playerMove(int n){
        if(tablero.isValidMove(n)){
            tablero.makeMove(n, -1);
            movimientos++;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isDraw(){
        return (movimientos>=42);
    }
}
