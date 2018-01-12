package NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenCastle.buildTypes

import NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.finishBuildTrigger

object NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenCastle_DeployRelease : BuildType({
    template = "StandardNuGetBuildTemplate"
    uuid = "7747abab-5070-43ad-8df2-fc87353e7ee7"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenCastle_DeployRelease"
    name = "Deploy Release"
    description = "Watches git repo & creates a build for any change to any branch. Runs tests. Does NOT package/deploy NuGet packages!"

    buildNumberPattern = "%BuildFormatSpecification%"

    params {
        param("BuildFormatSpecification", "%dep.NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild.BuildFormatSpecification%")
        param("PackageVersion", "%dep.NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild.PackageVersion%")
    }

    vcs {
        checkoutMode = CheckoutMode.ON_AGENT
    }

    triggers {
        finishBuildTrigger {
            id = "TRIGGER_7"
            buildTypeExtId = NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild.id
            branchFilter = "+:master"
        }
    }

    dependencies {
        dependency(NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild) {
            snapshot {
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_6"
                artifactRules = "%ArtifactsOut%"
            }
        }
    }
    
    disableSettings("JetBrains.AssemblyInfo", "RUNNER_1", "RUNNER_2", "RUNNER_21", "RUNNER_22", "RUNNER_3", "RUNNER_4", "RUNNER_8")
})
