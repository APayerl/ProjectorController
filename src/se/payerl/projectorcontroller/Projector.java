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

package se.payerl.projectorcontroller;

import se.payerl.projectorcontroller.SerialHelper.Helper;
import se.payerl.projectorcontroller.SerialHelper.SendQueueElement;
import se.payerl.projectorcontroller.SerialHelper.Interfaces.Message;

public abstract class Projector {
	protected String projectorName;
	protected Helper helper;
	
//	public String getProjectorName() {
//		return this.projectorName;
//	}
//	
//	public Helper getProjectorHelper() {
//		return this.helper;
//	}
//	
//	protected void setProjectorName(String name) {
//		this.projectorName = name;
//	}
//	
//	protected void setProjectorHelper(Helper h) {
//		this.helper = h;
//	}
	
	public void queueMessage(String message, int replys, Message callback) {
		this.queueMessage(new SendQueueElement(message, replys, callback));
	}
	
	public void queueMessage(SendQueueElement sqe) {
		this.helper.queueMessage(sqe);
	}
	
	public void closePorts() {
		this.helper.close();
	}
}