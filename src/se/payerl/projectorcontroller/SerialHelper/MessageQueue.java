//ProjectorController is a program used to control a projector using a serial connection.
//Copyright (C) <2019>  <Anders Payerl>
//
//This program is free software: you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation, either version 3 of the License, or
//(at your option) any later version.
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this program. If not, see <https://www.gnu.org/licenses/>.

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