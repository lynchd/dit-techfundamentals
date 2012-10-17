package ie.dit.architecture;

public class Delay {
		public static void delay(int periodInMs) {
			try {
				Thread.sleep(periodInMs);
			}
			catch (Exception ex) {
				// don't care
			}	
		}
}
