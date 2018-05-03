package membean.gui;

import membean.util.Reference;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;


public class Window {
    /**
     * Creates an error callback.
     */
    private final GLFWErrorCallback glfwErrorCallback = GLFWErrorCallback.createPrint(System.err);

    public static long window;


    /**
     * Initializes and creates an new instance of Window.
     */
    public Window() {
        glfwErrorCallback.set();

        if (!GLFW.glfwInit()) {
            System.err.println("Unable to initialize GLFW");
            System.exit(1);
        }

        GLFW.glfwWindowHint(GLFW.GLFW_SAMPLES, 4);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
        GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 2);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT, GL11.GL_TRUE);
        GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GL11.GL_FALSE);

        window = GLFW.glfwCreateWindow(Reference.WINDOW_WIDTH, Reference.WINDOW_HEIGHT,
                "Membean: The RPG", MemoryUtil.NULL, MemoryUtil.NULL);

        if (window == MemoryUtil.NULL) {
            System.err.println("Unable to create a window");
            System.exit(1);
        }

        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();
        GLFW.glfwSwapInterval(1);

        start();
    }

    public void start() {
        float now, last = 0f, delta;

        init();

        while (!GLFW.glfwWindowShouldClose(window)) {
            now = (float) GLFW.glfwGetTime();
            delta = now - last;
            last = now;

            // Update and render
            update(delta);
            render(delta);

            // Poll the events and swap the buffers
            GLFW.glfwPollEvents();
            GLFW.glfwSwapBuffers(window);
        }

        dispose();

        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();

        System.exit(0);
    }

    private void init() {
    }

    private void update(double delta) {
    }

    private void render(double delta) {
    }

    private void dispose() {
    }
}
