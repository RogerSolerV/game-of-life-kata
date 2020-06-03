package com.kognia.test.gameoflife.domain;

public enum STATUS {
  ALIVE,
  DEAD;

  public static final String DEAD_CHAR = ".";
  public static final String ALIVE_CHAR = "O";

  public static STATUS valueOfChar(char val) {
    return valueOfChar(String.valueOf(val));
  }

  public static STATUS valueOfChar(String val) {
    switch (val) {
      case ALIVE_CHAR:
        return ALIVE;
      case DEAD_CHAR:
        return DEAD;
      default:
        throw new IllegalArgumentException();
    }
  }

  @Override
  public String toString() {
    switch (this) {
      case ALIVE:
        return ALIVE_CHAR;
      case DEAD:
        return DEAD_CHAR;
      default:
        throw new IllegalArgumentException();
    }
  }
}
