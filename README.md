# tunnel-toolchain-test

تطبيق أندرويد صغير منفصل للتحقق من مكدّس الترقية المؤجلة قبل تطبيقها على
`Ayman Tunnel Plus` — لا يمسّ `tunnel-app` إطلاقًا (لا كوده ولا مستودعه
ولا تشغيلاته).

## المكدّس المُختبَر

| المكوّن | الإصدار |
|---|---|
| Android Gradle Plugin | 9.1.0 |
| Gradle | 9.1.0 |
| compileSdk / targetSdk | 37 |
| Kotlin | 2.3.21 |
| KSP | 2.3.14 |
| Hilt | 2.59 |
| Room | 2.8.5 |
| Compose BOM | 2026.11.01 |
| core-ktx | 1.19.1 |
| lifecycle | 2.11.1 |
| hilt-navigation-compose | 1.4.0 |
| JDK (في CI) | 17 |

## ما يغطيه التطبيق

- نشاط واحد + Compose (نص ترحيبي + عدّاد من قاعدة البيانات).
- حقن Hilt واحد (`@HiltAndroidApp` + `@HiltViewModel` + `@Module` يوفّر قاعدة البيانات).
- كيان Room واحد (`Note`) مع DAO — يختبر توليد كود KSP/Hilt/Room.
- اختبار وحدة واحد (`ToolchainTest`).

## البناء

```sh
./gradlew testDebugUnitTest
./gradlew :app:assembleDebug
```

## النتيجة

- ✅ نجاح التشغيل في GitHub Actions يعني أن مكدّس الترقية يعمل معًا،
  وأن ترقية `tunnel-app` إلى AGP 9.1 + Gradle 9 + SDK 37 ممكنة تقنيًا.
- ❌ فشل التشغيل يعني أن الترقية ما زالت محظورة — ويُقرأ سبب الفشل من
  سجل الخطوة الفاشلة في التشغيل قبل أي ترقية.
