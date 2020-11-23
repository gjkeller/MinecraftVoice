/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.okgabe.minecraftvoice.exception;

public class SocketException extends Exception {
    public SocketException(String message, Throwable cause){
        super(message, cause);
    }

    public SocketException(String message){
        super(message);
    }
}
