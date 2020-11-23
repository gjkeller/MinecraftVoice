/*
 * Copyright 2020 Gabriel Keller
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.okgabe.minecraftvoice.data;

public enum ConfigPath {
    TEST_CONFIG("");

    private String path;

    ConfigPath(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString(){
        return path;
    }
}
