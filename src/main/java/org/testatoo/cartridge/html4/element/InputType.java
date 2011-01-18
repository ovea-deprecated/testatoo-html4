/**
 * Copyright (C) 2008 Ovea <dev@testatoo.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.testatoo.cartridge.html4.element;

/**
 * This enum gives the different possible types for a html4 input element.
 *
 * @author dev@testatoo.org
 */
public enum InputType {
    text, password, checkbox, radio, submit, reset, file, hidden, image, button;

    /**
     * To match the html input type to corresponding testatoo type
     *
     * @param inputType html attribute for imput type
     * @return testatoo type
     */

    public static String toComponentType(InputType inputType) {
        switch (inputType) {
            case text:
                return "InputText";
            case password:
                return "InputPassword";
            case checkbox:
                return "CheckBox";
            case radio:
                return "Radio";
            case hidden:
                return "Hidden";

        }
        return "Undefined";
    }

}
