package commands;

import botdiscord.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");

		if (args[0].equalsIgnoreCase(Main.prefix + "ping")) {
			event.getChannel().sendMessage("PONG!").queue();
		} else if (args[0].equalsIgnoreCase(Main.prefix + "cavera")) {
			EmbedBuilder cavera = new EmbedBuilder();
			cavera.setTitle("O Maior Lixão");
			cavera.setDescription("É, obviamente, o Cavera");
			cavera.setFooter("Lixo");

			event.getChannel().sendMessageEmbeds(cavera.build()).queue();
			cavera.clear();
		} else if (args[0].equalsIgnoreCase(Main.prefix + "clear")) {
			if (args.length < 2) {
				// TODO error
				EmbedBuilder usage = new EmbedBuilder();
				usage.setColor(0xff3923);
				usage.setTitle("Specify amount to delete");
				usage.setDescription("Usage: " + Main.prefix + "clear [# of messages]");
			} else {
				java.util.List<Message> messages = event.getChannel().getHistory()
						.retrievePast(Integer.parseInt(args[1])).complete();
				event.getChannel().deleteMessages(messages).queue();
			}
		}
	}
}
