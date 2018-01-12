package NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v2017_2.triggers.vcs

object NuGet_MirukenDotNet_MirukenSolutionKotlin_CiBuild : BuildType({
    template = "StandardNuGetBuildTemplate"
    uuid = "63f13df7-45b1-4b52-b34c-aa6fbbfa2788"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_CiBuild"
    name = "CI Build"
    description = "Watches git repo & creates a build for any change to any branch. Runs tests. Does NOT package/deploy NuGet packages!"

    buildNumberPattern = "%BuildFormatSpecification%"

    params {
        param("BranchSpecification", "+:refs/heads/(*)")
        param("MajorVersion", "0")
        param("MinorVersion", "0")
        param("PatchVersion", "0")
        param("PdbFilesForSymbols", "")
        param("PrereleaseVersion", "-CI.%build.counter%")
    }

    vcs {
        root(NuGet_MirukenDotNet_MirukenSolutionKotlin.vcsRoots.NuGet_MirukenDotNet_MirukenSolutionKotlin_HttpsGithubComMirukenDotNetMirukenGitC)

        cleanCheckout = true
    }

    triggers {
        vcs {
            id = "vcsTrigger"
            quietPeriodMode = VcsTrigger.QuietPeriodMode.USE_DEFAULT
            perCheckinTriggering = true
            groupCheckinsByCommitter = true
            enableQueueOptimization = false
        }
    }

    features {
        feature {
            id = "symbol-indexer"
            type = "symbol-indexer"
            enabled = false
        }
    }
    
    disableSettings("RUNNER_21", "RUNNER_22", "RUNNER_4", "RUNNER_5", "RUNNER_6", "RUNNER_8")
})
