# 📱 PostApp

PostApp, **Jetpack Compose**, **Paging 3**, **Hilt**, **Retrofit**, **Room** ve **Clean Architecture** prensipleri kullanılarak geliştirilmiş modern bir Android uygulamasıdır. Uygulama, **JSONPlaceholder API** üzerinden post verilerini çeker ve **infinite scroll (Paging)** desteği sağlar.

---

## ✅ Özellikler
- ✅ **MVVM** + **Clean Architecture** yaklaşımı  
- ✅ **Jetpack Compose UI**  
- ✅ **Paging 3** ile sonsuz listeleme  
- ✅ **Retrofit** ile REST API entegrasyonu  
- ✅ **Hilt** ile Dependency Injection  
- ✅ **Room** ile local cache (eklenebilir)  
- ✅ **Coroutines + Flow** ile asenkron veri yönetimi  
- ✅ **Unit Test** desteği (Paging, ViewModel)  

---

## 🛠️ Kullanılan Teknolojiler
- **Kotlin** (100% Compose)
- **Jetpack Compose** (UI)
- **Paging 3** (Veri sayfalama)
- **Hilt** (Dependency Injection)
- **Retrofit + OkHttp** (Network)
- **Room** (Local DB)
- **Coroutines + Flow** (Reactive)
- **JUnit + Turbine** (Test)

## 📂 Proje Yapısı

app/
├── data/
│ ├── local/ # Room Entity & DAO
│ ├── mapper/ # DTO-Entity-Model Mapper
│ ├── paging/ # PagingSource
│ ├── remote/ # Retrofit API & DTO
│ └── repository/ # Repository Implementation
├── domain/
│ ├── model/ # Post Model
│ ├── repository/ # Repository Interface
│ └── usecase/ # UseCase (GetPostsUseCase)
├── presentation/
│ ├── navigation/ # Navigation Graph
│ ├── state/ # UI State
│ ├── ui/ # Compose UI Screens
│ └── viewmodel/ # PostViewModel
├── di/ # Hilt Modules
├── ui/theme/ # Compose Theme
├── MainActivity.kt
├── PostsApp.kt # Hilt Application
└── tests/ # Unit Tests

## ▶️ Çalıştırma
1. **Clone Repo**
   ```bash
   git clone https://github.com/bukanevefiore/PostAppRepo.git
   cd PostApp

   Android Studio ile Aç

Minimum Android Studio Giraffe veya üzeri önerilir.
Gradle Sync
gradlew build veya IDE'den Sync.
Çalıştır
Uygulamayı bir Emulator veya Fiziksel Cihazda başlat.

Testler
Projede Unit Test desteği bulunmaktadır:
ViewModel Testi (PagingData doğrulama)
UseCase Testi
Repository Testi (Fake Data)

Çalıştırmak için:
bash
./gradlew test

Kullanılan API: JSONPlaceholder




