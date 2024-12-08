import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    java
    alias(libs.plugins.bukkit.yml)
}

group = "de.xtkq.voidgen"
version = "2.3.0"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

dependencies {
    compileOnly(libs.paper.api)

    library(libs.commons.lang3)
}

bukkit {
    name = "VoidGen"
    main = "de.xtkq.voidgen.VoidGen"
    version = project.version.toString()
    author = "xtkq"
    website = "https://github.com/xtkq-is-not-available/VoidGen"
    apiVersion = "1.21"
    loadBefore = listOf("Multiverse-Core", "Multiworld")
    load = BukkitPluginDescription.PluginLoadOrder.STARTUP
}
