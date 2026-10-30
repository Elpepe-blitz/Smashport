# Smash Android

Base inicial del proyecto Android para Windows + Android Studio.

## Estado de esta primera etapa

- Proyecto Android nativo en Kotlin.
- Pantalla inicial de Smash Android.
- Selector de archivo ROM mediante el selector del sistema Android.
- Copia del archivo seleccionado al almacenamiento privado de la aplicación.
- Configuración inicial de NDK y CMake.
- Biblioteca JNI nativa de prueba para verificar que la parte C++ carga correctamente.

**Todavía no incluye el emulador N64 ni ejecuta juegos.** En la siguiente etapa se integrará el núcleo de emulación compatible y se conectará a la pantalla de juego. La ROM no está incluida en este proyecto.

## Requisitos

- Android Studio.
- JDK 17 o el JBR incluido con Android Studio.
- Android SDK Platform 36.
- Android SDK Build-Tools.
- Android SDK Platform-Tools.
- NDK (Side by side).
- CMake.

## Abrir

1. Descomprime `SmashAndroid.zip`.
2. En Android Studio selecciona **Open** y elige la carpeta `SmashAndroid`.
3. Espera a que termine la sincronización de Gradle.
4. Si Android Studio solicita instalar componentes del SDK/NDK/CMake, acepta.
5. Ejecuta en un dispositivo Android o emulador.

## Seleccionar una ROM

En la pantalla principal pulsa **Seleccionar ROM** y elige tu archivo desde el selector del sistema. El archivo se copia al directorio privado de la aplicación. Esta versión solo comprueba la selección y la copia; aún no inicia la emulación.

## Datos técnicos

- Nombre: Smash Android
- Application ID: `com.smashandroid.n64`
- Lenguaje: Kotlin + C++
- Min SDK: 23
- Compile/Target SDK: 36
- NDK: versión instalada mediante `ndkVersion` de Android Gradle Plugin (se puede fijar cuando instalemos la versión concreta).
