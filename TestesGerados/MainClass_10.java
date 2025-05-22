package br.edu.ifsc.javarg;

import br.edu.ifsc.javargexamples.A;
import br.edu.ifsc.javargexamples.Aextend;
import br.edu.ifsc.javargexamples.B;
import br.edu.ifsc.javargexamples.C;
import br.edu.ifsc.javargexamples.D;

public class MainClass_10 {

    public static void main(String[] args) {
        br.edu.ifsc.javargexamples.A aInst = new A(-1497, 1674, true);
        br.edu.ifsc.javargexamples.B bInst = new B(false, false);
        if (aInst.a3 && true) {
            br.edu.ifsc.javargexamples.Aextend aExt = new Aextend(2214, 35823);
            System.out.println("Entrou no if interno.");
        } else {
            System.out.println("Caiu no else.");
        }
        D d = new D(bInst, new C());
        System.out.println("Instância de D criada.");
    }

    public int metodoCalculo() {
        int x = 344408;
        int y = -496716999;
        double resultado = x + y + 13585.54;
        br.edu.ifsc.javargexamples.C cInst = new br.edu.ifsc.javargexamples.C();
        br.edu.ifsc.javargexamples.D dInst = new D(new br.edu.ifsc.javargexamples.B(365), cInst);
        return (int) resultado;
    }
}
