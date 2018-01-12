package NuGet_MirukenDotNet_MirukenSolutionKotlin.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

object NuGet_MirukenDotNet_MirukenSolutionKotlin_HttpsGithubComMirukenDotNetMirukenGitC : GitVcsRoot({
    uuid = "8408d132-3c36-4bc7-8740-c1e0a39f7a40"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_HttpsGithubComMirukenDotNetMirukenGitC"
    name = "https://github.com/Miruken-DotNet/Miruken.git-CI"
    url = "https://github.com/Miruken-DotNet/Miruken.git"
    branch = "%DefaultBranch%"
    branchSpec = "%BranchSpecification%"
    agentCleanPolicy = GitVcsRoot.AgentCleanPolicy.ALWAYS
})
