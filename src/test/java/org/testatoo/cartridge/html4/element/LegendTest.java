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

public class LegendTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("FieldSet.html");
    }

    @Test
    public void can_find_legend_by_id() {
        component(Legend.class, "legend_1");

        try {
            component(Legend.class, "legend_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=legend_0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_legend() {
        try {
            component(Legend.class, "radio");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=radio is not a Legend but a Radio"));
        }
    }

    @Test
    public void test_legend_i18nAttributes() {
        Legend legend = component(Legend.class, "legend_1");
        assertThat(legend.direction(), is(Direction.lefttoright));
        assertThat(legend.language(), is("es"));
    }

    @Test
    public void test_legend_coreAttributes() {
        Legend legend = component(Legend.class, "legend_1");
        assertThat(legend.id(), is("legend_1"));
        assertThat(legend.classname(), is("MyLEGENDClass"));
        assertThat(legend.style(), containsString("color:blue"));
        assertThat(legend.title(), is("legendTitle"));
    }

    @Test
    public void test_legend_specifics_attributes() {
        Legend legend = component(Legend.class, "legend_2");
        assertThat(legend.accesskey(), is("M"));
    }

    @Test
    public void test_toString() {
        assertThat(component(Legend.class, "legend_1").toString(),
                is("class org.testatoo.cartridge.html4.element.Legend with state : enabled:true, visible:true, title:legendTitle, content:Personal information"));
    }
}
