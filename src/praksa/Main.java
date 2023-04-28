package praksa;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Kreiranje liste karaktera iz fajla
		ArrayList<Karakter> karakteri = Karakter.citanjeKarakteraIzFajla("resource/got_meta_data.txt");

		// Ispis poruka koje je poslala Daenerys Stormborn
		CitacPoruka cp = new CitacPoruka("resource/message_logs/messages82387561293.txt");
		cp.procitajPoruke();

		System.out.println();
		// Ispisivanje broja poruka po karakterima
		BrojacPoruka bp = BrojacPoruka.ispisBrojaPorukaZaLika(karakteri, "Daenerys Stormborn");
		BrojacPoruka bp2 = BrojacPoruka.ispisBrojaPorukaZaLika(karakteri, "Jon Snow");
		BrojacPoruka bp3 = BrojacPoruka.ispisBrojaPorukaZaLika(karakteri, "Tyrion Lannister");
		BrojacPoruka bp4 = BrojacPoruka.ispisBrojaPorukaZaLika(karakteri, "Cersei Lannister");

		System.out.println();
		// Analiza karaktera - broj srećnih i tužnih smajlija
		AnalizaKaraktera ak = new AnalizaKaraktera();
		ak.analizirajKarakter(karakteri);
		System.out.println();
		// Izdvajanje karaktera sa najviše srećnih i karaktera sa najviše tužnih
		// smajlija
		ak.analizirajKarakterSrecniTuzni(karakteri);
		System.out.println();
		// Proveravamo da li Jon više voli Deniris ili ona više voli njega
		ak.analizirajLjubav(karakteri);

	}

}
