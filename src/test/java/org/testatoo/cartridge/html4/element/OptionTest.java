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

public class OptionTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Option.html");
    }

    @Test
    public void can_find_option_by_id() {
        component(Option.class, By.id("1"));

        try {
            component(Option.class, By.id("someOption"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=someOption"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_option() {
        try {
            component(Option.class, By.id("country"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=country is not a Option but a DropDown"));
        }
    }

    @Test
    public void can_test_value() {
        assertThat(component(Option.class, By.id("1")).value(), is("Canada_country"));
    }

    @Test
    public void can_retrieve_the_content() {
        assertThat(component(Option.class, By.id("1")).content(), is("Canada (CA)"));
    }

    @Test
    public void test_label() {
        assertThat(component(Option.class, By.id("1")).label(), is("Canada"));
    }

    @Test
    public void can_test_is_selected() {
        assertThat(component(Option.class, By.id("1")).selected(), is(true));
        assertThat(component(Option.class, By.id("2")).selected(), is(false));
    }

    @Test
    public void test_enability() {
        assertThat(component(Option.class, By.id("1")).isDisabled(), is(false));
        assertThat(component(Option.class, By.id("2")).isDisabled(), is(true));
    }

    @Test
    public void test_i18nAttributes() {
        assertThat(component(Option.class, By.id("2")).direction(), is(Direction.righttoleft));
        assertThat(component(Option.class, By.id("2")).language(), is("fr"));
    }

    @Test
    public void test_coreAttributes() {
        Option my2 = component(Option.class, By.id("2"));
        assertThat(my2.id(), is("2"));
        assertThat(my2.classname(), is("myClass"));
        assertThat(my2.style(), containsString("color:black"));
        assertThat(my2.title(), is("optionTitle"));
    }

    @Test
    public void test_toString() {
        assertThat(component(Option.class, By.id("2")).toString(),
                is("class org.testatoo.cartridge.html4.element.Option with state : enabled:false, visible:true, value:France_country, label:France, text:France (FR), selected:false"));
    }

}
