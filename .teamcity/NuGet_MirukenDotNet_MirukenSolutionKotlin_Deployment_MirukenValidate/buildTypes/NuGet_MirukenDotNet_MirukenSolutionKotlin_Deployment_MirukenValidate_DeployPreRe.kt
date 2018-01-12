package NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidate.buildTypes

import NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.finishBuildTrigger

object NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidate_DeployPreRe : BuildType({
    template = "StandardNuGetBuildTemplate"
    uuid = "b84e3b95-918a-4273-a354-f23e85502f1e"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidate_DeployPreRe"
    name = "Deploy PreRelease"
    description = "This will push a NuGet package with a -PreRelease tag for testing from the develop branch. NO CI.   (Note: Non-prerelease nuget packages come from the master branch)"

    buildNumberPattern = "%BuildFormatSpecification%"

    params {
        param("BuildFormatSpecification", "%dep.NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild.BuildFormatSpecification%")
        param("PackageVersion", "%dep.NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild.PackageVersion%")
    }

    vcs {
        checkoutMode = CheckoutMode.ON_SERVER
    }

    triggers {
        finishBuildTrigger {
            id = "TRIGGER_4"
            buildTypeExtId = NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild.id
            successfulOnly = true
            branchFilter = "+:*"
        }
    }

    features {
        feature {
            id = "symbol-indexer"
            type = "symbol-indexer"
        }
    }

    dependencies {
        dependency(NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild) {
            snapshot {
            }

            artifacts {
                id = "ARTIFACT_DEPENDENCY_3"
                artifactRules = "%ArtifactsOut%"
            }
        }
    }
    
    disableSettings("RUNNER_1", "RUNNER_2", "RUNNER_21", "RUNNER_22", "RUNNER_3", "RUNNER_5", "RUNNER_6", "RUNNER_8")
})
