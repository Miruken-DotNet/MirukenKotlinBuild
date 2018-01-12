package NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_Miruken

import NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_Miruken.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.Project

object Project : Project({
    uuid = "9e53e204-ef86-44e6-be6d-f4554a5e966e"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_Miruken"
    parentId = "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment"
    name = "Miruken"
    description = "Miruken nuget package"

    buildType(NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_Miruken_DeployRelease)
    buildType(NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_Miruken_DeployPreRelease)

    params {
        param("NuGetPackSpecFiles", """Source\Miruken\Miruken.nuspec""")
        param("PackageName", "Miruken")
    }
    buildTypesOrder = arrayListOf(NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_Miruken.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_Miruken_DeployPreRelease, NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_Miruken.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_Miruken_DeployRelease)
})
