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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;

public class RadioTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Radio.html");
    }

    @Test
    public void test_i18nAttributes() {
        Radio radio = component(Radio.class, "radio");

        assertThat(radio.direction(), is(Direction.righttoleft));
        assertThat(radio.language(), is("fr"));
    }

    @Test
    public void test_coreAttributes() {
        Radio radio = component(Radio.class, "radio");

        assertThat(radio.id(), is("radio"));
        assertThat(radio.classname(), is("myClass"));
        assertThat(radio.style(), containsString("color:black"));
        assertThat(radio.title(), is("radioTitle"));
    }

    @Test
    public void test_specifics_attributes() {
        Radio radio = component(Radio.class, "radio");

        assertThat(radio.name(), is("myRadio"));
        assertThat(radio.value(), is("radioValue"));
        assertThat(radio.alt(), is("short description"));
        assertThat(radio.tabindex(), is(5));
        assertThat(radio.accesskey(), is("C"));
    }

    @Test
    public void exception_thrown_if_component_not_a_html_radio() {
        try {
            component(Radio.class, "var_ess1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=var_ess1 is not a Radio but a Var"));
        }
    }

    @Test
    public void exception_thrown_if_component_is_a_html_checkbox() {
        try {
            component(Radio.class, "firstChoice");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=firstChoice is not a Radio but a CheckBox"));
        }
    }

    @Test
    public void test_toString() {
        assertThat(component(Radio.class, "radio").toString(),
                is("class org.testatoo.cartridge.html4.element.Radio with state : enabled:true, visible:true, label:Radio label, checked:false"));
    }
}
