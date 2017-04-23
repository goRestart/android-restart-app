package com.restart.restart.shared.di

import android.content.Context
import android.content.SharedPreferences
import android.os.Handler
import com.restart.restart.listing.di.ListingContainer
import com.restart.restart.login.di.LoginContainer
import com.restart.restart.main.ui.MainPresenter
import com.restart.restart.product.di.ProductContainer
import com.restart.restart.product.ui.viewmodel.PlatformViewModelMapper
import com.restart.restart.product.ui.viewmodel.PriceViewModelMapper
import com.restart.restart.shared.domain.UseCaseExecutor
import com.restart.restart.storage.ProductStorage
import java.lang.ref.WeakReference
import java.util.concurrent.ExecutorService
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class DependencyContainer(
    private val appContext: Context
) {
    var activityContext: Context? = null

    val context: Context
        get() = activityContext!!

    val listing: ListingContainer
        get() = ListingContainer(this)

    val product: ProductContainer
        get() = ProductContainer(this)

    val login: LoginContainer
        get() = LoginContainer(this)

    fun getMainPresenter(view: MainPresenter.View): MainPresenter {
        return MainPresenter(WeakReference(view))
    }

    val productStorage: ProductStorage by lazy {
        ProductStorage()
    }

    val priceViewModelMapper: PriceViewModelMapper
        get() = PriceViewModelMapper()

    val platformViewModelMapper: PlatformViewModelMapper
        get() = PlatformViewModelMapper()

    val useCaseExecutor: UseCaseExecutor
        get() = UseCaseExecutor(
            useCaseExecutorService,
            useCaseHandler
        )

    val useCaseExecutorService: ExecutorService
        get() {
            val corePoolSize = Runtime.getRuntime().availableProcessors()
            val maximumPoolSize = 8
            val keepAliveTime: Long = 30
            val unit = TimeUnit.SECONDS
            val workQueue = LinkedBlockingQueue<Runnable>()

            return ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue
            )
        }

    val useCaseHandler: Handler by lazy {
        Handler()
    }

    val sharedPreferences: SharedPreferences
        get() = context.getSharedPreferences(
            "Restart App Shared Preferences",
            Context.MODE_PRIVATE
        )
}