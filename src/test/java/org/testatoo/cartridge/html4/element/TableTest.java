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
import org.testatoo.cartridge.WebTest;
import org.testatoo.cartridge.html4.By;
import org.testatoo.core.ComponentException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;

public class TableTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Table.html");
    }

    // ---------------TESTS ON TABLE ATTRIBUTES -------------------
    @Test
    public void can_find_table_by_id() {
        component(Table.class, "table_1");

        try {
            component(Table.class, "table_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=table_0"));
        }
    }

    @Test
    public void can_find_table_by_name() {
        component(Table.class, By.name("tableName"));

        try {
            component(Table.class, By.name("myTableName"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by name=myTableName"));
        }
    }

    @Test
    public void can_find_table_by_title() {
        component(Table.class, By.title("tableTitle"));

        try {
            component(Table.class, By.title("myTableTitle"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by title=myTableTitle"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_table() {
        try {
            component(Table.class, "caption_table6");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=caption_table6 is not a Table but a Caption"));
        }
    }

    @Test
    public void test_i18nAttributes() {
        Table table_2 = component(Table.class, "table_2");

        assertThat(table_2.direction(), is(Direction.lefttoright));
        assertThat(table_2.language(), is("ca"));
    }

    @Test
    public void test_coreAttributes() {
        Table table_2 = component(Table.class, "table_2");

        assertThat(table_2.id(), is("table_2"));
        assertThat(table_2.classname(), is("myClass"));
        assertThat(table_2.style(), containsString("color:black"));
        assertThat(table_2.title(), is("tableTitle"));
    }

    @Test
    public void test_specificsAttributes() {
        Table table_2 = component(Table.class, "table_2");
        Table table_3 = component(Table.class, "table_3");
        Table table_4 = component(Table.class, "table_4");
        Table table_5 = component(Table.class, "table_5");

        assertThat(table_2.summary(), is("tableSummary"));

        assertThat(table_2.width(), is("50%"));

        assertThat(table_2.border(), is(0));
        assertThat(table_3.border(), is(5));
        assertThat(table_4.border(), is(1));

        assertThat(table_2.frame(), is(TFrame.box));
        assertThat(table_3.frame(), is(TFrame.vsides));

        assertThat(table_2.rules(), is(TRules.all));
        assertThat(table_3.rules(), is(TRules.cols));

        assertThat(table_2.cellspacing(), is(""));
        assertThat(table_4.cellspacing(), is("10"));
        assertThat(table_5.cellspacing(), containsString("10"));
        assertThat(table_2.cellpadding(), is(""));
        assertThat(table_4.cellpadding(), containsString("8"));
        assertThat(table_5.cellpadding(), is("30"));
    }

    @Test
    public void can_obtain_caption() {
        Table table = component(Table.class, "table_5");

        assertThat(table.caption().title(), is("caption5_title"));
    }

    @Test
    public void can_obtain_thead() {
        Table table = component(Table.class, "table_6");

        assertThat(table.thead().id(), is("thead_ess1"));
        assertThat(table.thead().title(), is("thead1_Title"));
    }

    @Test
    public void can_obtain_tbody() {
        Table table = component(Table.class, "table_6");

        assertThat(table.tbody().id(), is("tbody_ess1"));
        assertThat(table.tbody().title(), is("tbody1_Title"));
    }

    @Test
    public void can_obtain_tfoot() {
        Table table = component(Table.class, "table_6");

        assertThat(table.tfoot().id(), is("tfoot_ess1"));
    }

    @Test
    public void can_obtain_colgroups() {
        Table table = component(Table.class, "table_8");

        assertThat(table.colgroups().size(), is(2));
        assertThat(table.colgroups().get(0).id(), is("colgroup_ess1"));
        assertThat(table.colgroups().get(1).id(), is("colgroup_ess2"));
    }

    @Test
    public void can_obtain_cols() {
        Table table = component(Table.class, "table_6");

        assertThat(table.cols().size(), is(4));
        assertThat(table.cols().get(0).title(), is("col_0"));
        assertThat(table.cols().get(1).title(), is("col_1"));
        assertThat(table.cols().get(2).title(), is("col_2"));
        assertThat(table.cols().get(3).title(), is("col_3"));
    }

    @Test
    public void can_obtain_table_rows() {
        Table table = component(Table.class, "table_5");

        assertThat(table.tr().size(), is(1));

        table = component(Table.class, "table_4");
        assertThat(table.tr().size(), is(4));

        table = component(Table.class, "table_6");
        assertThat(table.tr().size(), is(8));
    }

    @Test
    public void test_table_toString() {
        assertThat(component(Table.class, "table_2").toString(),
                is("class org.testatoo.cartridge.html4.element.Table with state : enabled:true, visible:true, column(s):0, row(s):1"));
    }

    // ---------------TESTS ON CAPTION : to describe the nature of the table -------------------
    @Test
    public void can_find_caption_by_id() {
        component(Caption.class, "caption_table5");
        try {
            component(Caption.class, "caption_ess0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=caption_ess0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_caption() {
        try {
            component(Caption.class, "table_2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=table_2 is not a Caption but a Table"));
        }
    }

    @Test
    public void test_caption_coreAttributes() {
        Caption caption_table5 = component(Caption.class, "caption_table5");

        assertThat(caption_table5.title(), is("caption5_title"));
        assertThat(caption_table5.id(), is("caption_table5"));
        assertThat(caption_table5.style(), containsString("font-size:10pt"));
        assertThat(caption_table5.classname(), is("MyCAPTIONClass"));
    }

    @Test
    public void test_caption_i18nAttributes() {
        Caption caption_table6 = component(Caption.class, "caption_table6");
        Caption caption_table5 = component(Caption.class, "caption_table5");

        assertThat(caption_table6.direction(), is(Direction.lefttoright));
        assertThat(caption_table6.language(), is(""));
        assertThat(caption_table5.language(), is("ar"));
        assertThat(caption_table5.direction(), is(Direction.righttoleft));
    }

    @Test
    public void test_caption_content() {
        Caption caption_table5 = component(Caption.class, "caption_table5");

        assertThat(caption_table5.content(), is("A test table with cellspacing and cellpadding"));
    }

    @Test
    public void test_caption_toString() {
        assertThat(component(Caption.class, "caption_table6").toString(),
                is("class org.testatoo.cartridge.html4.element.Caption with state : enabled:true, visible:true, content:The XHTML Playoffs"));
    }

    // ---------------TESTS ON THEAD : header information -------------------
    @Test
    public void can_find_thead_by_id() {
        component(THead.class, "thead_ess1");

        try {
            component(THead.class, "thead_ess0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=thead_ess0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_thead() {
        try {
            component(THead.class, "table_2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=table_2 is not a THead but a Table"));
        }
    }

    @Test
    public void test_thead_coreAttributes() {
        THead thead_ess1 = component(THead.class, "thead_ess1");

        assertThat(thead_ess1.title(), is("thead1_Title"));
        assertThat(thead_ess1.id(), is("thead_ess1"));
        assertThat(thead_ess1.style(), containsString("color:blue"));
        assertThat(thead_ess1.classname(), is("MyTHEADClass"));
    }

    @Test
    public void test_thead_i18nAttributes() {
        THead thead_ess1 = component(THead.class, "thead_ess1");
        THead thead_ess2 = component(THead.class, "thead_ess2");

        assertThat(thead_ess1.direction(), is(Direction.lefttoright));
        assertThat(thead_ess1.language(), is("fr"));
        assertThat(thead_ess2.language(), is("ar"));
        assertThat(thead_ess2.direction(), is(Direction.righttoleft));
    }

    @Test
    public void test_thead_specificsAttributes() {
        THead thead = component(THead.class, "thead_ess2");

        assertThat(thead.cellhalign(), is(Cellhalign.right));
        assertThat(thead.cellvalign(), is(Cellvalign.top));
    }

    @Test
    public void can_obtain_thead_tr() {
        THead thead = component(THead.class, "thead_ess1");
        assertThat(thead.tr().size(), is(2));
    }

    @Test
    public void test_thead_toString() {
        assertThat(component(THead.class, "thead_ess1").toString(),
                is("class org.testatoo.cartridge.html4.element.THead with state : enabled:true, visible:true, title:thead1_Title"));
    }

    // ---------------TESTS ON TFOOT : footer information -------------------
    @Test
    public void can_find_tfoot_by_id() {
        component(TFoot.class, "tfoot_ess1");

        try {
            component(TFoot.class, "tfoot_ess0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=tfoot_ess0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_tfoot() {
        try {
            component(TFoot.class, "table_2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=table_2 is not a TFoot but a Table"));
        }
    }

    @Test
    public void test_tfoot_coreAttributes() {
        TFoot tfoot_ess1 = component(TFoot.class, "tfoot_ess1");
        TFoot tfoot_ess2 = component(TFoot.class, "tfoot_ess2");

        assertThat(tfoot_ess1.title(), is(""));
        assertThat(tfoot_ess2.id(), is("tfoot_ess2"));
        assertThat(tfoot_ess2.style(), containsString("background-color:pink"));
        assertThat(tfoot_ess2.classname(), is("MyTFOOTClass"));
    }

    @Test
    public void test_tfoot_i18nAttributes() {
        TFoot tfoot_ess1 = component(TFoot.class, "tfoot_ess1");
        TFoot tfoot_ess2 = component(TFoot.class, "tfoot_ess2");

        assertThat(tfoot_ess1.direction(), is(Direction.lefttoright));
        assertThat(tfoot_ess1.language(), is("fr"));
        assertThat(tfoot_ess2.language(), is("es"));
        assertThat(tfoot_ess2.direction(), is(Direction.righttoleft));
    }

    @Test
    public void test_tfoot_specificsAttributes() {
        TFoot tfoot = component(TFoot.class, "tfoot_ess2");

        assertThat(tfoot.cellhalign(), is(Cellhalign.left));
        assertThat(tfoot.cellvalign(), is(Cellvalign.bottom));
    }

    @Test
    public void can_obtain_tfoot_tr() {
        TFoot tfoot = component(TFoot.class, "tfoot_ess2");

        assertThat(tfoot.tr().size(), is(1));
        assertThat(tfoot.tr().get(0).id(), is("tfoot_tr"));
    }

    @Test
    public void test_tfoot_toString() {
        assertThat(component(TFoot.class, "tfoot_ess2").toString(),
                is("class org.testatoo.cartridge.html4.element.TFoot with state : enabled:true, visible:true, title:tfoot_title2"));
    }

    // ---------------TESTS ON TBODY : main information -------------------
    @Test
    public void can_find_tbody_by_id() {
        component(TBody.class, "tbody_ess1");

        try {
            component(TBody.class, "tbody_ess0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=tbody_ess0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_tbody() {
        try {
            component(TBody.class, "table_2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=table_2 is not a TBody but a Table"));
        }
    }

    @Test
    public void test_tbody_coreAttributes() {
        TBody tbody_ess1 = component(TBody.class, "tbody_ess1");

        assertThat(tbody_ess1.title(), is("tbody1_Title"));
        assertThat(tbody_ess1.id(), is("tbody_ess1"));
        assertThat(tbody_ess1.style(), containsString("color:red"));
        assertThat(tbody_ess1.classname(), is("MyTBODYClass"));
    }

    @Test
    public void test_tbody_i18nAttributes() {
        TBody tbody_ess1 = component(TBody.class, "tbody_ess1");
        TBody tbody_ess2 = component(TBody.class, "tbody_ess2");

        assertThat(tbody_ess1.direction(), is(Direction.lefttoright));
        assertThat(tbody_ess1.language(), is("fr"));
        assertThat(tbody_ess2.language(), is("ar"));
        assertThat(tbody_ess2.direction(), is(Direction.righttoleft));
    }

    @Test
    public void test_tbody_specificsAttributes() {
        TBody tbody_ess2 = component(TBody.class, "tbody_ess2");

        assertThat(tbody_ess2.cellhalign(), is(Cellhalign.center));
        assertThat(tbody_ess2.cellvalign(), is(Cellvalign.baseline));
    }

    @Test
    public void can_obtain_tbody_tr() {
        TBody tbody = component(TBody.class, "tbody_ess1");

        assertThat(tbody.tr().size(), is(5));
    }

    @Test
    public void test_tbody_toString() {
        assertThat(component(TBody.class, "tbody_ess1").toString(),
                is("class org.testatoo.cartridge.html4.element.TBody with state : enabled:true, visible:true, title:tbody1_Title"));
    }

    // ---------------TESTS ON COLGROUP : group columns of a table -------------------
    @Test
    public void can_find_colgroup_by_id() {
        component(Colgroup.class, "colgroup_ess1");

        try {
            component(Colgroup.class, "colgroup_ess0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=colgroup_ess0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_colgroup() {
        try {
            component(Colgroup.class, "table_2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=table_2 is not a Colgroup but a Table"));
        }
    }

    @Test
    public void test_colgroup_coreAttributes() {
        Colgroup colgroup_ess1 = component(Colgroup.class, "colgroup_ess1");

        assertThat(colgroup_ess1.title(), is("colgroup1_Title"));
        assertThat(colgroup_ess1.id(), is("colgroup_ess1"));
        assertThat(colgroup_ess1.style(), containsString("color:blue"));
        assertThat(colgroup_ess1.classname(), is("MyCOLGROUPClass"));
    }

    @Test
    public void test_colgroup_i18nAttributes() {
        Colgroup colgroup_ess1 = component(Colgroup.class, "colgroup_ess1");
        Colgroup colgroup_ess2 = component(Colgroup.class, "colgroup_ess2");

        assertThat(colgroup_ess1.direction(), is(Direction.lefttoright));
        assertThat(colgroup_ess1.language(), is("fr"));
        assertThat(colgroup_ess2.language(), is("ar"));
        assertThat(colgroup_ess2.direction(), is(Direction.righttoleft));
    }

    @Test
    public void test_colgroup_specificsAttributes() {
        Colgroup colgroup_ess1 = component(Colgroup.class, "colgroup_ess1");
        Colgroup colgroup_ess2 = component(Colgroup.class, "colgroup_ess2");

        assertThat(colgroup_ess2.cellhalign(), is(Cellhalign.right));
        assertThat(colgroup_ess2.cellvalign(), is(Cellvalign.top));
        assertThat(colgroup_ess1.span(), is(2));
        assertThat(colgroup_ess2.width(), is("20%"));
    }

    @Test
    public void can_obtain_cols_associated() {
        Colgroup colgroup = component(Colgroup.class, "colgroup");

        assertThat(colgroup.cols().size(), is(3));
        assertThat(colgroup.cols().get(0).title(), is("col_1"));
        assertThat(colgroup.cols().get(1).title(), is("col_2"));
        assertThat(colgroup.cols().get(2).title(), is("col_3"));

    }

    @Test
    public void test_colgroup_toString() {
        assertThat(component(Colgroup.class, "colgroup_ess1").toString(),
                is("class org.testatoo.cartridge.html4.element.Colgroup with state : enabled:true, visible:false, title:colgroup1_Title"));
    }

    // ---------------TESTS ON COL : Sets attributes for table's columns ----------------------
    @Test
    public void can_find_col_by_id() {
        component(Col.class, "col_ess1");

        try {
            component(Col.class, "col_ess0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=col_ess0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_col() {
        try {
            component(Col.class, "table_2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=table_2 is not a Col but a Table"));
        }
    }

    @Test
    public void test_col_coreAttributes() {
        Col col_ess1 = component(Col.class, "col_ess1");

        assertThat(col_ess1.title(), is("col1_Title"));
        assertThat(col_ess1.id(), is("col_ess1"));
        assertThat(col_ess1.style(), containsString("width:7.6em"));
        assertThat(col_ess1.classname(), is("MyCOLClass"));
    }

    @Test
    public void test_col_i18nAttributes() {
        Col col_ess1 = component(Col.class, "col_ess1");
        Col col_ess2 = component(Col.class, "col_ess2");

        assertThat(col_ess1.direction(), is(Direction.lefttoright));
        assertThat(col_ess1.language(), is(""));
        assertThat(col_ess2.language(), is("su"));
        assertThat(col_ess2.direction(), is(Direction.righttoleft));
    }

    @Test
    public void test_col_specificsAttributes() {
        Col col_ess1 = component(Col.class, "col_ess1");
        Col col_ess2 = component(Col.class, "col_ess2");
        Col col_ess3 = component(Col.class, "col_ess3");

        assertThat(col_ess3.cellhalign(), is(Cellhalign.right));
        assertThat(col_ess3.cellvalign(), is(Cellvalign.top));
        assertThat(col_ess1.span(), is(3));
        assertThat(col_ess2.width(), is("40%"));
    }

    @Test
    public void test_col_toString() {
        // Test fail by browser specific implementation state of visibility
        assertThat(component(Col.class, "col_ess1").toString(),
                is("class org.testatoo.cartridge.html4.element.Col with state : enabled:true, visible:true, title:col1_Title"));
    }

    // ---------------TESTS ON TR : Inserts a row in a table ----------------------
    @Test
    public void can_find_tr_by_id() {
        component(Tr.class, "tr_ess1");

        try {
            component(Tr.class, "tr_ess0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=tr_ess0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_tr() {
        try {
            component(Tr.class, "table_2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=table_2 is not a Tr but a Table"));
        }
    }

    @Test
    public void test_tr_coreAttributes() {
        Tr tr_ess1 = component(Tr.class, "tr_ess1");

        assertThat(tr_ess1.title(), is("tr1_Title"));
        assertThat(tr_ess1.id(), is("tr_ess1"));
        assertThat(tr_ess1.style(), containsString("color:black"));
        assertThat(tr_ess1.classname(), is("MyTRClass"));
    }

    @Test
    public void test_tr_i18nAttributes() {
        Tr tr_ess1 = component(Tr.class, "tr_ess1");
        Tr tr_ess2 = component(Tr.class, "tr_ess2");

        assertThat(tr_ess1.direction(), is(Direction.lefttoright));
        assertThat(tr_ess1.language(), is("ca"));
        assertThat(tr_ess2.language(), is("fr"));
        assertThat(tr_ess2.direction(), is(Direction.righttoleft));
    }

    @Test
    public void test_tr_specificsAttributes() {
        Tr tr = component(Tr.class, "tr_ess3");

        assertThat(tr.cellhalign(), is(Cellhalign.left));
        assertThat(tr.cellvalign(), is(Cellvalign.top));
    }

    @Test
    public void test_can_obtain_td() {
        Tr tr = component(Tr.class, "tr_ess3");

        assertThat(tr.td().size(), is(3));

        tr = component(Tr.class, "female");

        assertThat(tr.td().size(), is(3));
        assertThat(tr.td().get(0).content(), is("1.7"));
        assertThat(tr.td().get(1).content(), is("0.002"));
        assertThat(tr.td().get(2).content(), is("43%"));

        assertThat(tr.th().size(), is(1));
        assertThat(tr.th().get(0).content(), is("Females"));
    }

    @Test
    public void test_tr_toString() {
        assertThat(component(Tr.class, "tr_ess1").toString(),
                is("class org.testatoo.cartridge.html4.element.Tr with state : enabled:true, visible:true, title:tr1_Title"));
    }

    // ---------------TESTS ON TH : Header cell of a table ----------------------
    @Test
    public void can_find_th_by_id() {
        component(Th.class, "th_ess1");

        try {
            component(Th.class, "th_ess0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=th_ess0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_th() {
        try {
            component(Th.class, "table_2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=table_2 is not a Th but a Table"));
        }
    }

    @Test
    public void test_th_coreAttributes() {
        Th th_ess1 = component(Th.class, "th_ess1");

        assertThat(th_ess1.title(), is("th1_Title"));
        assertThat(th_ess1.id(), is("th_ess1"));
        assertThat(th_ess1.style(), containsString("color:brown"));
        assertThat(th_ess1.classname(), is("MyTHClass"));
    }

    @Test
    public void test_th_i18nAttributes() {
        Th th_ess1 = component(Th.class, "th_ess1");
        Th th_ess2 = component(Th.class, "th_ess2");

        assertThat(th_ess1.direction(), is(Direction.lefttoright));
        assertThat(th_ess1.language(), is("ca"));
        assertThat(th_ess2.language(), is("fr"));
        assertThat(th_ess2.direction(), is(Direction.righttoleft));
    }

    @Test
    public void test_th_specificsAttributes() {
        Th th_ess2 = component(Th.class, "th_ess2");
        Th th_ess3 = component(Th.class, "th_ess3");
        Th th_ess4 = component(Th.class, "th_ess4");

        assertThat(th_ess3.cellhalign(), is(Cellhalign.left));
        assertThat(th_ess3.cellvalign(), is(Cellvalign.top));
        assertThat(th_ess3.abbr(), is("abbr tests for th"));
        assertThat(th_ess2.rowspan(), is(2));
        assertThat(th_ess3.colspan(), is(2));
        assertThat(th_ess4.axis(), is("cat1, cat2, cat3"));
        assertThat(th_ess4.headers(), is("id_cell1,id_cell2,id_cell3"));
        assertThat(th_ess4.scope(), is(Scope.col));
    }

    @Test
    public void test_th_toString() {
        assertThat(component(Th.class, "th_ess1").toString(),
                is("class org.testatoo.cartridge.html4.element.Th with state : enabled:true, visible:true, title:th1_Title"));
    }

    //-------- Tests on TD : regular cell of a table ------------------
    @Test
    public void can_find_td_by_id() {
        component(Td.class, "td_ess1");

        try {
            component(Td.class, "td_ess0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=td_ess0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_td() {
        try {
            component(Td.class, "table_2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=table_2 is not a Td but a Table"));
        }
    }

    @Test
    public void test_td_coreAttributes() {
        Td td_ess1 = component(Td.class, "td_ess1");
        Td td_ess3 = component(Td.class, "td_ess3");

        assertThat(td_ess1.title(), is(""));
        assertThat(td_ess1.id(), is("td_ess1"));
        assertThat(td_ess1.style(), containsString("color:yellow"));
        assertThat(td_ess3.classname(), is("MyTDClass"));
    }

    @Test
    public void test_td_i18nAttributes() {
        Td td_ess1 = component(Td.class, "td_ess1");
        Td td_ess2 = component(Td.class, "td_ess2");

        assertThat(td_ess1.direction(), is(Direction.righttoleft));
        assertThat(td_ess1.language(), is("ca"));
        assertThat(td_ess2.language(), is(""));
        assertThat(td_ess2.direction(), is(Direction.lefttoright));
    }

    @Test
    public void test_td_specificsAttributes() {
        Td td_ess1 = component(Td.class, "td_ess1");
        Td td_ess2 = component(Td.class, "td_ess2");
        Td td_ess3 = component(Td.class, "td_ess3");

        assertThat(td_ess2.cellhalign(), is(Cellhalign.left));
        assertThat(td_ess3.cellvalign(), is(Cellvalign.top));
        assertThat(td_ess1.abbr(), is("abbreviation tests for td"));
        assertThat(td_ess2.rowspan(), is(3));
        assertThat(td_ess2.colspan(), is(4));
        assertThat(td_ess1.axis(), is("cat4, cat5, cat6"));
        assertThat(td_ess2.headers(), is("cell3, cell4, cell5"));
        assertThat(td_ess3.scope(), is(Scope.rowgroup));
    }

    @Test
    public void test_td_toString() {
        assertThat(component(Td.class, "td_ess1").toString(),
                is("class org.testatoo.cartridge.html4.element.Td with state : enabled:true, visible:true, title:, content:Sean"));
    }
}
