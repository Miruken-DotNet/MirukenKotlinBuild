package NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment

import jetbrains.buildServer.configs.kotlin.v2017_2.*
import jetbrains.buildServer.configs.kotlin.v2017_2.Project

object Project : Project({
    uuid = "a05a4b1c-8511-4cfe-a22a-ead65b876307"
    id = "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment"
    parentId = "NuGet_MirukenDotNet_MirukenSolutionKotlin"
    name = "Deployment"

    params {
        param("SHA", "")
    }
    subProjectsOrder = arrayListOf("NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_Miruken", "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenCastle", "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidate", "NuGet_MirukenDotNet_MirukenSolutionKotlin_Deployment_MirukenValidateCastle")
})
