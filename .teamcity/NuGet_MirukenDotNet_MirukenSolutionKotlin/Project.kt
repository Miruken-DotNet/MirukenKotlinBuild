package NuGet_MirukenDotNet_MirukenSolutionKotlin

import NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes.*
import NuGet_MirukenDotNet_MirukenSolutionKotlin.vcsRoots.*
import NuGet_MirukenDotNet_MirukenSolutionKotlin.vcsRoots.NuGet_MirukenDotNet_MirukenSolutionKotlin_MirukenKotlinBuildGit
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.Project
import jetbrains.buildServer.configs.kotlin.v2017_2.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v2017_2.projectFeatures.versionedSettings

object Project : Project({
    uuid = "a27246ea-2f2d-483a-bfd4-8ea6d22b2239"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin"
    parentId = "NuGet_MirukenDotNet"
    name = "Miruken Solution Kotlin"
    description = "Core Miruken-DotNet"

    vcsRoot(NuGet_MirukenDotNet_MirukenSolutionKotlin_MirukenKotlinBuildGit)
    vcsRoot(NuGet_MirukenDotNet_MirukenSolutionKotlin_MirukenGitMiruken)
    vcsRoot(NuGet_MirukenDotNet_MirukenSolutionKotlin_HttpsGithubComMirukenDotNetMirukenGitC)

    buildType(NuGet_MirukenDotNet_MirukenSolutionKotlin_CiBuild)
    buildType(NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild)
    buildType(NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild)

    params {
        param("ArtifactsIn", """
            Source      => Build.zip!/Source
            packages    => Build.zip!/packages
            Miruken.sln => Build.zip!
        """.trimIndent())
        param("ArtifactsOut", """
            Build.zip!/Source   => Source
            Build.zip!/packages => packages
            Build.zip!/Miruken.sln
        """.trimIndent())
        param("MajorVersion", "1")
        param("MinorVersion", "11")
        param("PatchVersion", "18")
        param("PreReleaseProjectId", "NuGet_MirukenDotNet_MirukenSolution_PreReleaseBuild")
        param("ReleaseProjectId", "NuGet_MirukenDotNet_MirukenSolution_ReleaseBuild")
        param("Solution", "Miruken.sln")
        param("SolutionProjectId", "NuGet_MirukenDotNet_MirukenSolution")
        param("TestAssemblies", """**\bin\*Test*.dll""")
    }

    features {
        versionedSettings {
            id = "PROJECT_EXT_2"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.PREFER_SETTINGS_FROM_VCS
            rootExtId = NuGet_MirukenDotNet_MirukenSolutionKotlin_MirukenKotlinBuildGit.id
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
            storeSecureParamsOutsideOfVcs = true
        }
    }
    buildTypesOrder = arrayListOf(NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_CiBuild, NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_PreReleaseBuild, NuGet_MirukenDotNet_MirukenSolutionKotlin.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_ReleaseBuild)
    subProjectsOrder = arrayListOf("NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment")
})
