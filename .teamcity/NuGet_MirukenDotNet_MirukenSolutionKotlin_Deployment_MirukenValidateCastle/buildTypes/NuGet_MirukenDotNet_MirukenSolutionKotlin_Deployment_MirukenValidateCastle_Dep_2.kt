package NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidateCastle.buildTypes

import NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.finishBuildTrigger

object NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidateCastle_Dep_2 : BuildType({
    template = "StandardNuGetBuildTemplate"
    uuid = "1481dd5e-1174-4157-8e3a-861d4424dc67"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidateCastle_Dep_2"
    name = "Deploy PreRelease"
    description = "This will push a NuGet package with a -PreRelease tag for testing from the develop branch. NO CI.   (Note: Non-prerelease nuget packages come from the master branch)"

    buildNumberPattern = "%BuildFormatSpecification%"

    params {
        param("BuildFormatSpecification", "%dep.NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild.BuildFormatSpecification%")
    }

    vcs {
        checkoutMode = CheckoutMode.ON_SERVER
    }

    triggers {
        finishBuildTrigger {
            id = "TRIGGER_5"
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
                id = "ARTIFACT_DEPENDENCY_4"
                artifactRules = "%ArtifactsOut%"
            }
        }
    }
    
    disableSettings("RUNNER_1", "RUNNER_2", "RUNNER_21", "RUNNER_22", "RUNNER_3", "RUNNER_5", "RUNNER_6", "RUNNER_8")
})
