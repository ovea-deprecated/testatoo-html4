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
import org.testatoo.core.component.PasswordField;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.*;
import static org.testatoo.core.Language.assertThat;

public class PasswordFieldTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("InputPassword.html");
    }

    @Test
    public void can_find_passwordField_by_id() {
        component(PasswordField.class, "input_1");

        try {
            component(PasswordField.class, "input_2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=input_2"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_passwordField() {
        try {
            component(PasswordField.class, "inputPasswordError");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=inputPasswordError is not a PasswordField but a CheckBox"));
        }
    }

    @Test
    public void can_test_max_length() {
        assertThat(component(PasswordField.class, "input_1").maxLength(), is(10));
        assertThat(component(PasswordField.class, "password_1").maxLength(), is(20));
    }

    @Test
    public void test_label() {
        assertThat(component(PasswordField.class, "password").label(), is("Password label"));
    }

    @Test
    public void test_toString() {
        assertThat(component(PasswordField.class, "password").toString(), is("class org.testatoo.core.component.PasswordField with state : enabled:false, visible:true, value:passwordValue, label:Password label, maxLength:8"));
    }
}
