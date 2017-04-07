/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Minimax;

import java.util.ArrayList;

/**
 *
 * @author AlexAlmora
 */
public class Funciones {
    public static int[] arr = {0,0,-1,1,0,1,0};
    public static Tablero max(Tablero a, Tablero b){
        if(a.getValor()>b.getValor()){
            return a;
        }else{
            return b;
        }
    }
    public static Tablero min(Tablero a, Tablero b){
        if(a.getValor()<b.getValor()){
            return a;
        }else{
            return b;
        }
    }
    
    public static int[] listToArray(ArrayList<Integer> list){
        int[] aux = new int[list.size()];
        for(int i=0;i<list.size();i++){
            aux[i]=list.get(i).intValue();
        }
        return aux;
    }
    public static int cuentaSeriesLineal(int[] vec, int tipo, int repe){
        int cuentaRepetidos=0;
        int cuentaCeros = 0;
        int cuentaFinal = 0;
        for(int i=0;i<vec.length;i++){
            if(vec[i]==tipo && cuentaRepetidos == repe){
                cuentaCeros=0;
                cuentaRepetidos=1;
            }
            else if(vec[i]==tipo && cuentaRepetidos < repe){
                cuentaRepetidos++;
            }
            else if(vec[i]==0 && cuentaRepetidos == repe){
                cuentaCeros++;
                if(cuentaRepetidos + cuentaCeros == 4){
                   cuentaFinal++; 
                   cuentaCeros = 0;
                   cuentaRepetidos = 0;
                }
                
            }
            else if(vec[i]==0 && cuentaRepetidos < repe){
                cuentaCeros = 0;
                cuentaRepetidos = 0;
            }
            else if(vec[i]==-1*tipo){
                cuentaCeros=0;
                cuentaRepetidos=0;
            }
            if(cuentaRepetidos + cuentaCeros == 4){
                cuentaFinal++;
                cuentaCeros=0;
                cuentaRepetidos=0;
            }
        }
        cuentaRepetidos=0;
        cuentaCeros = 0;
        for(int i= vec.length-1;i>=0;i--){
            if(vec[i]==tipo && cuentaRepetidos == repe){
                cuentaCeros=0;
                cuentaRepetidos=1;
            }
            else if(vec[i]==tipo && cuentaRepetidos < repe){
                cuentaRepetidos++;
            }
            else if(vec[i]==0 && cuentaRepetidos == repe){
                cuentaCeros++;
                if(cuentaRepetidos + cuentaCeros == 4){
                   cuentaFinal++; 
                   cuentaCeros = 0;
                   cuentaRepetidos = 0;
                }
                
            }
            else if(vec[i]==0 && cuentaRepetidos < repe){
                cuentaCeros = 0;
                cuentaRepetidos = 0;
            }
            else if(vec[i]==-1*tipo){
                cuentaCeros=0;
                cuentaRepetidos=0;
            }
            if(cuentaRepetidos + cuentaCeros == 4){
                cuentaFinal++;
                cuentaCeros=0;
                cuentaRepetidos=0;
            }
        }
        return cuentaFinal;
    }
    
}
