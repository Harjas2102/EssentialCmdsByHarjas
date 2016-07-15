package com.gmail.harjassingh02.JavaProgrammingTest;

import com.gmail.harjassingh02.JavaProgrammingTest.commands.GamemodeCreativeCommand;
import com.gmail.harjassingh02.JavaProgrammingTest.commands.GamemodeSurvivalCommand;
import com.gmail.harjassingh02.JavaProgrammingTest.commands.HelloCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class HarjasTestPlugin extends JavaPlugin{
    @Override
    public void onEnable() {
        getCommand("Hello").setExecutor(new HelloCommand());
        getCommand("gmc").setExecutor(new GamemodeCreativeCommand());
        getCommand("gms").setExecutor(new GamemodeSurvivalCommand());
    }

    @Override
    public void onDisable() {

    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (command.getName().equals("Bye")) {
                p.kickPlayer("You have been kicked from the server");
            } else if (command.getName().equals("Hello")) {
                p.sendMessage(ChatColor.AQUA + "Hello " + p.getName() + " ! ");
            }
        }

        else  {
            if (command.getName().equals("Bye")) {
                if (args.length > 0){
                    List<Player> p= Bukkit.matchPlayer(args[0]);
                    if (p.size()==0) {
                        sender.sendMessage("That player is not online!");
                        return true;
                    }

                    for (Player player : p){

                        player.kickPlayer("You have been kicked from the server ");

                    }


                }
            }

            else if (command.getName().equals("Hello")) {
                sender.sendMessage("Hello Console !");
            }
        }




        return true;
    }
}
