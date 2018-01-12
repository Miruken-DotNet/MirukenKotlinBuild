package NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidateCastle

import NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidateCastle.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.Project

object Project : Project({
    uuid = "d87733ba-30d4-4d79-b7af-fc9fe30ac69a"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidateCastle"
    parentId = "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment"
    name = "Miruken.Validate.Castle"
    description = "Miruken.Validate.Castle nuget package"

    buildType(NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidateCastle_Deplo)
    buildType(NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidateCastle_Dep_2)

    params {
        param("NuGetPackSpecFiles", """Source\Miruken.Validate.Castle\Miruken.Validate.Castle.nuspec""")
        param("PackageName", "Miruken.Validate.Castle")
    }
    buildTypesOrder = arrayListOf(NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidateCastle.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidateCastle_Deplo)
})
