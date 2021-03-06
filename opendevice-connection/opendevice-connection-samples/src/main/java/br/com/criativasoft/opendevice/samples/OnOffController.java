/*
 * *****************************************************************************
 * Copyright (c) 2013-2014 CriativaSoft (www.criativasoft.com.br)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * - Ricardo JL Rufino - Initial API and Implementation
 * *****************************************************************************
 */

package br.com.criativasoft.opendevice.samples;

import br.com.criativasoft.opendevice.connection.*;
import br.com.criativasoft.opendevice.connection.message.GPIO;
import br.com.criativasoft.opendevice.connection.message.Message;
import br.com.criativasoft.opendevice.connection.message.SimpleMessage;
import br.com.criativasoft.opendevice.samples.ui.FormController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OnOffController extends FormController  implements ConnectionListener {

	private FormController form;
	private static StreamConnection connection;

    private int PIN = 13; // CHANGE PIN TO CONTROL.
	
	public OnOffController() {
		
		//USE: samples/arduino/UsbConnection
		 connection = StreamConnectionFactory.createUsb(); //
		
		//USE: samples/arduino/BluetoothConnection
		// connection = StreamConnectionFactory.createBluetooth("20:13:01:24:01:93");

		connection.addListener(this);

		form = this;
		form.setConnection(connection);
		form.addButton("ON", btnListener);
		form.addButton("OFF", btnListener);
		form.setVisible(true);
		
		
		System.out.println("listAvaibleURIs = "+ UsbConnection.listAvailablePortNames());
		
		// connection.setEndOfMessageToken(ArduinoConnection.TOKEN_ZERO);
		// ((AbstractSerialConnection) connection).setSerialReader(new FixedSerialReader(3));
	}
	
	private ActionListener btnListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			String btnName = event.getActionCommand();

			try {
				if (btnName.equalsIgnoreCase("ON")) {
					System.out.println("SEND: ON");
					connection.send(new GPIO(PIN, GPIO.HIGH));
				}
				
				if (btnName.equalsIgnoreCase("OFF")) {
					System.out.println("SEND: OFF");
                    connection.send(new GPIO(PIN, GPIO.LOW));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	};
	

	@Override
	public void connectionStateChanged(DeviceConnection connection, ConnectionStatus status) {
		
		try {
			if(connection.isConnected()){
				System.out.println("Connected !!!");
				connection.send(SimpleMessage.LOW);  // Iniciar comunicacao	.
			}else{
				System.out.println("Disconnected !!!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onMessageReceived(Message message, DeviceConnection connection) {
		
		SimpleMessage stream = (SimpleMessage) message;
		
		String value = new String(stream.getBytes());
			
		System.out.println(value);
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		new OnOffController();
	}

}
