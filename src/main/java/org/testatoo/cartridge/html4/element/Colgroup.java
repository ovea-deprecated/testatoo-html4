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

import static org.testatoo.cartridge.html4.element.HtmlElementType.Colgroup;

/**
 * This class allows the testing of the "colgroup" element properties for html4.
 * Column group specifies attributes to be applied to a set of table columns.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#edef-COLGROUP"> "colgroup" specification </a>
 */

public final class Colgroup extends Component implements Coreattrs, I18n, Container {

    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;
    private HtmlEvaluator evaluator;

    /**
     * Class constructor specifying the evaluator to use and the id of the "colgroup" element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the "colgroup" element
     * @throws ComponentException if the given id does not correspond to a "colgroup" element
     */
    public Colgroup(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        attributeSupport = new AttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Colgroup) {
            throw new ComponentException("The component with id=" + id + " is not a " + Colgroup + " but a " + evaluator.htmlElementType(id));
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
     * To know if the colgroup contains all the given components.
     *
     * @param components components we want to know if contained in the colgroup
     * @return True if all the components is contained in the colgroup
     */
    public Boolean contains(Component... components) {
        return evaluator.contains(this, components);
    }

    /**
     * To get the cellhalign attribute of the column group.
     *
     * @return the cellhalign of the column group
     * @see <a href="http://www.w3.org/TR/html401/sgml/dtd.html#cellhalign">W3C recommendation</a>
     */
    public Cellhalign cellhalign() {
        return attributeSupport.cellhalign(this);
    }

    /**
     * To get the cellvalign attribute of the column group.
     *
     * @return the cellvalign of the column group
     * @see <a href="http://www.w3.org/TR/html401/sgml/dtd.html#cellvalign">W3C recommendation</a>
     */
    public Cellvalign cellvalign() {
        return attributeSupport.cellvalign(this);
    }

    /**
     * To get the span attribute of the column.
     * Specifies the number of columns in the column group.
     *
     * @return the span of the column group
     * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#adef-span-COLGROUP">W3C recommendation</a>
     */
    public int span() {
        return attributeSupport.span(this);
    }

    /**
     * To get the width attribute of the column group.
     * Specifies a default width for each column in the current column group.
     *
     * @return the width of the columns in the column group
     * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#adef-width-COLGROUP">W3C recommendation</a>
     */
    public String width() {
        return attributeSupport.width(this);
    }

    /**
     * To get the columns in the column group.
     *
     * @return a list of Col objects
     * @see Col
     */
    public Selection<Col> cols() {
        return evaluator.cols(this);
    }

    @Override
    public Boolean isVisible() {
        return false;
    }

    /**
     * To get the string describing the column group.
     *
     * @return string describing the column group
     */
    public String toString() {
        return super.toString() + ", title:" + title();
    }
}