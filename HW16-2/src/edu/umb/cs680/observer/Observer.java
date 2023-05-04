package edu.umb.cs680.observer;

public interface Observer<T> {
	public void update(Observable<T> sender, T event);
}
