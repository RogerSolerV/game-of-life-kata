package com.kognia.test.gameoflife.feature;

@FunctionalInterface
public interface Generation<T> {

  T generate(T t);
}
