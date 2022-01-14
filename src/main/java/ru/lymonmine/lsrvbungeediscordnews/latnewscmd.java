package ru.lymonmine.lsrvbungeediscordnews;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class latnewscmd extends Command {
    public latnewscmd() {
        super("latnews");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if (commandSender instanceof ProxiedPlayer) {
            if (!commandSender.hasPermission("lsrvbdn.lat")) {
                commandSender.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', main.instance.config.getString("lang.noperm"))));
            } else {
                if (discordlistener.url == null) {
                    commandSender.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', main.instance.config.getString("lang.last-post.nolast"))));
                } else {
                    commandSender.sendMessage(new TextComponent(ChatColor.translateAlternateColorCodes('&', main.instance.config.getString("lang.last-post.last"))));
                    TextComponent message = new TextComponent(ChatColor.LIGHT_PURPLE + "ПОСЛЕДНИЯ НОВОСТЬ");
                    message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, discordlistener.url));
                    message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.translateAlternateColorCodes('&', main.instance.config.getString("lang.last-post.mouse"))).create()));
                    commandSender.sendMessage(message);


                }
            }
        }
    }
}