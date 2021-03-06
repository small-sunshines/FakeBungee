package space.mori.fakebungee.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import space.mori.fakebungee.config.ConfigManager


object ConfigCommand : CommandExecutor, TabCompleter {
    override fun onCommand(
        sender: CommandSender, command: Command, label: String, args: Array<out String>
    ): Boolean {
        if (!sender.hasPermission("fb.fconfig")) {
            return true
        }

        ConfigManager.load()
        sender.sendMessage("${ChatColor.GREEN}[!] ${ChatColor.WHITE}Config have been successfully reloaded.")

        if(ConfigManager.Config.debug) {
            sender.sendMessage("${ChatColor.GREEN}[!] ${ChatColor.WHITE}debug mode activated")
        }

        return true
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<out String>): MutableList<String> = mutableListOf<String>()
}
