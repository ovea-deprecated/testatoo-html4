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

public class LabelTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Label.html");
    }

    @Test
    public void can_find_label_by_id() {
        component(Label.class, "label_1");

        try {
            component(Label.class, "label_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=label_0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_label() {
        try {
            component(Label.class, "abbr_ess1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess1 is not a Label but a Abbr"));
        }
    }

    @Test
    public void test_label_i18nAttributes() {
        Label label = component(Label.class, "label_1");

        assertThat(label.direction(), is(Direction.lefttoright));
        assertThat(label.language(), is("en"));
    }

    @Test
    public void test_label_coreAttributes() {
        Label label = component(Label.class, "label_1");

        assertThat(label.id(), is("label_1"));
        assertThat(label.classname(), is("myLABELClass"));
        assertThat(label.style(), containsString("color:red"));
        assertThat(label.title(), is("labelTitle"));
    }

    @Test
    public void test_label_specifics_attributes() {
        Label label_1 = component(Label.class, "label_1");
        Label label_2 = component(Label.class, "label_2");

        assertThat(label_1._for(), is("lname"));
        assertThat(label_2.accesskey(), is("L"));
        assertThat(label_1.toString(), is("class org.testatoo.cartridge.html4.element.Label with state : enabled:true, visible:true, content: First name"));
    }

    @Test
    public void test_label_content() {
        assertThat(component(Label.class, "label_3").content(), is("Home phone number"));
    }

    @Test
    public void test_toString() {
        assertThat(component(Label.class, "label_3").toString(), is("class org.testatoo.cartridge.html4.element.Label with state : enabled:true, visible:true, content: Home phone number"));
    }
}
