package praksa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalizaKaraktera {

	// Metoda koja utvrđuje broj tužnih i broj srećnih smajlija
	public void analizirajKarakter(ArrayList<Karakter> karakter) throws IOException {
		for (Karakter k : karakter) {
			int brojSrecnih = 0;
			int brojTuznih = 0;
			BufferedReader br = new BufferedReader(new FileReader("resource/message_logs/" + k.getLogPoruka()));
			String linija = br.readLine();

			// Obrada smajlija
			while (linija != null) {
				for (Emoji emoji : Emoji.values()) {
					String[] emojiNiz = emoji.getEmoji();
					for (String e : emojiNiz) {
						Pattern pattern = Pattern.compile(e);
						Matcher matcher = pattern.matcher(linija);
						int count = 0;
						while (matcher.find()) {
							count++;
						}
						if (emoji == Emoji.HAPPY) {
							brojSrecnih += count;
						} else if (emoji == Emoji.SAD) {
							brojTuznih += count;
						}
					}
				}
				linija = br.readLine();
			}

			// Ispisivanje broja tužnih i broja srećnih smajlija
			if (brojSrecnih > brojTuznih) {
				System.out.println(k.getImeKaraktera() + " je srećan! Ima " + brojSrecnih + " srećnih i " + brojTuznih
						+ " tužnih smajlija!");
			} else if (brojSrecnih < brojTuznih) {
				System.out.println(k.getImeKaraktera() + " je tužan! Ima " + brojSrecnih + " srećnih i " + brojTuznih
						+ " tužnih smajlija!");
			} else {
				System.out.println(k.getImeKaraktera() + " je u neutralnom raspoloženju. Ima " + brojSrecnih
						+ " srećnih i " + brojTuznih + " tužnih smajlija!");
			}

			br.close();
		}
	}

	// Metoda koja utvrđuje koji karakter je najpozitivniji a koji najnegativniji
	public void analizirajKarakterSrecniTuzni(ArrayList<Karakter> karakter) throws IOException {
		Karakter najpozitivnijiKarakter = null;
		Karakter najnegativnijiKarakter = null;
		int najviseSrecnih = 0;
		int najviseTuznih = 0;

		for (Karakter k : karakter) {
			int brojSrecnih = 0;
			int brojTuznih = 0;
			BufferedReader br = new BufferedReader(new FileReader("resource/message_logs/" + k.getLogPoruka()));
			String linija = br.readLine();

			// Obrada smajlija
			while (linija != null) {
				for (Emoji emoji : Emoji.values()) {
					String[] emojiNiz = emoji.getEmoji();
					for (String e : emojiNiz) {
						Pattern pattern = Pattern.compile(e);
						Matcher matcher = pattern.matcher(linija);
						int count = 0;
						while (matcher.find()) {
							count++;
						}
						if (emoji == Emoji.HAPPY) {
							brojSrecnih += count;
						} else if (emoji == Emoji.SAD) {
							brojTuznih += count;
						}
					}
				}
				linija = br.readLine();
			}

			// Poređenje karaktera
			if (brojSrecnih > najviseSrecnih) {
				najpozitivnijiKarakter = k;
				najviseSrecnih = brojSrecnih;
			}

			if (brojTuznih > najviseTuznih) {
				najnegativnijiKarakter = k;
				najviseTuznih = brojTuznih;
			}

			br.close();
		}
		// Štampanje rezultzata
		System.out.println("Najpozitivniji karakter: " + najpozitivnijiKarakter.getImeKaraktera() + " sa "
				+ najviseSrecnih + " srećnih smajlija.");
		System.out.println("Najnegativniji karakter: " + najnegativnijiKarakter.getImeKaraktera() + " sa "
				+ najviseTuznih + " tužnih smajlija.");

	}

	// Metoda koja analizira da li Jon više voli Deniris ili ona više voli njega
	public static void analizirajLjubav(ArrayList<Karakter> karakter) {
		int jonBrojLjubavnih = 0;
		int daenerysBrojLjubavnih = 0;
		for (Karakter k : karakter) {
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader("resource/message_logs/" + k.getLogPoruka()));
				String linija = br.readLine();
				// Obrada ljubavnih smajlija
				while (linija != null) {
					for (Emoji emoji : Emoji.values()) {
						if (emoji == Emoji.LOVING) {
							String[] emojiNiz = emoji.getEmoji();

							for (String e : emojiNiz) {
								Pattern pattern = Pattern.compile(e);
								Matcher matcher = pattern.matcher(linija);
								int count = 0;
								while (matcher.find()) {
									count++;
								}
								if (k.getImeKaraktera().equals("Jon Snow") && count > 0) {
									jonBrojLjubavnih += count;
								} else if (k.getImeKaraktera().equals("Daenerys Targaryen") && count > 0) {
									daenerysBrojLjubavnih += count;
								}
							}
						}
					}
					linija = br.readLine();
				}
				br.close();
			} catch (IOException e) {
				System.out.println("Nije moguće otvoriti datoteku: " + k.getLogPoruka());
			}
		}
		// Štampanje rezultata
		if (jonBrojLjubavnih > daenerysBrojLjubavnih) {
			System.out.println("Jon voli Daenerys više nego što ona voli njega!");
		} else if (jonBrojLjubavnih < daenerysBrojLjubavnih) {
			System.out.println("Daenerys voli Jona više nego što on voli nju!");
		} else {
			System.out.println("Jon i Daenerys jednako vole jedno drugo!");
		}
	}

}
