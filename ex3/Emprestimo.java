import java.util.Scanner;

public class Emprestimo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            System.out.print("Nome do colaborador: ");
            String nome = scanner.nextLine();

            System.out.print("Data de admissao (anos na empresa): ");
            int anosNaEmpresa = scanner.nextInt();

            System.out.print("Salario atual: ");
            double salario = scanner.nextDouble();

            System.out.print("Valor de emprestimo desejado: ");
            double valorEmprestimo = scanner.nextDouble();
            double MetadeEmprestimo = 0;
            double metadeEmprestimo = 0;
            if (anosNaEmpresa > 5) {
                    if (valorEmprestimo % 2 == 0) {
                double limiteEmprestimo = salario * 2;

                if (valorEmprestimo <= limiteEmprestimo) {
                    System.out.println("Escolha a opcao de retirada:");
                    System.out.println("1 - Notas de maior valor");
                    System.out.println("2 - Notas de menor valor");
                    System.out.println("3 - Notas meio a meio");

                    int opcao = scanner.nextInt();

                    switch (opcao) {
                        case 1:
                            calcularNotasMaiorValor(valorEmprestimo);
                            break;
                        case 2:
                            calcularNotasMenorValor(valorEmprestimo);
                            break;
                        case 3:
                            calcularNotasMeioAMeio(valorEmprestimo);
                            break;
                        default:
                            System.out.println("Opacao invalida.");
                    }
                } else {
                    System.out.println("Valor de emprestimo excede o limite permitido.");
                }
                    }
                else {
                     System.out.println("Insira um valor válido (múltiplo de dois).");
                }
            } else {
                System.out.println("Agradecemos seu interesse, mas voce nao atende os requisitos minimos do programa.");
            }

            System.out.print("Deseja calcular outro emprestimo? (s/n): ");
            scanner.nextLine(); 
            String resposta = scanner.nextLine().toLowerCase();
            continuar = resposta.equals("s");
        }

        System.out.println("Programa encerrado. Obrigado por usar nosso servico de emprestimo.");
        scanner.close();
    }

    private static void calcularNotasMaiorValor(double valorEmprestimo) {
        int notas100 = (int) (valorEmprestimo / 100);
        int notas50 = (int) ((valorEmprestimo % 100) / 50);
        int notas20m = (int) (((valorEmprestimo % 100) % 50) / 20);
        int notas10m = (int) ((((valorEmprestimo % 100) % 50) % 20) / 10);
        int notas5m = (int) (((((valorEmprestimo % 100) % 50) % 20) % 10) / 5);
        int notas2m = (int) ((((((valorEmprestimo % 100) % 50) % 20) % 10) % 5) / 2);

        System.out.println("Emprestimo em notas de maior valor:");
        System.out.println(notas100 + " x 100 reais");
        System.out.println(notas50 + " x 50 reais");
        System.out.println(notas20m + " x 20 reais");
        System.out.println(notas10m + " x 10 reais");
        System.out.println(notas5m + " x 5 reais");
        System.out.println(notas2m + " x 2 reais");
    }

    private static void calcularNotasMenorValor(double valorEmprestimo) {
        int notas20 = (int) (valorEmprestimo /20);
        int notas10 = (int) ((valorEmprestimo % 20) / 10);
        int notas5 = (int) (((valorEmprestimo % 20) % 10) / 5);
        int notas2 = (int) ((((valorEmprestimo % 20) % 10) % 5)/ 2);

        System.out.println("Emprestimo em notas de menor valor:");
        System.out.println(notas20 + " x 20 reais");
        System.out.println(notas10 + " x 10 reais");
        System.out.println(notas5 + " x 5 reais");
        System.out.println(notas2 + " x 2 reais");
    }

    private static void calcularNotasMeioAMeio(double valorEmprestimo) {
        double MetadeEmprestimo = valorEmprestimo / 2;
        int notas100 = (int) (MetadeEmprestimo / 100);
        int notas50 = (int) ((MetadeEmprestimo % 100) / 50);
        int notas20 = (int) (((MetadeEmprestimo % 100) % 50) / 20);
        int notas5 = (int) ((((MetadeEmprestimo % 100) % 50) % 20) /5);
        double metadeEmprestimo = valorEmprestimo / 2;
        int notas200 = (int) (metadeEmprestimo /20);
        int notas10 = (int) ((metadeEmprestimo % 20) / 10);
        int notas05 = (int) (((metadeEmprestimo % 20) % 10) / 5);
        int notas2 = (int) ((((metadeEmprestimo % 20) % 10) % 5) / 2);

        System.out.println("Metade do emprestimo em notas de maior valor: ");
        System.out.println(notas100 + " x 100 reais");
        System.out.println(notas50 + " x 50 reais");
        System.out.println(notas20 + " x 20 reais");
        System.out.println(notas5 + " x 5 reais");
        System.out.println("Metade do emprestimo em notas de menor valor:");
        System.out.println(notas200 + " x 20 reais");
        System.out.println(notas10 + " x 10 reais");
        System.out.println(notas05 + " x 5 reais");
        System.out.println(notas2 + " x 2 reais");
    }
}

