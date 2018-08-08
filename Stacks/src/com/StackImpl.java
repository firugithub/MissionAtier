package com;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackImpl {
	private int capacity;
	private List<Integer> arrList = new ArrayList<Integer>();;

	public StackImpl(int capacity) {
		super();
		this.capacity = capacity;
	}

	private boolean isEmpty() {
		return (arrList.size() == 0);
	}

	private boolean isFull() {
		return (arrList.size() == capacity);
	}

	public int pop() {
		if (isEmpty()) {
			throw new EmptyStackException();

		} else {
			int data = arrList.get(arrList.size() - 1);
			arrList.remove(arrList.size() - 1);
			return data;
		}
	}

	public void push(int data) {
		if (isFull()) {
			throw new StackOverflowError();

		} else {
			arrList.add(data);
		}
	}

}
