package space.mori.fakebungee

import org.bukkit.plugin.java.JavaPlugin

import space.mori.fakebungee.commands.Ping
import space.mori.fakebungee.region.RegionCommand
import space.mori.fakebungee.region.RegionManager
import space.mori.fakebungee.player.Chat
import space.mori.fakebungee.player.PlayerList
import space.mori.fakebungee.player.ResourcePack

class FakeBungee : JavaPlugin() {
    companion object {
        lateinit var instance: FakeBungee
    }

    override fun onEnable() {
        FakeBungee.instance = this
        getCommand("ping").executor = Ping
        getCommand("fregion").executor = RegionCommand

        RegionManager.load()
        RegionManager.runTaskTimer(this, 0, 20)

        Chat(this).chat()
        PlayerList(this).playerList()
        ResourcePack(this).resourcePack()


        logger.info("${this.description.name} v${this.description.version} was loaded successfully.")
    }

    override fun onDisable() {
        RegionManager.save()

        logger.info("${this.description.name} is unloaded")
    }
}
