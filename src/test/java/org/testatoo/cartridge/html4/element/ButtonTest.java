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
import static org.testatoo.cartridge.html4.By.$;
import static org.testatoo.core.ComponentFactory.*;
import static org.testatoo.core.Language.assertThat;

public class ButtonTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Button.html");
    }

    @Test
    public void exception_thrown_if_component_not_a_html_button() {
        try {
            component(Button.class, $("#country"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=country is not a Button but a DropDown"));
        }
    }

    @Test
    public void exception_thrown_if_component_is_a_radio_button() {
        try {
            component(Button.class, $("#radio"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=radio is not a Button but a Radio"));
        }
    }

    @Test
    public void can_get_button_type() {
        assertThat(component(Button.class, $("#submitImage_1")).type(), is(InputType.image));
        assertThat(component(Button.class, $("#submit_1")).type(), is(InputType.submit));
        assertThat(component(Button.class, $("#reset_1")).type(), is(InputType.reset));
        assertThat(component(Button.class, $("#submitImage_1")).type(), is(InputType.image));
        assertThat(component(Button.class, $("#button")).type(), is(InputType.submit));
    }

    @Test
    public void can_get_the_icon() {
        assertThat(component(Button.class, $("#submitImage_1")).icon(), containsString("images/forward.png"));
        assertThat(component(Button.class, $("#submit_1")).icon(), is(""));
        assertThat(component(Button.class, $("#button")).icon(), containsString("images/forward.png"));
    }

    @Test
    public void test_i18nAttributes() {
        Button button = component(Button.class, $("#button_2"));
        assertThat(button.direction(), is(Direction.righttoleft));
        assertThat(button.language(), is("fr"));
    }

    @Test
    public void test_coreAttributes() {
        Button button = component(Button.class, $("#button_2"));

        assertThat(button.id(), is("button_2"));
        assertThat(button.classname(), is("myClass"));
        assertThat(button.style(), containsString("color:black"));
        assertThat(button.title(), is("buttonTitle"));
    }

    @Test
    public void test_specifics_attributes() {
        Button button = component(Button.class, $("#button"));
        assertThat(button.name(), is("myButtonName"));
        assertThat(button.value(), is("myButtonValue"));
        assertThat(button.alt(), is(""));
        assertThat(button.tabindex(), is(0));
        assertThat(button.accesskey(), is(""));
        assertThat(button.type(), is(InputType.submit));

        Button button2 = component(Button.class, $("#button_2"));
        assertThat(button2.name(), is("myButton"));
        assertThat(button2.value(), is("buttonValue"));
        assertThat(button2.alt(), is("short description"));
        assertThat(button2.tabindex(), is(5));
        assertThat(button2.accesskey(), is("C"));
    }

    @Test
    public void test_enability() {
        Button button1 = component(Button.class, $("#button"));
        assertThat(button1.isEnabled(), is(true));
        assertThat(button1.isDisabled(), is(false));

        Button disabledButton = component(Button.class, $("#disabledButton"));
        assertThat(disabledButton.isEnabled(), is(false));
        assertThat(disabledButton.isDisabled(), is(true));
    }

    @Test
    public void test_toString() {
        assertThat(component(Button.class, $("#button")).toString(), is("class org.testatoo.cartridge.html4.element.Button with state : enabled:true, visible:true, text:MyButtonText, icon:images/forward.png"));
        assertThat(component(Button.class, $("#button_1")).toString(), is("class org.testatoo.cartridge.html4.element.Button with state : enabled:true, visible:true, text:buttonValue, icon:"));
    }
}
