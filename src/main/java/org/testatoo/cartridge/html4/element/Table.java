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

import org.testatoo.cartridge.html4.HtmlEvaluator;
import org.testatoo.core.ComponentException;
import org.testatoo.core.Selection;
import org.testatoo.core.component.Component;
import org.testatoo.core.nature.Container;

import static org.testatoo.cartridge.html4.element.HtmlElementType.Table;

/**
 * This class allows the testing of the "table" element properties for html4.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#edef-TABLE"> "table" specification </a>
 */

public final class Table extends org.testatoo.core.component.datagrid.DataGrid implements Coreattrs, I18n, Container {

    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;
    private HtmlEvaluator evaluator;

    /**
     * Class constructor specifying the evaluator to use and the id of the table element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the table element
     * @throws ComponentException if the given id does not correspond to a "table" element
     */
    public Table(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        attributeSupport = new AttributeSupport(evaluator);
        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Table) {
            throw new ComponentException("The component with id=" + id + " is not a " + Table + " but a " + evaluator.htmlElementType(id));
        }
    }

    /**
     * @see CoreAttributeSupport
     */
    public String classname() {
        return coreAttributeSupport.classname(this);
    }

    /**
     * @see CoreAttributeSupport
     */
    public String style() {
        return coreAttributeSupport.style(this);
    }

    /**
     * @see CoreAttributeSupport
     */
    public String title() {
        return coreAttributeSupport.title(this);
    }

    /**
     * @see I18nAttributeSupport
     */
    public String language() {
        return i18nAttributeSupport.language(this);
    }

    /**
     * @see I18nAttributeSupport
     */
    public Direction direction() {
        return i18nAttributeSupport.direction(this);
    }

    /**
     * To know if the table contains all the given components.
     *
     * @param components components we want to know if contained in the table
     * @return True if all the components is contained in the table
     */
    public Boolean contains(Component... components) {
        return evaluator.contains(this, components);
    }

    /**
     * To get the summary attribute of the table (summary of the data represented in the table).
     *
     * @return the summary of the table
     * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#adef-summary">W3C recommendation</a>
     */
    public String summary() {
        return attributeSupport.summary(this);
    }

    /**
     * To get the width attribute of the table.
     *
     * @return the width of the table
     * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#adef-width-TABLE">W3C recommendation</a>
     */
    public String width() {
        return attributeSupport.width(this);
    }

    /**
     * To get the border attribute of the table (width in pixels of the frame around a table).
     *
     * @return the number of pixels of the border of the table
     * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#adef-border-TABLE">W3C recommendation</a>
     */
    public int border() {
        return attributeSupport.border(this);
    }

    /**
     * To get the frame attribute of the table.
     * Frame specifies which sides of the frame surrounding the table will be visible.
     *
     * @return the value of "frame" attribute for the table
     * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#adef-frame">W3C recommendation</a>
     */
    public TFrame frame() {
        return attributeSupport.frame(this);
    }

    /**
     * To get the rules attribute of the table.
     * Rules specifies which rules will appear between cells within a table.
     *
     * @return the value of "rules" attribute for the table
     * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#adef-rules">W3C recommendation</a>
     */
    public TRules rules() {
        return attributeSupport.rules(this);
    }

    /**
     * To get the cellspacing attribute of the table.
     *
     * @return the value of "cellspacing" attribute for the table
     * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#adef-cellspacing">W3C recommendation</a>
     */
    public String cellspacing() {
        return attributeSupport.cellspacing(this);
    }

    /**
     * To get the cellpadding attribute of the table.
     *
     * @return the value of "cellpadding" attribute for the table
     * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#adef-cellpadding">W3C recommendation</a>
     */
    public String cellpadding() {
        return attributeSupport.cellpadding(this);
    }

    /**
     * To get the "caption" element corresponding to the table.
     * Caption must appear straight after the opening table tag and used only once.
     *
     * @return the value of "caption" element in the table
     * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#edef-CAPTION">W3C recommendation</a>
     */
    public Caption caption() {
        return evaluator.caption(this);
    }

    /**
     * To get the thead attribute of the table (table rows grouped into a head section).
     *
     * @return the thead attribute of the table
     */
    public THead thead() {
        return evaluator.thead(this);
    }

    /**
     * To get the tbody attribute of the table (table rows grouped into a body section).
     *
     * @return the tbody attribute of the table
     */
    public TBody tbody() {
        return evaluator.tbody(this);
    }

    /**
     * To get the tfoot attribute of the table (table rows grouped into a foot section).
     *
     * @return the tfoot attribute of the table
     */
    public TFoot tfoot() {
        return evaluator.tfoot(this);
    }

    /**
     * To get the columns of the table.
     *
     * @return the list of cols of the table
     */
    public Selection<Col> cols() {
        return evaluator.cols(this);
    }

    /**
     * To get the groups of columns of the table.
     *
     * @return the list of colgroups of the table
     */
    public Selection<Colgroup> colgroups() {
        return evaluator.colgroups(this);
    }

    /**
     * To get the list of rows ("tr" elements)  of the table.
     *
     * @return the list of Tr of the table
     */
    public Selection<Tr> tr() {
        return evaluator.tr(this);
    }
}
