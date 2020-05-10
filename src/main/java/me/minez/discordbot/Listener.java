package me.minez.discordbot;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;

public class Listener extends ListenerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);
    private final CommandManager manager = new CommandManager();

    @Override
    public void onReady(@Nonnull ReadyEvent event) {
        LOGGER.info("{} is ready", event.getJDA().getSelfUser().getAsTag());
    }

    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        User user = event.getAuthor();

        if (user.isBot() || event.isWebhookMessage()) {
            return;
        }

        String prefix = Config.get("PREFIX");
        String raw = event.getMessage().getContentRaw();

        if (raw.equalsIgnoreCase(prefix + "shutdown") && event.getAuthor().getId().equals(Config.get("OWNER_ID"))) {
            LOGGER.info("Shutting down");
            event.getJDA().shutdown();

            return;
        }

        if (raw.startsWith(prefix)) {
            manager.handle(event);
        }

        // Useless features no one asked for

        if (raw.toLowerCase().equals("hello")) {
            event.getChannel().sendMessage("world").queue();
        }
        if (raw.toLowerCase().equals("owo")) {
            event.getChannel().sendMessage("whats this?").queue();
        }
        if (raw.toLowerCase().equals("ipad")) {
            event.getChannel().sendMessage("zombie1").queue();
        }
        if (raw.toLowerCase().contains("kms")) {
            event.getChannel().sendMessage("Keeping myself safe").queue();
        }
        if (raw.toLowerCase().contains("kys")) {
            event.getChannel().sendMessage("Keep yourself safe").queue();
        }

        if (raw.toLowerCase().equals("p!catch gardevoir")) {
            event.getChannel().sendMessage("Congratulations " + event.getAuthor().getAsMention() +"! You caught a level 21 Gardevoir!").queue();
        }
    }

}
