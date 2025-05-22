package br.edu.ifsc.javarg;

import br.edu.ifsc.javargexamples.A;
import br.edu.ifsc.javargexamples.Aextend;
import br.edu.ifsc.javargexamples.B;
import br.edu.ifsc.javargexamples.C;
import br.edu.ifsc.javargexamples.D;

public class MainClass_6 {

    public static void main(String[] args) {
        br.edu.ifsc.javargexamples.A aInst = new A(1, -746508, false);
        br.edu.ifsc.javargexamples.B bInst = new B(true, false);
        if (aInst.a3 && false) {
            br.edu.ifsc.javargexamples.Aextend aExt = new Aextend(2243961, 19);
            System.out.println("Entrou no if interno.");
        } else {
            System.out.println("Caiu no else.");
        }
        D d = new D(bInst, new C());
        System.out.println("Instância de D criada.");
    }

    public int metodoCalculo() {
        int x = -7;
        int y = 0;
        double resultado = x + y + 296.8;
        br.edu.ifsc.javargexamples.C cInst = new br.edu.ifsc.javargexamples.C();
        br.edu.ifsc.javargexamples.D dInst = new D(new br.edu.ifsc.javargexamples.B(46550), cInst);
        return (int) resultado;
    }
}
