package me.minez.discordbot.command.commands.Reddit;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;

import java.util.Arrays;
import java.util.List;

public class WholesomeAnimemeCommand extends RedditImageTemplate implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        super.handle("wholesomeanimemes", ctx);
    }

    @Override
    public String getName() {
        return "wanimeme";
    }

    @Override
    public String getHelp() {
        return "Posts a random recently popular wholesome animeme.";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("wholesomeanimeme", "wholesomeanimememes", "wanimememes", "wholesomeanimemes", "wanimememe", "wholesomeanimememe");
    }
}

