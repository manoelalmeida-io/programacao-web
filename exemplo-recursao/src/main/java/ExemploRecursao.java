public class ExemploRecursao {

  public static void main(String[] args) {
    contagemRegressivaRecursiva(5);
    System.out.println("Fatorial de 5: " + fatorialRecursivo(5));
    System.out.println("Fatorial de 10: " + fatorialIterativo(10));
    exibeVetor(new int[]{ 1, 2, 3, 4, 5 }, 0);
  }

  public static void contagemRegressivaRecursiva(int n) {
    if (n < 0) {
      return;
    }

    System.out.println(n);
    contagemRegressivaRecursiva(n - 1);
  }

  public static int fatorialRecursivo(int n) {
    if (n == 0) {
      return 1;
    }

    return n * fatorialRecursivo(n - 1);
  }

  public static int fatorialIterativo(int n) {
    int resultado = 1;
    for (int i = n; i > 0; i--) {
      resultado *= i;
    }

    return resultado;
  }

  public static void contagemRegressiva(int n) {
    for (int i = n; i >= 0; i--) {
      System.out.println(i);
    }
  }

  public static void exibeVetor (int[] v, int i) {
    if (i == v.length) {
      return;
    }

    System.out.println(v[i]);
    exibeVetor(v, i + 1);
  }
}
