package br.edu.ifsc.javarg;

import br.edu.ifsc.javargexamples.A;
import br.edu.ifsc.javargexamples.Aextend;
import br.edu.ifsc.javargexamples.B;
import br.edu.ifsc.javargexamples.C;
import br.edu.ifsc.javargexamples.D;

public class MainClass_4 {

    public static void main(String[] args) {
        br.edu.ifsc.javargexamples.A aInst = new A(27023, -99, false);
        br.edu.ifsc.javargexamples.B bInst = new B(true, true);
        if (aInst.a3 && false) {
            br.edu.ifsc.javargexamples.Aextend aExt = new Aextend(-1593, 5634327);
            System.out.println("Entrou no if interno.");
        } else {
            System.out.println("Caiu no else.");
        }
        D d = new D(bInst, new C());
        System.out.println("Instância de D criada.");
    }

    public int metodoCalculo() {
        int x = -388319;
        int y = 159;
        double resultado = x + y + 66.11;
        br.edu.ifsc.javargexamples.C cInst = new br.edu.ifsc.javargexamples.C();
        br.edu.ifsc.javargexamples.D dInst = new D(new br.edu.ifsc.javargexamples.B(-59380), cInst);
        return (int) resultado;
    }
}
