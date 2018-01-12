package NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenCastle.buildTypes

import NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.finishBuildTrigger

object NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenCastle_DeployPreRele : BuildType({
    template = "StandardNuGetBuildTemplate"
    uuid = "e61672e7-6727-47da-9e47-e8ec10bffe41"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenCastle_DeployPreRele"
    name = "Deploy PreRelease"
    description = "Watches git repo & creates a build for any change to any branch. Runs tests. Does NOT package/deploy NuGet packages!"

    buildNumberPattern = "%BuildFormatSpecification%"

    params {
        param("BuildFormatSpecification", "%dep.NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild.BuildFormatSpecification%")
        param("PackageVersion", "%dep.NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild.PackageVersion%")
    }

    triggers {
        finishBuildTrigger {
            id = "TRIGGER_3"
            buildTypeExtId = NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild.id
            successfulOnly = true
            branchFilter = "+:*"
        }
    }

    features {
        feature {
            id = "symbol-indexer"
            type = "symbol-indexer"
            enabled = false
        }
    }

    dependencies {
        dependency(NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild) {
            snapshot {
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_2"
                artifactRules = "%ArtifactsOut%"
            }
        }
    }
    
    disableSettings("JetBrains.AssemblyInfo", "RUNNER_1", "RUNNER_2", "RUNNER_21", "RUNNER_22", "RUNNER_3", "RUNNER_6", "RUNNER_8")
})
