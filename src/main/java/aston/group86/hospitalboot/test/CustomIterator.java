package aston.group86.hospitalboot.test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomIterator<T> implements Iterator<T> {

  private final T[] collection;
  private int index = 0;

  public CustomIterator(T[] collection) {
    this.collection = collection;
  }

  @Override
  public boolean hasNext() {
    return collection.length > index;
  }

  @Override
  public T next() {
    if(!hasNext()){
      throw new NoSuchElementException();
    }
    return collection[index++];
  }
}
