package me.minez.discordbot.command.commands.Reddit;

import me.minez.discordbot.command.CommandContext;
import net.dv8tion.jda.api.EmbedBuilder;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public abstract class RedditImageTemplate {
    public void handle(String memeType, CommandContext ctx){
        for(int i = 0; i < 3; i++){
                    try {
                        String[] splitted = new Scanner(new URL("https://meme-api.herokuapp.com/gimme/" + memeType).openStream(), "UTF-8").useDelimiter("\\A").next().split("\"");
                        String link = splitted[3];
                String title = splitted[11];
                String imagelink = splitted[15];
                EmbedBuilder meme = new EmbedBuilder();
                meme.setTitle(title, link);
                meme.setColor(0x15ff00);
                meme.setImage(imagelink);
                ctx.getChannel().sendMessage(meme.build()).queue();
                meme.clear();
                break;
            }
            catch (IOException| IllegalArgumentException e){
                if (i < 2){
                    continue;
                }
                ctx.getChannel().sendMessage("Something went wrong, try again later.").queue();

            }

        }

    }
}
