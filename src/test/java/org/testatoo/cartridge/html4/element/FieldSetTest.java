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

public class FieldSetTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("FieldSet.html");
    }

    @Test
    public void can_find_fieldSet_by_id() {
        component(FieldSet.class, "fieldSet_1");

        try {
            component(FieldSet.class, "fieldSet_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=fieldSet_0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_fieldSet() {
        try {
            component(FieldSet.class, "radio");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=radio is not a FieldSet but a Radio"));
        }
    }

    @Test
    public void test_fieldSet_i18nAttributes() {
        FieldSet fieldSet_1 = component(FieldSet.class, "fieldSet_1");

        assertThat(fieldSet_1.direction(), is(Direction.lefttoright));
        assertThat(fieldSet_1.language(), is("fr"));
    }

    @Test
    public void test_fieldSet_coreAttributes() {
        FieldSet fieldSet_1 = component(FieldSet.class, "fieldSet_1");

        assertThat(fieldSet_1.id(), is("fieldSet_1"));
        assertThat(fieldSet_1.classname(), is("MyFIELDSETClass"));
        assertThat(fieldSet_1.style(), containsString("color:black"));
        assertThat(fieldSet_1.title(), is("fieldSetTitle"));
    }

    @Test
    public void test_toString() {
        FieldSet fieldSet = component(FieldSet.class, "fieldSet_1");
        assertThat(fieldSet.toString(), is("class org.testatoo.cartridge.html4.element.FieldSet with state : enabled:true, visible:true"));
    }
}
