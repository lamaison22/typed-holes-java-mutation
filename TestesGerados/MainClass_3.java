package br.edu.ifsc.javarg;

import br.edu.ifsc.javargexamples.A;
import br.edu.ifsc.javargexamples.Aextend;
import br.edu.ifsc.javargexamples.B;
import br.edu.ifsc.javargexamples.C;
import br.edu.ifsc.javargexamples.D;

public class MainClass_3 {

    public static void main(String[] args) {
        br.edu.ifsc.javargexamples.A aInst = new A(346, 831039612, true);
        br.edu.ifsc.javargexamples.B bInst = new B(false, true);
        if (aInst.a3 && true) {
            br.edu.ifsc.javargexamples.Aextend aExt = new Aextend(-4843, 247);
            System.out.println("Entrou no if interno.");
        } else {
            System.out.println("Caiu no else.");
        }
        D d = new D(bInst, new C());
        System.out.println("Instância de D criada.");
    }

    public int metodoCalculo() {
        int x = -12;
        int y = 729493142;
        double resultado = x + y + 1849.86;
        br.edu.ifsc.javargexamples.C cInst = new br.edu.ifsc.javargexamples.C();
        br.edu.ifsc.javargexamples.D dInst = new D(new br.edu.ifsc.javargexamples.B(1620407109), cInst);
        return (int) resultado;
    }
}
