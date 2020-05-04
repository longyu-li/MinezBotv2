package me.minez.discordbot.command.commands.Memes;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;

public class DankMemeCommand extends MemeTemplate implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        super.handle("dankmemes", ctx);
    }

    @Override
    public String getName() {
        return "dankmeme";
    }

    @Override
    public String getHelp() {
        return "Posts a random recently popular dank meme";
    }
}
