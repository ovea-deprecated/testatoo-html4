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

public class DivTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Panel.html");
    }

    @Test
    public void can_find_div_by_id() {
        component(Div.class, "panelId");

        try {
            component(Div.class, "otherPanel");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=otherPanel"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_div() {
        try {
            component(Div.class, "radio");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=radio is not a Panel but a Radio"));
        }
    }

    @Test
    public void test_i18nAttributes() {
        Div div = component(Div.class, "panelId");

        assertThat(div.direction(), is(Direction.lefttoright));
        assertThat(div.language(), is("en"));
    }

    @Test
    public void test_coreAttributes() {
        Div div = component(Div.class, "panelId");

        assertThat(div.id(), is("panelId"));
        assertThat(div.classname(), is("myClass"));
        assertThat(div.style(), containsString("background-color:red"));
        assertThat(div.title(), is("panelTitle"));
    }

    @Test
    public void test_toString() {
        Div div = component(Div.class, "panelId");
        assertThat(div.toString(), is("class org.testatoo.cartridge.html4.element.Div with state : enabled:true, visible:true, title:panelTitle"));
    }
}
