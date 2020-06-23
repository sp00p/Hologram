package org.sean.hologram;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import static org.bukkit.Bukkit.getServer;

public class HologramListener implements CommandExecutor, Listener {

    // hologram create cc <msg> y [y position] (spaces with _)
    //            0     1   2   3       4

    public String color (String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player plr = (Player) sender;

        if (plr.hasPermission("hologram.use")) {

            if (cmd.getName().equalsIgnoreCase("hologram")) {
                if (args[0].equals("create")) {
                    
                    if (args[1].equalsIgnoreCase("cc") && args[3].equalsIgnoreCase("y")) {
                        // hologram create cc <msg> y yNum (note: spaces with _)
                        String string = args[2];
                        double yNum = Double.parseDouble(args[4]);

                        if (string.contains("&")) {

                            String editedString = color(string);
                            String finalmsg = editedString.replace("_"," ").trim();

                            ArmorStand stand = (ArmorStand) plr.getWorld().spawnEntity(plr.getLocation().add(0, yNum, 0), EntityType.ARMOR_STAND);
                            stand.setVisible(false);
                            stand.setGravity(false);
                            stand.setInvulnerable(true);

                            stand.setCustomNameVisible(true);
                            stand.setCustomName(finalmsg);
                        } else {
                            plr.sendMessage(ChatColor.RED + "String " + string + " does not contain &");
                        }


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
