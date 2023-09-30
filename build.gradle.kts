plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "fun.socialcraft.economy"
version = "1.0.0"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        url = uri("https://oss.sonatype.org/content/groups/public/")
    }
    maven {
        url = uri("https://repo.mrivanplays.com/repository/ivan/")
    }
}

dependencies {
    compileOnly(
            group = "io.papermc.paper",
            name = "paper-api",
            version = "1.20.2-R0.1-SNAPSHOT"
    )
    compileOnly(
            group = "com.mrivanplays",
            name = "conversations-paper",
            version = "0.0.2-SNAPSHOT")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything

        // Set the release flag. This configures what version bytecode the compiler will emit, as well as what JDK APIs are usable.
        // See https://openjdk.java.net/jeps/247 for more information.
        options.release.set(17)
    }
    processResources {
        filteringCharset = Charsets.UTF_8.name() // We want UTF-8 for everything
    }

    build {
        dependsOn(shadowJar)
    }

processResources {
        val props = mapOf("version" to version.toString())
        inputs.properties(props)
        filteringCharset = Charsets.UTF_8.toString()
        filesMatching("paper-plugin.yml") {
            expand(props)
        }
    }

//
//    shadowJar {
//        destinationDirectory.set(file("E:\\MINECRAFT\\Servers\\Develop\\1.19\\plugins"));
//    }
}