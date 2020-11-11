import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Holidays{
    public static final String[] HOLIDAY_NAMES = {
        "New Year's Day", 
        "Martin Luther King Jr. Day",
        "Chinese New Year",
        "Valentine's Day",
        "Presidents' Day",
        "Holi",
        "Good Friday",
        "Earth Day",
        "Cinco de Mayo",
        "Memorial Day",
        "Flag Day",
        "Juneteenth",
        "Independence Day",
        "Bastille Day",
        "Hijra - Islamic New Year",
        "Labor Day",
        "Rosh Hashana",
        "Yom Kippur",
        "Sukkot",
        "National Cat Day",
        "Halloween",
        "Veterans Day",
        "Diwali",
        "Thanksgiving",
        "Christmas Day"
    };
    public static final int[][] HOLIDAY_DATES = {
        {1, 1}, {1, 20}, {1, 25}, {2, 14}, {2, 17}, {3, 9}, {4, 10}, {4, 22}, 
        {5, 5}, {5, 25}, {6, 14}, {6, 19}, {7, 4}, {7, 14}, {8, 21}, {9, 7}, 
        {9, 18}, {9, 27}, {10, 9}, {10, 29}, {10, 31}, {11, 11}, {11, 14}, 
        {11, 26}, {12, 25} 
    };
    
    /**
     * Setup a string that's required at the beginning of the HTML document,
     * which includes the title "Holidays"
     * @return String at the end of the HTML document
     */
    public static String getHTMLStart() {
        String ret = "<html>\n";
        ret += "    <head>\n";
        ret += "        <meta charset=utf-8></meta>\n";
        ret += "        <title>Major Holidays 2020</title>\n";
        ret += "        <style>\n";
        ret += "            table, th, td {";
        ret += "border: 1px solid black;";
        ret += "padding: 15px; text-align: center; }\n";
        ret += "            body {background-color: f5f5dc;}\n";
        ret += "            h1 {text-align: center;}\n";
        ret += "            table.center { margin-left: auto; margin-right: auto;}";
        ret += "\n        </style>";
        ret += "\n  </head>\n";
        ret += "    <body>\n";
        ret += "      <h1>Holidays</h1>";
        return ret;
    }
    
    /**
     * Setup a string that's required at the end of the HTML document
     * @return String at the end of the HTML document
     */
    public static String getHTMLEnd() {
        return "    </body>\n</html>";
    }
    
    /**
     * Write a string to a file using the PrintWriter class
     * @param filename Name of the file to which to write the string
     * @param s String to write to the file
     */
    public static void writeToFile(String filename, String s) {
        try (PrintWriter out = new PrintWriter(filename)) {
            out.write(s);
        }
        catch(FileNotFoundException e) {
            System.out.println("Could not open " + filename);
        }
    }
    
    // TODO: Create a method that converts a month nubmer into a string
    public static String getMonthName(int month){
        String[] monthNames = { 
            "January", 
            "Feburary", 
            "March", 
            "April", 
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"};
        return monthNames[month - 1];
    }
    
    
    // TODO: Create a method that returns a String corresponding to a 
    // particular row of the table
    public static String getHolidayRow(int holiday){
        return "        <tr>\n          <td>" + Weekday.getWeekday(2020, HOLIDAY_DATES[holiday][0],HOLIDAY_DATES[holiday][1]) + "</td>\n          <td>" + getMonthName(HOLIDAY_DATES[holiday][0]) + "</td>\n          <td>" + HOLIDAY_DATES[holiday][1] + "</td>\n          <td>" + HOLIDAY_NAMES[holiday] + "</td>\n       </tr>\n";
    }
    
    
    // TODO: Create a method that pieces the full HTML string together and then 
    // writes all of the HTML code to a file
    public static void createCode(){
        String code = getHTMLStart() + "\n      <table class=\"center\">\n";
        code += "        <tr>\n          <td>Weekday</td>\n          <td>Month</td>\n          <td>Day</td>\n          <td>Holiday</td>\n        </tr>\n";
        for(int i = 0; i < HOLIDAY_NAMES.length; i++){
            code += getHolidayRow(i);
        }
        code += "\n      </table>\n" + getHTMLEnd();
        writeToFile("holidays.html", code);
    }
    
    public static void main(String[] args) {
        // TODO: Call the method from here that writes all of the HTML
        // code to a file
        createCode();
    }
}
