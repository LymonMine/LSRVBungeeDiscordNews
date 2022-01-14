package ru.lymonmine.lsrvbungeediscordnews;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class fakenewscmd extends Command {
    public fakenewscmd() {
        super("fakenews");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if (commandSender instanceof ProxiedPlayer) {
            if (!commandSender.hasPermission("lsrvbdn.fake")) {
                commandSender.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', main.instance.config.getString("lang.noperm"))));
            } else {
                for (String s : main.instance.config.getStringList("news")) {
                    s = ChatColor.translateAlternateColorCodes('&', s);
                    ProxyServer.getInstance().broadcast(s);


                }
            }
        }
    }
}
