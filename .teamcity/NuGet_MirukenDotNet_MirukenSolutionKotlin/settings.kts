package NuGet_MirukenDotNet_MirukenSolutionKotlin

import jetbrains.buildServer.configs.kotlin.v2017_2.*

version = "2017.2"
project(configureNugetSolutionProject(NugetSolution(
        guid           = "2f710b99-d945-4072-b5dd-463fac99b976",
        parentId       = "NuGet_MirukenDotNet",
        id             = "NuGet_MirukenDotNet_MirukenSolutionKotlin",
        name           = "Miruken Solution Kotlin",
        codeGithubUrl  = "git@github.com:Miruken-DotNet/Miruken.git",
        buildGithubUrl = "git@github.com:Miruken-DotNet/MirukenKotlinBuild.git",
        solutionFile   = "Miruken.sln",
        testAssemblies = "**\\bin\\*Test*.dll",
        nugetProjects = listOf(
                NugetProject(
                        id          = "Miruken",
                        packageName = "Miruken",
                        nuspecFile  = "Source\\Miruken\\Miruken.nuspec"),
                NugetProject(
                        id          = "MirukenCastle",
                        packageName = "Miruken.Castle",
                        nuspecFile  =  "Source\\Miruken.Castle\\Miruken.Castle.nuspec"),
                NugetProject(
                        id          = "MirukenValidate",
                        packageName = "Miruken.Validate",
                        nuspecFile  =  "Source\\Miruken.Validate\\Miruken.Validate.nuspec"),
                NugetProject(
                        id          = "MirukenValidateCastle",
                        packageName = "Miruken.Validate.Castle",
                        nuspecFile  =  "Source\\Miruken.Valiate.Castle\\Miruken.Validate.Castle.nuspec")
))))
