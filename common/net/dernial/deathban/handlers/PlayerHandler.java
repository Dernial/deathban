package net.dernial.deathban.handlers;

import net.dernial.deathban.config.ConfigurationSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import cpw.mods.fml.common.IPlayerTracker;

public class PlayerHandler implements IPlayerTracker
{
    @Override
    public void onPlayerLogin(EntityPlayer player)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onPlayerLogout(EntityPlayer player)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onPlayerChangedDimension(EntityPlayer player)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onPlayerRespawn(EntityPlayer player)
    {
        if(PlayerDeathHandler.isBanned(player.username))
        {
            EntityPlayerMP entityplayermp = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(player.username);
            
            entityplayermp.playerNetServerHandler.kickPlayerFromServer("Banned from death.");
        }
    }
    
    @ForgeSubscribe
    public void entityDied(LivingDeathEvent event)
    {
        if(ConfigurationSettings.DEATHBAN_ENABLED)
        {
            if(event.entityLiving instanceof EntityPlayer)
            {
                EntityPlayer deadPlayer = (EntityPlayer) event.entityLiving;
                
                PlayerDeathHandler.banPlayer(deadPlayer.username);
            }
        }

    }

}
