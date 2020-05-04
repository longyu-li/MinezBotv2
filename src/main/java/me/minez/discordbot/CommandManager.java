package me.minez.discordbot;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;
import me.minez.discordbot.command.commands.*;
import me.minez.discordbot.command.commands.Memes.AnimemeCommand;
import me.minez.discordbot.command.commands.Memes.DankMemeCommand;
import me.minez.discordbot.command.commands.Memes.HistoryMemeCommand;
import me.minez.discordbot.command.commands.Memes.NormalMemeCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CommandManager {
    private final List<ICommand> commands = new ArrayList<>();

    public CommandManager() {
        addCommand(new PingCommand());
        addCommand(new HelpCommand(this));
        addCommand(new InfoCommand());
        addCommand(new ClearCommand());
        addCommand(new SpamCommand());
        addCommand(new ProfilePictureCommand());
        addCommand(new AnimemeCommand());
        addCommand(new DankMemeCommand());
        addCommand(new NormalMemeCommand());
        addCommand(new HistoryMemeCommand());
    }

    private void addCommand(ICommand cmd) {
        boolean nameFound = this.commands.stream().anyMatch((it) -> it.getName().equalsIgnoreCase(cmd.getName()));

        if (nameFound) {
            throw new IllegalArgumentException("A command with this name is already present");
        }

        commands.add(cmd);
    }

    public List<ICommand> getCommands() {
        return commands;
    }

    @Nullable
    public ICommand getCommand(String search) {
        String searchLower = search.toLowerCase();

        for (ICommand cmd: this.commands) {
            if (cmd.getName().equals(searchLower) || cmd.getAliases().contains(searchLower)) {
                return cmd;
            }
        }

        return null;
    }

    void handle(GuildMessageReceivedEvent event) {
        String[] split = event.getMessage().getContentRaw().replaceFirst("(?i)" + Pattern.quote(Config.get("PREFIX")), "").split("\\s+");

        String invoke = split[0].toLowerCase();
        ICommand cmd = this.getCommand(invoke);

        if (cmd != null) {
            event.getChannel().sendTyping().queue();
            List<String> args = Arrays.asList(split).subList(1, split.length);

            CommandContext ctx = new CommandContext(event, args);

            cmd.handle(ctx);
        }
        else {
            EmbedBuilder error = new EmbedBuilder();
            error.setColor(0xff0a0a);
            error.setTitle("Invalid Command!");
            event.getChannel().sendMessage(error.build()).queue();
            error.clear();
        }
    }
}
