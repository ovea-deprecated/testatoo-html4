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
import static org.testatoo.cartridge.html4.By.$;
import static org.testatoo.core.ComponentFactory.*;
import static org.testatoo.core.Language.assertThat;
import static org.testatoo.core.matcher.Matchers.*;

public class ImgTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Img.html");
    }

    // ---------------Tests on image attributes. -------------------
    @Test
    public void can_find_image_by_id() {
        component(Img.class, $("#image_1"));

        try {
            component(Img.class, $("#image_0"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by jQueryExpression=$('#image_0')"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_image() {
        try {
            component(Img.class, $("#div_1"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=div_1 is not a Image but a Panel"));
        }
    }

    @Test
    public void can_find_image_source() {
        assertThat(component(Img.class, $("#image_1")).source(), is("images/Montpellier.jpg"));
    }

    @Test
    public void test_image_i18nAttributes() {
        Img image_1 = component(Img.class, $("#image_1"));

        assertThat(image_1.direction(), is(Direction.lefttoright));
        assertThat(image_1.language(), is("fr"));
    }

    @Test
    public void test_image_coreAttributes() {
        Img image_1 = component(Img.class, $("#image_1"));

        assertThat(image_1.id(), is("image_1"));
        assertThat(image_1.classname(), is("MyIMAGEClass"));
        assertThat(image_1.style(), containsString("color:black"));
        assertThat(image_1.title(), is("imageTitle"));
    }

    @Test
    public void test_image_specifics_attributes() {
        Img image_1 = component(Img.class, $("#image_1"));
        Img image_2 = component(Img.class, $("#image_2"));

        assertThat(image_1.name(), is("imageName"));
        assertThat(image_1.alt(), is("Montpellier tramway"));
        assertThat(image_1.longdesc(), is("Montpellier first line tramway"));
        assertThat(image_1.usemap(), is("http://mySite/images"));
//      Not tested cause result is browser dependant
//        assertThat(image_1.height(), is("733"));
//        assertThat(image_1.width(), is("1102"));

        assertThat(image_2.usemap(), is("#map_2"));
    }

    @Test
    public void test_image_toString() {
        assertThat(component(Img.class, $("#image_1")).toString(), is("class org.testatoo.cartridge.html4.element.Img with state : enabled:true, visible:true, source:images/Montpellier.jpg"));
    }

    //------------- Tests on map : Defines a client-side image map. -----------------------------
    @Test
    public void can_find_map_by_id() {
        component(Map.class, $("#map_2"));

        try {
            component(Map.class, $("#map_0"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by jQueryExpression=$('#map_0')"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_map() {
        try {
            component(Map.class, $("#div_1"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=div_1 is not a Map but a Div"));
        }
        try {
            component(Map.class, $("#image_1"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=image_1 is not a Map but a Img"));
        }
    }

    @Test
    public void test_map_i18nAttributes() {
        Map map_2 = component(Map.class, $("#map_2"));

        assertThat(map_2.direction(), is(Direction.righttoleft));
        assertThat(map_2.language(), is("en"));
    }

    @Test
    public void test_map_coreAttributes() {
        Map map_2 = component(Map.class, $("#map_2"));

        assertThat(map_2.id(), is("map_2"));
        assertThat(map_2.classname(), is("MyMAPClass"));
        assertThat(map_2.style(), containsString("color:blue"));
        assertThat(map_2.title(), is("map_title2"));
    }

    @Test
    public void test_map_specifics_attributes() {
        Map map_2 = component(Map.class, $("#map_2"));

        assertThat(map_2.name(), is("map_2"));
    }

    @Test
    public void can_obtain_area() {
        Map map_2 = component(Map.class, $("#map_2"));

        assertThat(map_2.areas(), has(size(4)));

        assertThat(map_2.areas().get(0).coords(), is("40,144,80,171"));
        assertThat(map_2.areas().get(1).coords(), is("112,144,152,171"));
        assertThat(map_2.areas().get(2).coords(), is("184,144,224,171"));
        assertThat(map_2.areas().get(3).coords(), is("256,144,296,171"));
    }

    @Test
    public void test_map_toString() {
        assertThat(component(Map.class, $("#map_2")).toString(), is("class org.testatoo.cartridge.html4.element.Map with state : enabled:true, visible:false, title:map_title2"));
    }

    //------------- Tests on area : Defines sectors for image maps. -----------------------------
    @Test
    public void can_find_area_by_id() {
        component(Area.class, $("#area_1"));

        try {
            component(Area.class, $("#area_0"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by jQueryExpression=$('#area_0')"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_area() {
        try {
            component(Area.class, $("#div_1"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=div_1 is not a Area but a Div"));
        }
        try {
            component(Area.class, $("#image_1"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=image_1 is not a Area but a Img"));
        }
    }

    @Test
    public void test_area_i18nAttributes() {
        Area area_1 = component(Area.class, $("#area_1"));

        assertThat(area_1.direction(), is(Direction.righttoleft));
        assertThat(area_1.language(), is("dr"));
    }

    @Test
    public void test_area_coreAttributes() {
        Area area_1 = component(Area.class, $("#area_1"));

        assertThat(area_1.id(), is("area_1"));
        assertThat(area_1.classname(), is("MyAREAClass"));
        assertThat(area_1.style(), containsString("color:red"));
        assertThat(area_1.title(), is("area_title1"));
    }

    @Test
    public void test_area_specifics_attributes() {
        Area area_1 = component(Area.class, $("#area_1"));
        Area area_2 = component(Area.class, $("#area_2"));

        assertThat(area_1.shape(), is(Shape.rect));
        assertThat(area_1.accesskey(), is("C"));
        assertThat(area_1.alt(), is("area1"));
        assertThat(area_1.coords(), is("40,144,80,171"));
        assertThat(area_2.href(), is("Exit.html"));
        assertThat(area_2.tabindex(), is(2));
    }

    @Test
    public void test_visibility() {
        Area area = component(Area.class, $("#area_1"));
        assertThat(area.isVisible(), is(false));
    }

    @Test
    public void test_area_toString() {
        assertThat(component(Area.class, $("#area_1")).toString(), is("class org.testatoo.cartridge.html4.element.Area with state : enabled:true, visible:false, title:area_title1, href:Exit.html"));
    }
}
