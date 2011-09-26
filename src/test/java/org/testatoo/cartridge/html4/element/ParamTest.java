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

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.*;
import static org.testatoo.core.Language.assertThat;

public class ParamTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Object.html");
    }

    @Test
    public void can_find_param_by_id() {
        component(Param.class, "param_1");

        try {
            component(Param.class, "param_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=param_0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_param() {
        try {
            component(Param.class, "var_ess1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=var_ess1 is not a Param but a Var"));
        }
    }

    @Test
    public void test_param_specifics_attributes() {
        Param param_1 = component(Param.class, "param_1");
        Param param_2 = component(Param.class, "param_2");
        Param param_3 = component(Param.class, "param_3");

        assertThat(param_1.valuetype(), is(ValueType.data));
        assertThat(param_1.name(), is("movie"));
        assertThat(param_1.type(), is(""));
        assertThat(param_2.value(), is("high"));
        assertThat(param_3.name(), is("IMAGE1"));
        assertThat(param_3.value(), is("flash/camera.swf"));
        assertThat(param_3.valuetype(), is(ValueType.ref));
        assertThat(param_3.type(), is("image/gif"));
    }

    @Test
    public void test_toString() {
        assertThat(component(Param.class, "param_1").toString(),
                is("class org.testatoo.cartridge.html4.element.Param with state : enabled:true, visible:false, name:movie, value:images/dropdown.swf"));
    }
}
