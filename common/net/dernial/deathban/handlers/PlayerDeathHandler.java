package net.dernial.deathban.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import net.dernial.deathban.config.ConfigurationSettings;
import net.dernial.deathban.lib.Reference;
import cpw.mods.fml.common.FMLLog;

/**
 * Deathban
 * 
 * PlayerDeathHandler
 * 
 * @author dernial
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class PlayerDeathHandler
{
    private static HashMap<String, Date> mPlayersBanned;

    /**
     * Get the player's return time based on username
     * 
     * @param sUserName Player's username
     * @return a Date value containing the date/time of player's return.
     */
    public static Date getUnbanTime(String sUserName)
    {
        return mPlayersBanned.get(sUserName);
    }

    /**
     * Set the time/date a player can return.
     * 
     * @param sUserName Player's username
     * @param mDate the date/time they will be unbanned
     */
    public static void setUnbanTime(String sUserName, Date mDate)
    {
        mPlayersBanned.put(sUserName, mDate);

        saveBans(Reference.BAN_FILE);
    }

    /**
     * Checks to see if the user is banned.
     * 
     * @param sUserName Player's username
     * @return True if they are banned, false if they are not
     */
    public static Boolean isBanned(String sUserName)
    { 
        if (mPlayersBanned.containsKey(sUserName))
            if(ConfigurationSettings.DEATHBAN_PERMANENT)
                return true;
            else
            {
                if(new Date().before(getUnbanTime(sUserName)))
                    return true;
                else
                {
                    // Time is expired remove name from list.
                    removeBan(sUserName);
                    return false;
                }
            }

        return false;
    }

    /**
     * Get the time the player can return
     * 
     * @param sUserName Player's Username
     * @return a string value of when the player can return
     */
    public static String getReturnTime(String sUserName)
    {
        DateFormat dateFormat = new SimpleDateFormat(Reference.DATETIME_FORMAT);
        return dateFormat.format(getUnbanTime(sUserName));
    }

    /**
     * Adds a player to the banned list. Uses the configured ban length.
     * 
     * @param sUserName Player's Username
     */
    public static void banPlayer(String sUserName)
    {

        Calendar cal = Calendar.getInstance();
        
        TimeHandler clTime = new TimeHandler(ConfigurationSettings.DEATHBAN_BAN_TIME);
        
        cal.add(Calendar.DAY_OF_MONTH, clTime.days);
        cal.add(Calendar.HOUR, clTime.hours);
        cal.add(Calendar.MINUTE, clTime.minutes);

        setUnbanTime(sUserName, cal.getTime());
    }
    
    /**
     * Removes a player from the ban list.
     * 
     * @param sUserName Player's username
     * @return True if player was on list and was removed, false if the player was not on the list
     */
    public static Boolean removeBan(String sUserName) {
        if(mPlayersBanned.containsKey(sUserName))
        {
            mPlayersBanned.remove(sUserName);
            saveBans(Reference.BAN_FILE);
            return true;
        }
        return false;
    }
    
    /**
     * Clears the ban list.
     */
    public static void clearBans() {
        mPlayersBanned.clear();
        saveBans(Reference.BAN_FILE);
    }

    /**
     * Loads the current ban list.
     * 
     * @param sBanFile absolute Path/filename of ban file
     */
    public static void loadBans(String sBanFile)
    {
        mPlayersBanned = new HashMap<String, Date>();  
        
        DateFormat dateFormat = new SimpleDateFormat(Reference.DATETIME_FORMAT);    
        
        try
        {
            File inputfile = new File(sBanFile);

            FileInputStream inputStream = new FileInputStream(inputfile);

            Scanner fileScanner = new Scanner(inputStream);

            // read data from file line by line:
            String currentLine;

            while (fileScanner.hasNextLine())
            {
                currentLine = fileScanner.nextLine();

                StringTokenizer tokenizedString = new StringTokenizer(currentLine, "=", false);

                mPlayersBanned.put(tokenizedString.nextToken(), dateFormat.parse(tokenizedString.nextToken()));
            }

            fileScanner.close();
            inputStream.close();
        } catch (Exception e)
        {
            FMLLog.severe("Something went wrong loading Ban file: %s", e.getMessage());
        }
    }

    /**
     * Saves the stored memory list to disk.
     * 
     * @param sBanFile absolute path/file to the ban file
     */
    public static void saveBans(String sBanFile)
    {
        DateFormat dateFormat = new SimpleDateFormat(Reference.DATETIME_FORMAT);

        try
        {
            File outputFile = new File(sBanFile);

            FileOutputStream outputStream = new FileOutputStream(outputFile);

            PrintWriter fileWriter = new PrintWriter(outputStream);

            for (Map.Entry<String, Date> currentEntry : mPlayersBanned.entrySet())
            {
                fileWriter.println(currentEntry.getKey() + "=" + dateFormat.format(currentEntry.getValue()));
            }

            fileWriter.flush();
            outputStream.close();

        } catch (Exception e)
        {
        }
    }
}
