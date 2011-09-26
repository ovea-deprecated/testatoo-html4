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
import org.testatoo.cartridge.html4.By;
import org.testatoo.core.ComponentException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.*;
import static org.testatoo.core.Language.assertThat;

public class TextAreaTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("TextArea.html");
    }

    @Test
    public void can_find_textArea_by_id() {
        component(TextArea.class, "textArea_1");

        try {
            component(TextArea.class, "textArea_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=textArea_0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_textArea() {
        try {
            component(TextArea.class, "abbr_ess1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess1 is not a TextArea but a Abbr"));
        }
    }

    @Test
    public void test_textArea_coreAttributes() {
        TextArea textArea_1 = component(TextArea.class, "textArea_1");

        assertThat(textArea_1.id(), is("textArea_1"));
        assertThat(textArea_1.classname(), is("myTEXTAREAClass"));
        assertThat(textArea_1.style(), containsString("color:blue"));
        assertThat(textArea_1.title(), is("textAreaTitle"));
    }

    @Test
    public void test_textArea_i18nAttributes() {
        TextArea textArea_1 = component(TextArea.class, "textArea_1");

        assertThat(textArea_1.direction(), is(Direction.lefttoright));
        assertThat(textArea_1.language(), is("en"));
    }

    @Test
    public void test_textArea_specifics_attributes() {
        TextArea textArea_1 = component(TextArea.class, "textArea_1");

        assertThat(textArea_1.name(), is("textAreaName"));
        assertThat(textArea_1.rows(), is(10));
        assertThat(textArea_1.cols(), is(50));
        assertThat(textArea_1.tabindex(), is(3));
        assertThat(textArea_1.accesskey(), is("T"));

        assertThat(textArea_1.value(), containsString("First line of initial text"));
        assertThat(textArea_1.value(), containsString("Second line of initial text"));
    }

    @Test
    public void test_enability() {
        TextArea textArea_1 = component(TextArea.class, "textArea_1");
        TextArea textArea_2 = component(TextArea.class, "textArea_2");
        TextArea textArea_3 = component(TextArea.class, By.jQuery("$('[name=textArea3linesName]')"));

        assertThat(textArea_1.isDisabled(), is(false));
        assertThat(textArea_1.isEnabled(), is(true));
        assertThat(textArea_1.isReadOnly(), is(false));
        assertThat(textArea_2.isReadOnly(), is(true));
        assertThat(textArea_3.isDisabled(), is(true));
        assertThat(textArea_3.isEnabled(), is(false));
    }

    @Test
    public void test_label() {
        assertThat(component(TextArea.class, "textArea_2").label(), is("Text with two lines"));
        assertThat(component(TextArea.class, By.jQuery("$('[name=textArea3linesName]')")).label(), containsString("Text with three lines"));
    }

    @Test
    public void test_toString() {
        TextArea textArea = component(TextArea.class, "textArea_1");
        assertThat(textArea.toString(),
                containsString("class org.testatoo.cartridge.html4.element.TextArea with state : enabled:true, visible:true, value:First line of initial text."));

        assertThat(textArea.toString(),
                containsString("Second line of initial text., label:"));
    }
}
