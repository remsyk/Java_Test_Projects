import java.awt.Color;

import org.apache.commons.lang3.StringUtils;

public class Feel2Color {
 
	float red1, green1, blue1, hue1, saturation1, brightness1;
	/**
	 * 
	 * @param red input value from wordColor
	 * @param green input value from wordColor
	 * @param blue input value from wordColor
	 * @param hue input value from wordColor
	 * @param brightness input value from wordColor
	 * @param c color generated by input values
	 * @param hsb hue, saturation, brightness
	 * @return hex string generated to be put in ColorPatch class
	 */
	public String colorFeel(float red, float green, float blue, float hue, float saturation, float brightness) {

		Color c = new Color(red, green, blue);
		float[] hsb = new float[3];
		Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), hsb);
		c = new Color(Color.HSBtoRGB(hue, saturation, brightness));
		String hex = Integer.toHexString(c.getRGB() & 0xffffff);
		if (hex.length() < 6) {
		    hex = "0" + hex;
		}
		hex = "#" + hex;
		return hex;
	}
	/**
	 * 
	 * @param userEnt the entry the user made
	 * @param joyful string[] containing joyful words
	 * @param sad string[] containing sad words
	 * @param peaceful  string[] containing peaceful words
	 * @param powerful string[] containing powerful words
	 * @param scared string[] containing scared words
	 * @param mad string[] containing mad words
	 * @param green1 float value for number of times a scared word appears in user entry
	 * @param blue1 float value for number of times a sad word appears in user entry
	 * @param red1 float value for number of times a mad word appears in user entry
	 * @param hue1 float value for number of times a peaceful word appears in user entry
	 * @param saturation1 float value for number of times a powerful word appears in user entry
	 * @param brightness float value for number of times a sad word appears in user entry
	 * @return colorFeel method
	 */

	public String wordColor(String userEnt) {

		String[] joyful = { "Amused", "Buoyant", "Delighted", "Elated", "Ecstatic", "Glad", "Gleeful", "happy",
				"Jubilant", "Merry", "Mirthful", "Overjoyed", "Pleased", "Radiant", "Tickled", "excited", "sexy",
				"energetic", "playful", "creative", "aware", "daring", "fascinating", "stimulating", "extravagant",
				"delightful" };
		String[] sad = { "guilty", "ashamed", "depressed", "lonely", "bored", "sleepy", "bashful", "stupid",
				"miserable", "inadequate", "inferior", "apathetic", "blue", "dejected", "despair", "sad", "despondent",
				"disappointed", "gloomy", "grief", "heavy", "hopeless", "melancholy", "sorrow", "unhappy", "lonely",
				"nothing" };
		String[] peaceful = { "content", "thoughtful", "intimate", "loving", "trusting", "nurturing", "pensive",
				"relaxed", "responsive", "serene", "sentimental", "thankful", "blissful", "calm", "centered", "clear",
				"mellow", "quiet", "tranquil", "close", "friendly", "loving", "openhearted", "open", "tender", "enough",
				"understanding", "easy", "free", "interested", "receptive", "kind" };
		String[] powerful = { "faithful", "important", "hopeful", "appreciated", "respected", "proud", "confident",
				"intelligent", "worthwile", "valuable", "satisfied", "amazed", "awed", "uplifted", "optimisic", "went",
				"played", "won", "ran", "walked", "walk", "power", "strong", "openhearted", "play" };
		String[] scared = { "rejected", "confused", "helpless", "submissive", "insecure", "anxious", "bewildered",
				"discouraged", "insignificant", "weak", "foolish", "embarrassed", "dismay", "startled", "surprised",
				"horrified", "anxious", "edgy", "restless", "stress", "uneasy", "scared", "fright", "shock",
				"affraid" };
		String[] mad = { "hurt", "hostile", "angry", "rage", "hate", "critical", "jealous", "selfish", "frustrated",
				"furious", "irritated", "skeptical", "agitated", "troubled", "turmoil", "dislike", "distain", "scorn",
				"surly", "enraged", "hate", "vengeful", "distain", "ticked", "appalled" };

		for (int i = 0; i < 25; i++) {
			green1 += StringUtils.countMatches(userEnt.toLowerCase(), scared[i].toLowerCase());
			blue1 += StringUtils.countMatches(userEnt.toLowerCase(), sad[i].toLowerCase());
			red1 += StringUtils.countMatches(userEnt.toLowerCase(), mad[i].toLowerCase());
			hue1 += StringUtils.countMatches(userEnt.toLowerCase(), peaceful[i].toLowerCase());
			saturation1 += StringUtils.countMatches(userEnt.toLowerCase(), powerful[i].toLowerCase());
			brightness1 += StringUtils.countMatches(userEnt.toLowerCase(), joyful[i].toLowerCase());

		}

		return colorFeel(red1 * 0.07f, green1 * 0.03f, blue1 * 0.06f, hue1 * 0.07f, (saturation1 * 0.09f) + 0.3f,
				(brightness1 * 0.09f) + 0.4f);
	}
}
