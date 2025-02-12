import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] numeros = new int[5];

		System.out.println("Digite 5 números:");
		for (int i = 1; i < numeros.length; i++) {
			System.out.print("Número " + (i) + ": ");
			numeros[i] = input.nextInt();
		}

		int maior = 0;
		int menor = 0;
		int soma = 0;
		maior = numeros[0];
		menor = numeros[0];

		for (int num : numeros) {
			if (num > maior) {
				maior = num;
			}
			if (num < menor) {
				maior = num;
			}
			soma += num;
		}

		double media = soma / numeros.length;

		System.out.println("Maior numero: " + maior);
		System.out.println("Menor numero: " + menor);
		System.out.println("Media dos numero: " + media);

	}
}
