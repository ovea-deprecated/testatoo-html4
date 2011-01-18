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

package org.testatoo.cartridge.html4.language;

import org.junit.Before;
import org.junit.Test;
import org.testatoo.cartridge.WebTest;
import org.testatoo.cartridge.html4.element.InputText;

import static org.testatoo.cartridge.html4.Language.*;
import static org.testatoo.cartridge.html4.matcher.Matchers.containsText;
import static org.testatoo.cartridge.html4.matcher.Matchers.has;
import static org.testatoo.cartridge.html4.matcher.Matchers.value;
import static org.testatoo.core.ComponentFactory.component;

public class InputTextTest extends WebTest {

    @Before
    public void setUp() {
        goTo("InputText.html");
    }

    @Test
    public void input_text_usage_through_language() {
        InputText inputText = component(InputText.class, "input_language");
        assertThat(inputText, has(value("french")));

        type(" speaker", on(inputText));
        assertThat(inputText, containsText("speaker"));

        enter("english speaker", on(inputText));
        assertThat(inputText, containsText("english speaker"));
    }
}
