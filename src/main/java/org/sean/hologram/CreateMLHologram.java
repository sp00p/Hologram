package org.sean.hologram;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CreateMLHologram implements CommandExecutor {

    public String color (String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public String editString (String arg1) {

        return arg1.replace("_", " ").trim();

    }

    // mlhologram create <line1> <line2> <line3> yPos

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player plr = (Player) sender;

        if (plr.hasPermission("hologram.use")) {

            if (cmd.getName().equalsIgnoreCase("mlhologram")) {
                if (args[0].equals("create")) {
                    // mlhologram create line1 line2 line3 yPos
                    //               0     1     2     3    4
                    String line1Raw = args[1];
                    String line2Raw = args[2];
                    String line3Raw = args[3];
                    double yNum = Double.parseDouble(args[4]);

                    if (line1Raw.contains("&") || line2Raw.contains("&") || line3Raw.contains("&")) {

                        String editedString1 = color(line1Raw);
                        String editedString2 = color(line2Raw);
                        String editedString3 = color(line3Raw);

                        String finalmsg1 = editString(editedString1);
                        String finalmsg2 = editString(editedString2);
                        String finalmsg3 = editString(editedString3);

                        ArmorStand stand1 = (ArmorStand) plr.getWorld().spawnEntity(plr.getLocation().add(0, yNum, 0), EntityType.ARMOR_STAND);
                        stand1.setVisible(false);
                        stand1.setGravity(false);
                        stand1.setInvulnerable(true);

                        stand1.setCustomNameVisible(true);
                        stand1.setCustomName(finalmsg1);

                        ArmorStand stand2 = (ArmorStand) plr.getWorld().spawnEntity(plr.getLocation().add(0, yNum - 0.5, 0), EntityType.ARMOR_STAND);
                        stand2.setVisible(false);
                        stand2.setGravity(false);
                        stand2.setInvulnerable(true);

                        stand2.setCustomNameVisible(true);
                        stand2.setCustomName(finalmsg2);

                        ArmorStand stand3 = (ArmorStand) plr.getWorld().spawnEntity(plr.getLocation().add(0, yNum - 1, 0), EntityType.ARMOR_STAND);
                        stand3.setVisible(false);
                        stand3.setGravity(false);
                        stand3.setInvulnerable(true);

                        stand3.setCustomNameVisible(true);
                        stand3.setCustomName(finalmsg3);
                    }
                }
            }
        }
        return false;
    }

}
