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
import org.testatoo.core.ComponentException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;

public class InputPasswordTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("InputPassword.html");
    }

    @Test
    public void can_find_inputText_by_id() {
        component(InputPassword.class, "input_1");

        try {
            component(InputPassword.class, "input_2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=input_2"));
        }

        try {
            component(InputPassword.class, "inputPasswordError");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=inputPasswordError is not a PasswordField but a CheckBox"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_inputPassword() {
        try {
            component(InputPassword.class, "image_3");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=image_3 is not a PasswordField but a Image"));
        }
    }

    @Test
    public void test_i18nAttributes() {
        InputPassword myInputPwd = component(InputPassword.class, "password");

        assertThat(myInputPwd.direction(), is(Direction.righttoleft));
        assertThat(myInputPwd.language(), is("fr"));
    }

    @Test
    public void test_coreAttributes() {
        InputPassword myInputPwd = component(InputPassword.class, "password");

        assertThat(myInputPwd.id(), is("password"));
        assertThat(myInputPwd.classname(), is("myClass"));
        assertThat(myInputPwd.style(), containsString("color:black"));
        assertThat(myInputPwd.title(), is("passwordTitle"));
    }

    @Test
    public void test_specifics_attributes() {
        InputPassword myInputPwd = component(InputPassword.class, "password");

        assertThat(myInputPwd.name(), is("myPassword"));
        assertThat(myInputPwd.value(), is("passwordValue"));
        assertThat(myInputPwd.alt(), is("short description"));
        assertThat(myInputPwd.tabindex(), is(5));
        assertThat(myInputPwd.accesskey(), is("C"));
        assertThat(myInputPwd.size(), is(15));
        assertThat(myInputPwd.type(), is(InputType.password));

        InputPassword myInputPwdDef = component(InputPassword.class, "password_def");

        assertThat(myInputPwdDef.name(), is(""));
        assertThat(myInputPwdDef.value(), is(""));
        assertThat(myInputPwdDef.alt(), is(""));
        assertThat(myInputPwdDef.tabindex(), is(0));
        assertThat(myInputPwdDef.accesskey(), is(""));
        assertThat(myInputPwdDef.size(), is(8));
        assertThat(myInputPwdDef.type(), is(InputType.password));
    }

    @Test
    public void can_test_if_readonly() {
        assertThat(component(InputPassword.class, "password").isReadOnly(), is(true));
        assertThat(component(InputPassword.class, "password_1").isReadOnly(), is(false));
    }

    @Test
    public void can_test_max_length() {
        assertThat(component(InputPassword.class, "input_1").maxLength(), is(10));
        assertThat(component(InputPassword.class, "password_1").maxLength(), is(20));
    }

    @Test
    public void test_toString() {
        assertThat(component(InputPassword.class, "password").toString(),
                is("class org.testatoo.cartridge.html4.element.InputPassword with state : enabled:false, visible:true, value:passwordValue, label:Password label, maxLength:8"));
    }
}
