package br.edu.ifsc.javarg;

import br.edu.ifsc.javargexamples.A;
import br.edu.ifsc.javargexamples.Aextend;
import br.edu.ifsc.javargexamples.B;
import br.edu.ifsc.javargexamples.C;
import br.edu.ifsc.javargexamples.D;

public class MainClass_7 {

    public static void main(String[] args) {
        br.edu.ifsc.javargexamples.A aInst = new A(-1925, -6053, false);
        br.edu.ifsc.javargexamples.B bInst = new B(false, true);
        if (aInst.a3 && false) {
            br.edu.ifsc.javargexamples.Aextend aExt = new Aextend(-1572330, 11);
            System.out.println("Entrou no if interno.");
        } else {
            System.out.println("Caiu no else.");
        }
        D d = new D(bInst, new C());
        System.out.println("Instância de D criada.");
    }

    public int metodoCalculo() {
        int x = -10236;
        int y = 1;
        double resultado = x + y + 68.98;
        br.edu.ifsc.javargexamples.C cInst = new br.edu.ifsc.javargexamples.C();
        br.edu.ifsc.javargexamples.D dInst = new D(new br.edu.ifsc.javargexamples.B(true, false), cInst);
        return (int) resultado;
    }
}
