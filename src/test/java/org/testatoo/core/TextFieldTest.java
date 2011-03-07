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
import org.testatoo.core.component.TextField;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;

public class TextFieldTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("InputText.html");
    }

    @Test
    public void can_find_textField_by_id() {
        component(TextField.class, "input_1");

        try {
            component(TextField.class, "input_2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=input_2"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_textField() {
        try {
            component(TextField.class, "inputTextError");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=inputTextError is not a TextField but a CheckBox"));
        }
    }

    @Test
    public void can_test_max_length() {
        assertThat(component(TextField.class, "input_1").maxLength(), is(10));
        assertThat(component(TextField.class, "input_language").maxLength(), is(20));
    }

    @Test
    public void test_label() {
        assertThat(component(TextField.class, "text").label(), is("Text label"));
    }

    @Test
    public void test_toString() {
        assertThat(component(TextField.class, "text").toString(), is("class org.testatoo.core.component.TextField with state : enabled:false, visible:true, value:textValue, label:Text label, maxLength:20"));
    }
}
