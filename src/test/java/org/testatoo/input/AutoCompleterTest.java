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

package org.testatoo.input;

import org.junit.Ignore;
import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.cartridge.html4.element.Div;
import org.testatoo.cartridge.html4.element.InputText;
import org.testatoo.core.input.Keyboard;

import static org.junit.Assert.fail;
import static org.testatoo.cartridge.html4.By.$;
import static org.testatoo.core.ComponentFactory.*;
import static org.testatoo.core.Language.clickOn;

public class AutoCompleterTest extends WebTest {

    @Test
    @Ignore
    public void can_test_ajax_autocompleter() throws Exception {
        page().open("AutoCompleter.html");

        try {
            component(Div.class, $("[title=March]"));
            fail();
        } catch (Exception e) {

        }

        // Fail with pure selenium cause none native keyboard events
//        Selenium selenium = (Selenium) EvaluatorHolder.get().implementation();
//        selenium.type("months", "m");

        // Success with Testatoo and native keyboard events
        // TODO need keyboard refactor ASAP => Romain
        clickOn(component(InputText.class, "months"));
        Keyboard.type("M");

        component(Div.class, $("[title=March]"));
        component(Div.class, $("[title=May]"));
    }
}
