/**
 * Lead Author(s):
 * @author Anthony Bazalaki, Elias Zarate
 *
 * Class Responsibilities:
 * Distinguishes CPU and GPU as processors
 */
public interface Processor {
    
	/**
	 * OverClock the Computer Part
	 * @return clockSpeedMhz
	 */
	int getClockSpeedMHz();
}
