package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Produto> list = new ArrayList<>();

		System.out.printf("Entre com o Numero de Produtos: ");
		int loop = sc.nextInt();

		for (int i = 1; i <= loop; i++) {
			System.out.println("Dados do Produto #" + i);
			System.out.printf("Comum, Usado ou Importando (C/U/I) ? ");
			char tipoDeProduto = sc.next().charAt(0);

			System.out.printf("Nome do Produto: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.printf("Preco do Produto: ");
			Double preco = sc.nextDouble();

			if (tipoDeProduto == 'i') {
				System.out.printf("Taxa de Importacao: ");
				Double taxa = sc.nextDouble();
				list.add(new ProdutoImportado(nome, preco, taxa));
			} else if (tipoDeProduto == 'u') {
				System.out.printf("Data de Fabricacao: (dd/mm/yyyy) ");
				Date data = sdf.parse(sc.next());
				list.add(new ProdutoUsado(nome, preco, data));
			} else if (tipoDeProduto == 'c') {
				list.add(new Produto(nome, preco));
			}
		}
		System.out.println("");
		System.out.println("Etique dos Produtos:");
		System.out.println("");
		for (Produto produto : list) {
			System.out.println(produto.etiquetaDePreco());
		}

		sc.close();
	}

}
