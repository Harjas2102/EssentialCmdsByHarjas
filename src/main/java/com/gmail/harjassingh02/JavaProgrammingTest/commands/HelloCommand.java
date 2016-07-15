package com.gmail.harjassingh02.JavaProgrammingTest.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelloCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage(ChatColor.AQUA + "Hello " + p.getName() + " ! ");
        } else

            sender.sendMessage("Hello Console !");


        return true;
    }
}
