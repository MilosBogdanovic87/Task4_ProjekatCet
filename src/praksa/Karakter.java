package praksa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Karakter extends FileHelper {
	protected String ime;
	protected String pripadnostGrupi;
	protected String logPoruka;

	// Parametrizovani konstruktor
	public Karakter(String ime, String pripadnostGrupi, String logPoruka) {
		this.ime = ime;
		this.pripadnostGrupi = pripadnostGrupi;
		this.logPoruka = logPoruka;
	}

	// Staticka metoda za štampanje podataka o likovima
	public static ArrayList<Karakter> citanjeKarakteraIzFajla(String imeFajla) {
		ArrayList<Karakter> karakteri = new ArrayList<>();
		Pattern pattern = Pattern.compile("^([^,]+),\\s*([^,]+),\\s*([^,]+)$");
		try (BufferedReader br = new BufferedReader(new FileReader(imeFajla))) {
			String linijaTeksta;
			br.readLine();
			while ((linijaTeksta = br.readLine()) != null) {
				Matcher matcher = pattern.matcher(linijaTeksta);
				if (matcher.matches()) {
					String ime = matcher.group(1).trim();
					String pripadnostGrupi = matcher.group(2).trim();
					String logPoruka = matcher.group(3).trim();
					karakteri.add(new Karakter(ime, pripadnostGrupi, logPoruka));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Karakter c : karakteri) {
			System.out.println(c);
			System.out.println();
		}
		return karakteri;
	}

	public String getImeKaraktera() {
		return ime;
	}

	public String getPripadnostGrupi() {
		return pripadnostGrupi;
	}

	public String getLogPoruka() {
		return logPoruka;
	}

	@Override
	public String toString() {
		return "Ime: " + ime + "\nPripadnost kući: " + pripadnostGrupi + "\nLog četa: " + logPoruka;
	}

	public String[] citanjePorukaIzFajla() {
		ArrayList<String> poruke = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(logPoruka))) {
			String linijaTeksta;
			while ((linijaTeksta = br.readLine()) != null) {
				poruke.add(linijaTeksta);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return poruke.toArray(new String[poruke.size()]);
	}

	public void stampanjePorukaKaraktera(String imeKaraktera) {
		if (!imeKaraktera.equals(ime)) {
			return;
		}
		String[] poruke = citanjePorukaIzFajla();
		for (String s : poruke) {
			System.out.println(s);
		}
	}

}
