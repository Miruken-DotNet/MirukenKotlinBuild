package NuGet_MirukenDotNet_MirukenSolutionKotlin.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

object NuGet_MirukenDotNet_MirukenSolutionKotlin_MirukenGitMiruken : GitVcsRoot({
    uuid = "0a720152-3aec-462a-bb72-8583792bbe09"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_MirukenGitMiruken"
    name = "Miruken.git-Miruken"
    url = "git@github.com:Miruken-DotNet/Miruken.git"
    branch = "%DefaultBranch%"
    branchSpec = "%BranchSpecification%"
    agentCleanPolicy = GitVcsRoot.AgentCleanPolicy.ALWAYS
    authMethod = uploadedKey {
        uploadedKey = "provenstyle"
    }
})
