package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Entre com o caminho do diretório: ");
		String path = input.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Set<LogEntry> set = new HashSet<>();

			String line = br.readLine();
			while (line != null) {
				String[] vect = line.split(" ");
				set.add(new LogEntry(vect[0], Date.from(Instant.parse(vect[1]))));
				line = br.readLine();
			}
			
			System.out.println("Total de usuários: " + set.size());
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			if (input != null)
				input.close();
		}
	}
}