package com.shawn.status

import android.content.Context
import androidx.lifecycle.asFlow
import com.shawn.data.util.SyncStatusMonitor
import kotlinx.coroutines.flow.Flow
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.shawn.util.SyncWorkName
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.map

/**
 * [SyncStatusMonitor] backed by [WorkInfo] from [WorkManager]
 */
class WorkManagerSyncStatusMonitor(
    context: Context
) : SyncStatusMonitor {
    override val isSyncing: Flow<Boolean> =
        WorkManager.getInstance(context).getWorkInfosForUniqueWorkLiveData(SyncWorkName).asFlow()
            .map { workInfos ->
                workInfos.any { it.state == WorkInfo.State.RUNNING }
            }.conflate()

//    val workManager = WorkManager.getInstance(context)
//    val workInfoFlow = workManager.getWorkInfosForUniqueWorkLiveData(SyncWorkName).asFlow()
//
//    val anyRunningFlow: Flow<Boolean> = workInfoFlow.map { workInfos ->
//        workInfos.any { it.state == WorkInfo.State.RUNNING }
//    }.conflate()

//        Transformations.map(
//            WorkManager.getInstance(context).getWorkInfosForUniqueWorkLiveData(SyncWorkName),
//            MutableList<WorkInfo>::anyRunning
//        )
//            .asFlow()
//            .conflate()
}