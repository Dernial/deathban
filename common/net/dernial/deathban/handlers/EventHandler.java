package net.dernial.deathban.handlers;

import net.dernial.deathban.config.ConfigurationSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

/**
 * Deathban
 * 
 * EventHandler
 * 
 * @author dernial
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class EventHandler
{
    @ForgeSubscribe
    public void entityDied(LivingDeathEvent event)
    {
        if(ConfigurationSettings.DEATHBAN_ENABLED)
        {
            if(event.entityLiving instanceof EntityPlayer)
            {
                EntityPlayer deadPlayer = (EntityPlayer) event.entityLiving;
                
                PlayerDeathHandler.banPlayer(deadPlayer.username);
                
                EntityPlayerMP entityplayermp = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(deadPlayer.username);
                
                entityplayermp.playerNetServerHandler.kickPlayerFromServer(event.source.getDeathMessage(deadPlayer) + "\nBanned from death.");
            }
        }

    }
}
