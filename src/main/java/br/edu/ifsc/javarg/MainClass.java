package br.edu.ifsc.javarg;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.LiteralExpr;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
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

//         String sourceCode = "public class MyClass {\n" +
//                             "    public static void main(String[] args) {\n" +
//                             "        int cc =?35?;\n" +
//                             "        System.out.println(cc);\n" +
//                             "    }\n" +
//                             "}";

//         CompilationUnit compilationUnit = StaticJavaParser.parse(sourceCode);

//         ReflectionTypeSolver typeSolver = new ReflectionTypeSolver();
//         JavaSymbolSolver symbolSolver = new JavaSymbolSolver(typeSolver);
//         StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);

//         compilationUnit.findAll(VariableDeclarator.class).forEach(variableDeclarator -> {
//             if (variableDeclarator.getNameAsString().equals("cc")) {
//                 if (variableDeclarator.getType().isPrimitiveType()) {
//                     Expression initializer = variableDeclarator.getInitializer().orElse(null);
//                     if (initializer instanceof LiteralExpr) {
//                         LiteralExpr literalExpr = (LiteralExpr) initializer;
//                         String markedValue = "?" + getLiteralValueAsString(literalExpr) + "?";
//                         String replacementValue = "42";  // Substitua pelo valor desejado

//                         variableDeclarator.setInitializer(replaceMarkedValue(literalExpr, markedValue, replacementValue));
//                     }
//                 }
//             }
//         });

//         System.out.println(compilationUnit.toString());
//     }
  
//     public static String getLiteralValueAsString(LiteralExpr literalExpr) {
//         if (literalExpr.isBooleanLiteralExpr()) {
//             return Boolean.toString(literalExpr.asBooleanLiteralExpr().getValue());
//         } else if (literalExpr.isDoubleLiteralExpr()) {
//             return Double.toString(literalExpr.asDoubleLiteralExpr().asDouble());
//         } else if (literalExpr.isIntegerLiteralExpr()) {
//             return Integer.toString(literalExpr.asIntegerLiteralExpr().asInt());
//         } else if (literalExpr.isLongLiteralExpr()) {
//             return Long.toString(literalExpr.asLongLiteralExpr().asLong());
//         } else if (literalExpr.isNullLiteralExpr()) {
//             return "null";
//         } else if (literalExpr.isStringLiteralExpr()) {
//             return literalExpr.asStringLiteralExpr().asString();
//         } else {
//             return "";
//         }
//     }

//     public static String replaceMarkedValue(LiteralExpr literalExpr, String markedValue, String replacementValue) {
//         String valueType = literalExpr.calculateResolvedType().describe();

//         switch (valueType) {
//             case "int":
//                 return replacementValue;
//             case "long":
//                 return replacementValue + "L";
//             case "float":
//                 return replacementValue + "f";
//             case "double":
//                 return replacementValue + "d";
//             case "char":
//                 return "'" + replacementValue.charAt(0) + "'";
//             case "boolean":
//                 return Boolean.parseBoolean(replacementValue) ? "true" : "false";
//             default:
//                 return markedValue;
//         }
//     }
// }
//        String sourceCode = "public class MyClass {\n" +
//                "    public static void main(String[] args) {\n" +
//                "        int cc = ?36?;\n" +
//                "        System.out.println(cc);\n" +
//                "    }\n" +
//                "}";
//
//        CompilationUnit compilationUnit = StaticJavaParser.parse(sourceCode);
//
//        ReflectionTypeSolver typeSolver = new ReflectionTypeSolver();
//        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(typeSolver);
//        StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);
//
//        compilationUnit.findAll(VariableDeclarator.class).forEach(variableDeclarator -> {
//            if (variableDeclarator.getNameAsString().equals("cc")) {
//                if (variableDeclarator.getType().isPrimitiveType()) {
//                    Expression initializer = variableDeclarator.getInitializer().orElse(null);
//                    if (initializer instanceof LiteralExpr) {
//                        LiteralExpr literalExpr = (LiteralExpr) initializer;
//                        String markedValue = getMarkedValue(literalExpr);
//                        String replacementValue = "42";  // Substitua pelo valor desejado do mesmo tipo
//
//                        String valueType = literalExpr.calculateResolvedType().describe();
//                        String replacementCode = getReplacementCode(valueType, replacementValue);
//
//                        VariableDeclarationExpr declarationExpr = variableDeclarator.findAncestor(VariableDeclarationExpr.class).orElse(null);
//                        if (declarationExpr != null) {
//                            declarationExpr.replace(literalExpr, StaticJavaParser.parseExpression(replacementCode));
//                        }
//                    }
//                }
//            }
//        });
//
//        System.out.println(compilationUnit.toString());
//    }
//
//    private static String getMarkedValue(LiteralExpr literalExpr) {
//        String value = literalExpr.toString();
//        Pattern pattern = Pattern.compile("\\?(.*?)\\?");
//        Matcher matcher = pattern.matcher(value);
//        if (matcher.find()) {
//            return matcher.group(1);
//        }
//        return null;
//    }
//
//    private static String getReplacementCode(String valueType, String replacementValue) {
//        switch (valueType) {
//            case "int":
//                return replacementValue;
//            case "long":
//                return replacementValue + "L";
//            case "float":
//                return replacementValue + "f";
//            case "double":
//                return replacementValue + "d";
//            case "char":
//                return "'" + replacementValue.charAt(0) + "'";
//            case "boolean":
//                return Boolean.parseBoolean(replacementValue) ? "true" : "false";
//            default:
//                return "";
//        }
//    }
//}




























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

//----------------------------------o melhorzinho----------------------------------------------------------
//   String sourceCode = "public class MyClass {\n" +
//                              "    public static void main(String[] args) {\n" +
//                              "       Teste cc = @!@Teste@!@;\n" +
//                              "       Object dd = @!@Object@!@\n" +       
//                              "       int ee = @!@int@!@\n" +
//                              "        System.out.println(cc);\n" +
//                              "    }\n" +
//                             "}";


// //         //passa o codigo pro método que vai concatenar os ? no tipo já passando qual o tipo e pra oq trocar                                
//          String modifiedCode = replaceMarkedType(sourceCode,"object","double");
// //         //configuração da C.U e solvers, tem q usar o StaticJavaParser, o outro nao funciona aparentemente
// //         //instancia uma c.u e passa o codigo modificado que retornará
//          CompilationUnit compilationUnit = StaticJavaParser.parse(modifiedCode);
// //         //configura os solvers
//          ReflectionTypeSolver typeSolver = new ReflectionTypeSolver();
//          JavaSymbolSolver symbolSolver = new JavaSymbolSolver(typeSolver);
//          StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);
// //         //aqui ele percorre procurando o objeto "cc" e testa se acha o tipo q a gente tem q passar e dps muda
//          compilationUnit.findAll(VariableDeclarator.class).forEach(variableDeclarator -> {
//             if (variableDeclarator.getNameAsString().equals("cc")) {
//                  if (variableDeclarator.getType().isPrimitiveType() &&
//                         variableDeclarator.getType().asPrimitiveType().getType().asString().equals("object")) {
//                      variableDeclarator.setType(StaticJavaParser.parseType("double"));
//                  }
//             }
//          });

//          System.out.println(compilationUnit.toString());
//      }
// //     // concatena o tipo com as macações ? para que possa ser trocado
//      public static String replaceMarkedType(String code, String markedType, String replacementType) {


//          String pattern = "\\?" + Pattern.quote(markedType) + "\\?";
//          return code.replaceAll(pattern, replacementType);
//      }
//  }

String code = "public class Exemplo {\n" +
                "    ?int? num = 0;\n" +
                "    ?String? name = \"Joao\";\n" +
                "    ?double? value = 3.14;\n" +
                "}";

        List<String> types = extractTypes(code);
        System.out.println("Tipos encontrados:");
        for (String type : types) {
            System.out.println(type);
        }
    }

    public static List<String> extractTypes(String code) {
        List<String> types = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\?(.*?)\\?");
        Matcher matcher = pattern.matcher(code);

        while (matcher.find()) {
            String type = matcher.group(1).trim();
            types.add(type);
        }

        return types;
    }
  }

