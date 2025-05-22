package br.edu.ifsc.javarg;

import br.edu.ifsc.javargexamples.A;
import br.edu.ifsc.javargexamples.Aextend;
import br.edu.ifsc.javargexamples.B;
import br.edu.ifsc.javargexamples.C;
import br.edu.ifsc.javargexamples.D;

public class MainClass {

  public static void main(String[] args) {
    br.edu.ifsc.javargexamples.A aInst = new A(__int__a1, __int__a2, __boolean__a3);
    br.edu.ifsc.javargexamples.B bInst = new B(__boolean__b1, __boolean__b2);

    if (aInst.a3 && __boolean__condicional) {
      br.edu.ifsc.javargexamples.Aextend aExt = new Aextend(__int__val1, __int__val2);
      System.out.println("Entrou no if interno.");
    } else {
      System.out.println("Caiu no else.");
    }

    D d = new D(bInst, new C());
    System.out.println("Instância de D criada.");
  }

  public int metodoCalculo() {
    int x = __int__x;
    int y = __int__y;
    double resultado = x + y + __double__delta;

    br.edu.ifsc.javargexamples.C cInst = __br.edu.ifsc.javargexamples.C__cInstancia;
    br.edu.ifsc.javargexamples.D dInst = new D(__br.edu.ifsc.javargexamples.B__bArg, cInst);

    return (int) resultado;
  }
}