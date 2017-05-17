/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Minimax;
/**
 *
 * @author AlexAlmora
 */
public class Minimax {
    private int nodosExp;
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
        this.nodosExp = 0;
    }    
    private Tablero alphaBetaMinimax(Tablero tabActual, int nivel, Tablero alpha, Tablero beta, boolean maquinaPlayer){
        this.nodosExp++;
        if(tabActual.isWinner()==1 || nivel>=maxNivel){
            return tabActual;
        }
        if(maquinaPlayer){
            Tablero v = new Tablero(Integer.MIN_VALUE);
            for(int i=0;i<7;i++){
                 Tablero tabAux = tabActual.clone();
                 tabAux.makeMove(i,1);
                v = Funciones.max(v,alphaBetaMinimax(tabAux,nivel+1,alpha,beta,false));
                alpha = Funciones.max(alpha, v);
                if(beta.getValor()<=alpha.getValor()){
                    break;
                }
            }
            return v;
        }else{
            Tablero v = new Tablero(Integer.MAX_VALUE);
            for(int i=0;i<7;i++){
                Tablero tabAux = tabActual.clone();
                tabAux.makeMove(i,-1);
                v = Funciones.min(v,alphaBetaMinimax(tabAux,nivel+1,alpha,beta,true));
                beta = Funciones.min(v, beta);
                if(beta.getValor()<=alpha.getValor()){
                    break;
                }
            }
            return v;
        }
    }
    public int playGame(){
        this.nodosExp=0;
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
            System.out.println("Se expandieron: "+this.nodosExp+" nodos");
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
