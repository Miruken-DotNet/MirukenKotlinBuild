package NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*

object NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild : BuildType({
    template = "StandardNuGetBuildTemplate"
    uuid = "1887ebbd-ae70-4c20-b95c-e338469ddcba"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild"
    name = "PreRelease Build"
    description = "This will push a NuGet package with a -PreRelease tag for testing from the develop branch. NO CI.   (Note: Non-prerelease nuget packages come from the master branch)"

    artifactRules = "%ArtifactsIn%"
    buildNumberPattern = "%BuildFormatSpecification%"

    params {
        param("BranchSpecification", """
            +:refs/heads/(develop)
            +:refs/heads/(feature/*)
        """.trimIndent())
        param("BuildConfiguration", "Debug")
    }

    vcs {
        root(NuGet_MirukenDotNet_MirukenSolutionKotlin.vcsRoots.NuGet_MirukenDotNet_MirukenSolutionKotlin_MirukenGitMiruken)

        checkoutMode = CheckoutMode.ON_AGENT
    }

    features {
        feature {
            id = "symbol-indexer"
            type = "symbol-indexer"
        }
    }
    
    disableSettings("RUNNER_21", "RUNNER_22", "RUNNER_4", "RUNNER_5", "RUNNER_6", "RUNNER_8")
})
