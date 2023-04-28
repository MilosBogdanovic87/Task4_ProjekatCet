package praksa;

public enum Emoji {
	HAPPY("😄", "🙂", "😊", "😍"), SAD("😢", "😭", "😞", "👿"), LOVING("😍", "😘");

	private final String[] emoji;

	Emoji(String... emoji) {
		this.emoji = emoji;
	}

	public String[] getEmoji() {
		return emoji;
	}
}
