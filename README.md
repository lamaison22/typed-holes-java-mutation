# 🛠️ Java Random Program Generator with Typed Placeholders

This project aims to automatically generate Java programs from skeletons containing **typed placeholders**. The system replaces these placeholders with valid random values, compiles the resulting files, and executes them to validate whether the final program is functional.

---

## 📁 Project Structure

```
.
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── br/edu/ifsc/javarg/         # Contains the MainClass with placeholders
│   │       └── br/edu/ifsc/javargexamples/ # Auxiliary example classes
│   └── test/
│       └── java/
│           └── br/edu/ifsc/javarg/         # MainTest with substitution and test methods
├── TestesGerados/                          # Automatically generated Java programs
│   └── br/edu/ifsc/javarg/                 # .class files generated from compilation
└── README.md
```

---

## 🧱 How the Skeletons Work

The generation process starts with **Java code skeletons** that contain **explicitly typed placeholders**, such as:

```java
int x = __int__valueX;
boolean cond = __boolean__condition;
A a = new A(__int__a1, __boolean__a2);
```

These placeholders follow the format `__Type__name`, where:

- `Type` is the variable type (`int`, `double`, `boolean`, or a custom class)
- `name` is an identifier to allow the same value to be reused if needed

---

## ⚙️ MainTest Class

The `MainTest` class contains the core methods for the generation pipeline:

### 🔄 Placeholder Substitution

- `processPlaceholders(String path)`  
  Loads a `.java` skeleton, identifies all placeholders, and replaces them with valid values.

- `generateExpressionForType(String tipo)`  
  Generates a random expression based on the type (`int`, `boolean`, `double`, or instances of imported classes).

### 📁 Saving and Organizing

- `saveGeneratedCode(CompilationUnit cu)`  
  Saves the resulting code as `MainClass_X.java`, where X is incremental, inside the `TestesGerados` folder.

### 🔨 Compilation

- `compileWithJavac(File file)`  
  Uses a selected Java compiler to compile the generated `.java` file. The resulting `.class` files are stored automatically in `TestesGerados/br/...`.

### ▶️ Execution

- `runGeneratedClass(String fullyQualifiedName)`  
  Executes the compiled `.class` using `java` and the correct classpath, and returns whether execution succeeded.

### 🔁 Batch Testing

- `TestCodeGenerationBatch(int n)`  
  Automatically generates, compiles, and runs `n` programs, displaying how many were successful.

### 🔧 RunGeneratedClasses with Custom Java

The method `RunGeneratedClasses()` compiles and runs all generated `.java` files using customizable Java compilers. The following variables should be set:

- `compilerJavaCPath`: path to `javac.exe` (for compilation)
- `compilerJavaPath`: path to `java.exe` (for execution)

> ⚠️ It is strongly recommended to use the **same Java version** for both compilation and execution.

Example snippet:

```java
String compilerJavaCPath = jdkJavaCPath; // Set your compiler for javac
String compilerJavaPath = jdkJavaPath;   // Set your compiler for java runtime
```

Full method:

```java
public void RunGeneratedClasses() throws Exception {
    int successCount = 0;
    int failureCount = 0;

    String compilerJavaCPath = jdkJavaCPath;
    String compilerJavaPath = jdkJavaPath;

    File outputDir = new File(OUTPUT_DIRECTORY);
    if (outputDir.exists() && outputDir.isDirectory()) {
        File[] files = outputDir.listFiles((dir, name) -> name.endsWith(".java"));
        if (files != null) {
            for (File file : files) {
                System.out.println("Compiling: " + file.getName() + " with " + compilerJavaCPath);
                boolean compiled = compileWithJavac(file, compilerJavaCPath);
                String className = "br.edu.ifsc.javarg." + file.getName().replace(".java", "");
                System.out.println("Running: " + className);
                if (compiled) {
                    boolean executed = runGeneratedClass(className, compilerJavaPath);
                    if (executed) successCount++;
                    else {
                        failureCount++;
                        System.out.println("Execution failed: " + className);
                    }
                } else {
                    failureCount++;
                    System.out.println("Compilation failed: " + file.getName());
                }
            }
        } else {
            System.out.println("No .java files found in: " + OUTPUT_DIRECTORY);
        }
    } else {
        System.out.println("Output directory not found: " + OUTPUT_DIRECTORY);
    }

    System.out.println("
==== FINAL RESULT ====");
    System.out.println("Successful runs: " + successCount);
    System.out.println("Failures: " + failureCount);
}
```

---

## ✅ Why Compile and Execute?

- **Compilation ensures** the substituted code is syntactically valid Java.
- **Execution ensures** the program does not throw runtime exceptions.
- Together, these validate the robustness and semantic correctness of the generated code.

---

## 🧠 Final Remarks

Currently, the system performs best with primitive types and classes whose constructors only take primitive parameters. Future work may include:

- Supporting more complex types (lists, arrays, generics, etc.)
- Dynamic imports and deeper constructor analysis
- Integrating program synthesis or AI-based suggestion models

The generator can serve as a base for:

- **Automated educational tools**
- **Mutation testing**
- **Compiler stress testing**
- **Template-based code synthesis research**
