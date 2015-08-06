package com.sample.javafx.util;

import com.sample.javafx.scene.DashBoardScene;
import com.sample.javafx.scene.LoginScene;
import javafx.application.Application;
import javafx.scene.Scene;

/**
 * Created by matt on 01/08/2015.
 */
public class SceneFactory {
    public static Application getSceneByName(String sceneName) {
        Application scene = null;
        switch (sceneName) {
            case "LoginScene":
                scene = new LoginScene();
                break;
            case "DashBoardScene":
                scene = new DashBoardScene();
                break;
            default:
                throw new IllegalArgumentException("No such scene defined");
        }
        return scene;
    }
}
