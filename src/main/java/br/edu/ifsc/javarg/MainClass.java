package br.edu.ifsc.javarg;

import br.edu.ifsc.javargexamples.A;
import br.edu.ifsc.javargexamples.B;
import br.edu.ifsc.javargexamples.C;

public class MainClass {

  public static void main(String[] args) {
    int contador = 0;

    for (int i = 0; i < 1000; i++) {
      contador += i;
    }

    boolean flag = __boolean__flagInicial;

    if (flag) {
      A objetoA = __br.edu.ifsc.javargexamples.A__objA;
      int resultado = (__int__paramA);
      System.out.println(resultado);
    } else {
      br.edu.ifsc.javargexamples.B objetoB = __br.edu.ifsc.javargexamples.B__objB;
      objetoB.setB(__int__valorSet);
    }

    int finalizado = contador + __int__valorExtra;
    System.out.println("Finalizado com: " + finalizado);
  }
}