package me.minez.discordbot.command.commands.Reddit;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;

public class DoggoCommand extends RedditImageTemplate implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        super.handle("DOG", ctx);
    }

    @Override
    public String getName() {
        return "dog";
    }

    @Override
    public String getHelp() {
        return "Posts a random recently popular cute doggo.";
    }
}
