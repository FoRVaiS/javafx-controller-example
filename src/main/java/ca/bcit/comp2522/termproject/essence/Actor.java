package ca.bcit.comp2522.termproject.essence;

import ca.bcit.comp2522.termproject.essence.controllers.Controller;
import ca.bcit.comp2522.termproject.essence.controllers.Events;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public class Actor {
  private int x, y;
  private int speed;
  private Controller controller;
  private final ImageView sprite;

  public Actor(final ImageView sprite, final int x, final int y, final int speed) {
    this.speed = speed;
    this.x = x;
    this.y = y;

    this.sprite = sprite;
    this.sprite.setX(this.x);
    this.sprite.setY(this.y);
  }

  public void possess(final Controller controller) {
    this.controller = controller;

    this.controller.bindAxisKey(Events.MOVE_X, KeyCode.D, 1);
    this.controller.bindAxisKey(Events.MOVE_X, KeyCode.A, -1);
    this.controller.bindAxisKey(Events.MOVE_Y, KeyCode.W, 1);
    this.controller.bindAxisKey(Events.MOVE_Y, KeyCode.S, -1);

    this.controller.bindAxisKey(Events.MOVE_X, KeyCode.RIGHT, 1);
    this.controller.bindAxisKey(Events.MOVE_X, KeyCode.LEFT, -1);
    this.controller.bindAxisKey(Events.MOVE_Y, KeyCode.UP, 1);
    this.controller.bindAxisKey(Events.MOVE_Y, KeyCode.DOWN, -1);

    this.controller.bindAxis(Events.MOVE_X, this::moveX);
    this.controller.bindAxis(Events.MOVE_Y, this::moveY);
  }

  public void unpossess() {
    this.controller = null;
  }

  private void moveX(final Integer xDir) {
    this.x += xDir * this.speed;

    this.sprite.setX(this.x);
  }

  private void moveY(final int yDir) {
    this.y += yDir * this.speed;

    this.sprite.setY(this.y);
  }
}
