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

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;
import static org.testatoo.core.Language.assertThat;

public class ButtonTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Button.html");
    }

    @Test
    public void can_find_button_by_id() {
        component(Button.class, "button_1");

        try {
            component(Button.class, "button_10");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=button_10"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_button() {
        try {
            component(Button.class, "radio");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=radio is not a Button but a Radio"));
        }
    }

    @Test
    public void can_obtain_button_text() {
        assertThat(component(Button.class, "button_1").text(), is("buttonValue"));
        assertThat(component(Button.class, "button").text(), is("MyButtonText"));
    }

    @Test
    public void can_get_the_icon() {
        assertThat(component(Button.class, "submitImage_1").icon(), containsString("images/forward.png"));
        assertThat(component(Button.class, "submit_1").icon(), is(""));
        assertThat(component(Button.class, "button").icon(), containsString("images/forward.png"));
    }

    @Test
    public void test_toString() {
        assertThat(component(Button.class, "button").toString(), is("class org.testatoo.core.component.Button with state : enabled:true, visible:true, text:MyButtonText, icon:images/forward.png"));
    }
}
