package me.minez.discordbot.command.commands.Memes;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;

public class NormalMemeCommand extends MemeTemplate implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        super.handle("memes", ctx);
    }

    @Override
    public String getName() {
        return "meme";
    }

    @Override
    public String getHelp() {
        return "Posts a random recently popular meme";
    }
}
