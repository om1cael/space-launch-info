plugins {
    id("java")
    id("application")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.11.0")
}

application {
    mainClass.set("com.om1cael.sli.Main")
}

sourceSets {
    main {
        java {
            setSrcDirs(listOf("src"))
        }
    }
}