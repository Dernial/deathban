package net.dernial.deathban.handlers;

import net.dernial.deathban.config.ConfigurationSettings;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

/**
 * Deathban
 * 
 * BanHandler
 * 
 * @author dernial
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class BanHandler implements IConnectionHandler
{
    @Override
    public String connectionReceived(NetLoginHandler netHandler,
            INetworkManager manager)
    {
        // Check to see if everything is enabled, and if user is banned and keep them from finishing the connection if they're banned.
        if(ConfigurationSettings.DEATHBAN_ENABLED)
            if (PlayerDeathHandler.isBanned(netHandler.clientUsername))
                if(ConfigurationSettings.DEATHBAN_PERMANENT)
                    return String.format("You are dead! Death is perminant.");
                else
                    return String.format("You are dead! You may return at %s.", PlayerDeathHandler.getReturnTime(netHandler.clientUsername));

        return null;
    }

    @Override
    public void connectionOpened(NetHandler netClientHandler, String server,
            int port, INetworkManager manager)
    {

    }

    @Override
    public void connectionOpened(NetHandler netClientHandler,
            MinecraftServer server, INetworkManager manager)
    {

    }

    @Override
    public void connectionClosed(INetworkManager manager)
    {

    }

    @Override
    public void clientLoggedIn(NetHandler clientHandler,
            INetworkManager manager, Packet1Login login)
    {

    }

    @Override
    public void playerLoggedIn(Player player, NetHandler netHandler,
            INetworkManager manager)
    {
        
    }
}