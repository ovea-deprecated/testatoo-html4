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

import org.testatoo.cartridge.html4.HtmlEvaluator;

import java.util.UUID;

/**
 * This class allows the testing of javascript AlertBox properties (on call of "alert()" method).
 * The AlertBox is a special window that appears to display information to the user, with a single button to close it.
 *
 * @author dev@testatoo.org
 */

public final class AlertBox extends org.testatoo.core.component.AlertBox {

    public static final String ID = "_$ALERTBOX$_" + UUID.randomUUID().toString();

    /**
     * Class constructor specifying the evaluator to use and the id of the alertBox we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     */
    public AlertBox(HtmlEvaluator evaluator) {
        super(evaluator, ID);
    }

}
