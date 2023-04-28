package praksa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BrojacPoruka {

	// Metoda koja broji poruke
	public static BrojacPoruka ispisBrojaPorukaZaLika(ArrayList<Karakter> karakteri, String imeKaraktera) {
		int brojacPoruka = 0;
		for (Karakter karakter : karakteri) {
			if (karakter.getImeKaraktera().equals(imeKaraktera)) {
				String logCeta = karakter.getLogPoruka();
				String putanjaDoFajla = "resource/message_logs/" + logCeta;
				try (BufferedReader br = new BufferedReader(new FileReader(putanjaDoFajla))) {
					String linija;
					while ((linija = br.readLine()) != null) {
						String[] delovi = linija.split(",");
						if (delovi.length >= 2) {
							String poruka = delovi[1].trim().substring(1, delovi[1].length() - 1);
							brojacPoruka++;
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// Štampanje rezultata
		System.out.println("Broj poruka za " + imeKaraktera + ": " + brojacPoruka);
		return null;
	}

}
