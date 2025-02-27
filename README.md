
# Overview
- [專案介紹](#專案介紹)
- [架構簡介](#架構簡介)
- [主要畫面](#主要畫面)
- [其他](#其他)
- [Figma](#figma)

## 專案介紹
- 專案架構為MVVM架構
- 使用 Flow、coroutine 處理 call api
- koin 導入依賴注入架構 
- 使用Room 資料庫來作離線模式存儲資料的地方
- 架構參考[nowinandroid](https://github.com/InsertKoinIO/nowinandroid/tree/refacto_koin/end)

## 架構簡介
Hahow App 有離線也能使用App看資料，所以參考了 [nowinandroid](https://github.com/InsertKoinIO/nowinandroid/tree/refacto_koin/end) 來做離線存取的架構
- database module : 使用Room來存資料與取資料
- network module : Retrofit 來取api 或 json的資料、利用Header來決定是否用json加載
- data module : 依賴database module、network module 來做資料的處理
- sync module : 依賴data module 使用CoroutineWorker在App launch時來做後台同步處理，達成預加載減少使用者等待時間(參考[nowinandroid](https://github.com/InsertKoinIO/nowinandroid/tree/refacto_koin/end))

### 當app launch時到畫面時
- application - sync module - data module(network、database) - 儲存進room
### 畫面到取資料
- view(fragment) - viewmodel - data module(network、database) - 取得來自room的資料
  
## 主要畫面
| 畫面 | 介紹 | 
| - | - | 
| <img src="https://github.com/StoneShawn/ClassSchedule/assets/54303580/1f7aca07-46c2-4c59-a979-083934b5c3d7" height="500"> | 課程頁面</br>- 收藏按鈕處理 </br>- 使用Glide處理圖片 </br>- viewModel使用UiState來更新畫面 | 
## 其他
- 開發時間表
  | 0916 | 0917 | 0918 | 0919 | 0920 | 0921 |
  | - | - | - | - | - | - |
  | 規劃實作方式 | 專案建立、刻雛形畫面 | 課程view實作 | MVVM架構建立、Room導入、Koin導入 | MVVM架構完成、讀Json方式實作 | Api同步加進Room實作、畫面優化、readme更新 |
## Figma
- 使用Figma刻畫面
- [figma網址](https://www.figma.com/file/mQ5iQ0AdXGMWJcdihRwLuu/HaHow-Class-Scheudle?type=design&node-id=0%3A1&mode=design&t=xSVWTX732feqvhVf-1)
