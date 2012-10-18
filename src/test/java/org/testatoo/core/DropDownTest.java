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
import org.testatoo.core.component.DropDown;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;
import static org.testatoo.core.Language.assertThat;
import static org.testatoo.core.matcher.Matchers.has;
import static org.testatoo.core.matcher.Matchers.label;

public class DropDownTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Select.html");
    }

    @Test
    public void can_find_dropdown_by_id() {
        component(DropDown.class, "elements");

        try {
            component(DropDown.class, "otherDropdown");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=otherDropdown"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_dropdown() {
        try {
            component(DropDown.class, "cities");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=cities is not a DropDown but a ListBox"));
        }
    }

    @Test
    public void test_list_values() {
        // List without explicit values (in this case, the value is set with the content)
        DropDown countriesList = component(DropDown.class, "countries");
        assertThat(countriesList.values(), hasItems("Canada", "France", "Spain"));

        // List with explicit values
        DropDown elementsList = component(DropDown.class, "elements");
        assertThat(elementsList.values(), hasItems("Helium", "Boron", "Polonium", "Calcium", "Radium"));
        assertThat(elementsList.values(), hasItems("Calcium", "Boron", "Polonium", "Helium", "Radium"));

        Selection<String> values = component(DropDown.class, "elements").values();
        assertThat(values.containsAll(Arrays.asList("Helium", "Boron", "Polonium", "Calcium", "Radium")), is(true));
    }

    @Test
    public void test_can_select_value() {
        DropDown dropdown = component(DropDown.class, "elements");

        assertThat(dropdown.selectedValue(), is(""));
        dropdown.select("Polonium");
        assertThat(dropdown.selectedValue(), is("Polonium"));
    }

    // Test specific for Html
    @Test
    public void can_select_item() {
        // List without explicit values (in this case, the value is set with the content)
        DropDown countriesList = component(DropDown.class, "countries");
        countriesList.select("France");
        assertThat(countriesList.selectedValue(), is("France"));
        countriesList.select("Spain");
        assertThat(countriesList.selectedValue(), is("Spain"));

        // List with explicit values
        DropDown elementsList = component(DropDown.class, "elements");
        elementsList.select("Polonium");
        assertThat(elementsList.selectedValue(), is("Polonium"));
        elementsList.select("Calcium");
        assertThat(elementsList.selectedValue(), is("Calcium"));
    }

    @Test
    public void test_label() {
        assertThat(component(DropDown.class, "elements"), has(label("Elements list")));
    }

    @Test
    public void test_toString() {
        page().open("Select.html");
        assertThat(component(DropDown.class, "elements").toString(), is("class org.testatoo.cartridge.html4.element.DropDown with state : enabled:true, visible:true, values:[Helium, Boron, Polonium, Calcium, Radium], selectedValues:[], label:Elements list"));
    }
}
