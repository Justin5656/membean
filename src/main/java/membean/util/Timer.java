package membean.util;

import org.lwjgl.glfw.GLFW;

/**
 * Manages the time of the game (FPS, UPS, etc.).
 *
 * @version 0.1.0
 */
public class Timer {
    /**
     * Gets the time since GLFW was initialized.
     * @return Current time.
     */
    public static double getTime() {
        return GLFW.glfwGetTime();
    }


}
