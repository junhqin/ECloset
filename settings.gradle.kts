pluginManagement {
    repositories {
        maven { setUrl(" https://maven.aliyun.com/repository/google") }
        maven { setUrl(" https://maven.aliyun.com/repository/public") }
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven { setUrl(" https://maven.aliyun.com/repository/google") }
        maven { setUrl(" https://maven.aliyun.com/repository/public") }
        google()
        mavenCentral()
    }
}

rootProject.name = "ECloset"
include(":app")
include (":opendanmaku")
