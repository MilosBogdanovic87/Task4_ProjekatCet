package praksa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CitacPoruka {

	private String imeFajla;

	public CitacPoruka(String imeFajla) {
		this.imeFajla = imeFajla;
	}

	public void procitajPoruke() {
		try (BufferedReader br = new BufferedReader(new FileReader(imeFajla))) {
			String linija;
			while ((linija = br.readLine()) != null) {
				System.out.println(linija);
			}
		} catch (IOException e) {
			System.err.println("Greška pri čitanju fajla: " + e.getMessage());
		}
	}

}
