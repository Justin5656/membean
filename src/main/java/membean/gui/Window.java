package membean.gui;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;


public class Window {
    /**
     * Creates an error callback.
     */
    private final GLFWErrorCallback glfwErrorCallback = GLFWErrorCallback.createPrint(System.err);

    /**
     * Initializes and creates an new instance of Window.
     */
    public Window() {
        glfwErrorCallback.set();

        if (!GLFW.glfwInit()) {
            System.err.println("Unable to initialize GLFW");
            System.exit(1);
        }
    }
}
