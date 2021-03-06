/**
 * File     : StringLog.java
 * License  :
 *   Original   - Copyright (c) 2010 - 2016 Boxfuse GmbH
 *   Derivative - Copyright (c) 2016 Citadel Technology Solutions Pte Ltd
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *           http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.builtamont.cassandra.migration.internal.util.logging;

/**
 * Logger that captures output as a string.
 */
@SuppressWarnings("StringConcatenationInsideStringBufferAppend")
public class StringLog implements Log {
    private final boolean debugEnabled;

    private final StringBuilder output;

    public StringLog(StringBuilder output, boolean debugEnabled) {
        this.output = output;
        this.debugEnabled = debugEnabled;
    }

    public void debug(String message) {
        if (debugEnabled) {
            output.append("DEBUG: " + message + "\n");
        }
    }

    public void info(String message) {
        output.append("INFO: " + message + "\n");
    }

    public void warn(String message) {
        output.append("WARN: " + message + "\n");
    }

    public void error(String message) {
        output.append("ERROR: " + message + "\n");
    }

    public void error(String message, Exception e) {
        output.append("ERROR: " + message + "\nCaused by: " + e);
    }
}
