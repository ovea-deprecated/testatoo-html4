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

public class PhraseTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Text.html");
    }

    // ---------------EM :Indicates emphasis. -------------------
    @Test
    public void can_find_em_by_id() {
        component(Em.class, "em_ess3");

        try {
            component(Em.class, "em_ess4");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=em_ess4"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_em() {
        try {
            component(Em.class, "abbr_ess1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess1 is not a Em but a Abbr"));
        }
    }

    @Test
    public void test_em_coreAttributes() {
        Em em_ess1 = component(Em.class, "em_ess1");
        Em em_ess2 = component(Em.class, "em_ess2");

        assertThat(em_ess1.title(), is("em1_Title"));
        assertThat(em_ess1.id(), is("em_ess1"));
        assertThat(em_ess1.style(), containsString("color:red"));
        assertThat(em_ess2.classname(), is("MyEMClass"));
    }

    @Test
    public void test_em_i18nAttributes() {
        Em em_ess2 = component(Em.class, "em_ess2");
        Em em_ess3 = component(Em.class, "em_ess3");

        assertThat(em_ess2.direction(), is(Direction.lefttoright));
        assertThat(em_ess2.language(), is("fr"));
        assertThat(em_ess3.language(), is("es"));
        assertThat(em_ess3.direction(), is(Direction.righttoleft));
    }

    @Test
    public void can_obtain_em_text() {
        assertThat(component(Em.class, "em_ess2").text(), is("TextTestem2"));
    }

    @Test
    public void testEm_toString() {
        assertThat(component(Em.class, "em_ess2").toString(),
                is("class org.testatoo.cartridge.html4.element.Em with state : enabled:true, visible:true, text:TextTestem2"));
    }

    // ---------------STRONG : Indicates stronger emphasis. -------------------
    @Test
    public void can_find_strong_by_id() {
        component(Strong.class, "strong_ess3");

        try {
            component(Strong.class, "strong_ess4");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=strong_ess4"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_strong() {
        try {
            component(Strong.class, "abbr_ess1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess1 is not a Strong but a Abbr"));
        }
    }

    @Test
    public void test_strong_coreAttributes() {
        Strong strong_ess1 = component(Strong.class, "strong_ess1");
        Strong strong_ess2 = component(Strong.class, "strong_ess2");
        Strong strong_ess3 = component(Strong.class, "strong_ess3");

        assertThat(strong_ess1.title(), is("strong1_Title"));
        assertThat(strong_ess1.id(), is("strong_ess1"));
        assertThat(strong_ess1.style(), containsString("color:yellow"));
        assertThat(strong_ess3.style(), containsString("font-size:14pt"));
        assertThat(strong_ess2.classname(), is("MySTRONGClass"));
    }

    @Test
    public void test_strong_i18nAttributes() {
        Strong strong_ess2 = component(Strong.class, "strong_ess2");
        Strong strong_ess3 = component(Strong.class, "strong_ess3");

        assertThat(strong_ess2.direction(), is(Direction.lefttoright));
        assertThat(strong_ess2.language(), is("fr"));
        assertThat(strong_ess3.language(), is("es"));
        assertThat(strong_ess3.direction(), is(Direction.righttoleft));
    }

    @Test
    public void can_obtain_strong_text() {
        assertThat(component(Strong.class, "strong_ess2").text(), is("TextTestStrong2"));
    }

    @Test
    public void testStrong_toString() {
        assertThat(component(Strong.class, "strong_ess2").toString(),
                is("class org.testatoo.cartridge.html4.element.Strong with state : enabled:true, visible:true, text:TextTestStrong2"));
    }

    // --------- CITE : Contains a citation or a reference to other sources.---------
    @Test
    public void can_find_cite_by_id() {
        component(Cite.class, "cite_ess3");

        try {
            component(Cite.class, "cite_ess4");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=cite_ess4"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_cite() {
        try {
            component(Cite.class, "abbr_ess1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess1 is not a Cite but a Abbr"));
        }
    }

    @Test
    public void test_cite_coreAttributes() {
        Cite cite_ess1 = component(Cite.class, "cite_ess1");
        Cite cite_ess2 = component(Cite.class, "cite_ess2");
        Cite cite_ess3 = component(Cite.class, "cite_ess3");

        assertThat(cite_ess1.title(), is("cite1_Title"));
        assertThat(cite_ess1.id(), is("cite_ess1"));
        assertThat(cite_ess1.style(), containsString("color:pink"));
        assertThat(cite_ess3.style(), containsString("font-size:16pt"));
        assertThat(cite_ess2.classname(), is("MyCITEClass"));
    }

    @Test
    public void test_cite_i18nAttributes() {
        Cite cite_ess2 = component(Cite.class, "cite_ess2");
        Cite cite_ess3 = component(Cite.class, "cite_ess3");

        assertThat(cite_ess2.direction(), is(Direction.lefttoright));
        assertThat(cite_ess2.language(), is("fr"));
        assertThat(cite_ess3.language(), is("es"));
        assertThat(cite_ess3.direction(), is(Direction.righttoleft));
    }

    @Test
    public void can_obtain_cite_text() {
        assertThat(component(Cite.class, "cite_ess2").text(), is("TextTestCite2"));
    }

    @Test
    public void testCite_toString() {
        assertThat(component(Cite.class, "cite_ess2").toString(),
                is("class org.testatoo.cartridge.html4.element.Cite with state : enabled:true, visible:true, text:TextTestCite2"));
    }

    // --------------- DFN : Indicates that this is the defining instance of the enclosed term.-----------------
    @Test
    public void can_find_dfn_by_id() {
        component(Dfn.class, "dfn_ess3");

        try {
            component(Dfn.class, "dfn_ess4");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=dfn_ess4"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_dfn() {
        try {
            component(Dfn.class, "abbr_ess1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess1 is not a Dfn but a Abbr"));
        }
    }

    @Test
    public void test_dfn_coreAttributes() {
        Dfn dfn_ess1 = component(Dfn.class, "dfn_ess1");
        Dfn dfn_ess2 = component(Dfn.class, "dfn_ess2");
        Dfn dfn_ess3 = component(Dfn.class, "dfn_ess3");

        assertThat(dfn_ess1.title(), is("dfn1_Title"));
        assertThat(dfn_ess1.id(), is("dfn_ess1"));
        assertThat(dfn_ess1.style(), containsString("color:blue"));
        assertThat(dfn_ess3.style(), containsString("font-size:10pt"));
        assertThat(dfn_ess2.classname(), is("MyDFNClass"));
    }

    @Test
    public void test_dfn_i18nAttributes() {
        Dfn dfn_ess2 = component(Dfn.class, "dfn_ess2");
        Dfn dfn_ess3 = component(Dfn.class, "dfn_ess3");

        assertThat(dfn_ess2.direction(), is(Direction.lefttoright));
        assertThat(dfn_ess2.language(), is("fr"));
        assertThat(dfn_ess3.language(), is("es"));
        assertThat(dfn_ess3.direction(), is(Direction.righttoleft));
    }

    @Test
    public void can_obtain_dfn_text() {
        assertThat(component(Dfn.class, "dfn_ess2").text(), is("TextTestDfn2"));
    }

    @Test
    public void testDfn_toString() {
        assertThat(component(Dfn.class, "dfn_ess2").toString(),
                is("class org.testatoo.cartridge.html4.element.Dfn with state : enabled:true, visible:true, text:TextTestDfn2"));
    }

    //---------------- CODE: Designates a fragment of computer code.--------------------------------------------
    @Test
    public void can_find_code_by_id() {
        component(Code.class, "code_ess3");

        try {
            component(Code.class, "code_ess4");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=code_ess4"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_code() {
        try {
            component(Code.class, "abbr_ess1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess1 is not a Code but a Abbr"));
        }
    }

    @Test
    public void test_code_coreAttributes() {
        Code code_ess1 = component(Code.class, "code_ess1");
        Code code_ess2 = component(Code.class, "code_ess2");
        Code code_ess3 = component(Code.class, "code_ess3");

        assertThat(code_ess1.title(), is("code1_Title"));
        assertThat(code_ess1.id(), is("code_ess1"));
        assertThat(code_ess1.style(), containsString("color:blue"));
        assertThat(code_ess3.style(), containsString("font-size:10pt"));
        assertThat(code_ess2.classname(), is("MyCODEClass"));
    }

    @Test
    public void test_code_i18nAttributes() {
        Code code_ess2 = component(Code.class, "code_ess2");
        Code code_ess3 = component(Code.class, "code_ess3");

        assertThat(code_ess2.direction(), is(Direction.lefttoright));
        assertThat(code_ess2.language(), is("fr"));
        assertThat(code_ess3.language(), is("es"));
        assertThat(code_ess3.direction(), is(Direction.righttoleft));
    }

    @Test
    public void can_obtain_code_text() {
        assertThat(component(Code.class, "code_ess2").text(), is("TextTestCode2"));
    }

    @Test
    public void testCode_toString() {
        assertThat(component(Code.class, "code_ess2").toString(),
                is("class org.testatoo.cartridge.html4.element.Code with state : enabled:true, visible:true, text:TextTestCode2"));
    }

    //---------------- SAMP: Designates sample output from programs, scripts, etc. -----------------------------
    @Test
    public void can_find_samp_by_id() {
        component(Samp.class, "samp_ess3");

        try {
            component(Samp.class, "samp_ess4");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=samp_ess4"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_samp() {
        try {
            component(Samp.class, "abbr_ess1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess1 is not a Samp but a Abbr"));
        }
    }

    @Test
    public void test_samp_coreAttributes() {
        Samp samp_ess1 = component(Samp.class, "samp_ess1");
        Samp samp_ess2 = component(Samp.class, "samp_ess2");
        Samp samp_ess3 = component(Samp.class, "samp_ess3");

        assertThat(samp_ess1.title(), is("samp1_Title"));
        assertThat(samp_ess1.id(), is("samp_ess1"));
        assertThat(samp_ess1.style(), containsString("color:blue"));
        assertThat(samp_ess3.style(), containsString("font-size:10pt"));
        assertThat(samp_ess2.classname(), is("MySAMPClass"));
    }

    @Test
    public void test_samp_i18nAttributes() {
        Samp samp_ess2 = component(Samp.class, "samp_ess2");
        Samp samp_ess3 = component(Samp.class, "samp_ess3");

        assertThat(samp_ess2.direction(), is(Direction.lefttoright));
        assertThat(samp_ess2.language(), is("fr"));
        assertThat(samp_ess3.language(), is("es"));
        assertThat(samp_ess3.direction(), is(Direction.righttoleft));
    }

    @Test
    public void can_obtain_samp_text() {
        assertThat(component(Samp.class, "samp_ess2").text(), is("TextTestSamp2"));
    }

    @Test
    public void testSamp_toString() {
        assertThat(component(Samp.class, "samp_ess2").toString(),
                is("class org.testatoo.cartridge.html4.element.Samp with state : enabled:true, visible:true, text:TextTestSamp2"));
    }

    //---------------- KBD: Indicates text to be entered by the user. ------------------------------------------
    @Test
    public void can_find_kbd_by_id() {
        component(Kbd.class, "kbd_ess3");

        try {
            component(Kbd.class, "kbd_ess4");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=kbd_ess4"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_kbd() {
        try {
            component(Kbd.class, "abbr_ess1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess1 is not a Kbd but a Abbr"));
        }
    }

    @Test
    public void test_kbd_coreAttributes() {
        Kbd kbd_ess1 = component(Kbd.class, "kbd_ess1");
        Kbd kbd_ess2 = component(Kbd.class, "kbd_ess2");
        Kbd kbd_ess3 = component(Kbd.class, "kbd_ess3");

        assertThat(kbd_ess1.title(), is("kbd1_Title"));
        assertThat(kbd_ess1.id(), is("kbd_ess1"));
        assertThat(kbd_ess1.style(), containsString("color:blue"));
        assertThat(kbd_ess3.style(), containsString("font-size:10pt"));
        assertThat(kbd_ess2.classname(), is("MyKBDClass"));
    }

    @Test
    public void test_kbd_i18nAttributes() {
        Kbd kbd_ess2 = component(Kbd.class, "kbd_ess2");
        Kbd kbd_ess3 = component(Kbd.class, "kbd_ess3");

        assertThat(kbd_ess2.direction(), is(Direction.lefttoright));
        assertThat(kbd_ess2.language(), is("fr"));
        assertThat(kbd_ess3.language(), is("es"));
        assertThat(kbd_ess3.direction(), is(Direction.righttoleft));
    }

    @Test
    public void can_obtain_kbd_text() {
        assertThat(component(Kbd.class, "kbd_ess2").text(), is("TextTestKbd2"));
    }

    @Test
    public void testKbd_toString() {
        assertThat(component(Kbd.class, "kbd_ess2").toString(),
                is("class org.testatoo.cartridge.html4.element.Kbd with state : enabled:true, visible:true, text:TextTestKbd2"));
    }

    //---------------- VAR: Indicates an instance of a variable or program argument.----------------------------
    @Test
    public void can_find_var_by_id() {
        component(Var.class, "var_ess3");

        try {
            component(Var.class, "var_ess4");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=var_ess4"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_var() {
        try {
            component(Var.class, "abbr_ess1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess1 is not a Var but a Abbr"));
        }
    }

    @Test
    public void test_var_coreAttributes() {
        Var var_ess1 = component(Var.class, "var_ess1");
        Var var_ess2 = component(Var.class, "var_ess2");
        Var var_ess3 = component(Var.class, "var_ess3");

        assertThat(var_ess1.title(), is("var1_Title"));
        assertThat(var_ess1.id(), is("var_ess1"));
        assertThat(var_ess1.style(), containsString("color:blue"));
        assertThat(var_ess3.style(), containsString("font-size:10pt"));
        assertThat(var_ess2.classname(), is("MyVARClass"));
    }

    @Test
    public void test_var_i18nAttributes() {
        Var var_ess2 = component(Var.class, "var_ess2");
        Var var_ess3 = component(Var.class, "var_ess3");

        assertThat(var_ess2.direction(), is(Direction.lefttoright));
        assertThat(var_ess2.language(), is("fr"));
        assertThat(var_ess3.language(), is("es"));
        assertThat(var_ess3.direction(), is(Direction.righttoleft));
    }

    @Test
    public void can_obtain_var_text() {
        assertThat(component(Var.class, "var_ess2").text(), is("TextTestVar2"));
    }

    @Test
    public void testVar_toString() {
        assertThat(component(Var.class, "var_ess2").toString(),
                is("class org.testatoo.cartridge.html4.element.Var with state : enabled:true, visible:true, text:TextTestVar2"));
    }

    //---------------- ABBR: Indicates an abbreviated form (e.g., WWW, HTTP, URI, Mass., etc.).-----------------
    @Test
    public void can_find_abbr_by_id() {
        component(Abbr.class, "abbr_ess3");

        try {
            component(Abbr.class, "abbr_ess4");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=abbr_ess4"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_abbr() {
        try {
            component(Abbr.class, "var_ess2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=var_ess2 is not a Abbr but a Var"));
        }
    }

    @Test
    public void test_abbr_coreAttributes() {
        Abbr abbr_ess1 = component(Abbr.class, "abbr_ess1");
        Abbr abbr_ess2 = component(Abbr.class, "abbr_ess2");
        Abbr abbr_ess3 = component(Abbr.class, "abbr_ess3");

        assertThat(abbr_ess1.title(), is("abbr1_Title"));
        assertThat(abbr_ess1.id(), is("abbr_ess1"));
        assertThat(abbr_ess1.style(), containsString("color:blue"));
        assertThat(abbr_ess3.style(), containsString("font-size:10pt"));
        assertThat(abbr_ess2.classname(), is("MyABBRClass"));
    }

    @Test
    public void test_abbr_i18nAttributes() {
        Abbr abbr_ess2 = component(Abbr.class, "abbr_ess2");
        Abbr abbr_ess3 = component(Abbr.class, "abbr_ess3");

        assertThat(abbr_ess2.direction(), is(Direction.lefttoright));
        assertThat(abbr_ess2.language(), is("fr"));
        assertThat(abbr_ess3.language(), is("es"));
        assertThat(abbr_ess3.direction(), is(Direction.righttoleft));
    }

    @Test
    public void can_obtain_abbr_text() {
        assertThat(component(Abbr.class, "abbr_ess2").text(), is("TextTestAbbr2"));
    }

    @Test
    public void testAbbr_toString() {
        assertThat(component(Abbr.class, "abbr_ess2").toString(),
                is("class org.testatoo.cartridge.html4.element.Abbr with state : enabled:true, visible:true, text:TextTestAbbr2"));
    }

    //---------------- ACRONYM: Indicates an acronym (e.g., WAC, radar, etc.).----------------------------------
    @Test
    public void can_find_acronym_by_id() {
        component(Acronym.class, "acronym_ess3");

        try {
            component(Acronym.class, "acronym_ess4");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=acronym_ess4"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_acronym() {
        try {
            component(Acronym.class, "abbr_ess1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=abbr_ess1 is not a Acronym but a Abbr"));
        }
    }

    @Test
    public void test_acronym_coreAttributes() {
        Acronym acronym_ess1 = component(Acronym.class, "acronym_ess1");
        Acronym acronym_ess2 = component(Acronym.class, "acronym_ess2");
        Acronym acronym_ess3 = component(Acronym.class, "acronym_ess3");

        assertThat(acronym_ess1.title(), is("acronym1_Title"));
        assertThat(acronym_ess1.id(), is("acronym_ess1"));
        assertThat(acronym_ess1.style(), containsString("color:blue"));
        assertThat(acronym_ess3.style(), containsString("font-size:10pt"));
        assertThat(acronym_ess2.classname(), is("MyACRONYMClass"));
    }

    @Test
    public void test_acronym_i18nAttributes() {
        Acronym acronym_ess2 = component(Acronym.class, "acronym_ess2");
        Acronym acronym_ess3 = component(Acronym.class, "acronym_ess3");

        assertThat(acronym_ess2.direction(), is(Direction.lefttoright));
        assertThat(acronym_ess2.language(), is("fr"));
        assertThat(acronym_ess3.language(), is("es"));
        assertThat(acronym_ess3.direction(), is(Direction.righttoleft));
    }

    @Test
    public void can_obtain_acronym_text() {
        assertThat(component(Acronym.class, "acronym_ess2").text(), is("TextTestAcronym2"));
    }

    @Test
    public void testAcronym_toString() {
        assertThat(component(Acronym.class, "acronym_ess2").toString(),
                is("class org.testatoo.cartridge.html4.element.Acronym with state : enabled:true, visible:true, text:TextTestAcronym2"));
    }

    //---------------- P: Paragraph .----------------------------

    @Test
    public void can_find_p_by_id() {
        component(P.class, "p_1");

        try {
            component(P.class, "a_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=a_0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_p() {
        try {
            component(P.class, "acronym_ess1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=acronym_ess1 is not a P but a Acronym"));
        }
    }

    @Test
    public void test_p_i18nAttributes() {
        P p = component(P.class, "p_1");

        assertThat(p.direction(), is(Direction.righttoleft));
        assertThat(p.language(), is("en"));
    }

    @Test
    public void test_p_coreAttributes() {
        P p = component(P.class, "p_1");

        assertThat(p.id(), is("p_1"));
        assertThat(p.classname(), is("myPClass"));
        assertThat(p.style(), containsString("color:black"));
        assertThat(p.title(), is("pTitle"));
    }

    @Test
    public void can_obtain_p_text() {
        assertThat(component(P.class, "p_1").text(), is("My Paragraph text"));
    }

    @Test
    public void testP_toString() {
        assertThat(component(P.class, "p_1").toString(),
                is("class org.testatoo.cartridge.html4.element.P with state : enabled:true, visible:true, text:My Paragraph text"));
    }

}
