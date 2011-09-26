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

public class HiddenTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Hidden.html");
    }

    @Test
    public void can_find_hidden_field_by_id() {
        component(Hidden.class, "hidden_1");

        try {
            component(Hidden.class, "hidden_2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=hidden_2"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_hidden() {
        try {
            component(Hidden.class, "hiddenError");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=hiddenError is not a Hidden but a InputText"));
        }
    }

    @Test
    public void test_can_obtain_value() {
        assertThat(component(Hidden.class, "hidden").value(), is("hiddenValue"));
    }

    @Test
    public void test_i18nAttributes() {
        Hidden hidden = component(Hidden.class, "hidden");

        assertThat(hidden.direction(), is(Direction.righttoleft));
        assertThat(hidden.language(), is("fr"));
    }

    @Test
    public void test_coreAttributes() {
        Hidden hidden = component(Hidden.class, "hidden");

        assertThat(hidden.id(), is("hidden"));
        assertThat(hidden.classname(), is("myClass"));
        assertThat(hidden.style(), containsString("color:black"));
        assertThat(hidden.title(), is("hiddenTitle"));
    }

    @Test
    public void test_specifics_attributes() {
        Hidden hidden = component(Hidden.class, "hidden");

        assertThat(hidden.name(), is("hiddenName"));
        assertThat(hidden.type(), is(InputType.hidden));
        assertThat(hidden.value(), is("hiddenValue"));
        assertThat(hidden.alt(), is("short description"));
        assertThat(hidden.tabindex(), is(4));
        assertThat(hidden.accesskey(), is("C"));

        Hidden hidden2 = component(Hidden.class, "hidden2");
        assertThat(hidden2.name(), is(""));
        assertThat(hidden2.type(), is(InputType.hidden));
        assertThat(hidden2.value(), is(""));
        assertThat(hidden2.alt(), is(""));
        assertThat(hidden2.tabindex(), is(0));
    }

    @Test
    public void test_toString() {
        assertThat(component(Hidden.class, "hidden").toString(), is("class org.testatoo.cartridge.html4.element.Hidden with state : enabled:true, visible:false, value:hiddenValue, label:"));
    }
}
