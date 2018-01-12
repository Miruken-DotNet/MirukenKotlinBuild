package NuGet_MirukenDotNet_MirukenSolutionKotlin.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.vcs.GitVcsRoot

object NuGet_MirukenDotNet_MirukenSolutionKotlin_MirukenKotlinBuildGit : GitVcsRoot({
    uuid = "da77f0da-6ad7-4af9-a6e8-09f28543294f"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_MirukenKotlinBuildGit"
    name = "MirukenKotlinBuild.git"
    url = "git@github.com:Miruken-DotNet/MirukenKotlinBuild.git"
    authMethod = uploadedKey {
        uploadedKey = "provenstyle"
    }
})
