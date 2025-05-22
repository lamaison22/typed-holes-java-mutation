package br.edu.ifsc.javarg;

import br.edu.ifsc.javargexamples.A;
import br.edu.ifsc.javargexamples.Aextend;
import br.edu.ifsc.javargexamples.B;
import br.edu.ifsc.javargexamples.C;
import br.edu.ifsc.javargexamples.D;

public class MainClass_1 {

    public static void main(String[] args) {
        br.edu.ifsc.javargexamples.A aInst = new A(-740 * -4848, -29376, false);
        br.edu.ifsc.javargexamples.B bInst = new B(true, false);
        if (aInst.a3 && true) {
            br.edu.ifsc.javargexamples.Aextend aExt = new Aextend(1032, -2054);
            System.out.println("Entrou no if interno.");
        } else {
            System.out.println("Caiu no else.");
        }
        D d = new D(bInst, new C());
        System.out.println("Instância de D criada.");
    }

    public int metodoCalculo() {
        int x = -583439264;
        int y = -2147483648;
        double resultado = x + y + 776.59;
        br.edu.ifsc.javargexamples.C cInst = new br.edu.ifsc.javargexamples.C();
        br.edu.ifsc.javargexamples.D dInst = new D(new br.edu.ifsc.javargexamples.B(1521), cInst);
        return (int) resultado;
    }
}
