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
import org.testatoo.core.Selection;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.*;
import static org.testatoo.core.Language.assertThat;

// If this test fail verify your flash browser plugin
public class ObjectTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Object.html");
    }

    //---------- Object --------------------
    @Test
    public void can_find_object_by_id() {
        component(Object.class, "object_1");

        try {
            component(Object.class, "object_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=object_0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_object() {
        try {
            component(Object.class, "var_ess1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=var_ess1 is not a Object but a Var"));
        }
    }

    @Test
    public void test_object_coreAttributes() {
        Object object_1 = component(Object.class, "object_1");

        assertThat(object_1.id(), is("object_1"));
        assertThat(object_1.classname(), is("MyOBJECTClass"));
        assertThat(object_1.style(), containsString("color:blue"));
        assertThat(object_1.title(), is("objectTitle1"));
    }

    @Test
    public void test_object_i18nAttributes() {
        Object object_1 = component(Object.class, "object_1");

        assertThat(object_1.direction(), is(Direction.lefttoright));
        assertThat(object_1.language(), is("es"));
    }

    @Test
    public void test_object_specifics_attributes() {
        Object object_1 = component(Object.class, "object_1");
        Object object_2 = component(Object.class, "object_2");
        // Not loaded in IE
//        Object object_3 = findObject(By.id("object_3"));
        Object object_4 = component(Object.class, "object_4");

        assertThat(object_1.data(), containsString("images/forward.png"));
        assertThat(object_1.type(), is("image/jpg"));
        assertThat(object_2.classid(), is("clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"));
        assertThat(object_2.codebase(), is("http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=4,0,0,0"));
        assertThat(object_2.name(), is("object_name2"));
//        assertThat(object_3.archive(), is("http://ma-cabane-au-canada.com/"));
//        assertThat(object_3.standby(), is("loading......."));
//        assertThat(object_3.usemap(), is("#map"));
//        assertThat(object_3.width(), is("300"));
//        assertThat(object_3.height(), is("300"));
        assertThat(object_4.codetype(), is("application/octet-stream"));
    }

    @Test
    public void can_obtain_params_associated() {
        Object object_1 = component(Object.class, "object_2");

        Selection<Param> params = object_1.params();
        assertThat(params.size(), is(3));
        assertThat(params.get(0).name(), is("movie"));
        assertThat(params.get(1).name(), is("quality"));
        assertThat(params.get(2).name(), is("bgcolor"));
    }

    @Test
    public void test_toString() {
        assertThat(component(Object.class, "object_2").toString(),
                is("class org.testatoo.cartridge.html4.element.Object with state : enabled:true, visible:true"));
    }
}
