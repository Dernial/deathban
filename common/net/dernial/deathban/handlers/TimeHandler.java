package net.dernial.deathban.handlers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Deathban
 * 
 * TimeHandler
 * 
 * @author dernial
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class TimeHandler {
    
    public int days = 0;
    public int hours = 0;
    public int minutes = 0;
    
    private static Pattern daysPattern = Pattern.compile("\\d+[dD]");
    private static Pattern hoursPattern = Pattern.compile("\\d+[hH]");
    private static Pattern minutesPattern = Pattern.compile("\\d+[mM]");
    
    public TimeHandler(String sIncomingTime)
    {
        Matcher daysMatch = daysPattern.matcher(sIncomingTime);
        Matcher hoursMatch = hoursPattern.matcher(sIncomingTime);
        Matcher minutesMatch = minutesPattern.matcher(sIncomingTime);
        
        if(daysMatch.find())
            days = Integer.parseInt(daysMatch.group(0).substring(0, daysMatch.group(0).length() - 1));
        if(hoursMatch.find())
            hours = Integer.parseInt(hoursMatch.group(0).substring(0, hoursMatch.group(0).length() - 1));
        if(minutesMatch.find())
            minutes = Integer.parseInt(minutesMatch.group(0).substring(0, minutesMatch.group(0).length() - 1));            
    }
    
    public String buildString()
    {
        return String.format("%dD%dH%dM", days, hours, minutes);
    }
}
