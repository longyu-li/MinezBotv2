package me.minez.discordbot.command.commands.Memes;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;

public class AnimemeCommand extends MemeTemplate implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        super.handle("animemes", ctx);
    }

    @Override
    public String getName() {
        return "animeme";
    }

    @Override
    public String getHelp() {
        return "Posts a random recently popular animeme.";
    }
}
