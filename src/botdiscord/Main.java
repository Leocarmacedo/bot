package botdiscord;

import javax.security.auth.login.LoginException;

import commands.Commands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
	public static JDA jda;
	public static String prefix = "-";
	
	public static void main(String[] args) throws LoginException {
		jda = JDABuilder.createDefault("ODgxNjg5MDc3ODQ4NjI5MzQ5.YSwe8Q.17wkmBQbFjNLmkAj1bz-eoMr318").build();
		jda.getPresence().setActivity(Activity.watching("Chaves"));
		
		jda.addEventListener(new Commands());
	}
}
