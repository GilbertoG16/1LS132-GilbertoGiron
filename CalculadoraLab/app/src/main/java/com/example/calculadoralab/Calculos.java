package com.example.calculadoralab;




public class Calculos {
    static Double n1;
    static Double n2;
    static Double resultado;
    public Calculos (Double p,Double s){
        n1 = p;
        n2 = s;

    }
    public static double Sumar(){
        resultado = n1 + n2 ;

        return resultado;
    }
    public static double Restar(){
        resultado = n1 - n2 ;

        return resultado;
    }
    public static double Multiplicar(){
        resultado = n1 * n2 ;

        return resultado;
    }
    public static double Division(){
        resultado = n1 / n2 ;

        return resultado;
    }
}
