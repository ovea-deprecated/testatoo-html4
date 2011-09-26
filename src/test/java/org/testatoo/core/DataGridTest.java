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

package org.testatoo.core;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.core.component.datagrid.Column;
import org.testatoo.core.component.datagrid.DataGrid;
import org.testatoo.core.component.datagrid.Row;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.*;
import static org.testatoo.core.Language.assertThat;

public class DataGridTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("DataGrid.html");
    }

    @Test
    public void can_find_datagrid_by_id() {
        component(DataGrid.class, "grid1");

        try {
            component(DataGrid.class, "otherGrid");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=otherGrid"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_datagrid() {
        try {
            component(DataGrid.class, "firstChoice");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=firstChoice is not a DataGrid but a CheckBox"));
        }
    }

    @Test
    public void can_test_columns_title() {
        DataGrid grid1 = component(DataGrid.class, "grid1");

        assertThat(grid1.columns().size(), is(3));

        Selection<Column> columns = grid1.columns();

        assertThat(columns.get(0).title(), is("Column1"));
        assertThat(columns.get(1).title(), is("Column2"));
        assertThat(columns.get(2).title(), is("Column3"));
    }

    @Test
    public void can_test_column_cells() {
        DataGrid grid1 = component(DataGrid.class, "grid1");

        Selection<Column> columns = grid1.columns();

        assertThat(columns.get(0).cells().size(), is(3));
        assertThat(columns.get(1).cells().size(), is(3));
        assertThat(columns.get(2).cells().size(), is(3));

        assertThat(columns.get(0).cells().get(0).value(), is("value10"));
        assertThat(columns.get(0).cells().get(1).value(), is("value11"));
        assertThat(columns.get(0).cells().get(2).value(), is("value12"));

        assertThat(columns.get(1).cells().get(0).value(), is("value20"));
        assertThat(columns.get(1).cells().get(1).value(), is("value21"));
        assertThat(columns.get(1).cells().get(2).value(), is("value22"));

        assertThat(columns.get(2).cells().get(0).value(), is("value30"));
        assertThat(columns.get(2).cells().get(1).value(), is("value31"));
        assertThat(columns.get(2).cells().get(2).value(), is("value32"));
    }

    @Test
    public void can_test_row_cell() {
        DataGrid grid1 = component(DataGrid.class, "grid1");

        Selection<Row> rows = grid1.rows();

        assertThat(rows.size(), is(3));

        assertThat(rows.get(0).cells().size(), is(3));
        assertThat(rows.get(1).cells().size(), is(3));
        assertThat(rows.get(2).cells().size(), is(3));

        assertThat(rows.get(0).cells().get(0).value(), is("value10"));
        assertThat(rows.get(0).cells().get(1).value(), is("value20"));
        assertThat(rows.get(0).cells().get(2).value(), is("value30"));

        assertThat(rows.get(1).cells().get(0).value(), is("value11"));
        assertThat(rows.get(1).cells().get(1).value(), is("value21"));
        assertThat(rows.get(1).cells().get(2).value(), is("value31"));

        assertThat(rows.get(2).cells().get(0).value(), is("value12"));
        assertThat(rows.get(2).cells().get(1).value(), is("value22"));
        assertThat(rows.get(2).cells().get(2).value(), is("value32"));
    }

    @Test
    public void test_toString() {
        DataGrid grid1 = component(DataGrid.class, "grid1");
        assertThat(grid1.toString(), is("class org.testatoo.core.component.datagrid.DataGrid with state : enabled:true, visible:true, column(s):3, row(s):3"));
    }
}
