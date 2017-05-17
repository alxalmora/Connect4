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
        if(nivel>=maxNivel){
            return tabActual;
        }
        if(maquinaPlayer && tabActual.isWinner() == 1){
            return tabActual;
        }
        if(!maquinaPlayer && tabActual.isWinner()==-1){
            return tabActual;
        }
        this.nodosExp++;
        if(maquinaPlayer){
            //Tablero v = new Tablero(Integer.MIN_VALUE);
            for(int i=0;i<7;i++){
                 Tablero tabAux = tabActual.clone();
                 tabAux.makeMove(i,1);
                alpha = Funciones.max(alpha,alphaBetaMinimax(tabAux,nivel+1,alpha,beta,false));
                //alpha = Funciones.max(alpha, v);
                if(beta.getValor()<=alpha.getValor()){
                    break;
                }
            }
            return alpha;
        }else{
            //Tablero v = new Tablero(Integer.MAX_VALUE);
            for(int i=0;i<7;i++){
                Tablero tabAux = tabActual.clone();
                tabAux.makeMove(i,-1);
                beta = Funciones.min(beta,alphaBetaMinimax(tabAux,nivel+1,alpha,beta,true));
                //beta = Funciones.min(v, beta);
                if(beta.getValor()<=alpha.getValor()){
                    break;
                }
            }
            return beta;
        }
    }
    public int playGame(){
        long tStart = System.currentTimeMillis();
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
            long tEnd = System.currentTimeMillis();
            long tDelta = tEnd-tStart;
            double elapsedSeconds = tDelta/1000.0;
            movimientos++;
            System.out.println("Movimiento ["+movimientos+"]: Se expandieron: "+this.nodosExp+" nodos, tiempo de proceso:"+elapsedSeconds+"s");
            tablero.makeMove(maximo.getFirstMove(),1);
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
