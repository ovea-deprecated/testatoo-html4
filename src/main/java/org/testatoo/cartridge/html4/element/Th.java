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
import org.testatoo.core.component.Component;
import org.testatoo.core.nature.Container;

import static org.testatoo.cartridge.html4.element.HtmlElementType.Th;

/**
 * This class allows the testing of the "th" element properties for html4.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#edef-TH"> "td" specification </a>
 */

public final class Th extends Component implements Coreattrs, I18n, Container {

    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;
    private HtmlEvaluator evaluator;

    /**
     * Class constructor specifying the evaluator to use and the id of the th element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the th element
     * @throws ComponentException if the given id does not correspond to a "th" element
     */
    public Th(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        attributeSupport = new AttributeSupport(evaluator);
        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Th) {
            throw new ComponentException("The component with id=" + id + " is not a " + Th + " but a " + evaluator.htmlElementType(id));
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
     * To know if the Th contains all the given components.
     *
     * @param components components we want to know if contained in the table header cell
     * @return True if all the components is contained in the table header cell
     */
    public Boolean contains(Component... components) {
        return evaluator.contains(this, components);
    }

    /**
     * To get the abbr attribute of the th element.
     * Abbr can be used to specify an abbreviated version of the content of the cell.
     *
     * @return the value of "abbr" attribute for the table header cell
     * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#adef-abbr">W3C recommendation</a>
     */
    public String abbr() {
        return attributeSupport.abbr(this);
    }

    /**
     * To get the axis attribute of the th element.
     * Axis can be used to specify a category that forms a conceptual axis in n-dimensional space for hierarchical structuring.
     *
     * @return the value of "axis" attribute for the table header cell (single name or a comma-separated list of names)
     * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#adef-axis">W3C recommendation</a>
     */
    public String axis() {
        return attributeSupport.axis(this);
    }

    /**
     * To get the headers attribute of the th element.
     * Headers can be used to explicitly specify which header cells are associated to the cell.
     *
     * @return the value of "headers" attribute for the table header cell (single value or comma-separated list of table cell id values.)
     * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#adef-headers">W3C recommendation</a>
     */
    public String headers() {
        return attributeSupport.headers(this);
    }

    /**
     * To get the rowspan attribute of the th element.
     * Rowspan can be used to specify across how many rows the cell should spread.
     *
     * @return the value of "rowspan" attribute for the table header cell (default value is 1)
     * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#adef-rowspan">W3C recommendation</a>
     */
    public int rowspan() {
        return attributeSupport.rowspan(this);
    }

    /**
     * To get the colspan attribute of the th element.
     * Colspan can be used to specify across how many columns the cell should spread.
     *
     * @return the value of "colspan" attribute for the table header cell (default value is 1)
     * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#adef-colspan">W3C recommendation</a>
     */
    public int colspan() {
        return attributeSupport.colspan(this);
    }

    /**
     * To get the scope attribute of the th element.
     * Scope can be used to specify the set of data cells for which the current header cell provides header information.
     *
     * @return the value of "scope" attribute for the table header cell
     * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#adef-scope">W3C recommendation</a>
     */
    public Scope scope() {
        return attributeSupport.scope(this);
    }

    /**
     * To get the cellhalign attribute of the th element.
     *
     * @return the value of "cellhalign" attribute for the table header cell
     * @see <a href="http://www.w3.org/TR/html401/sgml/dtd.html#cellhalign">W3C recommendation</a>
     */
    public Cellhalign cellhalign() {
        return attributeSupport.cellhalign(this);
    }

    /**
     * To get the cellvalign attribute of the th element.
     *
     * @return the value of "cellvalign" attribute for the table header cell
     * @see <a href="http://www.w3.org/TR/html401/sgml/dtd.html#cellvalign">W3C recommendation</a>
     */
    public Cellvalign cellvalign() {
        return attributeSupport.cellvalign(this);
    }

    /**
     * To get the content of the table header cell.
     *
     * @return the content of the table header cell
     */
    public String content() {
        return evaluator.content(this);
    }

    /**
     * To get the string describing the table header cell.
     *
     * @return string describing the table header cell
     */
    public String toString() {
        return super.toString() + ", title:" + title();
    }
}
