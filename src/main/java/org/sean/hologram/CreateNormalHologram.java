package org.sean.hologram;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class CreateNormalHologram implements CommandExecutor {

    // hologram create <msg> yNum (note: spaces with _)
    //            0     1      2

    public String color (String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player plr = (Player) sender;

        if (plr.hasPermission("hologram.use")) {

            if (cmd.getName().equalsIgnoreCase("hologram")) {
                if (args[0].equals("create")) {
                    // hologram create <msg> yNum (note: spaces with _)
                    //             0    1      2

                    String string = args[1];
                    double yNum = Double.parseDouble(args[2]);

                    if (string.contains("&")) {

                        String editedString = color(string);
                        String finalmsg = editedString.replace("_"," ").trim();

                        ArmorStand stand = (ArmorStand) plr.getWorld().spawnEntity(plr.getLocation().add(0, yNum, 0), EntityType.ARMOR_STAND);
                        stand.setVisible(false);
                        stand.setGravity(false);
                        stand.setInvulnerable(true);

                        stand.setCustomNameVisible(true);
                        stand.setCustomName(finalmsg);

                        plr.sendMessage(ChatColor.GREEN + "Hologram created successfully, " + ChatColor.BLUE + plr.getName());
                    } else if (!string.contains("&")){

                        String finalmsg = string.replace("_"," ").trim();

                        ArmorStand stand = (ArmorStand) plr.getWorld().spawnEntity(plr.getLocation().add(0, yNum, 0), EntityType.ARMOR_STAND);
                        stand.setVisible(false);
                        stand.setGravity(false);
                        stand.setInvulnerable(true);

                        stand.setCustomNameVisible(true);
                        stand.setCustomName(ChatColor.WHITE + finalmsg);

                        plr.sendMessage(ChatColor.GREEN + "Hologram created successfully, " + ChatColor.BLUE + plr.getName());
                    } else {
                        plr.sendMessage(ChatColor.RED + "There was an error creating your hologram!");
                        plr.sendMessage("The syntax for this command can be found here: https://github.com/sp00p/Hologram/wiki/Commands");
                    }


                } else if(args[0].equals("delete")) {
                    try {
                        getServer().dispatchCommand(getServer().getConsoleSender(), "kill @e[type=armor_stand] {id=" + args[1] + "}");
                        plr.sendMessage(ChatColor.GREEN + "Hologram deleted successfully!");
                    } catch (Error e) {
                        plr.sendMessage(ChatColor.RED + "Hologram does not exist!");
                    }
                }
            }
        } else {
            plr.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
        }
        return false;
    }
}




