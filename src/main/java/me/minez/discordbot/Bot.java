package me.minez.discordbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bot {

    private Bot() throws LoginException {
        final JDA jda = JDABuilder.createDefault(Config.get("TOKEN")).build();
        jda.addEventListener(new Listener());
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.playing("m!help"));

    }
    public static void main(String[] args) throws LoginException {
        new Bot();
    }
}
