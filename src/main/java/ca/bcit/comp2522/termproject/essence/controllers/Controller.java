package ca.bcit.comp2522.termproject.essence.controllers;

import java.util.function.Consumer;

import javafx.scene.input.KeyCode;

public interface Controller {
  void bindAxisKey(final Events eventName, final KeyCode keycode, final Integer scale);
  void bindAxis(final Events eventName, final Consumer<Integer> handler);
}
