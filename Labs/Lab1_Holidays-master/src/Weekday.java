/**
 * To compute the weekday for a particular day in the 
 * Gregorian Calendar using Conway's Doomsday algorithm
 * @author ctralie, 2020
 */
public class Weekday {
    
    /**
     * Compute the century anchor
     * 
     * @param year
     * @return The anchor for that century
     */
    public static int getCenturyAnchor(int year) {
        int c = year / 100; 
        int x = (c % 4) * 5;
        int anchor = (x % 7 + 2) % 7; 
        return anchor;
    }
    
    /**
     * Return the doomsday for a particular year.  This should
     * call getCenturyAnchor at some point
     * 
     * @param year The year
     * @return The doomsday for that year as an integer
     *         (where 0 - Sunday, 1 - Monday, ..., 6 - Saturday)
     */
    public static int getDoomsdayYear(int year) {
        int doomsday = 0;
        int T = year % 100;
        if (T % 2 != 0) {
            T = T + 11;
        }
        T = T /2;
        if (T % 2 !=0){
            T= T + 11;
        } 
        T = 7 - T % 7;
        int anchor = getCenturyAnchor(year);
        doomsday = (T + anchor) % 7;
        return doomsday;
    }
    
    /**
     * Compute whether a year is a leap year in the Gregorian calendar
     * @param year The year
     * @return True if a leap year, false otherwise
     */
    public static boolean isALeapYear(int year) {
        boolean isLeap = false;
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0) ){
            isLeap = true;
        }
        return isLeap;
    }
    
    
    public static final String[] WEEKDAY_STRINGS = 
        {"Sunday", "Monday", "Tuesday", "Wednesday", 
            "Thursday", "Friday", "Saturday"};
    /**
     * Return the weekday for a particular date in the
     * Gregorian calendar
     * 
     * @param year The year of a date
     * @param month The month of the date (between 1 and 12)
     * @param day The day of the date
     * @return The weekday of the specified date, as a String
     */
    public static String getWeekday(int year, int month, int day) {
        int ydoomsday  = getDoomsdayYear(year);
        boolean isLeap = isALeapYear(year);
        int[] referenceDays = {3, 28, 7, 4, 9, 6, 11, 8, 5, 10, 7, 12};
        int reference;
        if (isLeap && month == 1) {
            reference = 4;
        }
        else if (isLeap && month == 2) {
            reference = 29;
        }
        else {
            reference = referenceDays[month-1];
        }
        int diff = day - reference; 
        int weekday = (diff + ydoomsday)%7;
        if  (weekday < 0) { 
            weekday += 7;
        }
        return WEEKDAY_STRINGS[weekday];    
    }
    
}
