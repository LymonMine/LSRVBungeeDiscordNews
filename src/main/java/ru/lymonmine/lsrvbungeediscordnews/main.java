package ru.lymonmine.lsrvbungeediscordnews;

import net.dv8tion.jda.api.JDABuilder;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;

public final class main extends Plugin {
    public Configuration config;
    public File f;
    public static main instance;
    @Override
    public void onEnable(){
        //конфиг
        this.getDataFolder().mkdirs();
        this.f = new File(this.getDataFolder(), "config.yml");
        if (!this.f.exists()) {
            try {
                Files.copy(this.getResourceAsStream("config.yml"), this.f.toPath(), new CopyOption[0]);
            } catch (Exception ex) {
            }
        }
        try {
            this.config = ConfigurationProvider.getProvider((Class) YamlConfiguration.class).load(this.f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //конфиг
        //команды
        getProxy().getPluginManager().registerCommand(this, new latnewscmd());
        getProxy().getPluginManager().registerCommand(this, new fakenewscmd());
        //команды
        //discordapi
        JDABuilder builder = JDABuilder.createDefault(config.getString("bot.token"));
        builder.addEventListeners(new discordlistener());
        try {
            builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
        //discordapi
        instance = this;
    }

}
