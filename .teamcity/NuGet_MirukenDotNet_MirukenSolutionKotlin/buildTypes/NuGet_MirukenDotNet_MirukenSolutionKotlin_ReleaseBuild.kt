package NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*

object NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild : BuildType({
    template = "StandardNuGetBuildTemplate"
    uuid = "b8916e74-6cb7-4cd3-a82f-0b4809f4e094"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild"
    name = "Release Build"
    description = "This will push a NuGet package from the MASTER branch. NO CI."

    artifactRules = "%ArtifactsIn%"
    buildNumberPattern = "%BuildFormatSpecification%"

    params {
        param("BranchSpecification", "+:refs/heads/(master)")
        param("DefaultBranch", "master")
        param("NuGetPackPrereleaseVersionString", "")
        param("PrereleaseVersion", "")
    }

    vcs {
        root(NuGet_MirukenDotNet_MirukenSolutionKotlin.vcsRoots.NuGet_MirukenDotNet_MirukenSolutionKotlin_MirukenGitMiruken)

        checkoutMode = CheckoutMode.ON_AGENT
    }
    
    disableSettings("RUNNER_4", "RUNNER_5", "RUNNER_6", "RUNNER_8")
})
