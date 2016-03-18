
public class Episode extends Series{
		//private data for episode class
		//the episode title and the season of a series
		private String TitleAndSeason;
		//year the episode was first broadcasted
		private String brodcastYear;
		
		//constructor for the Episode class
		public Episode(String TitleAndSeason, String broadcastYear ){
		}
		
		
		/**
		 * Sets the episode title and season from a series.
		 *  Mutator method
		 * <P>
		 * Algorithm:<br>
		 * 1. Sets the episode title and season from a series. <br>
		 * 2. Sets to "????" if not present. <br>
		 * </P>
		 * @param 	TitleAndSeason	The episode title and season number
		 */
		public void setTitleAndSeason(String TitleAndSeason){
		}
		
		/**
		 * Sets the year the episode first aired. Mutator method
		 * <P>
		 * Algorithm:<br>
		 * 1. Sets the year the episode first aired. <br>
		 * 2. Sets to "????" if not present. <br>
		 * </P>
		 * @param 	broadcastYear	The year the episode first aired.
		 */
		public void setBroadcastYear(String broadcastYear){
		}
		
		/**
		 * Gets the title and season of episode. Accessor method
		 * <P>
		 * Algorithm:<br>
		 * 1. Gets the episode's title and season.<br>
		 * </P>
		 * @return  String		The title and season of episode
		 */
		public void getTitleAndSeason(String TitleAndSeason){
		}
		
		/**
		 * Gets the year the episode first broadcasted. Accessor method
		 * <P>
		 * Algorithm:<br>
		 * 1. Gets the episode's broadcast year.<br>
		 * </P>
		 * @return  String		The year the episode first broadcasted. 
		 */
		public String getBroadcastYear(){
			return null;
		}
}
