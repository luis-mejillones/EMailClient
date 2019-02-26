package app;

/**
 * Programa principal que crea una instancia de la clase
 * Demo y hace un par de busquedas con los textos definidos.
 */
public class Main {
  public static void main(String[] args) {
    String searchCriteria1 = "demo01";
    String searchCriteria2 = "important";

    Demo demo = new Demo();
    demo.search(searchCriteria1);
    demo.search(searchCriteria2);
  }
}
