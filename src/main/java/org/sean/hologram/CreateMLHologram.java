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

    // mlhologram create <line1> <line2> <line3> <yPos> <decreaseScale>

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player plr = (Player) sender;

        if (plr.hasPermission("hologram.use")) {

            if (cmd.getName().equalsIgnoreCase("mlhologram")) {
                if (args[0].equals("create")) {
                    // mlhologram create line1 line2 line3 yPos decreaseScale
                    //               0     1     2     3    4        5
                    String line1Raw = args[1];
                    String line2Raw = args[2];
                    String line3Raw = args[3];
                    double yNum = Double.parseDouble(args[4]);
                    double decreaseScale = Double.parseDouble(args[5]);

                    if (!line1Raw.equals("") && !line2Raw.equals("") && !line3Raw.equals("")) {

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

                            ArmorStand stand2 = (ArmorStand) plr.getWorld().spawnEntity(plr.getLocation().add(0, yNum - decreaseScale, 0), EntityType.ARMOR_STAND);
                            stand2.setVisible(false);
                            stand2.setGravity(false);
                            stand2.setInvulnerable(true);

                            stand2.setCustomNameVisible(true);
                            stand2.setCustomName(finalmsg2);

                            ArmorStand stand3 = (ArmorStand) plr.getWorld().spawnEntity(plr.getLocation().add(0, yNum - decreaseScale, 0), EntityType.ARMOR_STAND);
                            stand3.setVisible(false);
                            stand3.setGravity(false);
                            stand3.setInvulnerable(true);

                            stand3.setCustomNameVisible(true);
                            stand3.setCustomName(finalmsg3);
                            
                            plr.sendMessage(ChatColor.GREEN + "Multi-line hologram created successfully, " + ChatColor.BLUE + plr);
                        } else if (!line1Raw.contains("&") && !line2Raw.contains("&") && !line3Raw.contains("&")) {

                            ArmorStand stand1 = (ArmorStand) plr.getWorld().spawnEntity(plr.getLocation().add(0, yNum, 0), EntityType.ARMOR_STAND);
                            stand1.setVisible(false);
                            stand1.setGravity(false);
                            stand1.setInvulnerable(true);

                            stand1.setCustomNameVisible(true);
                            stand1.setCustomName(ChatColor.WHITE + line1Raw);

                            ArmorStand stand2 = (ArmorStand) plr.getWorld().spawnEntity(plr.getLocation().add(0, yNum - decreaseScale, 0), EntityType.ARMOR_STAND);
                            stand2.setVisible(false);
                            stand2.setGravity(false);
                            stand2.setInvulnerable(true);

                            stand2.setCustomNameVisible(true);
                            stand2.setCustomName(ChatColor.WHITE + line2Raw);

                            ArmorStand stand3 = (ArmorStand) plr.getWorld().spawnEntity(plr.getLocation().add(0, yNum - decreaseScale, 0), EntityType.ARMOR_STAND);
                            stand3.setVisible(false);
                            stand3.setGravity(false);
                            stand3.setInvulnerable(true);

                            stand3.setCustomNameVisible(true);
                            stand3.setCustomName(ChatColor.WHITE + line3Raw);

                            plr.sendMessage(ChatColor.GREEN + "Multi-line hologram created successfully, " + ChatColor.BLUE + plr);
                        }
                    } else {
                        plr.sendMessage(ChatColor.RED + "There was an error creating your hologram!");
                        plr.sendMessage("The syntax for this command can be found here: https://github.com/sp00p/Hologram/wiki/Commands");
                    }
                } else {
                    plr.sendMessage(ChatColor.RED + "There was an error creating your hologram!");
                    plr.sendMessage("The syntax for this command can be found here: https://github.com/sp00p/Hologram/wiki/Commands");
                }
            }
        }
        return false;
    }

}
