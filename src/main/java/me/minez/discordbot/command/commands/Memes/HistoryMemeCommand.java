package me.minez.discordbot.command.commands.Memes;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;

public class HistoryMemeCommand extends MemeTemplate implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        super.handle("HistoryMemes", ctx);
    }

    @Override
    public String getName() {
        return "historymeme";
    }

    @Override
    public String getHelp() {
        return "Posts a random recently popular history meme";
    }
}

