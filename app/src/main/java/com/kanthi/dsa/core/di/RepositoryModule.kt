package com.kanthi.dsa.core.di

import com.kanthi.dsa.data.repository.UserRepositoryImpl
import com.kanthi.dsa.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
/** Tells Hilt which implementation to use for [UserRepository]. */
abstract class RepositoryModule {

    @Binds
    @Singleton
    /** Binds the data layer repository to the domain interface. */
    abstract fun bindsUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository

}
