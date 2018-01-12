package NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidate

import NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidate.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.Project

object Project : Project({
    uuid = "9bf34f88-f530-485d-a043-450d148abc9d"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidate"
    parentId = "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment"
    name = "Miruken.Validate"
    description = "Miruken.Validate nuget package"

    buildType(NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidate_DeployRelea)
    buildType(NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidate_DeployPreRe)

    params {
        param("NuGetPackSpecFiles", """Source\Miruken.Validate\Miruken.Validate.nuspec""")
        param("PackageName", "Miruken.Validate")
    }
    buildTypesOrder = arrayListOf(NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidate.buildTypes.NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidate_DeployRelea)
})
