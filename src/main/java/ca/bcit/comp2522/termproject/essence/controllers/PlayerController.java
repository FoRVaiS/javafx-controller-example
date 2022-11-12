package ca.bcit.comp2522.termproject.essence.controllers;

import java.util.HashMap;
import java.util.function.Consumer;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PlayerController implements Controller {
  private final Scene scene;
  private final HashMap<KeyCode, Events> keyMap;
  private final HashMap<Events, Consumer<Integer>> eventFnMap;
  private final HashMap<KeyCode, Integer> keyScaleMap;

  public PlayerController(final Scene scene) {
    this.scene = scene;
    this.keyMap = new HashMap<>();    
    this.eventFnMap = new HashMap<>();    
    this.keyScaleMap = new HashMap<>();

    this.scene.setOnKeyPressed(this::processInput);
  }

  @Override
  public void bindAxisKey(final Events eventName, final KeyCode keycode, final Integer scale) {
    this.keyMap.put(keycode, eventName);
    this.keyScaleMap.put(keycode, scale);
  }

  @Override
  public void bindAxis(final Events eventName, final Consumer<Integer> handler) {
    this.eventFnMap.put(eventName, handler);
  }

  private void processInput(final KeyEvent event) {
    final KeyCode code = event.getCode();

    final Events eventName = this.keyMap.get(code);
    final Integer scale = this.keyScaleMap.get(code);
    final Consumer<Integer> callback = this.eventFnMap.get(eventName);

    callback.accept(scale);
  }
}
