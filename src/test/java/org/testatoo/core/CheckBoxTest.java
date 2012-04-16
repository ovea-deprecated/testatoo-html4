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
import org.testatoo.core.component.CheckBox;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;
import static org.testatoo.core.Language.*;
import static org.testatoo.core.matcher.Matchers.*;

public class CheckBoxTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("CheckBox.html");
    }

    @Test
    public void can_find_checkbox_by_id() {
        component(CheckBox.class, "firstChoice");

        try {
            component(CheckBox.class, "otherChoice");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=otherChoice"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_checkbox() {
        try {
            component(CheckBox.class, "text_1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=text_1 is not a CheckBox but a TextField"));
        }
    }

    @Test
    public void can_check() {
        CheckBox firstchoice = component(CheckBox.class, "firstChoice");

        assertThat(firstchoice, is(not(checked())));
        clickOn(firstchoice);
        assertThat(firstchoice, is(checked()));
        clickOn(firstchoice);
        assertThat(firstchoice, is(not(checked())));

        CheckBox secondchoice = component(CheckBox.class, "secondChoice");

        assertThat(secondchoice, is(not(checked())));
        check(secondchoice);
        assertThat(secondchoice, is(checked()));
        unCheck(secondchoice);
        assertThat(secondchoice, is(not(checked())));
    }

    @Test
    public void test_label() {
        assertThat(component(CheckBox.class, "checkbox"), has(label("Checkbox Label")));
        assertThat(component(CheckBox.class, "checkbox2"), has(label("Checkbox into label")));
    }

    @Test
    public void test_toString() {
        assertThat(component(CheckBox.class, "checkbox").toString(), is("class org.testatoo.core.component.CheckBox with state : enabled:true, visible:true, label:Checkbox Label, checked:false"));
    }
}
