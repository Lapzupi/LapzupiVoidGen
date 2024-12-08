rootProject.name = "VoidGen"


dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven ("https://repo.papermc.io/repository/maven-public/")
        maven("https://oss.sonatype.org/content/groups/public/")
    }
    versionCatalogs {
        create("libs") {
            library ("paper-api","io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
            library("commons-lang3", "org.apache.commons:commons-lang3:3.12.0")

            plugin("shadow", "com.gradleup.shadow").version("8.3.5")
            plugin("bukkit-yml", "net.minecrell.plugin-yml.bukkit").version("0.6.0")
        }
    }
}