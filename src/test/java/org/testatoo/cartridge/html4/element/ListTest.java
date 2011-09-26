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

public class ListTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("List.html");
    }

    //---------- UL --------------------
    @Test
    public void can_find_ul_by_id() {
        component(Ul.class, "ul_1");

        try {
            component(Ul.class, "ul_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=ul_0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_ul() {
        try {
            component(Ul.class, "abbr_ess2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess2 is not a Ul but a Abbr"));
        }
    }

    @Test
    public void test_ul_coreAttributes() {
        Ul ul_1 = component(Ul.class, "ul_1");

        assertThat(ul_1.id(), is("ul_1"));
        assertThat(ul_1.classname(), is("MyULClass"));
        assertThat(ul_1.style(), containsString("color:red"));
        assertThat(ul_1.title(), is("ul_title1"));
    }

    @Test
    public void test_ul_i18nAttributes() {
        Ul ul_1 = component(Ul.class, "ul_1");

        assertThat(ul_1.direction(), is(Direction.righttoleft));
        assertThat(ul_1.language(), is("en"));
    }

    @Test
    public void testUl_toString() {
        assertThat(component(Ul.class, "ul_1").toString(), is("class org.testatoo.cartridge.html4.element.Ul with state : enabled:true, visible:true, title:ul_title1"));
    }

    //---------- Li --------------------
    @Test
    public void can_find_li_by_id() {
        component(Li.class, "li_1");

        try {
            component(Li.class, "li_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=li_0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_li() {
        try {
            component(Li.class, "abbr_ess2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess2 is not a Li but a Abbr"));
        }
    }

    @Test
    public void test_li_coreAttributes() {
        Li li_1 = component(Li.class, "li_1");
        Li li_2 = component(Li.class, "li_2");

        assertThat(li_1.id(), is("li_1"));
        assertThat(li_1.classname(), is("MyLIClass"));
        assertThat(li_1.style(), containsString("color:blue"));
        assertThat(li_1.title(), is("li_title1"));
        assertThat(li_2.title(), is("li_title2"));
    }

    @Test
    public void test_li_i18nAttributes() {
        Li li_1 = component(Li.class, "li_1");

        assertThat(li_1.direction(), is(Direction.lefttoright));
        assertThat(li_1.language(), is("fr"));
    }

    @Test
    public void testLi_toString() {
        assertThat(component(Li.class, "li_1").toString(), is("class org.testatoo.cartridge.html4.element.Li with state : enabled:true, visible:true, title:li_title1, content:Item 1"));
    }

    //---------- 0L --------------------
    @Test
    public void can_find_ol_by_id() {
        component(Ol.class, "ol_1");

        try {
            component(Ol.class, "ol_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=ol_0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_ol() {
        try {
            component(Ol.class, "abbr_ess2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess2 is not a Ol but a Abbr"));
        }
    }

    @Test
    public void test_ol_coreAttributes() {
        Ol ol_1 = component(Ol.class, "ol_1");

        assertThat(ol_1.id(), is("ol_1"));
        assertThat(ol_1.classname(), is("MyOLClass"));
        assertThat(ol_1.style(), containsString("color:brown"));
        assertThat(ol_1.title(), is("ol_title1"));
    }

    @Test
    public void test_ol_i18nAttributes() {
        Ol ol_1 = component(Ol.class, "ol_1");

        assertThat(ol_1.direction(), is(Direction.lefttoright));
        assertThat(ol_1.language(), is("es"));
    }

    @Test
    public void testOl_toString() {
        assertThat(component(Ol.class, "ol_1").toString(), is("class org.testatoo.cartridge.html4.element.Ol with state : enabled:true, visible:true, title:ol_title1"));
    }

    //---------- DL --------------------
    @Test
    public void can_find_dl_by_id() {
        component(Dl.class, "dl_1");

        try {
            component(Dl.class, "dl_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=dl_0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_dl() {
        try {
            component(Dl.class, "abbr_ess2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess2 is not a Dl but a Abbr"));
        }
    }

    @Test
    public void test_dl_coreAttributes() {
        Dl dl_1 = component(Dl.class, "dl_1");

        assertThat(dl_1.id(), is("dl_1"));
        assertThat(dl_1.classname(), is("MyDLClass"));
        assertThat(dl_1.style(), containsString("color:black"));
        assertThat(dl_1.title(), is("dl_title1"));
    }

    @Test
    public void test_dl_i18nAttributes() {
        Dl dl_1 = component(Dl.class, "dl_1");

        assertThat(dl_1.direction(), is(Direction.lefttoright));
        assertThat(dl_1.language(), is("en"));
    }

    @Test
    public void testDl_toString() {
        assertThat(component(Dl.class, "dl_1").toString(), is("class org.testatoo.cartridge.html4.element.Dl with state : enabled:true, visible:true, title:dl_title1"));
    }

    //---------- DT --------------------
    @Test
    public void can_find_dt_by_id() {
        component(Dt.class, "dt_1");

        try {
            component(Dt.class, "dt_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=dt_0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_dt() {
        try {
            component(Dt.class, "abbr_ess2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess2 is not a Dt but a Abbr"));
        }
    }

    @Test
    public void test_dt_coreAttributes() {
        Dt dt_1 = component(Dt.class, "dt_1");

        assertThat(dt_1.id(), is("dt_1"));
        assertThat(dt_1.classname(), is("MyDTClass"));
        assertThat(dt_1.style(), containsString("color:red"));
        assertThat(dt_1.title(), is("dt_title1"));
    }

    @Test
    public void test_dt_i18nAttributes() {
        Dt dt_1 = component(Dt.class, "dt_1");

        assertThat(dt_1.direction(), is(Direction.righttoleft));
        assertThat(dt_1.language(), is("fr"));
    }

    @Test
    public void testDt_toString() {
        assertThat(component(Dt.class, "dt_1").toString(), is("class org.testatoo.cartridge.html4.element.Dt with state : enabled:true, visible:true, title:dt_title1, content:Red"));
    }

    //---------- DD --------------------
    @Test
    public void can_find_dd_by_id() {
        component(Dd.class, "dd_1");

        try {
            component(Dd.class, "dd_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=dd_0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_dd() {
        try {
            component(Dd.class, "abbr_ess2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess2 is not a Dd but a Abbr"));
        }
    }

    @Test
    public void test_dd_coreAttributes() {
        Dd dd_1 = component(Dd.class, "dd_1");

        assertThat(dd_1.id(), is("dd_1"));
        assertThat(dd_1.classname(), is("MyDDClass"));
        assertThat(dd_1.style(), containsString("color:pink"));
        assertThat(dd_1.title(), is("dd_title1"));
    }

    @Test
    public void test_dd_i18nAttributes() {
        Dd dd_1 = component(Dd.class, "dd_1");

        assertThat(dd_1.direction(), is(Direction.righttoleft));
        assertThat(dd_1.language(), is("en"));
    }

    @Test
    public void testDd_toString() {
        assertThat(component(Dd.class, "dd_1").toString(), is("class org.testatoo.cartridge.html4.element.Dd with state : enabled:true, visible:true, title:dd_title1, content:Constructed by R:255 ; G:0 ; B:0"));
    }
}
