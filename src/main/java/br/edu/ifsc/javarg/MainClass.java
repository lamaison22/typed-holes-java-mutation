package br.edu.ifsc.javarg;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import br.edu.ifsc.javargexamples.A;
import br.edu.ifsc.javargexamples.Aextend;
import br.edu.ifsc.javargexamples.AextendExtend;
import br.edu.ifsc.javargexamples.B;
import br.edu.ifsc.javargexamples.C;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.StaticJavaParser;


/**
 *
 * @author unknown
 *
 */
@SuppressWarnings("all")
public class MainClass {

  public static void main(String[] args) {


//     String sourceCode = "public class MyClass {\n" +
//     "    public void myMethod() {\n" +
//     " int cc =32; \n"+
//     "        System.out.println(\"?abc?\");\n" +
//     "    }\n" +
//     "}";

//   CompilationUnit compilationUnit = StaticJavaParser.parse(sourceCode);
  

//   // Criando um Visitor para substituir trechos demarcados
//   ModifierVisitor<?> modifierVisitor = new ModifierVisitor<Void>() {
//   @Override
//   public Visitable visit(MethodDeclaration methodDeclaration, Void arg) {
//   // Visita o nó MethodDeclaration e faz a substituição
//   super.visit(methodDeclaration, arg);
//   methodDeclaration.getBody().ifPresent(body -> {
//   for (Node child : body.getChildNodes()) {
//   if (child.toString().contains("?abc?")) {
//       String asm = child.getClass().getCanonicalName();
//       System.out.println("classe dessa porra" + asm.toString());
//       String newCode = child.toString().replace("?abc?", "double");
//       child.replace(StaticJavaParser.parseStatement(newCode));
//   }
//   }
//   });
//   return methodDeclaration;
//   }
//   };

//   // Aplica o Visitor na unidade de compilação
//   compilationUnit.accept(modifierVisitor, null);

//   // Imprime o código-fonte modificado
//   System.out.println(compilationUnit.toString());
//   }

//   String sourceCodezada = "public class MyClass {\n" +
//   "    public void myMethod() {\n" +
//   "        int a = 32;\n" +
//   "        String str = \"Hello\";\n" +
//   "        double d = 3.14;\n" +
//   "    }\n" +
//   "}";

// CompilationUnit compila = StaticJavaParser.parse(sourceCodezada);

// compila.findAll(VariableDeclarationExpr.class).forEach(variableDeclaration -> {
// List<Type> variableTypes = Collections.singletonList(variableDeclaration.getElementType());;
// if (!variableTypes.isEmpty()) {
// String variableType = variableTypes.get(0).toString();
// System.out.println("Tipo da variável: " + variableType);
// }
// });

 String sourceCode = "public class MyClass {\n" +
                            "    public static void main(String[] args) {\n" +
                            "        ?object? cc = 35;\n" +
                            "        System.out.println(cc);\n" +
                            "    }\n" +
                            "}";


        //passa o codigo pro método que vai concatenar os ? no tipo já passando qual o tipo e pra oq trocar                                
        String modifiedCode = replaceMarkedType(sourceCode, "object", "double");
        //configuração da C.U e solvers, tem q usar o StaticJavaParser, o outro nao funciona aparentemente
        //instancia uma c.u e passa o codigo modificado que retornará
        CompilationUnit compilationUnit = StaticJavaParser.parse(modifiedCode);
        //configura os solvers
        ReflectionTypeSolver typeSolver = new ReflectionTypeSolver();
        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(typeSolver);
        StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);
        //aqui ele percorre procurando o objeto "cc" e testa se acha o tipo q a gente tem q passar e dps muda
        compilationUnit.findAll(VariableDeclarator.class).forEach(variableDeclarator -> {
            if (variableDeclarator.getNameAsString().equals("cc")) {
                if (variableDeclarator.getType().isPrimitiveType() &&
                        variableDeclarator.getType().asPrimitiveType().getType().asString().equals("object")) {
                    variableDeclarator.setType(StaticJavaParser.parseType("double"));
                }
            }
        });

        System.out.println(compilationUnit.toString());
    }
    // concatena o tipo com as macações ? para que possa ser trocado
    public static String replaceMarkedType(String code, String markedType, String replacementType) {
        String pattern = "\\?" + Pattern.quote(markedType) + "\\?";
        return code.replaceAll(pattern, replacementType);
    }
}



   


