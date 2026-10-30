
package com.smashandroid.n64

import android.app.Activity
import android.os.Bundle
import android.view.SurfaceView
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.TextView
import java.io.File

class MainActivity : Activity() {

    private lateinit var gameSurface: SurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Pantalla completa
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        window.addFlags(
            WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
        )

        // Superficie donde se dibujará el juego
        gameSurface = SurfaceView(this)

        val root = FrameLayout(this)
        root.addView(
            gameSurface,
            FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        )

        setContentView(root)

        // Cargar la ROM automáticamente
        try {
            val romFile = File(filesDir, "roms/smash.z64")
            romFile.parentFile?.mkdirs()

            assets.open("rom/smash.z64").use { input ->
                romFile.outputStream().use { output ->
                    input.copyTo(output)
                }
            }

            android.util.Log.i(
                "SmashAndroid",
                "ROM preparada: ${romFile.absolutePath}"
            )

            // Aquí conectaremos el motor Libretro.
            // Todavía no iniciar la emulación:
            // falta compilar e integrar el núcleo.

        } catch (e: Exception) {
            android.util.Log.e(
                "SmashAndroid",
                "Error cargando la ROM",
                e
            )

            val errorText = TextView(this).apply {
                text = "No se pudo cargar el archivo del juego."
                textSize = 18f
                setTextColor(android.graphics.Color.WHITE)
            }

            root.addView(errorText)
        }
    }
}
