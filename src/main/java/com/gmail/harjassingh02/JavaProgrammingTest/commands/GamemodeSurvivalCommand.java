package com.gmail.harjassingh02.JavaProgrammingTest.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeSurvivalCommand implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            if (sender.hasPermission("cmds.gms") || sender.isOp()) {
                Player p = (Player) sender;

                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage("Your game mode has been updated");
            } else {
                sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command!");
            }
        }

        return false;
    }
}
