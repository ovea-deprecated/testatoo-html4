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

package org.testatoo.cartridge.html4;

import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.core.ComponentException;
import org.testatoo.core.EvaluatorHolder;
import org.testatoo.core.Selection;
import org.testatoo.core.component.*;
import org.testatoo.core.component.datagrid.DataGrid;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.cartridge.html4.By.$;
import static org.testatoo.core.ComponentFactory.*;
import static org.testatoo.core.Language.assertThat;
import static org.testatoo.core.matcher.Matchers.*;

public class FinderTest extends WebTest {

    @Test
    public void can_find_element_by_id_with_points() {
        page().open("ElementIdWithPoints.html");

        assertThat(component(Button.class, $("#my\\\\.button\\\\.id")), exist());
        assertThat(new Panel(EvaluatorHolder.get(), "my.panel.id"), exist());
    }

    @Test
    public void can_find_one_component_with_jQuery_expression() {
        page().open("Button.html");

        assertThat(component(Button.class, $(":submit:first")), exist());
    }

    @Test
    public void can_find_elements_with_multiple_search(){
        page().open("MultipleElements.html");

        assertThat(components(Panel.class, $(".classp")), has(size(3)));
    }

    @Test
    public void can_see_explicit_exception_when_no_element_is_found_on_simple_search() {
        page().open("MultipleElements.html");

        try {
            component(Panel.class, $(".classUnknow"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by jQueryExpression=$('.classUnknow')"));
        }
    }

    @Test
    public void can_see_explicit_exception_when_no_element_is_found_on_multiple_search() {
        page().open("MultipleElements.html");

        try {
            components(Panel.class, $(".classUnknow"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by jQueryExpression=$('.classUnknow')"));
        }
    }

    @Test
    public void can_see_explicit_exception_when_there_is_any_elements_found_on_simple_search() {
        page().open("MultipleElements.html");

        try {
            component(Panel.class, $(".classp"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Find more than one component defined by jQueryExpression=$('.classp')"));
        }
    }
}
