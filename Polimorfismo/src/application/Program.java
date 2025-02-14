package application;

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
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Produto> list = new ArrayList<>();
		
		System.out.print("Insira a quantidade de produtos:");
		int n = sc.nextInt();
		
		for (int i = 0; i<n; i++) {
			System.out.println("Dados do #" + (i + 1) +  " produto:");
			System.out.print("Comum, usado ou importado (c/u/i)?");
			char ch = sc.next().charAt(0);
			System.out.print("Nome:");
			String nome = sc.next();
			System.out.print("Preço:");
			double preco = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Taxa da Alfandega:");
				double taxaAlfandega = sc.nextDouble();
				Produto prod = new ProdutoImportado(nome, preco, taxaAlfandega);
				list.add(prod);
			} else if (ch == 'u') {
				System.out.print("Data de fabricação (DD/MM/AAAA):");
				String dataDeFabricacaoStr = sc.next();
				Date dataDeFabricacao = sdf.parse(dataDeFabricacaoStr);				
				Produto prod = new ProdutoUsado(nome, preco, dataDeFabricacao);
				list.add(prod);
			} else {
				Produto prod = new Produto(nome, preco);
				list.add(prod);
			}
		}
		
		System.out.println();
		System.out.println("ETIQUETAS DE PREÇO:");
		for (Produto p : list) {
			System.out.println(p.etiquetaDePreco());
		}
		
		
		
		
		sc.close();
	}

}
