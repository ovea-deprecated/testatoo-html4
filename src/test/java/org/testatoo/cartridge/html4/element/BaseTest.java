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
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;

public class BaseTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Base.html");
    }

    @Test
    public void can_find_base_by_id() {
        component(Base.class, "base");

        try {
            component(Base.class, By.id("otherBase"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=otherBase"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_base() {
        try {
            component(Base.class, "link");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=link is not a Base but a A"));
        }
    }

    @Test
    public void test_base_specifics_attributes() {
        assertThat(component(Base.class, "base").href(), is("http://www.google.ca"));
    }

    @Test
    public void testBase_toString() {
        assertThat(component(Base.class, "base").toString(), is("class org.testatoo.cartridge.html4.element.Base with state : enabled:true, visible:false, reference:http://www.google.ca"));
    }
}
