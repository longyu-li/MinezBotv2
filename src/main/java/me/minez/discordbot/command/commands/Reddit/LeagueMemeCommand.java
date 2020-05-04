package me.minez.discordbot.command.commands.Reddit;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;

import java.util.Arrays;
import java.util.List;

public class LeagueMemeCommand extends RedditImageTemplate implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        super.handle("LeagueOfMemes", ctx);
    }

    @Override
    public String getName() {
        return "lolmeme";
    }

    @Override
    public String getHelp() {
        return "Posts a random recently popular league of legends meme.";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("lolmemes", "leaguememe", "leaguememes", "leagueofmemes","leagueofmeme", "leagueoflegendsmeme", "leagueoflegendsmemes");
    }
}

