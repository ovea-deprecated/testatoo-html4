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

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.cartridge.html4.By;
import org.testatoo.cartridge.html4.HtmlEvaluator;
import org.testatoo.cartridge.html4.element.Div;
import org.testatoo.cartridge.html4.element.InputText;
import org.testatoo.core.Condition;
import org.testatoo.core.ConditionChain;
import org.testatoo.core.EvaluatorHolder;
import org.testatoo.core.condition.TimerCondition;
import org.testatoo.core.input.Keyboard;

import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;
import static org.testatoo.core.Language.clickOn;
import static org.testatoo.core.Language.waitingFor;

public class AutoCompleterTest extends WebTest {

    @BeforeClass
    public static void beforeClass() {
        HtmlEvaluator htmlEvaluator = (HtmlEvaluator) EvaluatorHolder.get();
        ConditionChain conditionChain = (ConditionChain) htmlEvaluator.getWaitingCondition();
        conditionChain.addCondition(new TimerCondition(200));
    }

    @Test
    public void can_test_ajax_autocompleter() {
        page().open("AutoCompleter.html");

        try {
            component(Div.class, By.jQuery("$('[title=March]')"));
            fail();
        } catch (Exception e) {

        }

        // Fail with pure selenium cause none native keyboard events
//        Selenium selenium = (Selenium) EvaluatorHolder.get().implementation();
//        selenium.type("months", "m");

        // Success with Testatoo and native keyboard events
        clickOn(component(InputText.class, "months"));
        Keyboard.type("M");

        waitingFor(OneSecond());
        component(Div.class, By.jQuery("$('[title=March]')"));
        component(Div.class, By.jQuery("$('[title=May]')"));
    }

    @Ignore
    private Condition OneSecond() {
        return new Condition() {
            @Override
            public boolean isReach() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // Nop
                }
                return true;
            }
        };
    }
}
