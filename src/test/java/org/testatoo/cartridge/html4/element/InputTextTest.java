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
import org.testatoo.cartridge.WebTest;
import org.testatoo.cartridge.html4.By;
import org.testatoo.core.ComponentException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;

public class InputTextTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("InputText.html");
    }

    @Test
    public void can_find_inputText_by_id() {
        component(InputText.class, "input_1");

        try {
            component(InputText.class, "input_2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=input_2"));
        }

        try {
            component(InputText.class, "inputTextError");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=inputTextError is not a TextField but a CheckBox"));
        }
    }

    @Test
    public void test_i18nAttributes() {
        InputText myText = component(InputText.class, "text");

        assertThat(myText.direction(), is(Direction.righttoleft));
        assertThat(myText.language(), is("fr"));
    }

    @Test
    public void test_coreAttributes() {
        InputText myText = component(InputText.class, "text");

        assertThat(myText.id(), is("text"));
        assertThat(myText.classname(), is("myClass"));
        assertThat(myText.style(), containsString("color:black"));
        assertThat(myText.title(), is("textTitle"));
    }

    @Test
    public void test_specifics_attributes() {
        InputText myText = component(InputText.class, "text");

        assertThat(myText.name(), is("myText"));
        assertThat(myText.value(), is("textValue"));
        assertThat(myText.alt(), is("short description"));
        assertThat(myText.tabindex(), is(5));
        assertThat(myText.accesskey(), is("C"));
        assertThat(myText.type(), is(InputType.text));
        assertThat(myText.toString(), is("class org.testatoo.cartridge.html4.element.InputText with state : enabled:false, visible:true, value:textValue, label:Text label, maxLength:20"));

        assertThat(component(InputText.class, "input_1").size(), is(20));

        InputText myTextDef = component(InputText.class, "text_def");

        assertThat(myTextDef.name(), is(""));
        assertThat(myTextDef.value(), is(""));
        assertThat(myTextDef.alt(), is(""));
        assertThat(myTextDef.tabindex(), is(0));
        assertThat(myTextDef.accesskey(), is(""));
        assertThat(myTextDef.type(), is(InputType.text));
        assertThat(myTextDef.size(), is(10));
    }

    @Test
    public void test_enability() {
        assertThat(component(InputText.class, "text").isReadOnly(), is(true));
        assertThat(component(InputText.class, "readonlytext").isReadOnly(), is(true));
        assertThat(component(InputText.class, "input_language").isReadOnly(), is(false));

        assertThat(component(InputText.class, "disabledtext").isEnabled(), is(false));
        assertThat(component(InputText.class, "input_language").isEnabled(), is(true));
    }

    @Test
    public void can_test_max_length() {
        assertThat(component(InputText.class, "input_1").maxLength(), is(10));
        assertThat(component(InputText.class, "input_language").maxLength(), is(20));
    }

    @Test
    public void test_label() {
        assertThat(component(InputText.class, "text").label(), is("Text label"));
        assertThat(component(InputText.class, By.name("cellnumber")).label(), is("Cell phone number"));
        assertThat(component(InputText.class, By.name("homenumber")).label(), is("Home phone number"));
    }

    @Test
    public void can_find_inputText_by_name() {
        component(InputText.class, By.name("inputTextName"));

        try {
            component(InputText.class, By.name("otherInputTextName"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by name=otherInputTextName"));
        }
    }

    @Test
    public void can_find_inputText_by_title() {
        component(InputText.class, By.title("inputTextTitle"));

        try {
            component(InputText.class, By.title("otherInputTextTitle"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by title=otherInputTextTitle"));
        }
    }

    @Test
    public void test_toString() {
        assertThat(component(InputText.class, "text").toString(),
                is("class org.testatoo.cartridge.html4.element.InputText with state : enabled:false, visible:true, value:textValue, label:Text label, maxLength:20"));
    }
}
