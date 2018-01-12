package NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_Miruken.buildTypes

import NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.finishBuildTrigger

object NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_Miruken_DeployRelease : BuildType({
    template = "StandardNuGetBuildTemplate"
    uuid = "38c89156-d865-456c-ab67-3b37f30183c1"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_Miruken_DeployRelease"
    name = "Deploy Release"
    description = "This will push a NuGet package from the MASTER branch. NO CI."

    buildNumberPattern = "%BuildFormatSpecification%"

    params {
        param("BuildFormatSpecification", "%dep.NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild.BuildFormatSpecification%")
        param("PackageVersion", "%dep.NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild.PackageVersion%")
        param("PrereleaseVersion", "")
    }

    vcs {
        checkoutMode = CheckoutMode.ON_AGENT
    }

    triggers {
        finishBuildTrigger {
            id = "TRIGGER_6"
            buildTypeExtId = NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild.id
            branchFilter = "+:master"
        }
    }

    dependencies {
        dependency(NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild) {
            snapshot {
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_5"
                artifactRules = "%ArtifactsOut%"
            }
        }
    }
    
    disableSettings("JetBrains.AssemblyInfo", "RUNNER_1", "RUNNER_2", "RUNNER_21", "RUNNER_22", "RUNNER_3", "RUNNER_4", "RUNNER_5", "RUNNER_8")
})
