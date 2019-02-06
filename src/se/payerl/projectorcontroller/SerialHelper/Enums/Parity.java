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

package se.payerl.projectorcontroller.SerialHelper.Enums;

public enum Parity {
	PARITY_EVEN(2),
 	PARITY_MARK(3),
 	PARITY_NONE(0),
 	PARITY_ODD(1),
 	PARITY_SPACE(4);
	
	private final int value;
	Parity(final int newValue) {
        value = newValue;
    }
	public int getValue() { return value; }
}