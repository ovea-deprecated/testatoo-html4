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
import static org.testatoo.cartridge.html4.By.$;
import static org.testatoo.core.ComponentFactory.*;
import static org.testatoo.core.Language.assertThat;

public class ScriptTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Script.html");
    }

    @Test
    public void can_find_script_by_id() {
        component(Script.class, $("#script_1"));

        try {
            component(Script.class, $("#script_0"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=script_0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_script() {
        try {
            component(Script.class, $("#var_ess1"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=var_ess1 is not a Script but a Var"));
        }
    }

    @Test
    public void test_script_specifics_attributes() {
        Script script = component(Script.class, $("#script_1"));

        assertThat(script.charset(), is("utf-8"));
        assertThat(script.src(), is("addtext.js"));
        assertThat(script.type(), is("text/javascript"));
    }

    @Test
    public void test_toString() {
        assertThat(component(Script.class, $("#script_1")).toString(),
                is("class org.testatoo.cartridge.html4.element.Script with state : enabled:true, visible:false, source:addtext.js"));
    }
}
