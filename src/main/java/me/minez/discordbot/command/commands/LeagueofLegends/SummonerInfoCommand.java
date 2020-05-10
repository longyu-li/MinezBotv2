package me.minez.discordbot.command.commands.LeagueofLegends;

import me.minez.discordbot.Config;
import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import no.stelar7.api.r4j.basic.constants.api.Platform;
import no.stelar7.api.r4j.impl.R4J;
import no.stelar7.api.r4j.impl.lol.builders.league.LeagueBuilder;
import no.stelar7.api.r4j.impl.lol.raw.DDragonAPI;
import no.stelar7.api.r4j.pojo.lol.league.LeagueEntry;
import no.stelar7.api.r4j.pojo.lol.summoner.Summoner;

import java.util.List;

public class SummonerInfoCommand implements ICommand {

    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        TextChannel channel = ctx.getChannel();
        if (args.size() == 0){
            EmbedBuilder error = new EmbedBuilder();
            error.setColor(0xff0a0a);
            error.setTitle("Specify a valid summoner name");
            error.setDescription("Format is: " + Config.get("PREFIX") + "summoner [summoner name]");
            channel.sendMessage(error.build()).queue();
            error.clear();
        }
        else {
            final R4J r4J = new R4J(SecretFile.CREDS);
            DDragonAPI dragapi = r4J.getDDragonAPI();
            Summoner summoner = Summoner.byName(Platform.valueOf("NA1"), args.get(0));
            List<LeagueEntry> data = new LeagueBuilder().withPlatform(Platform.NA1).withSummonerId(summoner.getSummonerId()).getLeagueEntries();
            System.out.println(data);
            EmbedBuilder summInfo = new EmbedBuilder();
            summInfo.setColor(0x15ff00);
            summInfo.setTitle("Summoner Name: " + summoner.getName());
            summInfo.setThumbnail(r4J.getImageAPI().getProfileIcon(String.valueOf(summoner.getProfileIconId()), dragapi.getVersions().get(0)));
            summInfo.addField("Level", String.valueOf(summoner.getSummonerLevel()), true);
            for (LeagueEntry entry: data){
                StringBuilder rankedDescription = new StringBuilder();
                rankedDescription.append(entry.getTierDivisionType().prettyName());
                rankedDescription.append(" " + entry.getLeaguePoints() + "LP W: " + entry.getWins() + " L: " + entry.getLosses());
                summInfo.addField(entry.getQueueType().prettyName(), rankedDescription.toString(), false);
            }

            channel.sendMessage(summInfo.build()).queue();
            summInfo.clear();
        }
    }

    @Override
    public String getName() {
        return "summoner";
    }

    @Override
    public String getHelp() {
        return "Shows basic summoner information";
    }
}
