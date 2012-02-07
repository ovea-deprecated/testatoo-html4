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

import org.junit.Before;
import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.cartridge.html4.By;
import org.testatoo.core.ComponentException;
import org.testatoo.core.Selection;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.fail;
import static org.testatoo.cartridge.html4.By.$;
import static org.testatoo.core.ComponentFactory.*;
import static org.testatoo.core.Language.assertThat;
import static org.testatoo.core.matcher.Matchers.*;

public class SelectTest extends WebTest {

    @Before
    public void setUp() {
        page().open("Select.html");
    }

    @Test
    public void can_find_select_by_id() {
        component(Select.class, $("#cities"));

        try {
            component(Select.class, $("#otherSelect"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by jQueryExpression=$('#otherSelect')"));
        }
    }

    @Test
    public void test_if_multiple_select() {
        assertThat(component(Select.class, $("#cities")).isMultiple(), is(true));
    }

    @Test
    public void test_number_of_visible_rows() {
        assertThat(component(Select.class, $("#elements")).visibleRows(), is(2));
    }

    @Test
    public void test_i18nAttributes() {
        Select select = component(Select.class, $("#elements"));

        assertThat(select.direction(), is(Direction.lefttoright));
        assertThat(select.language(), is("fr"));
    }

    @Test
    public void test_coreAttributes() {
        Select select = component(Select.class, $("#elements"));

        assertThat(select.id(), is("elements"));
        assertThat(select.classname(), is("myClass"));
        assertThat(select.style(), containsString("color:black"));
        assertThat(select.title(), is("elementTitle"));
    }

    @Test
    public void test_specifics_attributes() {
        Select select = component(Select.class, $("#elements"));

        assertThat(select.name(), is("elementName"));
        assertThat(select.tabindex(), is(2));
        assertThat(select.size(), is(2));
        assertThat(select.visibleRows(), is(2));

        Select emptySelect = component(Select.class, $("#emptyList"));
        assertThat(emptySelect.size(), is(0));
        assertThat(emptySelect.visibleRows(), is(0));
    }

    @Test
    public void test_enability() {
        Select select = component(Select.class, $("#elements"));
        assertThat(select, is(enabled()));
        assertThat(select, is(not(disabled())));
        assertThat(component(Select.class, $("#name")), is(disabled()));
    }

    @Test
    public void can_retrieve_all_options() {
        Selection<Option> options = component(Select.class, $("#cities")).options();

        assertThat(component(Select.class, $("#cities")).optionGroups(), has(size(0)));
        assertThat(options, has(size(6)));

        assertThat(options.get(0).content(), is("Montreal"));
        assertThat(options.get(1).content(), is("Quebec"));
        assertThat(options.get(2).content(), is("Montpellier"));
        assertThat(options.get(3).content(), is("New York"));
        assertThat(options.get(4).content(), is("Casablanca"));
        assertThat(options.get(5).content(), is("Munich"));
    }

    @Test
    public void can_retrieve_optionGroups() {
        Selection<OptionGroup> optionGroups = component(Select.class, $("#os")).optionGroups();

        assertThat(optionGroups, has(size(3)));

        assertThat(optionGroups.get(0), has(label("linux")));
        assertThat(optionGroups.get(1), has(label("win32")));
        assertThat(optionGroups.get(2), has(label("BSD")));
    }

    @Test
    public void can_retrieve_options_from_a_optionGroup() {
        Selection<OptionGroup> optionGroups = component(Select.class, $("#os")).optionGroups();

        Selection<Option> options = optionGroups.get(1).options();
        assertThat(options, has(size(2)));

        assertThat(options.get(0).label(), is("XPLabel"));
        assertThat(options.get(0).value(), is("XPValue"));
        assertThat(options.get(0).content(), is("XP"));

        assertThat(options.get(1).label(), is("VistaLabel"));
        assertThat(options.get(1).value(), is("VistaValue"));
        assertThat(options.get(1).content(), is("Vista"));
    }

    @Test
    public void can_select_options() {
        // Single
        Select osSelect = component(Select.class, $("#os"));

        assertThat(osSelect.optionGroups().get(0), has(label("linux")));

        assertThat(osSelect.options(), has(size(8)));
        osSelect.select("KubuntuValue");

        assertThat(osSelect.selectedOptions(), has(size(1)));
        Option osSelectedOption = osSelect.selectedOptions().get(0);

        assertThat(osSelectedOption.label(), is("KubuntuLabel"));
        assertThat(osSelectedOption.value(), is("KubuntuValue"));
        assertThat(osSelectedOption.content(), is("Kubuntu"));

        osSelect.select("FreeBSDValue");

        assertThat(osSelect.selectedOptions(), has(size(1)));
        osSelectedOption = osSelect.selectedOptions().get(0);

        assertThat(osSelectedOption.label(), is("FreeBSDLabel"));
        assertThat(osSelectedOption.value(), is("FreeBSDValue"));
        assertThat(osSelectedOption.content(), is("FreeBSD"));

        // Multiple
        Select planetsSelect = component(Select.class, $("#planets"));
        planetsSelect.select("3");
        planetsSelect.select("5");

        assertThat(planetsSelect.selectedOptions(), has(size(2)));
        Selection<Option> planetsSelectedOptions = planetsSelect.selectedOptions();

        assertThat(planetsSelectedOptions.get(0).label(), is("Earth"));
        assertThat(planetsSelectedOptions.get(0).value(), is("3"));
        assertThat(planetsSelectedOptions.get(0).content(), is("Earth"));

        assertThat(planetsSelectedOptions.get(1).label(), is("Jupiter"));
        assertThat(planetsSelectedOptions.get(1).value(), is("5"));
        assertThat(planetsSelectedOptions.get(1).content(), is("Jupiter"));
    }

    @Test
    public void can_retrieve_values() {
        // List without explicit values (in this case, the value is set with the content)
        Select countriesList = component(Select.class, $("#countries"));
        assertThat(countriesList.values(), hasItems("Canada", "France", "Spain"));

        // List with explicit values
        Select oceansList = component(Select.class, $("#oceans"));
        assertThat(oceansList.values(), hasItems("304", "208", "378", "153", "357"));
        assertThat(oceansList.values(), hasItems("357", "208", "378", "153", "304"));
        assertThat(oceansList.values(), not(hasItems("305", "209", "378", "153", "357")));
    }

    @Test
    public void can_retrieve_selected_values() {
        // List without explicit values (in this case, the value is set with the content)
        Select countriesList = component(Select.class, $("#countries"));
        countriesList.select("France");
        assertThat(countriesList.selectedValues(), hasItems("France"));

        // Single
        Select componentsList = component(Select.class, $("#elements"));
        componentsList.select("1");
        assertThat(componentsList.selectedValues().get(0), is("1"));
        componentsList.select("20");
        assertThat(componentsList.lstSelectedValues().get(0), is("20"));
        assertThat(componentsList.lstSelectedValues(), hasItems("20"));

        try {
            componentsList.select("2");
        } catch (Exception e) {
            assertThat(e.getMessage(), is("ERROR: Option with value '2' not found"));
        }

        // Multiple with simple values
        Select planetsSelect = component(Select.class, $("#planets"));
        planetsSelect.select("2");
        planetsSelect.select("4");
        planetsSelect.select("6");
        assertThat(planetsSelect.selectedValues().get(0), is("2"));
        assertThat(planetsSelect.selectedValues().get(1), is("4"));
        assertThat(planetsSelect.selectedValues().get(2), is("6"));
        assertThat(planetsSelect.lstSelectedValues().get(0), is("2"));
        assertThat(planetsSelect.lstSelectedValues().get(1), is("4"));
        assertThat(planetsSelect.lstSelectedValues().get(2), is("6"));

        assertThat(planetsSelect.lstSelectedValues(), hasItems("2", "4", "6"));

        // Multiple with complex values
        Select oceansList = component(Select.class, $("#oceans"));
        oceansList.select("378");
        oceansList.select("153");
        assertThat(oceansList.selectedValues().get(0), is("378"));
        assertThat(oceansList.selectedValues().get(1), is("153"));
        assertThat(oceansList.selectedValues(), hasItems("378", "153"));
    }

    @Test
    public void can_unselect_options() {
        // Single
        Select osSelect = component(Select.class, $("#os"));

        assertThat(osSelect.selectedOptions(), has(size(1)));
        assertThat(osSelect.selectedOptions().get(0), has(value("none")));

        osSelect.select("KubuntuValue");

        assertThat(osSelect.selectedOptions(), has(size(1)));
        assertThat(osSelect.selectedOptions().get(0), has(value("KubuntuValue")));

        // Cannot unselect an component in a single select
        try {
            osSelect.unselect("KubuntuValue");
            fail();
        } catch (ComponentException e) {
            assertThat(true, is(true));
        }

        // Multiple
        Select planetsSelect = component(Select.class, $("#planets"));
        planetsSelect.select("3");
        planetsSelect.select("5");

        assertThat(planetsSelect.selectedOptions(), has(size(2)));

        planetsSelect.unselect("5");
        assertThat(planetsSelect.selectedOptions(), has(size(1)));

        planetsSelect.unselect("3");
        assertThat(planetsSelect.selectedOptions(), has(size(0)));

        osSelect = component(Select.class, $("#os"));
        assertThat(osSelect.selectedOptions(), has(size(1)));

        try {
            osSelect.unselectAll();
            fail();
        } catch (ComponentException e) {
            assertThat(true, is(true));
        }

        planetsSelect = component(Select.class, $("#planets"));
        planetsSelect.select("1");
        planetsSelect.select("2");
        assertThat(planetsSelect.selectedOptions(), has(size(2)));

        planetsSelect.unselectAll();

        assertThat(planetsSelect.selectedOptions(), has(size(0)));
    }

    @Test
    public void test_label() {
        assertThat(component(Select.class, $("#cities")), has(label("Cities list")));
        assertThat(component(Select.class, $("[name=girlsList]")).label(), containsString("girls list"));
    }

    @Test
    public void test_toString() {
        assertThat(component(Select.class, $("#cities")).toString(),
                is("class org.testatoo.cartridge.html4.element.Select with state : enabled:true, visible:true, values:[Montreal, Quebec, Montpellier, New York, Casablanca, Munich], selectedValues:[New York, Munich], optionGroup:[], visibleRows:3"));
    }
}
