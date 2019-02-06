package se.payerl.projectorcontroller.SerialHelper;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageQueue<T> {
	private Queue<T> sendQueue;
	private Lock lock;
	
	public int length;
	
	public MessageQueue() {
		this.sendQueue = new ArrayDeque<>();
		this.length = 0;
		this.lock = new ReentrantLock(true);
	}
	
	public boolean push(T element) {
		this.lock.lock();
		this.length += 1;
		boolean success = this.sendQueue.add(element);
		this.lock.unlock();
		return success;
	}
	
	public T pop() {
		this.lock.lock();
		this.length -= 1;
		T tmp = this.sendQueue.poll();
		this.lock.unlock();
		return tmp;
	}
	
	public T peek() {
		this.lock.lock();
		T tmp = this.sendQueue.peek();
		this.lock.unlock();
		return tmp;
	}
	
	public boolean isEmpty() {
		this.lock.lock();
		boolean result = this.peek() == null;
		this.lock.unlock();
		return result;
	}
}