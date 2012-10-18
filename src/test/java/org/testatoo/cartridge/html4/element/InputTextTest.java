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
import static org.junit.Assert.*;
import static org.testatoo.cartridge.html4.By.$;
import static org.testatoo.core.ComponentFactory.*;
import static org.testatoo.core.Language.assertThat;
import static org.testatoo.core.matcher.Matchers.*;

public class InputTextTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("InputText.html");
    }

    @Test
    public void can_find_inputText_by_id() {
        component(InputText.class, $("#input_1"));

        try {
            component(InputText.class, $("#input_2"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by jQueryExpression=$('#input_2')"));
        }

        try {
            component(InputText.class, $("#inputTextError"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=inputTextError is not a TextField but a CheckBox"));
        }
    }

    @Test
    public void test_i18nAttributes() {
        InputText myText = component(InputText.class, $("#text"));

        assertThat(myText.direction(), is(Direction.righttoleft));
        assertThat(myText.language(), is("fr"));
    }

    @Test
    public void test_coreAttributes() {
        InputText myText = component(InputText.class, $("#text"));

        assertThat(myText.id(), is("text"));
        assertThat(myText.classname(), is("myClass"));
        assertThat(myText.style(), containsString("color:black"));
        assertThat(myText.title(), is("textTitle"));
    }

    @Test
    public void test_specifics_attributes() {
        InputText myText = component(InputText.class, $("#text"));

        assertThat(myText.name(), is("myText"));
        assertThat(myText.value(), is("textValue"));
        assertThat(myText.alt(), is("short description"));
        assertThat(myText.tabindex(), is(5));
        assertThat(myText.accesskey(), is("C"));
        assertThat(myText.type(), is(InputType.text));
        assertThat(myText.toString(), is("class org.testatoo.cartridge.html4.element.InputText with state : enabled:false, visible:true, value:textValue, label:Text label, maxLength:20"));

        assertThat(component(InputText.class, $("#input_1")), has(size(20)));

        InputText myTextDef = component(InputText.class, $("#text_def"));

        assertThat(myTextDef.name(), is(""));
        assertThat(myTextDef.value(), is(""));
        assertThat(myTextDef.alt(), is(""));
        assertThat(myTextDef.tabindex(), is(0));
        assertThat(myTextDef.accesskey(), is(""));
        assertThat(myTextDef.type(), is(InputType.text));
        assertThat(myTextDef.size(), is(10));
    }

    @Test
    public void test_is_enabled() {
        assertTrue(component(InputText.class, $("#text")).isReadOnly());
        assertTrue(component(InputText.class, $("#readonlytext")).isReadOnly());
        assertThat(component(InputText.class, $("#input_language")).isReadOnly(), is(false));

        assertThat(component(InputText.class, $("#disabledtext")), is(not(enabled())));
        assertThat(component(InputText.class, $("#input_language")), is(enabled()));
    }

    @Test
    public void can_test_max_length() {
        assertThat(component(InputText.class, $("#input_1")), has(maxLength(10)));
        assertThat(component(InputText.class, $("#input_language")), has(maxLength(20)));
    }

    @Test
    public void test_label() {
        assertThat(component(InputText.class, $("#text")), has(label("Text label")));
        assertThat(component(InputText.class, $("[name=cellnumber]")), has(label("Cell phone number")));
        assertThat(component(InputText.class, $("[name=homenumber]")), has(label("Home phone number")));
    }

    @Test
    public void test_toString() {
        assertThat(component(InputText.class, $("#text")).toString(),
                is("class org.testatoo.cartridge.html4.element.InputText with state : enabled:false, visible:true, value:textValue, label:Text label, maxLength:20"));
    }
}
