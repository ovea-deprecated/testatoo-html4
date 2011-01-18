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

package specs.keyboard;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.testatoo.cartridge.MainModule;
import org.testatoo.cartridge.html4.HtmlEvaluator;
import org.testatoo.cartridge.html4.element.InputText;
import org.testatoo.config.annotation.TestatooModules;
import org.testatoo.config.junit.TestatooWithConcordionJunitRunner;
import org.testatoo.core.ConditionChain;
import org.testatoo.core.EvaluatorHolder;
import org.testatoo.core.condition.TimerCondition;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;
import static org.testatoo.core.Language.into;
import static org.testatoo.core.Language.type;

@RunWith(TestatooWithConcordionJunitRunner.class)
@TestatooModules(MainModule.class)
public class ConcordionKeyboardTest {

    @BeforeClass
    public static void beforeClass() {
        HtmlEvaluator htmlEvaluator = (HtmlEvaluator) EvaluatorHolder.get();
        ConditionChain conditionChain = (ConditionChain) htmlEvaluator.getWaitingCondition();
        conditionChain.addCondition(new TimerCondition(200));
    }

    public String typeAndCheck(String input, String value) {
        page().open("InputText.html");
        InputText input_language = component(InputText.class, input);
        assertThat(input_language.value(), is("french"));
        type(value, into(input_language));
        return input_language.value();
    }

}