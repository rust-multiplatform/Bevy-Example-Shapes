import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.DockerCommandStep
import jetbrains.buildServer.configs.kotlin.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.vcs

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2022.10"

project {

    buildType(OpenSourceProjects_RustMultiplatform_BevyTemplate_Build)
    buildType(OpenSourceProjects_RustMultiplatform_BevyTemplate_Test)
}

object OpenSourceProjects_RustMultiplatform_BevyTemplate_Build : BuildType({
    id("Build")
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        dockerCommand {
            name = "Build Docker Image"
            commandType = build {
                source = file {
                    path = ".ci/Dockerfile"
                }
                contextDir = ".ci"
                platform = DockerCommandStep.ImagePlatform.Linux
                namesAndTags = "bevy_ci_image:latest"
                commandArgs = "--pull"
            }
        }
        script {
            name = "Build"
            scriptContent = """
                cargo build
                cargo build --release
            """.trimIndent()
            dockerImage = "bevy_ci_image:latest"
            dockerImagePlatform = ScriptBuildStep.ImagePlatform.Linux
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})

object OpenSourceProjects_RustMultiplatform_BevyTemplate_Test : BuildType({
    id("Test")
    name = "Test"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        dockerCommand {
            name = "Build Docker Image"
            commandType = build {
                source = file {
                    path = ".ci/Dockerfile"
                }
                contextDir = ".ci"
                platform = DockerCommandStep.ImagePlatform.Linux
                namesAndTags = "bevy_ci_image:latest"
                commandArgs = "--pull"
            }
        }
        script {
            name = "Test"
            scriptContent = """
                cargo test
                cargo test --release
            """.trimIndent()
            dockerImage = "bevy_ci_image:latest"
            dockerImagePlatform = ScriptBuildStep.ImagePlatform.Linux
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})
