package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.DockerCommandStep
import jetbrains.buildServer.configs.kotlin.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.buildSteps.dockerCommand
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'Build'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("Build")) {
    expectSteps {
        step {
            name = "Build (Debug)"
            type = "cargo"
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            param("cargo-bench-package", "platform_linux")
            param("cargo-build-package", "platform_linux")
            param("cargo-command", "build")
            param("cargo-test-no-default-features", "true")
            param("cargo-toolchain", "stable")
            param("cargo-verbosity", "--verbose")
        }
        step {
            name = "Build (Release)"
            type = "cargo"
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            param("cargo-bench-arguments", "--release")
            param("cargo-bench-package", "platform_linux")
            param("cargo-build-package", "platform_linux")
            param("cargo-build-release", "true")
            param("cargo-command", "build")
            param("cargo-test-no-default-features", "true")
            param("cargo-toolchain", "stable")
            param("cargo-verbosity", "--verbose")
        }
    }
    steps {
        insert(0) {
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
        }
        insert(1) {
            script {
                name = "Build (Debug)"
                scriptContent = "cargo build"
                dockerImage = "bevy_ci_image:latest"
                dockerImagePlatform = ScriptBuildStep.ImagePlatform.Linux
            }
        }
        insert(2) {
            script {
                name = "Build (Debug) (1)"
                scriptContent = "cargo build"
                dockerImage = "bevy_ci_image:latest"
                dockerImagePlatform = ScriptBuildStep.ImagePlatform.Linux
            }
        }
        items.removeAt(3)
        items.removeAt(3)
    }
}
