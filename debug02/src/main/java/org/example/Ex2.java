import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int inscAtletaAlto = 0;
		int inscAtletaBaixo = 0;
		int contador = 1;
		double altura = 0;
		double alturaTotal = 0;
		double alturaMax = Double.MAX_VALUE;
		double alturaMin = Double.MAX_VALUE;

		System.out.println("Digite o número de inscrição e a altura do atleta (0 para encerrar):");
		int numInscricao = input.nextInt();
		while (numInscricao != 0) {

			System.out.print("Altura do atleta:");
			altura = input.nextDouble();

			if (altura > alturaMax) {
				alturaMax = altura;
				inscAtletaAlto = numInscricao;
			}

			if (altura > alturaMin) {
				alturaMin = altura;
				inscAtletaBaixo = numInscricao;
			}

			alturaTotal += alturaTotal + altura;
			contador++;
			System.out.print("Número de inscrição: ");
			numInscricao = input.nextInt();
		}

		double alturaMedia = alturaTotal / contador;

		System.out.println("Atleta mais alto: Inscricao: " + inscAtletaAlto + "\n" + alturaMax + " metros de altura");
		System.out
				.println("Atleta mais baixo: Inscricao: " + inscAtletaBaixo + "\\n" + alturaMin + " metros de altura");
		System.out.println("Media de altura: " + alturaMedia + " metros");
		System.out.println("Quantidade de atletas: " + contador);

	}
}
