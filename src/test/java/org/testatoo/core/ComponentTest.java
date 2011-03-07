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

package org.testatoo.core;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.core.component.Button;
import org.testatoo.core.component.Component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;

public class ComponentTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Component.html");
    }

    @Test
    public void test_component_enability() {
        Button invisible_button = component(Button.class, "hidden_button_1");

        assertThat(invisible_button.isDisabled(), is(false));
        assertThat(invisible_button.isEnabled(), is(true));

        Button disabled_button = component(Button.class, "disabled_button");

        assertThat(disabled_button.isDisabled(), is(true));
        assertThat(disabled_button.isEnabled(), is(false));
    }

    @Test
    public void test_component_visibility() {
        assertThat(component(Button.class, "disabled_button").isVisible(), is(true));

        assertThat(component(Button.class, "hidden_button_1").isVisible(), is(false));
        assertThat(component(Button.class, "hidden_button_2").isVisible(), is(false));
        assertThat(component(Component.class, "hiddenField").isVisible(), is(false));
    }
}
