package br.edu.ifsc.javarg;

import br.edu.ifsc.javargexamples.A;
import br.edu.ifsc.javargexamples.Aextend;
import br.edu.ifsc.javargexamples.B;
import br.edu.ifsc.javargexamples.C;
import br.edu.ifsc.javargexamples.D;

public class MainClass_5 {

    public static void main(String[] args) {
        br.edu.ifsc.javargexamples.A aInst = new A(-2147483648, -218, false);
        br.edu.ifsc.javargexamples.B bInst = new B(true, false);
        if (aInst.a3 && true) {
            br.edu.ifsc.javargexamples.Aextend aExt = new Aextend(3, -308615);
            System.out.println("Entrou no if interno.");
        } else {
            System.out.println("Caiu no else.");
        }
        D d = new D(bInst, new C());
        System.out.println("Instância de D criada.");
    }

    public int metodoCalculo() {
        int x = 8246;
        int y = 912;
        double resultado = x + y + 9.39;
        br.edu.ifsc.javargexamples.C cInst = new br.edu.ifsc.javargexamples.C();
        br.edu.ifsc.javargexamples.D dInst = new D(new br.edu.ifsc.javargexamples.B(false, true), cInst);
        return (int) resultado;
    }
}
