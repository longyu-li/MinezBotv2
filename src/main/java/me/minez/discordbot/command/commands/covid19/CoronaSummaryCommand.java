package me.minez.discordbot.command.commands.covid19;

import me.minez.discordbot.command.CommandContext;
import me.minez.discordbot.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CoronaSummaryCommand implements ICommand{

    @Override
    public void handle(CommandContext ctx) {
        List<String> args = ctx.getArgs();
        if (args.isEmpty() || args.get(0).equals("summary")) {
            for (int i = 0; i < 2; i++) {
                try {
//                    String rawToday = new Scanner(new URL("https://disease.sh/v2/all?yesterday=false").openStream(), "UTF-8").useDelimiter("\\A").next();
//                    String[] summaryToday = rawToday.replace(":", ",").split(",");
//                    String rawYesterday = new Scanner(new URL("https://disease.sh/v2/all?yesterday=true").openStream(), "UTF-8").useDelimiter("\\A").next();
//                    String[] summaryYesterday = rawYesterday.replace(":", ",").split(",");
//
//
//                    String newCases = summaryToday[5];
//                    String totalCases = summaryToday[3];
//                    String newDeaths = summaryToday[9];
//                    String totalDeaths = summaryToday[7];
//                    String newRecovered = Integer.toString(Integer.parseInt(summaryToday[11]) - Integer.parseInt(summaryYesterday[11]));
//                    String totalRecovered = summaryToday[11];
                    // Not updated live API
                    String raw = new Scanner(new URL("https://api.covid19api.com/summary").openStream(), "UTF-8").useDelimiter("\\A").next();
                    String summaryRaw = raw.substring(0, raw.indexOf("}"));
                    String[] summaryToday = summaryRaw.substring(summaryRaw.lastIndexOf("{")).replace(":", ",").split(",");
                    String newCases = summaryToday[1];
                    String totalCases = summaryToday[3];
                    String newDeaths = summaryToday[5];
                    String totalDeaths = summaryToday[7];
                    String newRecovered = summaryToday[9];
                    String totalRecovered = summaryToday[11];
                    EmbedBuilder covid19 = new EmbedBuilder();
                    covid19.setTitle("Covid-19 Latest Stats");
                    covid19.setColor(0x2b7cff);
                    covid19.setThumbnail("https://www.statnews.com/wp-content/uploads/2020/02/Coronavirus-CDC-645x645.jpg");
                    covid19.addField("New Cases:", newCases, true);
                    covid19.addField("New Deaths:", newDeaths, true);
                    covid19.addField("New Recovered:", newRecovered, true);
                    covid19.addField("Total Cases:", totalCases, true);
                    covid19.addField("Total Deaths:", totalDeaths, true);
                    covid19.addField("Total Recovered:", totalRecovered, true);
                    covid19.setTimestamp(Instant.now());
                    ctx.getChannel().sendMessage(covid19.build()).queue();
                    covid19.clear();
                    break;
                } catch (IOException | IllegalArgumentException e) {
                    if (i == 0) {
                        continue;
                    }
                    ctx.getChannel().sendMessage("Something went wrong, try again later.").queue();
                    e.printStackTrace();
                }
            }
        }
        else {
            EmbedBuilder error = new EmbedBuilder();
            error.setColor(0xff0a0a);
            error.setTitle("Command doesn't exist!");
            ctx.getChannel().sendMessage(error.build()).queue();
            error.clear();
        }
    }
    @Override
    public String getName() {
        return "covid19";
    }

    @Override
    public String getHelp() {
        return "Displays a summary of latest covid19 data.";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("corona", "coronavirus");
    }
}
