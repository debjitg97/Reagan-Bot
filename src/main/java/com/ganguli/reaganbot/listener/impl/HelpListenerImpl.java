package com.ganguli.reaganbot.listener.impl;

import java.awt.Color;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.springframework.stereotype.Component;

import com.ganguli.reaganbot.listener.HelpListener;

@Component
public class HelpListenerImpl implements HelpListener{
	
	private String helpHeader = "I am always happy to help!";
	
	@Override
	public void onMessageCreate(MessageCreateEvent event) {
		if(event.getMessageContent().equals("!help")) {
			EmbedBuilder embed = new EmbedBuilder()
					.setTitle(helpHeader)
					.addField("!ping", "A simple command to check if I am online. Please do not complain to my supevisors if I am not.")
					.setColor(Color.GREEN);
			event.getChannel().sendMessage(embed);
		}
	}

}
