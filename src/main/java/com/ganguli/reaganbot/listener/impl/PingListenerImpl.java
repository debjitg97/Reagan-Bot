package com.ganguli.reaganbot.listener.impl;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import com.ganguli.reaganbot.listener.PingListener;
import com.ganguli.reaganbot.util.MentionUtil;

@Component
public class PingListenerImpl implements PingListener {
	
	private String reactEmoji = "❤️";
	
	private String pingHeader = "Did someone say ***ping***?";
	
	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		if(event.getMessageContent().equals("!ping")) {
			event.addReactionsToMessage(reactEmoji).join();
			EmbedBuilder embed = new EmbedBuilder()
					.addField(pingHeader, MentionUtil.getMentionString(event.getMessage().getUserAuthor()) + ", I am up and running!")
					.setColor(Color.GREEN);
			event.getChannel().sendMessage(embed);
		}
	}
}
