ext.constellationCreds = new URL("https://raw.githubusercontent.com/constellation-mc/artifacts/main/credentials").readLines();

ext.anyGitHubRepo = { Project project, String user, String repo ->
    project.repositories {
        maven {
            url = "https://maven.pkg.github.com/" + user + "/" + repo
            credentials {
                username = constellationCreds.get(0)
                password = "ghp_" + constellationCreds.get(1)
            }
        }
    }
}

ext.constellationRepo = { Project project, String repo ->
    project.repositories {
        maven {
            url = "https://maven.pkg.github.com/constellation-mc/" + repo
            credentials {
                username = constellationCreds.get(0)
                password = "ghp_" + constellationCreds.get(1)
            }
        }
    }
}