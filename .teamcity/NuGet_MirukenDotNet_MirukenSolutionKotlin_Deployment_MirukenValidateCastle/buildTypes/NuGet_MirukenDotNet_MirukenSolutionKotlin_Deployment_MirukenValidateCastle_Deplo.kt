package NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidateCastle.buildTypes

import NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.finishBuildTrigger

object NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidateCastle_Deplo : BuildType({
    template = "StandardNuGetBuildTemplate"
    uuid = "518785f5-1b0b-4578-9af3-c4dc3599c944"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidateCastle_Deplo"
    name = "Deploy Release"
    description = "This will push a NuGet package from the MASTER branch. NO CI."

    buildNumberPattern = "%BuildFormatSpecification%"

    params {
        param("BuildFormatSpecification", "%dep.NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild.BuildFormatSpecification%")
        param("PackageVersion", "%dep.NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild.PackageVersion%")
        param("PrereleaseVersion", "")
    }

    vcs {
        checkoutMode = CheckoutMode.ON_SERVER
    }

    triggers {
        finishBuildTrigger {
            id = "TRIGGER_9"
            buildTypeExtId = NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild.id
            branchFilter = "+:master"
        }
    }

    dependencies {
        dependency(NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild) {
            snapshot {
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_8"
                artifactRules = "%ArtifactsOut%"
            }
        }
    }
    
    disableSettings("JetBrains.AssemblyInfo", "RUNNER_1", "RUNNER_2", "RUNNER_21", "RUNNER_22", "RUNNER_3", "RUNNER_4", "RUNNER_5", "RUNNER_8")
})
