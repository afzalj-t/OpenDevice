/*
 * *****************************************************************************
 * Copyright (c) 2013-2014 CriativaSoft (www.criativasoft.com.br)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Ricardo JL Rufino - Initial API and Implementation
 * *****************************************************************************
 */

package br.com.criativasoft.opendevice.core.connection;

import br.com.criativasoft.opendevice.core.metamodel.EnumCode;

/**
 * ConnectionType ENUM
 *
 * @author Ricardo JL Rufino
 * @date 02/11/15
 */
public enum ConnectionType implements EnumCode {

    USB(1), BLUETOOTH(2), WIFI(3), ETHERNET(4), MQTT(5), WEBSOCKET(6);

    private int code;

    ConnectionType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ConnectionType getByCode(int code) {
        EnumCode[] values = ConnectionType.values();
        for (EnumCode enumCode : values) {
            if (enumCode.getCode() == code) {
                return (ConnectionType) enumCode;
            }
        }

        return null;
    }

    @Override
    public String getDescription() {
        return name();
    }
}
