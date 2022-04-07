package com.ganguli.reaganbot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.intent.Intent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.ganguli.reaganbot.listener.HelpListener;
import com.ganguli.reaganbot.listener.PingListener;

@SpringBootApplication
public class ReaganBotApplication {
	
	@Autowired
	PingListener pingListener;
	
	@Autowired
	HelpListener helpListener;

	public static void main(String[] args) {
		SpringApplication.run(ReaganBotApplication.class, args);
	}
	
	@Bean
	@ConfigurationProperties("discord-api")
	public DiscordApi discordApi() {
		String token = System.getenv("TOKEN");
		DiscordApiBuilder builder = new DiscordApiBuilder().setToken(token).setIntents(Intent.GUILD_MESSAGES, Intent.GUILD_MESSAGE_REACTIONS, Intent.DIRECT_MESSAGES, Intent.DIRECT_MESSAGE_REACTIONS);
		DiscordApi api = builder.login().join();
		api.addMessageCreateListener(pingListener);
		api.addMessageCreateListener(helpListener);
		return api;
	}
}
