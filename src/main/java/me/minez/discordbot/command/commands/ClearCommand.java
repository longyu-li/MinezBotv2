package me.minez.discordbot.command.commands;

import me.minez.discordbot.Config;
import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;

public class ClearCommand implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        if (!ctx.getAuthor().getId().equals(Config.get("OWNER_ID"))) {
            return;
        }
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        if (args.size() < 1) {
            // No amount specified
            EmbedBuilder error = new EmbedBuilder();
            error.setColor(0xff0a0a);
            error.setTitle("Specify amount to delete");
            error.setDescription("Format is: " + Config.get("PREFIX") + "clear [# of messages]");
            channel.sendMessage(error.build()).queue();
            error.clear();
        }
        else {
            try {
                List<Message> messages = channel.getHistory().retrievePast(Integer.parseInt(args.get(0))).complete();
                channel.deleteMessages(messages).queue();
                // Successful clear
                EmbedBuilder success = new EmbedBuilder();
                success.setColor(0x15ff00);
                success.setTitle("✅ Successfully deleted " + args.get(0) + " messages.");
                channel.sendMessage(success.build()).queue();
                success.clear();
            }
            catch (IllegalArgumentException e) {
                if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval") || args.get(0).equals("1")) {
                    // Error for too many messages
                    EmbedBuilder error = new EmbedBuilder();
                    error.setColor(0xff0a0a);
                    error.setTitle("🔴 Too many messages selected");
                    error.setDescription("Between 2-100 messages can be deleted at one time");
                    channel.sendMessage(error.build()).queue();
                    error.clear();
                }
                else {
                    // Error for messages that are too old
                    EmbedBuilder error = new EmbedBuilder();
                    error.setColor(0xff0a0a);
                    error.setTitle("🔴 Some messages are older than 2 weeks");
                    error.setDescription("Cannot delete messages older than 2 weeks");
                    channel.sendMessage(error.build()).queue();
                    error.clear();
                }
            }
        }
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getHelp() {
        return "Clears the chat of a specified number of messages";
    }
}
