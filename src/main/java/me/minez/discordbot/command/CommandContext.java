package me.minez.discordbot.command;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.sharding.ShardManager;

import java.util.List;

public class CommandContext{
    private final GuildMessageReceivedEvent event;
    private final List<String> args;

    public CommandContext(GuildMessageReceivedEvent event, List<String> args) {
        this.event = event;
        this.args = args;
    }


    public Guild getGuild() {
        return this.getEvent().getGuild();
    }

    public GuildMessageReceivedEvent getEvent() {
        return this.event;
    }

    public List<String> getArgs() {
        return this.args;
    }

    public TextChannel getChannel() {
        return this.getEvent().getChannel();
    }

    public Message getMessage() {
        return this.getEvent().getMessage();
    }

    public JDA getJDA() {
        return this.getEvent().getJDA();
    }

    public User getAuthor() {
        return this.getEvent().getAuthor();
    }

    public User getSelfUser() {
        return this.getJDA().getSelfUser();
    }

    public Member getSelfMember() {
        return this.getGuild().getSelfMember();
    }

    public ShardManager getShardManager() {
        return this.getJDA().getShardManager();
    }
}
