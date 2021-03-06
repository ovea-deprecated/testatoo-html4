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

import static org.testatoo.cartridge.html4.element.HtmlElementType.TFoot;

/**
 * This class allows the testing of the "TFoot" element properties for html4 tables.
 *
 * @author dev@testatoo.org
 * @see <a href="http://www.w3.org/TR/html401/struct/tables.html#edef-TFOOT"> "TFoot" specification </a>
 */

public final class TFoot extends Component implements Coreattrs, I18n, Container {

    private CoreAttributeSupport coreAttributeSupport;
    private I18nAttributeSupport i18nAttributeSupport;
    private AttributeSupport attributeSupport;
    private HtmlEvaluator evaluator;

    /**
     * Class constructor specifying the evaluator to use and the id of the TFoot element we want to test.
     *
     * @param evaluator a UI Test engine specific html evaluator
     * @param id        the id (unique) of the TFoot element
     * @throws ComponentException if the given id does not correspond to a "TFoot" element
     */
    public TFoot(HtmlEvaluator evaluator, String id) {
        super(evaluator, id);
        this.evaluator = evaluator;

        coreAttributeSupport = new CoreAttributeSupport(evaluator);
        i18nAttributeSupport = new I18nAttributeSupport(evaluator);
        attributeSupport = new AttributeSupport(evaluator);
        if (evaluator.htmlElementType(id) != TFoot) {
            throw new ComponentException("The component with id=" + id + " is not a " + TFoot + " but a " + evaluator.htmlElementType(id));
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
     * To know if the TFoot contains all the given components.
     *
     * @param components components we want to know if contained in the able footer
     * @return True if all the components is contained in the table footer
     */
    public Boolean contains(Component... components) {
        return evaluator.contains(this, components);
    }

    /**
     * To get the cellhalign attribute of the table footer
     *
     * @return the cellhalign of the table footer
     * @see <a href="http://www.w3.org/TR/html401/sgml/dtd.html#cellhalign">W3C recommendation</a>
     */
    public Cellhalign cellhalign() {
        return attributeSupport.cellhalign(this);
    }

    /**
     * To get the cellvalign attribute of the table footer
     *
     * @return the cellvalign of the table footer
     * @see <a href="http://www.w3.org/TR/html401/sgml/dtd.html#cellvalign">W3C recommendation</a>
     */
    public Cellvalign cellvalign() {
        return attributeSupport.cellvalign(this);
    }

    /**
     * To get the list of Tr elements in the TFoot element
     *
     * @return the list of Tr of the TFoot element
     */
    public Selection<Tr> tr() {
        return evaluator.tr(this);
    }

    /**
     * To get the string describing the TFoot element.
     *
     * @return string describing the TFoot element
     */
    public String toString() {
        return super.toString() + ", title:" + title();
    }
}