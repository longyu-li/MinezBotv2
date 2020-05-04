package me.minez.discordbot.command.commands.Reddit;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;

import java.util.Arrays;
import java.util.List;

public class DankMemeCommand extends RedditImageTemplate implements ICommand {
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

    @Override
    public List<String> getAliases() {
        return Arrays.asList("dmeme", "dmemes", "dankmemes");
    }
}
