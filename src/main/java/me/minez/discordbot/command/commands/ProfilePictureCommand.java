package me.minez.discordbot.command.commands;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Arrays;
import java.util.List;

public class ProfilePictureCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        if (args.size() == 0){
            channel.sendMessage(ctx.getAuthor().getAvatarUrl() + "?size=512").queue();
        }
        else {
            try {
                Member member =  ctx.getMessage().getMentionedMembers().get(0);
                channel.sendMessage(member.getUser().getAvatarUrl() + "?size=512").queue();
            }
            catch (IndexOutOfBoundsException e) {
                List<Member> members = ctx.getGuild().getMembersByNickname(args.get(0), true);
                if (members.size() == 0){
                    members = ctx.getGuild().getMembersByName(args.get(0), true);
                }
                for (Member mem: members){
                    ctx.getChannel().sendMessage(mem.getUser().getAvatarUrl() + "?size=512").queue();
                }

            }

        }
    }

    @Override
    public String getName() {
        return "pfp";
    }

    @Override
    public String getHelp() {
        return "Displays the profile picture of a target member";
    }

    public List<String> getAliases() {
        return Arrays.asList("profile", "profilepic", "profilepicture");
    }
}
