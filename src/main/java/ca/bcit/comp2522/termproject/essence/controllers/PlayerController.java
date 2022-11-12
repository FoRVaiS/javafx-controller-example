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
  private final HashMap<Events, Integer> eventScaleMap;

  public PlayerController(final Scene scene) {
    this.scene = scene;
    this.keyMap = new HashMap<>();    
    this.eventFnMap = new HashMap<>();    
    this.eventScaleMap = new HashMap<>();    

    this.scene.setOnKeyPressed(this::processInput);
  }

  @Override
  public void bindAxisKey(final Events eventName, final KeyCode keycode, final Integer scale) {
    this.keyMap.put(keycode, eventName);
    this.eventScaleMap.put(eventName, scale);
  }

  @Override
  public void bindAxis(final Events eventName, final Consumer<Integer> handler) {
    this.eventFnMap.put(eventName, handler);
  }

  private void processInput(final KeyEvent event) {
    final Events eventName = this.keyMap.get(event.getCode());
    final Consumer<Integer> callback = this.eventFnMap.get(eventName);
    final Integer scale = this.eventScaleMap.get(eventName);

    callback.accept(scale);
  }
}
