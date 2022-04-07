package com.ganguli.reaganbot.util;

import java.util.Optional;

import org.javacord.api.entity.user.User;

public final class MentionUtil {
	public static String getMentionString(Optional<User> user) {
		String mentionTag = "";
		if(user.isPresent()) {
			mentionTag = user.get().getMentionTag();
		}
		String mentionString = "Hi" + (mentionTag.length() > 0 ? " ": "") + mentionTag;
		return mentionString;
	}
}
