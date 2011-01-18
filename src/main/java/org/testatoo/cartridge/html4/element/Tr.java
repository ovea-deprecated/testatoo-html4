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

import static org.testatoo.cartridge.html4.element.HtmlElementType.Tr;

/**
 * This class allows the testing of the "tr" element properties for html4.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#edef-TR"> "tr" specification </a>
 */
public class Tr extends Component implements Coreattrs, I18n, Container {

    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;
    private HtmlEvaluator evaluator;

    /**
     * Class constructor specifying the evaluator to use and the id of the tr element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the tr element
     * @throws ComponentException if the given id does not correspond to a "tr" element
     */
    public Tr(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        attributeSupport = new AttributeSupport(evaluator);
        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != Tr) {
            throw new ComponentException("The component with id=" + id + " is not a " + Tr + " but a " + evaluator.htmlElementType(id));
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
     * To know if the Tr contains all the given components.
     *
     * @param components components we want to know if contained in the table row
     * @return True if all the components is contained in the table row
     */
    public Boolean contains(Component... components) {
        return evaluator.contains(this, components);
    }

    /**
     * To get the cellhalign attribute of the tr element.
     *
     * @return the value of "cellhalign" attribute for the table row
     * @see <a href="http://www.w3.org/TR/html401/sgml/dtd.html#cellhalign">W3C recommendation</a>
     */
    public Cellhalign cellhalign() {
        return attributeSupport.cellhalign(this);
    }

    /**
     * To get the cellvalign attribute of the tr element.
     *
     * @return the value of "cellvalign" attribute for the table row
     * @see <a href="http://www.w3.org/TR/html401/sgml/dtd.html#cellvalign">W3C recommendation</a>
     */
    public Cellvalign cellvalign() {
        return attributeSupport.cellvalign(this);
    }

    /**
     * To get the list of cells ("td" elements) of the table row.
     *
     * @return the list of Td in the Tr
     */
    public Selection<Td> td() {
        return evaluator.td(this);
    }

    /**
     * To get the list of header cells ("th" elements) of the table row.
     *
     * @return the list of Th in the Tr
     */
    public Selection<Th> th() {
        return evaluator.th(this);
    }

    /**
     * To get the string describing the Tr.
     *
     * @return string describing the tr
     */
    public String toString() {
        return super.toString() + ", title:" + title();
    }
}
