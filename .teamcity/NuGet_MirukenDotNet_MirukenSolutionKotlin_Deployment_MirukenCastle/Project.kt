package NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenCastle

import NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenCastle.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.Project

object Project : Project({
    uuid = "d9f0666f-aa7d-427a-8838-ca1a8bf8d760"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenCastle"
    parentId = "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment"
    name = "Miruken.Castle"
    description = "Miruken.Castle nuget package"

    buildType(NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenCastle_DeployPreRele)
    buildType(NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenCastle_DeployRelease)

    params {
        param("NuGetPackSpecFiles", "Source/Miruken.Castle/Miruken.Castle.nuspec")
        param("PackageName", "Miruken.Castle")
        param("PrereleaseVersion", "")
    }
    buildTypesOrder = arrayListOf(NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenCastle.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenCastle_DeployRelease)
})
