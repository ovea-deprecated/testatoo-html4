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

import org.junit.BeforeClass;
import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.core.ComponentException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.*;
import static org.testatoo.core.Language.assertThat;

public class CheckBoxTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("CheckBox.html");
    }

    @Test
    public void exception_thrown_if_component_not_a_html_checkbox() {
        try {
            component(CheckBox.class, "hidden_1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=hidden_1 is not a CheckBox but a Hidden"));
        }
    }

    @Test
    public void test_i18nAttributes() {
        CheckBox checkbox = component(CheckBox.class, "checkbox");

        assertThat(checkbox.direction(), is(Direction.righttoleft));
        assertThat(checkbox.language(), is("fr"));
    }

    @Test
    public void test_coreAttributes() {
        CheckBox checkbox = component(CheckBox.class, "checkbox");

        assertThat(checkbox.id(), is("checkbox"));
        assertThat(checkbox.classname(), is("myClass"));
        assertThat(checkbox.style(), containsString("color:black"));
        assertThat(checkbox.title(), is("checkboxTitle"));
    }

    @Test
    public void test_specifics_attributes() {
        CheckBox checkbox = component(CheckBox.class, "checkbox");

        assertThat(checkbox.name(), is("myCheckbox"));
        assertThat(checkbox.value(), is("checkboxValue"));
        assertThat(checkbox.alt(), is("short description"));
        assertThat(checkbox.tabindex(), is(5));
        assertThat(checkbox.accesskey(), is("C"));
    }

    @Test
    public void test_toString() {
        assertThat(component(CheckBox.class, "checkbox2").toString(), is("class org.testatoo.cartridge.html4.element.CheckBox with state : enabled:true, visible:true, label:Checkbox into label, checked:false"));
    }
}
