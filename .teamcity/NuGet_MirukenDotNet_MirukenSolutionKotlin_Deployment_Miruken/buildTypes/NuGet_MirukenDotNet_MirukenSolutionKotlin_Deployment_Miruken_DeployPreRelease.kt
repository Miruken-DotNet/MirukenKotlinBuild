package NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_Miruken.buildTypes

import NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.finishBuildTrigger

object NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_Miruken_DeployPreRelease : BuildType({
    template = "StandardNuGetBuildTemplate"
    uuid = "7013d3d4-36c6-4968-8a2f-fda2e7fe8004"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_Miruken_DeployPreRelease"
    name = "Deploy PreRelease"
    description = "This will push a NuGet package with a -PreRelease tag for testing from the develop branch. NO CI.   (Note: Non-prerelease nuget packages come from the master branch)"

    buildNumberPattern = "%BuildFormatSpecification%"

    params {
        param("BuildFormatSpecification", "%dep.NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild.BuildFormatSpecification%")
        param("PackageVersion", "%dep.NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild.PackageVersion%")
    }

    vcs {
        checkoutMode = CheckoutMode.ON_AGENT
    }

    triggers {
        finishBuildTrigger {
            id = "TRIGGER_2"
            buildTypeExtId = NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild.id
            successfulOnly = true
            branchFilter = "+:*"
        }
    }

    dependencies {
        dependency(NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild) {
            snapshot {
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_1"
                artifactRules = "%ArtifactsOut%"
            }
        }
    }
    
    disableSettings("JetBrains.AssemblyInfo", "RUNNER_1", "RUNNER_2", "RUNNER_21", "RUNNER_22", "RUNNER_3", "RUNNER_5", "RUNNER_6", "RUNNER_8")
})
