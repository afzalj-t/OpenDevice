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

package br.com.criativasoft.opendevice.restapi;

import br.com.criativasoft.opendevice.core.DataManager;
import br.com.criativasoft.opendevice.restapi.model.dao.AccountDao;

/**
 * TODO: Add docs.
 *
 * @author Ricardo JL Rufino
 * @date 10/09/16
 */
public interface ApiDataManager extends DataManager {

    public AccountDao getAccountDao();

}
