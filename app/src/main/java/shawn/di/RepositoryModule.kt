package shawn.di

import org.koin.dsl.module
import shawn.data.remote.GetCourseRepository

val repositoryModule = module{
    factory {::GetCourseRepository }
}