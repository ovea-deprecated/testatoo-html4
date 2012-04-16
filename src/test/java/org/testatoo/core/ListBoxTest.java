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

import org.junit.Before;
import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.core.component.ListBox;
import org.testatoo.core.component.TextField;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;
import static org.testatoo.core.Language.assertThat;
import static org.testatoo.core.matcher.Matchers.has;
import static org.testatoo.core.matcher.Matchers.label;

public class ListBoxTest extends WebTest {

    @Before
    public void setUp() {
        page().open("Select.html");
    }

    @Test
    public void can_find_listbox_by_id() {
        component(ListBox.class, "cities");

        try {
            component(ListBox.class, "otherListbox");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=otherListbox"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_listBox() {
        try {
            component(ListBox.class, "elements");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=elements is not a ListBox but a DropDown"));
        }
    }

    @Test
    public void test_list_values() {
        Selection<String> values = component(ListBox.class, "cities").values();
        assertThat(values.containsAll(Arrays.asList("Montreal", "Quebec", "Montpellier", "New York", "Casablanca", "Munich")), is(true));
    }

    @Test
    public void can_obtain_selected_values() {
        assertThat(component(ListBox.class, "cities").selectedValues().containsAll(Arrays.asList("New York", "Munich")), is(true));
    }

    @Test
    public void test_can_select_multiple_value() {
        ListBox cities = component(ListBox.class, "cities");

        assertThat(component(TextField.class, "onChangeTest").value(), is(""));

        assertThat(cities.selectedValues().containsAll(Arrays.asList("New York", "Munich")), is(true));
        cities.select("Montpellier");
        assertThat(cities.selectedValues().containsAll(Arrays.asList("New York", "Munich", "Montpellier")), is(true));

        assertThat(component(TextField.class, "onChangeTest").value(), is("OnChange Event Fired"));
    }

    @Test
    public void can_unselect_value() {
        ListBox cities = component(ListBox.class, "cities");

        assertThat(cities.selectedValues().containsAll(Arrays.asList("New York", "Munich")), is(true));
        cities.unSelect("Munich");
        assertThat(cities.selectedValues().containsAll(Arrays.asList("New York")), is(true));
        cities.unSelect("New York");
        assertThat(cities.selectedValues().isEmpty(), is(true));
    }

    @Test
    public void test_label() {
        assertThat(component(ListBox.class, "cities"), has(label("Cities list")));
    }

    @Test
    public void test_toString() {
        assertThat(component(ListBox.class, "cities").toString(), is("class org.testatoo.cartridge.html4.component.ListBox with state : enabled:true, visible:true, values:[Montreal, Quebec, Montpellier, New York, Casablanca, Munich], selectedValues:[New York, Munich], label:Cities list"));
    }

}
