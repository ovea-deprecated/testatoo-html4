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

public class OptionGroupTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Select.html");
    }

    @Test
    public void can_find_optionGroup_by_id() {
        component(OptionGroup.class, "linux");

        try {
            component(OptionGroup.class, "someOptionGroup");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=someOptionGroup"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_optionGroup() {
        try {
            component(OptionGroup.class, "var_ess1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=var_ess1 is not a OptionGroup but a Var"));
        }
    }

    @Test
    public void test_label() {
        assertThat(component(OptionGroup.class, "linux").label(), is("linux"));
    }

    @Test
    public void can_get_options_of_optionGroup() {
        OptionGroup myLinux = component(OptionGroup.class, "linux");

        assertThat(myLinux.options().size(), is(3));

        Option optionLinux = component(Option.class, "kubuntuOption");
        assertThat(myLinux.options().contains(optionLinux), is(true));

        assertThat(myLinux.options().get(0).content(), is("Kubuntu"));
        assertThat(myLinux.options().get(1).content(), is("Fedora"));
        assertThat(myLinux.options().get(2).content(), is("Gentoo"));
    }

    @Test
    public void test_i18nAttributes() {
        OptionGroup myLinux = component(OptionGroup.class, "linux");

        assertThat(myLinux.direction(), is(Direction.lefttoright));
        assertThat(myLinux.language(), is("fr"));
    }

    @Test
    public void test_coreAttributes() {
        OptionGroup myLinux = component(OptionGroup.class, "linux");

        assertThat(myLinux.id(), is("linux"));
        assertThat(myLinux.classname(), is("myClass"));
        assertThat(myLinux.style(), containsString("color:black"));
        assertThat(myLinux.title(), is("linuxGrpTitle"));
    }

    @Test
    public void test_enability() {
        OptionGroup myLinux = component(OptionGroup.class, "linux");
        assertThat(myLinux.isEnabled(), is(true));
        assertThat(myLinux.isDisabled(), is(false));
    }

    @Test
    public void test_contains() {
        OptionGroup myLinux = component(OptionGroup.class, "linux");
        Option optionLinux = component(Option.class, "kubuntuOption");
        assertThat(myLinux.contains(optionLinux), is(true));
    }

    @Test
    public void test_toString() {
        // Test fail by browser specific implementation state of visibility
        assertThat(component(OptionGroup.class, "linux").toString(),
                is("class org.testatoo.cartridge.html4.element.OptionGroup with state : enabled:true, visible:false, label:linux, optionsValue:[KubuntuValue, RedHatValue, GentooValue]"));
    }
}
