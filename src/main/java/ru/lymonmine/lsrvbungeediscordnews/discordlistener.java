package ru.lymonmine.lsrvbungeediscordnews;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import org.jetbrains.annotations.NotNull;

public class discordlistener extends ListenerAdapter {
    public static String url;
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String idchannel = event.getChannel().getId();
        String ids = event.getGuild().getId();
        url = "https://discord.com/channels/" + ids + "/" + idchannel + "/" + event.getMessageId();
        String cidchannel = main.instance.config.getString("bot.channel");
        if (idchannel.equals(cidchannel)) {
            for (String s : main.instance.config.getStringList("news")) {
                s = ChatColor.translateAlternateColorCodes('&', s);
                ProxyServer.getInstance().broadcast(s);
            }
        }
    }
}
