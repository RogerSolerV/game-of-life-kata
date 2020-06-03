package com.kognia.test.gameoflife.domain;

public enum STATUS {
  ALIVE,
  DEAD;

  @Override
  public String toString() {
    switch (this) {
      case ALIVE:
        return "O";
      case DEAD:
        return ".";
      default:
        throw new IllegalArgumentException();
    }
  }
}
