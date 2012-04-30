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
import org.junit.Ignore;
import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.core.ComponentException;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;
import static org.testatoo.cartridge.html4.By.$;
import static org.testatoo.core.ComponentFactory.*;
import static org.testatoo.core.Language.assertThat;
import static org.testatoo.core.matcher.Matchers.contains;

public class IFrameTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("IFrame.html");
    }

    @Test
    public void can_find_iFrame_by_id() {
        component(IFrame.class, $("#iFrame_1"));

        try {
            component(IFrame.class, $("#iFrame_0"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by jQueryExpression=$('#iFrame_0')"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_iframe() {
        try {
            component(IFrame.class, $("#abbr_ess1"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess1 is not a IFrame but a Abbr"));
        }
    }

    @Test
    public void test_iFrame_coreAttributes() {
        IFrame iFrame_1 = component(IFrame.class, $("#iFrame_1"));

        assertThat(iFrame_1.id(), is("iFrame_1"));
        assertThat(iFrame_1.classname(), is("MyIFRAMEClass"));
        assertThat(iFrame_1.style(), containsString("color:red"));
        assertThat(iFrame_1.title(), is("iFrameTitle1"));
    }

    @Test
    public void test_iFrame_specifics_attributes() {
        IFrame iFrame_1 = component(IFrame.class, $("#iFrame_1"));

        assertThat(iFrame_1.name(), is("iFrameName1"));
        assertThat(iFrame_1.frameborder(), is(1));
        assertThat(iFrame_1.longdesc(), is(""));
        assertThat(iFrame_1.marginheight(), is(1));
        assertThat(iFrame_1.marginwidth(), is(1));
        assertThat(iFrame_1.scrolling(), is(Scrolling.yes));
        assertThat(iFrame_1.src(), is("http://www.google.com"));

        IFrame iFrame_2 = component(IFrame.class, $("#iFrame_2"));

        assertThat(iFrame_2.name(), is(""));
        assertThat(iFrame_2.frameborder(), is(1));
        assertThat(iFrame_2.longdesc(), is(""));
        assertThat(iFrame_2.marginheight(), is(1));
        assertThat(iFrame_2.marginwidth(), is(1));
        assertThat(iFrame_2.scrolling(), is(Scrolling.auto));
    }

    @Test
    public void test_toString() {
        assertThat(component(IFrame.class, $("#iFrame_1")).toString(), is("class org.testatoo.cartridge.html4.element.IFrame with state : enabled:true, visible:true, title:iFrameTitle1"));
    }
}
